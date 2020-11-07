package com.luv2code.springsecurity.demo.controller;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.Query;
import javax.validation.Valid;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
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
import com.luv2code.springsecurity.demo.user.ScheduleUser;

@Controller
@RequestMapping("/process")
public class ProcessController {
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
	@RequestMapping("/specificschedule")
	@Transactional
	public String processSpecificSchedule(@Valid @ModelAttribute("newschedule") Schedule newSchedule,
			BindingResult theBindingResult,
			Model theModel,
			RedirectAttributes ra
			)
	{
		Object authentication = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(authentication instanceof UserDetails)
		{
			if(theBindingResult.hasErrors())
			{
				logger.info("Binding Result has some errors while processing form for adding schedule in Process Controller");
				return "add-schedule";
			}
			String userName = ((UserDetails)authentication).getUsername();
			String name = newSchedule.getScheduleName();

			logger.info("processing add schedule for user : " + userName + "in ProcessController, /process/schedule");
			Session crs = sessionFactory.getCurrentSession();
			Query theQuery = crs.createQuery("from Schedule where userName=:UserName"
					+ " and scheduleName=:ScheduleName", Schedule.class
					);
			theQuery.setParameter("UserName", userName);
			theQuery.setParameter("ScheduleName", name);
			List<Schedule> theList = theQuery.getResultList();
			logger.info("for schedule name" + name + "result list size is " + Integer.toString(theList.size()));
			if(theList.size() > 0 && newSchedule.getId() != theList.get(0).getId())
			{
				logger.warning("Schedule with this name already exists!");
				ra.addFlashAttribute("someerrror", "Schedule with this name already exists!");
				return "redirect:/add/Schedule";
			}
			
			scheduleService.save(newSchedule);
			ra.addFlashAttribute("successmessage", "Schedule creation successful!");
			return "redirect:/view/Schedule";
		}
		return "redirect:/";
	}
	@RequestMapping("/schedule")
	@Transactional
	public String processSchedule(@Valid @ModelAttribute("newschedule") ScheduleUser newSchedule,
			BindingResult theBindingResult,
			Model theModel,
			RedirectAttributes ra
			)
	{
		Object authentication = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(authentication instanceof UserDetails)
		{
			if(theBindingResult.hasErrors())
			{
				logger.info("Binding Result has some errors while processing form for adding schedule in Process Controller");
				return "add-schedule";
			}
			String userName = ((UserDetails)authentication).getUsername();
			String name = newSchedule.getScheduleName();

			logger.info("processing add schedule for user : " + userName + "in ProcessController, /process/schedule");
			Session crs = sessionFactory.getCurrentSession();
			Query theQuery = crs.createQuery("from Schedule where userName=:UserName"
					+ " and scheduleName=:ScheduleName", Schedule.class
					);
			theQuery.setParameter("UserName", userName);
			theQuery.setParameter("ScheduleName", name);
			List<Schedule> theList = theQuery.getResultList();
			logger.info("for schedule name" + name + "result list size is " + Integer.toString(theList.size()));
			if(theList.size() > 0)
			{
				logger.warning("Schedule with this name already exists!");
				ra.addFlashAttribute("someerror", "Schedule with this name already exists!");
				return "redirect:/add/Schedule";
			}
			
			Schedule toSave = new Schedule();
			toSave.setScheduleName(name);
			toSave.setUserName(userName);
			scheduleService.save(toSave);
			ra.addFlashAttribute("successmessage", "Schedule creation successful!");
			return "redirect:/view/Schedule";
		}
		return "redirect:/";
	}
	@RequestMapping("/group")
	public String addNewGroup(Model theModel, 
			@Valid @ModelAttribute("newgroup") Group theGroup, 
			BindingResult theBindingResult,
			RedirectAttributes ra)
	{
		Object authentication = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(authentication instanceof UserDetails)
		{
			if(theBindingResult.hasErrors())
			{
				return "add-group";
			}
			try {	
				String userName = ((UserDetails)authentication).getUsername();
				logger.info("processing add group for user : " + userName + "in ProcessController, /process/schedule");
				List<Group> theGroupList = groupService.getGroupByUserName(userName);
				for(int i = 0;i < theGroupList.size(); i++)
				{
					if(theGroupList.get(i).getGroupName().equals(theGroup.getGroupName()))
					{
						ra.addFlashAttribute("registrationError", "Group with the same name already exists!");
						return "redirect:/add/group";
					}
				}
				groupService.save(theGroup);
				logger.info("Group creation by the name : " + theGroup.getGroupName() + " successful!");
				ra.addFlashAttribute("successMessage", "Group creation by the name : " + theGroup.getGroupName() + " successful!");
				return "redirect:/add";
			}
			catch(Exception e) {
				logger.info("Couldn't execute the add group command due to exception: " + e);
				theModel.addAttribute("registrationError", "an unexpected error occured : " + e);
				return "add-group";
			}
		}
		theModel.addAttribute("registrationError", "Log in first to continue.");
		return "redirect:/";
	}
	@RequestMapping("/account")
	public String addNewAccount(
			@Valid @ModelAttribute("newaccount") Account theAccount , 
			Model theModel, 
			BindingResult theBindingResult,
			RedirectAttributes ra)
	{
		Object authentication = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(authentication instanceof UserDetails)
		{
			String userName = ((UserDetails)authentication).getUsername();
			List<Group> listOfGroups = groupService.getGroupByUserName(userName);
			if(theBindingResult.hasErrors())
			{
				theModel.addAttribute("listofgroups", listOfGroups);
				return "add-account";
			}
			try {	
				logger.info("processing add account for user : " + userName + "in ProcessController, /process/schedule" + " name of account : " + theAccount.getAccountName());
				List<Account> theAccountList = accountService.getAccountByUserName(userName);
				for(int i = 0;i < theAccountList.size(); i++)
				{
					if(theAccountList.get(i).getAccountName().equals(theAccount.getAccountName()))
					{
						ra.addFlashAttribute("registrationError", "Account with the same name already exists!");
						return "redirect:/add/account";
					}
				}
				accountService.save(theAccount);
				logger.info("Group creation by the name : " + theAccount.getAccountName() + " successful!");
				ra.addFlashAttribute("successMessage", "Group creation by the name : " + theAccount.getAccountName() + " successful!");
				return "redirect:/add";
			}
			catch(Exception e) {
				theModel.addAttribute("listofgroups", listOfGroups);
				logger.info("Couldn't execute the add group command due to exception: " + e);
				theModel.addAttribute("registrationError", "an unexpected error occured : " + e);
				return "add-account";
			}
		}
		theModel.addAttribute("registrationError", "Log in first to continue.");
		return "redirect:/";
	}
	@RequestMapping("/justupdateaccount")
	public String justUpdateAccount(
			@Valid @ModelAttribute("newaccount") Account theAccount , 
			Model theModel, 
			BindingResult theBindingResult,
			RedirectAttributes ra)
	{
		Object authentication = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(authentication instanceof UserDetails)
		{
			String userName = ((UserDetails)authentication).getUsername();
			List<Group> listOfGroups = groupService.getGroupByUserName(userName);
			if(theBindingResult.hasErrors())
			{
				theModel.addAttribute("listofgroups", listOfGroups);
				return "add-account";
			}
			try {	
				logger.info("processing update account for user : " + userName + "in ProcessController, /process/schedule" + " name of account : " + theAccount.getAccountName());
				
				List<Account> alreadyExist = accountService.getAccountByUserName(userName);
				for(int i = 0; i < alreadyExist.size(); i++)
				{
					if(alreadyExist.get(i).getAccountName().equals(theAccount.getAccountName()))
					{
						Account gg = alreadyExist.get(i);
						gg.setAddressLine1(theAccount.getAddressLine1());
						gg.setAddressLine2(theAccount.getAddressLine2());
						gg.setCity(theAccount.getCity());
						gg.setEmail(theAccount.getEmail());
						gg.setGuarantorName(theAccount.getGuarantorName());
						gg.setHsnNumber(theAccount.getHsnNumber());
						gg.setMobileNumber1(theAccount.getMobileNumber1());
						gg.setMobileNumber2(theAccount.getMobileNumber2());
						gg.setPan(theAccount.getPan());
						gg.setPincode(theAccount.getPincode());
						accountService.save(gg);
					}
				}
				logger.info("Group creation by the name : " + theAccount.getAccountName() + " successful!");
				ra.addFlashAttribute("successMessage", "Account details updated of : " + theAccount.getAccountName() + " updated successfully!");
				return "redirect:/view/account";
			}
			catch(Exception e) {
				theModel.addAttribute("listofgroups", listOfGroups);
				logger.info("Couldn't execute the add group command due to exception: " + e);
				theModel.addAttribute("registrationError", "an unexpected error occured : " + e);
				return "add-account";
			}
		}
		theModel.addAttribute("registrationError", "Log in first to continue.");
		return "redirect:/";
	}
	@RequestMapping("/stockitem")
	public String addStockItem(
			@ModelAttribute("stockitem") @Valid StockForm stockItem,
			BindingResult theBindingResult, 
			Model theModel, 
			RedirectAttributes ra)
	{
		Object authentication = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(authentication instanceof UserDetails)
		{
			String userName = ((UserDetails)authentication).getUsername();
			List<Group> listOfGroups = groupService.getGroupByUserName(userName);
			if(theBindingResult.hasErrors())
			{
				logger.info(theBindingResult.toString());
				theModel.addAttribute("listofgroup", listOfGroups);
				return "add-stockitem";
			}
			try {	
				logger.info("processing add account for user : " + userName + "in ProcessController, /process/schedule" + " name of account : " + stockItem.getStockItemName());
				List<StockItem> theItemList = stockItemService.getStockItemByUserName(userName);
				for(int i = 0;i < theItemList.size(); i++)
				{
					if(theItemList.get(i).getStockItemName().equals(stockItem.getStockItemName()))
					{
						logger.info("Stock item by the name : " + stockItem.getStockItemName() + " already exists!");
						theModel.addAttribute("listofgroup", listOfGroups);
						theModel.addAttribute("registrationError", "Stock item with the same name already exists!");
						return "add-stockitem";
					}
				}
				StockItem toSave = new StockItem();
				toSave = toSave.createStockItem(stockItem);
				stockItemService.save(toSave);
				logger.info("Stock Item creation by the name : " + toSave.getStockItemName() + " successful!");
				ra.addFlashAttribute("successMessage", "Stock item creation by the name : " + toSave.getStockItemName() + " successful!");
				return "redirect:/add";
			}
			catch(Exception e) {
				theModel.addAttribute("listofgroup", listOfGroups);
				logger.info("Couldn't execute the add stock-item command due to exception: " + e);
				theModel.addAttribute("registrationError", "an unexpected error occured : " + e);
				return "add-stockitem";
			}
		}
		theModel.addAttribute("registrationError", "Log in first to continue.");
		return "redirect:/";
	}
}
