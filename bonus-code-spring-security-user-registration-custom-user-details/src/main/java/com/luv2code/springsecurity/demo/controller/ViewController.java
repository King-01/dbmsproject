package com.luv2code.springsecurity.demo.controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.love2code.springsecurity.demo.form.StockForm;
import com.luv2code.springsecurity.demo.entity.Account;
import com.luv2code.springsecurity.demo.entity.Group;
import com.luv2code.springsecurity.demo.entity.Schedule;
import com.luv2code.springsecurity.demo.entity.StockItem;
import com.luv2code.springsecurity.demo.service.AccountService;
import com.luv2code.springsecurity.demo.service.GroupService;
import com.luv2code.springsecurity.demo.service.ScheduleService;
import com.luv2code.springsecurity.demo.service.StockItemService;

@Controller
@RequestMapping("/view")
public class ViewController {
	@Autowired
	private ScheduleService scheduleService;
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private GroupService groupService;
	@Autowired
	private AccountService accountService;
	@Autowired
	private StockItemService stockItemService;
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}	
	@RequestMapping("/")
	public String addHome(Model theModel)
	{
		return "view";
	}
	@RequestMapping("/Schedule")
	public String showSchedules(Model theModel, RedirectAttributes ra)
	{
		Object authentication = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(authentication instanceof UserDetails)
		{
			String userName = ((UserDetails)authentication).getUsername();
			List<Schedule> theSchedules = scheduleService.getScheduleByUserName(userName);
			theModel.addAttribute("listofschedule", theSchedules);
			return "show-schedules";
		}
		
		ra.addFlashAttribute("someerror", "Please Login to continue");
		
		return "redirect:/";
	}
	@RequestMapping("/scheduleById")
	@Transactional
	public String showScheduleById(Model theModel, @RequestParam("scheduleId") Long scheduleId, RedirectAttributes ra)
	{
		Object authentication = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(authentication instanceof UserDetails)
		{
			Session crs = sessionFactory.getCurrentSession();
			Schedule obj = crs.get(Schedule.class, scheduleId);
			theModel.addAttribute("newschedule", obj);
			return "show-specific-schedule";
			
		}
		
		ra.addFlashAttribute("someerror", "Please Login to continue");
		
		return "redirect:/";
	}
	@RequestMapping("/group")
	public String showGroup(Model theModel, RedirectAttributes ra)
	{
		Object authentication = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(authentication instanceof UserDetails)
		{
			String userName = ((UserDetails)authentication).getUsername();
			List<Group> theGroups= groupService.getGroupByUserName(userName);
			
			theModel.addAttribute("listofgroups", theGroups);
			return "show-groups";
		}
		
		ra.addFlashAttribute("someerror", "Please Login to continue");
		
		return "redirect:/";
	}
	@RequestMapping("/groupById")
	@Transactional
	public String showGroupById(Model theModel, @RequestParam("groupId") Long groupId, RedirectAttributes ra)
	{
		Object authentication = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(authentication instanceof UserDetails)
		{
			Session crs = sessionFactory.getCurrentSession();
			Group obj = crs.get(Group.class, groupId);
			theModel.addAttribute("newgroup", obj);
			return "show-specific-group";
			
		}
		
		ra.addFlashAttribute("someerror", "Please Login to continue");
		
		return "redirect:/";
	}
	@RequestMapping("/account")
	public String showAccount(Model theModel, RedirectAttributes ra)
	{
		Object authentication = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(authentication instanceof UserDetails)
		{
			String userName = ((UserDetails)authentication).getUsername();
			List<Account> theAccounts= accountService.getAccountByUserName(userName);
			
			theModel.addAttribute("listofaccounts", theAccounts);
			return "show-accounts";
		}
		
		ra.addFlashAttribute("someerror", "Please Login to continue");
		
		return "redirect:/";
	}
	@RequestMapping("/accountById")
	@Transactional
	public String showAccountById(Model theModel, @RequestParam("accountId") Long accountId, RedirectAttributes ra)
	{
		Object authentication = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(authentication instanceof UserDetails)
		{
			Session crs = sessionFactory.getCurrentSession();
			Account obj = crs.get(Account.class, accountId);
			Session crs1 = sessionFactory.getCurrentSession();
			Group schedule = crs1.get(Group.class, obj.getGroupId());
			theModel.addAttribute("scheduleName", schedule.getGroupName());
			theModel.addAttribute("scheduleId", schedule.getId());
			theModel.addAttribute("newaccount", obj);
			return "show-specific-account";
			
		}
		
		ra.addFlashAttribute("someerror", "Please Login to continue");
		
		return "redirect:/";
	}
	@RequestMapping("/stockitem")
	public String showStockItem(Model theModel, RedirectAttributes ra)
	{
		Object authentication = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(authentication instanceof UserDetails)
		{
			String userName = ((UserDetails)authentication).getUsername();
			List<StockItem> theAccounts= stockItemService.getStockItemByUserName(userName);
			
			theModel.addAttribute("listofstockitems", theAccounts);
			return "show-stockitems";
		}
		
		ra.addFlashAttribute("someerror", "Please Login to continue");
		
		return "redirect:/";
	}
	@RequestMapping("/stockItemById")
	@Transactional
	public String showStockItemById(Model theModel
			, @RequestParam("stockItemId") Long stockItemId
			, RedirectAttributes ra)
	{
		Object authentication = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(authentication instanceof UserDetails)
		{
			Session crs = sessionFactory.getCurrentSession();
			StockItem obj = crs.get(StockItem.class, stockItemId);
			Session crs1 = sessionFactory.getCurrentSession();
			StockForm obj1 = new StockForm();
			obj1 = obj1.createStockForm(obj);
			Group schedule = crs1.get(Group.class, obj.getGroupId());
			theModel.addAttribute("scheduleName", schedule.getGroupName());
			theModel.addAttribute("scheduleId", schedule.getId());
			theModel.addAttribute("newstockitem", obj1);
			return "show-specific-stockitem";
			
		}
		
		ra.addFlashAttribute("someerror", "Please Login to continue");
		
		return "redirect:/";
	}
}
