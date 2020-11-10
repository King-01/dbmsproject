package com.luv2code.springsecurity.demo.controller;

import java.util.List;

import org.hibernate.SessionFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.love2code.springsecurity.demo.form.StockForm;
import com.luv2code.springsecurity.demo.entity.Account;
import com.luv2code.springsecurity.demo.entity.BankVoucher;
import com.luv2code.springsecurity.demo.entity.Group;
import com.luv2code.springsecurity.demo.entity.JournalVoucher;
import com.luv2code.springsecurity.demo.entity.Schedule;
import com.luv2code.springsecurity.demo.entity.StockItem;
import com.luv2code.springsecurity.demo.entity.StockTax;
import com.luv2code.springsecurity.demo.entity.Tax;
import com.luv2code.springsecurity.demo.entity.User;
import com.luv2code.springsecurity.demo.service.AccountService;
import com.luv2code.springsecurity.demo.service.GroupService;
import com.luv2code.springsecurity.demo.service.ScheduleService;
import com.luv2code.springsecurity.demo.service.StockItemService;
import com.luv2code.springsecurity.demo.service.StockTaxService;
import com.luv2code.springsecurity.demo.service.TaxService;
import com.luv2code.springsecurity.demo.service.UserService;
import com.luv2code.springsecurity.demo.user.ScheduleUser;
@Controller
@RequestMapping("/add")
public class AddController {
	@Autowired
	private ScheduleService scheduleService;
	@Autowired
	private GroupService groupService;
	@Autowired
	private AccountService accountService;
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private UserService userService;
	@Autowired
	private TaxService taxService;
	@Autowired
	private StockTaxService stockTaxService;
	@Autowired
	private StockItemService stockItemService;
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}	
	@RequestMapping("/")
	public String addHome(Model theModel,
			RedirectAttributes ra)
	{
		Object authentication = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if((authentication instanceof UserDetails))
		{
			logger.info(((UserDetails)authentication).getUsername());
			return "add";
		}
		ra.addFlashAttribute("someerror", "Please Login to continue");
		return "redirect:/";
	}
	@RequestMapping("/Schedule")
	public String addSchedule(Model theModel, RedirectAttributes ra)
	{
		Object authentication = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(authentication instanceof UserDetails)
		{
			ScheduleUser newSchedule = new ScheduleUser();
			theModel.addAttribute("newschedule", newSchedule);
			logger.info("Processing Add schedule for user : " + ((UserDetails)authentication).getUsername());
			return "add-schedule";
		}
		ra.addFlashAttribute("someerror", "Please Login to continue");
		return "redirect:/";
	}
	@RequestMapping("/group")
	public String addGroup(Model theModel, RedirectAttributes ra)
	{
		Object authentication = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(authentication instanceof UserDetails)
		{
			Group newGroup = new Group();
			theModel.addAttribute("newgroup", newGroup);
			List<Schedule> listofschedule = scheduleService.getScheduleByUserName(((UserDetails)authentication).getUsername());
			logger.info("Form to Add group for user : " + ((UserDetails)authentication).getUsername() + " in AddController /add/group");
			theModel.addAttribute("listofschedule", listofschedule);
			return "add-group";
		}
		ra.addFlashAttribute("someerror", "Please Login to continue");
		return "redirect:/";
		
	}
	@RequestMapping("/account")
	public String addAccount(Model theModel, RedirectAttributes ra)
	{
		Object authentication = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(authentication instanceof UserDetails)
		{
			Account newAccount = new Account();
			theModel.addAttribute("newaccount", newAccount);
			String userName = ((UserDetails)authentication).getUsername();
			List<Group> listofgroup = groupService.getGroupByUserName(userName);
			logger.info("Form to Add account for user : " + userName + " in AddController /add/group");
			theModel.addAttribute("listofgroup", listofgroup);
			return "add-account";
		}
		ra.addFlashAttribute("someerror", "Please Login to continue");
		return "redirect:/";
		
	}
	@RequestMapping("/stockitem")
	public String addStockItem(Model theModel, RedirectAttributes ra)
	{
		Object authentication = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(authentication instanceof UserDetails)
		{
			StockForm newStockForm= new StockForm();
			theModel.addAttribute("stockitem", newStockForm);
			String userName = ((UserDetails)authentication).getUsername();
			List<Group> listofgroup = groupService.getGroupByUserName(userName);
			logger.info("Form to Add stock item for user : " + userName + " in AddController /add/stockitem");
			theModel.addAttribute("listofgroup", listofgroup);
			return "add-stockitem";
		}
		ra.addFlashAttribute("someerror", "Please Login to continue");
		return "redirect:/";
		
	}
	
	@RequestMapping("/tax")
	public String addTax(Model theModel, RedirectAttributes ra)
	{
		Object authentication = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(authentication instanceof UserDetails)
		{
			User currentuser = userService.findByUserName((((UserDetails)authentication).getUsername()));
			Tax addelem = new Tax();
			addelem.setUserid(currentuser.getId());
			theModel.addAttribute("addelem", addelem);
			return "add-tax";
		}
		ra.addFlashAttribute("someerror", "Please Login to continue");
		return "redirect:/";
		
	}
	@RequestMapping("/stocktax")
	public String addTaxToStock(Model theModel, RedirectAttributes ra)
	{
		Object authentication = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(authentication instanceof UserDetails)
		{
			String userName = ((((UserDetails)authentication).getUsername()));
			StockTax newelem = new StockTax();
			List<Tax> taxes = taxService.getTaxByUserName(userName);
			List<StockItem> items = stockItemService.getStockItemByUserName(userName);
			theModel.addAttribute("addelem", newelem);
			theModel.addAttribute("taxes", taxes);
			theModel.addAttribute("items", items);
			return "add-stocktax";
		}
		ra.addFlashAttribute("someerror", "Please Login to continue");
		return "redirect:/";
		
	}
	@RequestMapping("/journalvoucher")
	public String addJournalVoucher(Model theModel, RedirectAttributes ra)
	{
		Object authentication = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(authentication instanceof UserDetails)
		{
			String userName = ((((UserDetails)authentication).getUsername()));
			Double credit = (double) 0, debit = (double) 0;
//			DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//			SimpleDateFormat dft= new SimpleDateFormat("yyyy-MM-dd");
//			LocalDateTime now = LocalDateTime.now();
//			Date curDate = (Date) df.parse(dft.format(now));
			JournalVoucher toadd = new JournalVoucher();
//			toadd.setDate(curDate);
			toadd.setDebitTotal(debit);
			toadd.setCreditTotal(credit);
			toadd.setUserName(userName);
			theModel.addAttribute("addelem",toadd);
			List<Account> thelist = accountService.getAccountByUserName(userName);
			theModel.addAttribute("theaccountlist", thelist);
			return "add-journalvoucher";
		}
		ra.addFlashAttribute("someerror", "Please Login to continue");
		return "redirect:/";
		
	}
    @RequestMapping("/bankvoucher")
    public String addBankVoucher(Model theModel, RedirectAttributes ra)
    {
        Object authentication = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(authentication instanceof UserDetails)
        {
            String userName = ((((UserDetails)authentication).getUsername()));
            Double credit = (double) 0, debit = (double) 0;
//          DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//          SimpleDateFormat dft= new SimpleDateFormat("yyyy-MM-dd");
//          LocalDateTime now = LocalDateTime.now();
//          Date curDate = (Date) df.parse(dft.format(now));
            BankVoucher toadd = new BankVoucher();
//          toadd.setDate(curDate);
            toadd.setDebitTotal(debit);
            toadd.setCreditTotal(credit);
            toadd.setUserName(userName);
            theModel.addAttribute("addelem",toadd);
            List<Account> thelist = accountService.getAccountByUserName(userName);
            theModel.addAttribute("theaccountlist", thelist);
            return "add-bankvoucher";
        }
        ra.addFlashAttribute("someerror", "Please Login to continue");
        return "redirect:/";
    }
}
