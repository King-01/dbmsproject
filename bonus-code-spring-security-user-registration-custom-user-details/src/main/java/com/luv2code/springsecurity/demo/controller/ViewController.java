package com.luv2code.springsecurity.demo.controller;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.love2code.springsecurity.demo.form.DateForm;
import com.love2code.springsecurity.demo.form.DateGroupForm;
import com.love2code.springsecurity.demo.form.DateScheduleForm;
import com.love2code.springsecurity.demo.form.StockForm;
import com.luv2code.springsecurity.demo.entity.Account;
import com.luv2code.springsecurity.demo.entity.BankVoucher;
import com.luv2code.springsecurity.demo.entity.CashVoucher;
import com.luv2code.springsecurity.demo.entity.Group;
import com.luv2code.springsecurity.demo.entity.JournalVoucher;
import com.luv2code.springsecurity.demo.entity.Schedule;
import com.luv2code.springsecurity.demo.entity.StockItem;
import com.luv2code.springsecurity.demo.entity.StockTax;
import com.luv2code.springsecurity.demo.entity.Tax;
import com.luv2code.springsecurity.demo.service.AccountService;
import com.luv2code.springsecurity.demo.service.BankVoucherService;
import com.luv2code.springsecurity.demo.service.CashVoucherService;
import com.luv2code.springsecurity.demo.service.GroupService;
import com.luv2code.springsecurity.demo.service.JournalVoucherService;
import com.luv2code.springsecurity.demo.service.ScheduleService;
import com.luv2code.springsecurity.demo.service.StockItemService;
import com.luv2code.springsecurity.demo.service.TaxService;
import com.luv2code.springsecurity.demo.service.UserService;

@Controller
@RequestMapping("/view")
public class ViewController {
	private static SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-MM-dd");
	private static DecimalFormat df = new DecimalFormat("0.00");
	@Autowired
	private ScheduleService scheduleService;
	@Autowired
	private UserService userService;
	@Autowired
	private CashVoucherService cashVoucherService;
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private GroupService groupService;
	@Autowired
	private AccountService accountService;
	@Autowired
	private JournalVoucherService journalVoucherService;
    @Autowired
    private BankVoucherService bankVoucherService;
	@Autowired
	private StockItemService stockItemService;
	@Autowired
	private TaxService taxService;
	
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
	public String showScheduleById(Model theModel, @RequestParam("scheduleId") Long scheduleId, RedirectAttributes ra)
	{
		Object authentication = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(authentication instanceof UserDetails)
		{
			Schedule obj = scheduleService.get(scheduleId);
			if(!obj.getUserName().equals(((UserDetails)authentication).getUsername()))
			{
				ra.addFlashAttribute("registrationError", "You're either not allowed to view the resource or resource does not exist!");
				return "redirect:/";
			}
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
	public String showGroupById(Model theModel, @RequestParam("groupId") Long groupId, RedirectAttributes ra)
	{
		Object authentication = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(authentication instanceof UserDetails)
		{
			String userName = ((UserDetails)authentication).getUsername();
			Group obj = groupService.getGroupById(groupId);
			if(!(scheduleService.get(obj.getSchedule())).getUserName().equals(userName))
			{
				ra.addFlashAttribute("registrationError", "You're either not allowed to view the resource or resource does not exist!");
				return "redirect:/";
			}
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
	public String showAccountById(Model theModel, 
			@RequestParam("accountId") Long accountId, 
			RedirectAttributes ra)
	{
		Object authentication = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(authentication instanceof UserDetails)
		{
			String userName = ((UserDetails)authentication).getUsername();
			Account obj = accountService.getAccount(accountId);
			Group schedule = groupService.getGroupById(obj.getGroupId());
			Schedule thes = scheduleService.get(schedule.getSchedule());
			if(!thes.getUserName().equals(userName))
			{
				ra.addFlashAttribute("registrationError", "You're either not allowed to view the resource or resource does not exist!");
				return "redirect:/";
			}
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
	public String showStockItemById(Model theModel
			, @RequestParam("stockItemId") Long stockItemId
			, RedirectAttributes ra)
	{
		Object authentication = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(authentication instanceof UserDetails)
		{
			String userName = ((UserDetails)authentication).getUsername();
			StockItem obj = stockItemService.get(stockItemId);
			StockForm obj1 = new StockForm();
			obj1 = obj1.createStockForm(obj);
			Group schedule = groupService.getGroupById(obj.getGroupId());
			Schedule thes = scheduleService.get(schedule.getSchedule());
			if(!thes.getUserName().equals(userName))
			{
				ra.addFlashAttribute("registrationError", "You're either not allowed to view the resource or resource does not exist!");
				return "redirect:/";
			}
			theModel.addAttribute("scheduleName", schedule.getGroupName());
			theModel.addAttribute("scheduleId", schedule.getId());
			theModel.addAttribute("newstockitem", obj1);
			return "show-specific-stockitem";
			
		}
		
		ra.addFlashAttribute("someerror", "Please Login to continue");
		
		return "redirect:/";
	}

	@RequestMapping("/tax")
	public String showTax(Model theModel, RedirectAttributes ra)
	{
		Object authentication = 
				SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		if(authentication instanceof UserDetails)
		{
			String userName = ((UserDetails)authentication)
					.getUsername();
			List<Tax> theList
			= taxService.getTaxByUserName(userName);
			
			theModel.addAttribute("list", theList);
			return "show-tax";
		}
		
		ra.addFlashAttribute("someerror", "Please Login to continue");
		
		return "redirect:/";
	}
	@RequestMapping("/taxbyid")
	public String showTaxById(Model theModel
			, @RequestParam("taxId") Long theId
			, RedirectAttributes ra)
	{
		Object authentication = SecurityContextHolder
				.getContext().getAuthentication()
				.getPrincipal();
		if(authentication instanceof UserDetails)
		{
			String userName = ((UserDetails)authentication)
					.getUsername();
			Tax obj = taxService.get(theId);
			if(!userService.get(obj.getUserid()).getUserName().equals(userName))
			{
				ra.addFlashAttribute("registrationError", "You're either not allowed to view the resource or resource does not exist!");
				return "redirect:/";
			}
			theModel.addAttribute("display", obj);
			return "show-specific-tax";
			
		}
		
		ra.addFlashAttribute("someerror", "Please Login to continue");
		
		return "redirect:/";
	}
	@RequestMapping("/taxbystock")
	public String showTaxbyStock(Model theModel, RedirectAttributes ra)
	{
		Object authentication = 
				SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		if(authentication instanceof UserDetails)
		{
			String userName = ((UserDetails)authentication)
					.getUsername();
			List<Tax> theList
			= taxService.getTaxByUserName(userName);
			StockTax st = new StockTax();
			theModel.addAttribute("addelem", st);
			theModel.addAttribute("taxes", theList);
			return "show-general";
		}
		
		ra.addFlashAttribute("someerror", "Please Login to continue");
		
		return "redirect:/";
	}
	@RequestMapping("/stockbytax")
	public String showStockbyTax(Model theModel, RedirectAttributes ra)
	{
		Object authentication = 
				SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		if(authentication instanceof UserDetails)
		{
			String userName = ((UserDetails)authentication)
					.getUsername();
			List<StockItem> theList
			= stockItemService.getStockItemByUserName(userName);

			StockTax st = new StockTax();
			theModel.addAttribute("addelem", st);
			theModel.addAttribute("items", theList);
			return "show-general";
		}
		
		ra.addFlashAttribute("someerror", "Please Login to continue");
		
		return "redirect:/";
	}
	@RequestMapping("/journalvoucherbyaccount")
	@Transactional
	public String showJournalVoucher(
			@ModelAttribute("addelem") JournalVoucher addelem,
			Model theModel, 
			RedirectAttributes ra)
	{
		Object authentication = 
				SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		if(authentication instanceof UserDetails)
		{
			String userName = ((UserDetails)authentication)
					.getUsername();
			List<Account> theList
			= accountService.getAccountByUserName(userName);
			theModel.addAttribute("items", theList);
			if(addelem == null) 
			{
				;
			}
			else if(addelem.getAccountId() == null)
			{
				theModel.addAttribute("registrationError", "Please select an account to view its vouchers!");
			}
			else
			{
				Double tot = 0.0;
				List<JournalVoucher> theVouchers = journalVoucherService.
						getJournalVoucher(addelem.getAccountId(), userName);
				theModel.addAttribute("theVouchers", theVouchers);
				for(int i = 0; i < theVouchers.size(); i++)
				{
					tot += theVouchers.get(i).getCreditTotal();
					tot -= theVouchers.get(i).getDebitTotal();
					theVouchers.get(i).setDebitTotal(Double.parseDouble(df.format(theVouchers.get(i).getDebitTotal())));
					theVouchers.get(i).setCreditTotal(Double.parseDouble(df.format(theVouchers.get(i).getCreditTotal())));
				}
				String status = "Credit";
				if(tot < 0)
				{
					status = "Debit";
					tot = -tot;
				}
				theModel.addAttribute("tot", df.format(tot));
				theModel.addAttribute("status", status);
				Session crs = sessionFactory.getCurrentSession();
				theModel.addAttribute("id", crs.get(Account.class, addelem.getAccountId()));
			}
			return "show-journalvouchersbyaccount";
		}
		
		ra.addFlashAttribute("someerror", "Please Login to continue");
		
		return "redirect:/";
	}
	@RequestMapping("/alljournalvouchers")
	public String showAllJournalVouchers(
			Model theModel, 
			RedirectAttributes ra)
	{
		Object authentication = 
				SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		if(authentication instanceof UserDetails)
		{
			String userName = ((UserDetails)authentication)
					.getUsername();
			List<JournalVoucher> theList
			= journalVoucherService.getJournalVoucherByUserName(userName);
			Double tot = 0.0;
			for(int i = 0; i < theList.size(); i++)
			{
				tot += theList.get(i).getCreditTotal();
				tot -= theList.get(i).getDebitTotal();
				theList.get(i).setDebitTotal(Double.parseDouble(df.format(theList.get(i).getDebitTotal())));
				theList.get(i).setCreditTotal(Double.parseDouble(df.format(theList.get(i).getCreditTotal())));
			}
			String status = "Credit";
			if(tot < 0)
			{
				status = "Debit";
				tot = -tot;
			}
			theModel.addAttribute("tot", df.format(tot));
			theModel.addAttribute("status", status);
			theModel.addAttribute("items", theList);
			return "show-alljournalvouchers";
		}
		
		ra.addFlashAttribute("someerror", "Please Login to continue");
		
		return "redirect:/";
	}
	@RequestMapping("/specificjournalvoucher")
	public String showSpecificJournalVoucher(
			Model theModel, 
			@RequestParam("jvoucherId")int jvoucherid,
			RedirectAttributes ra)
	{
		Object authentication = 
				SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		if(authentication instanceof UserDetails)
		{
			String userName = ((UserDetails)authentication)
					.getUsername();
			Long jvoucherId =  (long)jvoucherid;
			JournalVoucher item = journalVoucherService.getJournalVoucher(jvoucherId);
			if(!item.getUserName().equals(userName))
			{
				ra.addFlashAttribute("registrationError", "You're either not allowed to view the resource or resource does not exist!");
				return "redirect:/";
			}	
			logger.info("I'm in showspecificjournalvoucher " + Long.toString(item.getAccountId()));
			theModel.addAttribute("addelem", item);
			return "show-specific-journalvoucher";
		}
		
		ra.addFlashAttribute("someerror", "Please Login to continue");
		
		return "redirect:/";
	}

    @RequestMapping("/bankvoucherbyaccount")
    @Transactional
    public String showBankVoucher(
            @ModelAttribute("addelem") BankVoucher addelem,
            Model theModel, 
            RedirectAttributes ra)
    {
        Object authentication = 
                SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        if(authentication instanceof UserDetails)
        {
            String userName = ((UserDetails)authentication)
                    .getUsername();
            List<Account> theList
            = accountService.getAccountByUserName(userName);
            theModel.addAttribute("items", theList);
            if(addelem == null) 
            {
                ;
            }
            else if(addelem.getAccountId() == null)
            {
                theModel.addAttribute("registrationError", "Please select an account to view its vouchers!");
            }
            else
            {
                Double tot = 0.0;
                List<BankVoucher> theVouchers = bankVoucherService.
                        getBankVoucher(addelem.getAccountId(), userName);
                theModel.addAttribute("theVouchers", theVouchers);
                for(int i = 0; i < theVouchers.size(); i++)
                {
                    tot += theVouchers.get(i).getCreditTotal();
                    tot -= theVouchers.get(i).getDebitTotal();
                    theVouchers.get(i).setDebitTotal(Double.parseDouble(df.format(theVouchers.get(i).getDebitTotal())));
                    theVouchers.get(i).setCreditTotal(Double.parseDouble(df.format(theVouchers.get(i).getCreditTotal())));
                }
                String status = "Credit";
                if(tot < 0)
                {
                    status = "Debit";
                    tot = -tot;
                }
                theModel.addAttribute("tot", df.format(tot));
                theModel.addAttribute("status", status);
                Session crs = sessionFactory.getCurrentSession();
                theModel.addAttribute("id", crs.get(Account.class, addelem.getAccountId()));
            }
            return "show-bankvouchersbyaccount";
        }
        
        ra.addFlashAttribute("someerror", "Please Login to continue");
        
        return "redirect:/";
    }
    @RequestMapping("/allbankvouchers")
    public String showAllBankVouchers(
            Model theModel, 
            RedirectAttributes ra)
    {
        Object authentication = 
                SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        if(authentication instanceof UserDetails)
        {
            String userName = ((UserDetails)authentication)
                    .getUsername();
            List<BankVoucher> theList
            = bankVoucherService.getBankVoucherByUserName(userName);
            Double tot = 0.0;
            for(int i = 0; i < theList.size(); i++)
            {
                tot += theList.get(i).getCreditTotal();
                tot -= theList.get(i).getDebitTotal();
                theList.get(i).setDebitTotal(Double.parseDouble(df.format(theList.get(i).getDebitTotal())));
                theList.get(i).setCreditTotal(Double.parseDouble(df.format(theList.get(i).getCreditTotal())));
            }
            String status = "Credit";
            if(tot < 0)
            {
                status = "Debit";
                tot = -tot;
            }
            theModel.addAttribute("tot", df.format(tot));
            theModel.addAttribute("status", status);
            theModel.addAttribute("items", theList);
            return "show-allbankvouchers";
        }
        
        ra.addFlashAttribute("someerror", "Please Login to continue");
        
        return "redirect:/";
    }
    @RequestMapping("/specificbankvoucher")
    @Transactional
    public String showSpecificBankVoucher(
            Model theModel, 
            @RequestParam("bvoucherId")int bvoucherid,
            RedirectAttributes ra)
    {
        Object authentication = 
                SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        if(authentication instanceof UserDetails)
        {
        	Long bvoucherId =  (long)bvoucherid;

            Session crs = sessionFactory.getCurrentSession();
            BankVoucher item = crs.get(BankVoucher.class, bvoucherId);
            String userName = ((UserDetails)authentication)
                    .getUsername();
            if(!item.getUserName().equals(userName))
			{
				ra.addFlashAttribute("registrationError", "You're either not allowed to view the resource or resource does not exist!");
				return "redirect:/";
			}
            logger.info("I'm in showspecificbankvoucher " + Long.toString(item.getAccountId()));
            theModel.addAttribute("addelem", item);
            return "show-specific-bankvoucher";
        }
        
        ra.addFlashAttribute("someerror", "Please Login to continue");
        
        return "redirect:/";
    }

    @RequestMapping("/cashvoucherbyaccount")
    @Transactional
    public String showCashVoucher(
            @ModelAttribute("addelem") CashVoucher addelem,
            Model theModel, 
            RedirectAttributes ra)
    {
        Object authentication = 
                SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        if(authentication instanceof UserDetails)
        {
            String userName = ((UserDetails)authentication)
                    .getUsername();
            List<Account> theList
            = accountService.getAccountByUserName(userName);
            theModel.addAttribute("items", theList);
            if(addelem == null) 
            {
                ;
            }
            else if(addelem.getAccountId() == null)
            {
                theModel.addAttribute("registrationError", "Please select an account to view its vouchers!");
            }
            else
            {
                Double tot = 0.0;
                List<CashVoucher> theVouchers = cashVoucherService.
                        getCashVoucher(addelem.getAccountId(), userName);
                theModel.addAttribute("theVouchers", theVouchers);
                for(int i = 0; i < theVouchers.size(); i++)
                {
                    tot += theVouchers.get(i).getCreditTotal();
                    tot -= theVouchers.get(i).getDebitTotal();
                    theVouchers.get(i).setDebitTotal(Double.parseDouble(df.format(theVouchers.get(i).getDebitTotal())));
                    theVouchers.get(i).setCreditTotal(Double.parseDouble(df.format(theVouchers.get(i).getCreditTotal())));
                }
                String status = "Credit";
                if(tot < 0)
                {
                    status = "Debit";
                    tot = -tot;
                }
                theModel.addAttribute("tot", df.format(tot));
                theModel.addAttribute("status", status);
                Session crs = sessionFactory.getCurrentSession();
                theModel.addAttribute("id", crs.get(Account.class, addelem.getAccountId()));
            }
            return "show-cashvouchersbyaccount";
        }
        
        ra.addFlashAttribute("someerror", "Please Login to continue");
        
        return "redirect:/";
    }
    @RequestMapping("/allcashvouchers")
    public String showAllCashVouchers(
            Model theModel, 
            RedirectAttributes ra)
    {
        Object authentication = 
                SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        if(authentication instanceof UserDetails)
        {
            String userName = ((UserDetails)authentication)
                    .getUsername();
            List<CashVoucher> theList
            = cashVoucherService.getCashVoucherByUserName(userName);
            Double tot = 0.0;
            for(int i = 0; i < theList.size(); i++)
            {
                tot += theList.get(i).getCreditTotal();
                tot -= theList.get(i).getDebitTotal();
                theList.get(i).setDebitTotal(Double.parseDouble(df.format(theList.get(i).getDebitTotal())));
                theList.get(i).setCreditTotal(Double.parseDouble(df.format(theList.get(i).getCreditTotal())));
            }
            String status = "Credit";
            if(tot < 0)
            {
                status = "Debit";
                tot = -tot;
            }
            theModel.addAttribute("tot", df.format(tot));
            theModel.addAttribute("status", status);
            theModel.addAttribute("items", theList);
            return "show-allcashvouchers";
        }
        
        ra.addFlashAttribute("someerror", "Please Login to continue");
        
        return "redirect:/";
    }
    @RequestMapping("/specificcashvoucher")
    @Transactional
    public String showSpecificCashVoucher(
            Model theModel, 
            @RequestParam("cvoucherId")int cvoucherid,
            RedirectAttributes ra)
    {
        Object authentication = 
                SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        if(authentication instanceof UserDetails)
        {
            Long cvoucherId =  (long)cvoucherid;
            Session crs = sessionFactory.getCurrentSession();
            CashVoucher item = crs.get(CashVoucher.class, cvoucherId);
            String userName = ((UserDetails)authentication)
                    .getUsername();
            if(!item.getUserName().equals(userName))
			{
				ra.addFlashAttribute("registrationError", "You're either not allowed to view the resource or resource does not exist!");
				return "redirect:/";
			}
            logger.info("I'm in showspecificcashvoucher " + Long.toString(item.getAccountId()));
            theModel.addAttribute("addelem", item);
            return "show-specific-cashvoucher";
        }
        
        ra.addFlashAttribute("someerror", "Please Login to continue");
        
        return "redirect:/";
    }
    @RequestMapping("/cashvoucherbetweendates")
    public String showCashVoucherBetweenDates(
    		@ModelAttribute("theform") DateForm theform,
    		BindingResult theBindingResult,
            Model theModel, 
            RedirectAttributes ra
    		)
    {
        Object authentication = 
                SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        if(authentication instanceof UserDetails)
        {
        	String userName = ((UserDetails)authentication)
                    .getUsername();
        	if(theform == null || (theform.getEndDate() == null && theform.getStartDate() == null && theform.getAccountId() == null))
        	{
        		theModel.addAttribute("registrationError" ,"Choose atleast one of Start Date or End Date or Account to proceed for query!");
        		theform = new DateForm();
        		theModel.addAttribute("theform", theform);
        		List<Account> thel = accountService.getAccountByUserName(userName);
            	theModel.addAttribute("items", thel);
            	return "show-cashvoucherbetweendates";
        	}
        	logger.info(theform.toString());
        	List<CashVoucher> theList = new ArrayList<> ();
        	int key = 0;
        	if(theform.getStartDate() == null && theform.getEndDate() == null)
        	{
        		key = 1;
        	}
        	else if(theform.getStartDate() == null)
        	{
        		List<CashVoucher> theList1 = cashVoucherService.getCashVoucherByUserName(userName);
        		for(int i = 0; i < theList1.size(); i++)
        		{
        			try {
	        			Date temp = dt1.parse(theList1.get(i).getDate());
	        			Date temp1 = dt1.parse(dt1.format(theform.getEndDate()));
	        			if(temp1.after(temp))
	        			{
	        				theList.add(theList1.get(i));
	        			}
        			} catch(Exception e)
        			{
        				;
        			}
        		}
        	}
        	else if(theform.getEndDate() == null)
        	{
        		List<CashVoucher> theList1 = cashVoucherService.getCashVoucherByUserName(userName);
        		for(int i = 0; i < theList1.size(); i++)
        		{
        			try {
	        			Date temp = dt1.parse(theList1.get(i).getDate());
	        			Date temp1 = dt1.parse(dt1.format(theform.getStartDate()));
	        			if(!temp1.after(temp))
	        			{
	        				theList.add(theList1.get(i));
	        			}
        			} catch(Exception e)
        			{
        				;
        			}
        		}
        		
        	}
        	else
        	{
                List<CashVoucher> theList1 = cashVoucherService.getCashVoucherByUserName(userName);
                for(int i = 0; i < theList1.size(); i++)
                {
                    try {
                        Date temp = dt1.parse(theList1.get(i).getDate());
                        Date temp1 = dt1.parse(dt1.format(theform.getStartDate()));
                        if(!temp1.after(temp))
                        {
                            theList.add(theList1.get(i));
                        }
                    } catch(Exception e)
                    {
                        ;
                    }
                }
                theList1.clear();
                theList1.addAll(theList);
                theList.clear();
                for(int i = 0; i < theList1.size(); i++)
                {
                    try {
                        Date temp = dt1.parse(theList1.get(i).getDate());
                        Date temp1 = dt1.parse(dt1.format(theform.getEndDate()));
                        if(!temp1.before(temp))
                        {
                            theList.add(theList1.get(i));
                        }
                    } catch(Exception e)
                    {
                        ;
                    }
                	
                }
        	}
        	if(key == 1)
        	{
        		theList = cashVoucherService.getCashVoucherByUserName(userName);
        	}
        	if(theform.getAccountId() == null)
        	{
        		;
        	}
        	else
        	{
        		logger.info("The List size : " + Integer.toString(theList.size()));
        		List<CashVoucher> theList1 = new ArrayList<> ();
        		for(int i = 0; i < theList.size(); i++)
        		{
        			logger.info("i");
        			logger.info(theform.getAccountId());
        			logger.info(theList.get(i).getAccountId());
        			if(theList.get(i).getAccountId() == theform.getAccountId())
        			{
        				theList1.add(theList.get(i));
        			}
        		}
        		Account theaccount = accountService.getAccount(theform.getAccountId());
        		theModel.addAttribute("id", theaccount);
        		theList.clear();
        		theList.addAll(theList1);
        		logger.info("The List size : " + Integer.toString(theList.size()));
        		
        	}
        	double price = 0.00;
        	for(int i = 0 ; i < theList.size(); i++)
        	{
        		price += theList.get(i).getCreditTotal();
        		price -= theList.get(i).getDebitTotal();
        	}
        	String status = "Credit";
        	if(price < 0.00)
        	{
        		status = "Debit";
        		price = -price;
        	}
        	price = Double.parseDouble(df.format(price));
        	theModel.addAttribute("theList", theList);
        	theModel.addAttribute("status", status);
    		theModel.addAttribute("theform", theform);
        	theModel.addAttribute("price", price);
        	List<Account> thel = accountService.getAccountByUserName(userName);
        	theModel.addAttribute("items", thel);
        	return "show-cashvoucherbetweendates";
        }
      
        ra.addFlashAttribute("someerror", "Please Login to continue");
        
        return "redirect:/";
    }
    @RequestMapping("/cashvoucherbetweendatesbygroup")
    public String showCashVoucherBetweenDates(
            @ModelAttribute("theform") DateGroupForm theform,
            BindingResult theBindingResult,
            Model theModel, 
            RedirectAttributes ra
            )
    {
        Object authentication = 
                SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        if(authentication instanceof UserDetails)
        {
            String userName = ((UserDetails)authentication)
                    .getUsername();
            if(theform == null || (theform.getEndDate() == null && theform.getStartDate() == null && theform.getGroupId() == null))
            {
                theModel.addAttribute("registrationError" ,"Choose atleast one of Start Date or End Date or Group to proceed for query!");
                theform = new DateGroupForm();
                theModel.addAttribute("theform", theform);
                List<Group> thel = groupService.getGroupByUserName(userName);
                theModel.addAttribute("items", thel);
                return "show-cashvoucherbetweendatesbygroup";
            }
            logger.info(theform.toString());
            List<CashVoucher> theList = new ArrayList<> ();
            int key = 0;
            if(theform.getStartDate() == null && theform.getEndDate() == null)
            {
                key = 1;
            }
            else if(theform.getStartDate() == null)
            {
                List<CashVoucher> theList1 = cashVoucherService.getCashVoucherByUserName(userName);
                for(int i = 0; i < theList1.size(); i++)
                {
                    try {
                        Date temp = dt1.parse(theList1.get(i).getDate());
                        Date temp1 = dt1.parse(dt1.format(theform.getEndDate()));
                        logger.info(temp1.after(temp));
                        if(temp1.after(temp))
                        {
                            theList.add(theList1.get(i));
                        }
                    } catch(Exception e)
                    {
                        ;
                    }
                }
            }
            else if(theform.getEndDate() == null)
            {
                List<CashVoucher> theList1 = cashVoucherService.getCashVoucherByUserName(userName);
                for(int i = 0; i < theList1.size(); i++)
                {
                    try {
                        Date temp = dt1.parse(theList1.get(i).getDate());
                        Date temp1 = dt1.parse(dt1.format(theform.getStartDate()));
                        if(!temp1.after(temp))
                        {
                            theList.add(theList1.get(i));
                        }
                    } catch(Exception e)
                    {
                        ;
                    }
                }
                
            }
            else
            {
                List<CashVoucher> theList1 = cashVoucherService.getCashVoucherByUserName(userName);
                for(int i = 0; i < theList1.size(); i++)
                {
                    try {
                        Date temp = dt1.parse(theList1.get(i).getDate());
                        Date temp1 = dt1.parse(dt1.format(theform.getStartDate()));
                        if(!temp1.after(temp))
                        {
                            theList.add(theList1.get(i));
                        }
                    } catch(Exception e)
                    {
                        ;
                    }
                }
                theList1.clear();
                theList1.addAll(theList);
                theList.clear();
                for(int i = 0; i < theList1.size(); i++)
                {
                    try {
                        Date temp = dt1.parse(theList1.get(i).getDate());
                        Date temp1 = dt1.parse(dt1.format(theform.getEndDate()));
                        if(!temp1.before(temp))
                        {
                            theList.add(theList1.get(i));
                        }
                    } catch(Exception e)
                    {
                        ;
                    }
                	
                }
            }
            if(key == 1)
            {
                theList = cashVoucherService.getCashVoucherByUserName(userName);
            }
            if(theform.getGroupId() == null)
            {
                ;
            }
            else
            {
//            	List<Account> theAccountList = accountService.getAccountByGroupId(theform.getGroupId());
                logger.info("The List size : " + Integer.toString(theList.size()));
                List<CashVoucher> theList1 = new ArrayList<> ();
                for(int i = 0; i < theList.size(); i++)
                {
                    logger.info("i");
                    logger.info(theform.getGroupId());
                    logger.info(theList.get(i).getAccountId());
//                    for(int j = 0 ; j < theAccountList.size(); j++) {
//	                    if(theList.get(i).getAccountId() == theAccountList.get(j).getId())
//	                    {
//	                        theList1.add(theList.get(i));
//	                    }
//                    }
                    if(accountService.getAccount(theList.get(i).getAccountId()).getGroupId() == theform.getGroupId())
                    {
                    	theList1.add(theList.get(i));
                    }
                }
        		Group theaccount = groupService.getGroupById(theform.getGroupId());
        		theModel.addAttribute("id", theaccount);
                theList.clear();
                theList.addAll(theList1);
                logger.info("The List size : " + Integer.toString(theList.size()));
                
            }
            double price = 0.00;
            for(int i = 0 ; i < theList.size(); i++)
            {
                price += theList.get(i).getCreditTotal();
                price -= theList.get(i).getDebitTotal();
            }
            String status = "Credit";
            if(price < 0.00)
            {
                status = "Debit";
                price = -price;
            }
            price = Double.parseDouble(df.format(price));
            theModel.addAttribute("theList", theList);
            theModel.addAttribute("status", status);
            theModel.addAttribute("theform", theform);
            theModel.addAttribute("price", price);
            List<Group> thel = groupService.getGroupByUserName(userName);
            theModel.addAttribute("items", thel);
            return "show-cashvoucherbetweendatesbygroup";
        }
      
        ra.addFlashAttribute("someerror", "Please Login to continue");
        
        return "redirect:/";
    }
    @RequestMapping("/cashvoucherbetweendatesbyschedule")
    public String showCashVoucherBetweenDates(
            @ModelAttribute("theform") DateScheduleForm theform,
            BindingResult theBindingResult,
            Model theModel, 
            RedirectAttributes ra
            )
    {
        Object authentication = 
                SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        if(authentication instanceof UserDetails)
        {
            String userName = ((UserDetails)authentication)
                    .getUsername();
            if(theform == null || (theform.getEndDate() == null && theform.getStartDate() == null && theform.getScheduleId() == null))
            {
                theModel.addAttribute("registrationError" ,"Choose atleast one of Start Date or End Date or Schedule to proceed for query!");
                theform = new DateScheduleForm();
                theModel.addAttribute("theform", theform);
                List<Schedule> thel = scheduleService.getScheduleByUserName(userName);
                theModel.addAttribute("items", thel);
                return "show-cashvoucherbetweendatesbyschedule";
            }
            logger.info(theform.toString());
            List<CashVoucher> theList = new ArrayList<> ();
            int key = 0;
            if(theform.getStartDate() == null && theform.getEndDate() == null)
            {
                key = 1;
            }
            else if(theform.getStartDate() == null)
            {
                List<CashVoucher> theList1 = cashVoucherService.getCashVoucherByUserName(userName);
                for(int i = 0; i < theList1.size(); i++)
                {
                    try {
                        Date temp = dt1.parse(theList1.get(i).getDate());
                        Date temp1 = dt1.parse(dt1.format(theform.getEndDate()));
                        logger.info(temp1.after(temp));
                        if(temp1.after(temp))
                        {
                            theList.add(theList1.get(i));
                        }
                    } catch(Exception e)
                    {
                        ;
                    }
                }
            }
            else if(theform.getEndDate() == null)
            {
                List<CashVoucher> theList1 = cashVoucherService.getCashVoucherByUserName(userName);
                for(int i = 0; i < theList1.size(); i++)
                {
                    try {
                        Date temp = dt1.parse(theList1.get(i).getDate());
                        Date temp1 = dt1.parse(dt1.format(theform.getStartDate()));
                        if(!temp1.after(temp))
                        {
                            theList.add(theList1.get(i));
                        }
                    } catch(Exception e)
                    {
                        ;
                    }
                }
                
            }
            else
            {
                List<CashVoucher> theList1 = cashVoucherService.getCashVoucherByUserName(userName);
                for(int i = 0; i < theList1.size(); i++)
                {
                    try {
                        Date temp = dt1.parse(theList1.get(i).getDate());
                        Date temp1 = dt1.parse(dt1.format(theform.getStartDate()));
                        if(!temp1.after(temp))
                        {
                            theList.add(theList1.get(i));
                        }
                    } catch(Exception e)
                    {
                        ;
                    }
                }
                theList1.clear();
                theList1.addAll(theList);
                theList.clear();
                for(int i = 0; i < theList1.size(); i++)
                {
                    try {
                        Date temp = dt1.parse(theList1.get(i).getDate());
                        Date temp1 = dt1.parse(dt1.format(theform.getEndDate()));
                        if(!temp1.before(temp))
                        {
                            theList.add(theList1.get(i));
                        }
                    } catch(Exception e)
                    {
                        ;
                    }
                	
                }
            }
            if(key == 1)
            {
                theList = cashVoucherService.getCashVoucherByUserName(userName);
            }
            if(theform.getScheduleId() == null)
            {
                ;
            }
            else
            {
                logger.info("The List size : " + Integer.toString(theList.size()));
                List<CashVoucher> theList1 = new ArrayList<> ();
                for(int i = 0; i < theList.size(); i++)
                {
                    logger.info("i");
                    logger.info(theform.getScheduleId());
                    logger.info(theList.get(i).getAccountId());
                    if(groupService.getGroupById(theList.get(i).getAccountId()).getSchedule() == theform.getScheduleId())
                    {
                    	theList1.add(theList.get(i));
                    }
                }
        		Schedule theaccount = scheduleService.get(theform.getScheduleId());
        		theModel.addAttribute("id", theaccount);
                theList.clear();
                theList.addAll(theList1);
                logger.info("The List size : " + Integer.toString(theList.size()));
                
            }
            double price = 0.00;
            for(int i = 0 ; i < theList.size(); i++)
            {
                price += theList.get(i).getCreditTotal();
                price -= theList.get(i).getDebitTotal();
            }
            String status = "Credit";
            if(price < 0.00)
            {
                status = "Debit";
                price = -price;
            }
            price = Double.parseDouble(df.format(price));
            theModel.addAttribute("theList", theList);
            theModel.addAttribute("status", status);
            theModel.addAttribute("theform", theform);
            theModel.addAttribute("price", price);
            List<Schedule> thel = scheduleService.getScheduleByUserName(userName);
            theModel.addAttribute("items", thel);
            return "show-cashvoucherbetweendatesbyschedule";
        }
      
        ra.addFlashAttribute("someerror", "Please Login to continue");
        
        return "redirect:/";
    }
    @RequestMapping("/bankvoucherbetweendates")
    public String showBankVoucherBetweenDates(
            @ModelAttribute("theform") DateForm theform,
            BindingResult theBindingResult,
            Model theModel, 
            RedirectAttributes ra
            )
    {
        Object authentication = 
                SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        if(authentication instanceof UserDetails)
        {
            String userName = ((UserDetails)authentication)
                    .getUsername();
            if(theform == null || (theform.getEndDate() == null && theform.getStartDate() == null && theform.getAccountId() == null))
            {
                theModel.addAttribute("registrationError" ,"Choose atleast one of Start Date or End Date or Account to proceed for query!");
                theform = new DateForm();
                theModel.addAttribute("theform", theform);
                List<Account> thel = accountService.getAccountByUserName(userName);
                theModel.addAttribute("items", thel);
                return "show-bankvoucherbetweendates";
            }
            logger.info(theform.toString());
            List<BankVoucher> theList = new ArrayList<> ();
            int key = 0;
            if(theform.getStartDate() == null && theform.getEndDate() == null)
            {
                key = 1;
            }
            else if(theform.getStartDate() == null)
            {
                List<BankVoucher> theList1 = bankVoucherService.getBankVoucherByUserName(userName);
                for(int i = 0; i < theList1.size(); i++)
                {
                    try {
                        Date temp = dt1.parse(theList1.get(i).getDate());
                        Date temp1 = dt1.parse(dt1.format(theform.getEndDate()));
                        if(temp1.after(temp))
                        {
                            theList.add(theList1.get(i));
                        }
                    } catch(Exception e)
                    {
                        ;
                    }
                }
            }
            else if(theform.getEndDate() == null)
            {
                List<BankVoucher> theList1 = bankVoucherService.getBankVoucherByUserName(userName);
                for(int i = 0; i < theList1.size(); i++)
                {
                    try {
                        Date temp = dt1.parse(theList1.get(i).getDate());
                        Date temp1 = dt1.parse(dt1.format(theform.getStartDate()));
                        if(!temp1.after(temp))
                        {
                            theList.add(theList1.get(i));
                        }
                    } catch(Exception e)
                    {
                        ;
                    }
                }
                
            }
            else
            {
                List<BankVoucher> theList1 = bankVoucherService.getBankVoucherByUserName(userName);
                for(int i = 0; i < theList1.size(); i++)
                {
                    try {
                        Date temp = dt1.parse(theList1.get(i).getDate());
                        Date temp1 = dt1.parse(dt1.format(theform.getStartDate()));
                        if(!temp1.after(temp))
                        {
                            theList.add(theList1.get(i));
                        }
                    } catch(Exception e)
                    {
                        ;
                    }
                }
                theList1.clear();
                theList1.addAll(theList);
                theList.clear();
                for(int i = 0; i < theList1.size(); i++)
                {
                    try {
                        Date temp = dt1.parse(theList1.get(i).getDate());
                        Date temp1 = dt1.parse(dt1.format(theform.getEndDate()));
                        if(!temp1.before(temp))
                        {
                            theList.add(theList1.get(i));
                        }
                    } catch(Exception e)
                    {
                        ;
                    }
                    
                }
            }
            if(key == 1)
            {
                theList = bankVoucherService.getBankVoucherByUserName(userName);
            }
            if(theform.getAccountId() == null)
            {
                ;
            }
            else
            {
                logger.info("The List size : " + Integer.toString(theList.size()));
                List<BankVoucher> theList1 = new ArrayList<> ();
                for(int i = 0; i < theList.size(); i++)
                {
                    logger.info("i");
                    logger.info(theform.getAccountId());
                    logger.info(theList.get(i).getAccountId());
                    if(theList.get(i).getAccountId() == theform.getAccountId())
                    {
                        theList1.add(theList.get(i));
                    }
                }
                Account theaccount = accountService.getAccount(theform.getAccountId());
                theModel.addAttribute("id", theaccount);
                theList.clear();
                theList.addAll(theList1);
                logger.info("The List size : " + Integer.toString(theList.size()));
                
            }
            double price = 0.00;
            for(int i = 0 ; i < theList.size(); i++)
            {
                price += theList.get(i).getCreditTotal();
                price -= theList.get(i).getDebitTotal();
            }
            String status = "Credit";
            if(price < 0.00)
            {
                status = "Debit";
                price = -price;
            }
            price = Double.parseDouble(df.format(price));
            theModel.addAttribute("theList", theList);
            theModel.addAttribute("status", status);
            theModel.addAttribute("theform", theform);
            theModel.addAttribute("price", price);
            List<Account> thel = accountService.getAccountByUserName(userName);
            theModel.addAttribute("items", thel);
            return "show-bankvoucherbetweendates";
        }
      
        ra.addFlashAttribute("someerror", "Please Login to continue");
        
        return "redirect:/";
    }
    @RequestMapping("/bankvoucherbetweendatesbygroup")
    public String showBankVoucherBetweenDates(
            @ModelAttribute("theform") DateGroupForm theform,
            BindingResult theBindingResult,
            Model theModel, 
            RedirectAttributes ra
            )
    {
        Object authentication = 
                SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        if(authentication instanceof UserDetails)
        {
            String userName = ((UserDetails)authentication)
                    .getUsername();
            if(theform == null || (theform.getEndDate() == null && theform.getStartDate() == null && theform.getGroupId() == null))
            {
                theModel.addAttribute("registrationError" ,"Choose atleast one of Start Date or End Date or Group to proceed for query!");
                theform = new DateGroupForm();
                theModel.addAttribute("theform", theform);
                List<Group> thel = groupService.getGroupByUserName(userName);
                theModel.addAttribute("items", thel);
                return "show-bankvoucherbetweendatesbygroup";
            }
            logger.info(theform.toString());
            List<BankVoucher> theList = new ArrayList<> ();
            int key = 0;
            if(theform.getStartDate() == null && theform.getEndDate() == null)
            {
                key = 1;
            }
            else if(theform.getStartDate() == null)
            {
                List<BankVoucher> theList1 = bankVoucherService.getBankVoucherByUserName(userName);
                for(int i = 0; i < theList1.size(); i++)
                {
                    try {
                        Date temp = dt1.parse(theList1.get(i).getDate());
                        Date temp1 = dt1.parse(dt1.format(theform.getEndDate()));
                        logger.info(temp1.after(temp));
                        if(temp1.after(temp))
                        {
                            theList.add(theList1.get(i));
                        }
                    } catch(Exception e)
                    {
                        ;
                    }
                }
            }
            else if(theform.getEndDate() == null)
            {
                List<BankVoucher> theList1 = bankVoucherService.getBankVoucherByUserName(userName);
                for(int i = 0; i < theList1.size(); i++)
                {
                    try {
                        Date temp = dt1.parse(theList1.get(i).getDate());
                        Date temp1 = dt1.parse(dt1.format(theform.getStartDate()));
                        if(!temp1.after(temp))
                        {
                            theList.add(theList1.get(i));
                        }
                    } catch(Exception e)
                    {
                        ;
                    }
                }
                
            }
            else
            {
                List<BankVoucher> theList1 = bankVoucherService.getBankVoucherByUserName(userName);
                for(int i = 0; i < theList1.size(); i++)
                {
                    try {
                        Date temp = dt1.parse(theList1.get(i).getDate());
                        Date temp1 = dt1.parse(dt1.format(theform.getStartDate()));
                        if(!temp1.after(temp))
                        {
                            theList.add(theList1.get(i));
                        }
                    } catch(Exception e)
                    {
                        ;
                    }
                }
                theList1.clear();
                theList1.addAll(theList);
                theList.clear();
                for(int i = 0; i < theList1.size(); i++)
                {
                    try {
                        Date temp = dt1.parse(theList1.get(i).getDate());
                        Date temp1 = dt1.parse(dt1.format(theform.getEndDate()));
                        if(!temp1.before(temp))
                        {
                            theList.add(theList1.get(i));
                        }
                    } catch(Exception e)
                    {
                        ;
                    }
                    
                }
            }
            if(key == 1)
            {
                theList = bankVoucherService.getBankVoucherByUserName(userName);
            }
            if(theform.getGroupId() == null)
            {
                ;
            }
            else
            {
//              List<Account> theAccountList = accountService.getAccountByGroupId(theform.getGroupId());
                logger.info("The List size : " + Integer.toString(theList.size()));
                List<BankVoucher> theList1 = new ArrayList<> ();
                for(int i = 0; i < theList.size(); i++)
                {
                    logger.info("i");
                    logger.info(theform.getGroupId());
                    logger.info(theList.get(i).getAccountId());
//                    for(int j = 0 ; j < theAccountList.size(); j++) {
//                      if(theList.get(i).getAccountId() == theAccountList.get(j).getId())
//                      {
//                          theList1.add(theList.get(i));
//                      }
//                    }
                    if(accountService.getAccount(theList.get(i).getAccountId()).getGroupId() == theform.getGroupId())
                    {
                        theList1.add(theList.get(i));
                    }
                }
                Group theaccount = groupService.getGroupById(theform.getGroupId());
                theModel.addAttribute("id", theaccount);
                theList.clear();
                theList.addAll(theList1);
                logger.info("The List size : " + Integer.toString(theList.size()));
                
            }
            double price = 0.00;
            for(int i = 0 ; i < theList.size(); i++)
            {
                price += theList.get(i).getCreditTotal();
                price -= theList.get(i).getDebitTotal();
            }
            String status = "Credit";
            if(price < 0.00)
            {
                status = "Debit";
                price = -price;
            }
            price = Double.parseDouble(df.format(price));
            theModel.addAttribute("theList", theList);
            theModel.addAttribute("status", status);
            theModel.addAttribute("theform", theform);
            theModel.addAttribute("price", price);
            List<Group> thel = groupService.getGroupByUserName(userName);
            theModel.addAttribute("items", thel);
            return "show-bankvoucherbetweendatesbygroup";
        }
      
        ra.addFlashAttribute("someerror", "Please Login to continue");
        
        return "redirect:/";
    }
    @RequestMapping("/bankvoucherbetweendatesbyschedule")
    public String showBankVoucherBetweenDates(
            @ModelAttribute("theform") DateScheduleForm theform,
            BindingResult theBindingResult,
            Model theModel, 
            RedirectAttributes ra
            )
    {
        Object authentication = 
                SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        if(authentication instanceof UserDetails)
        {
            String userName = ((UserDetails)authentication)
                    .getUsername();
            if(theform == null || (theform.getEndDate() == null && theform.getStartDate() == null && theform.getScheduleId() == null))
            {
                theModel.addAttribute("registrationError" ,"Choose atleast one of Start Date or End Date or Schedule to proceed for query!");
                theform = new DateScheduleForm();
                theModel.addAttribute("theform", theform);
                List<Schedule> thel = scheduleService.getScheduleByUserName(userName);
                theModel.addAttribute("items", thel);
                return "show-bankvoucherbetweendatesbyschedule";
            }
            logger.info(theform.toString());
            List<BankVoucher> theList = new ArrayList<> ();
            int key = 0;
            if(theform.getStartDate() == null && theform.getEndDate() == null)
            {
                key = 1;
            }
            else if(theform.getStartDate() == null)
            {
                List<BankVoucher> theList1 = bankVoucherService.getBankVoucherByUserName(userName);
                for(int i = 0; i < theList1.size(); i++)
                {
                    try {
                        Date temp = dt1.parse(theList1.get(i).getDate());
                        Date temp1 = dt1.parse(dt1.format(theform.getEndDate()));
                        logger.info(temp1.after(temp));
                        if(temp1.after(temp))
                        {
                            theList.add(theList1.get(i));
                        }
                    } catch(Exception e)
                    {
                        ;
                    }
                }
            }
            else if(theform.getEndDate() == null)
            {
                List<BankVoucher> theList1 = bankVoucherService.getBankVoucherByUserName(userName);
                for(int i = 0; i < theList1.size(); i++)
                {
                    try {
                        Date temp = dt1.parse(theList1.get(i).getDate());
                        Date temp1 = dt1.parse(dt1.format(theform.getStartDate()));
                        if(!temp1.after(temp))
                        {
                            theList.add(theList1.get(i));
                        }
                    } catch(Exception e)
                    {
                        ;
                    }
                }
                
            }
            else
            {
                List<BankVoucher> theList1 = bankVoucherService.getBankVoucherByUserName(userName);
                for(int i = 0; i < theList1.size(); i++)
                {
                    try {
                        Date temp = dt1.parse(theList1.get(i).getDate());
                        Date temp1 = dt1.parse(dt1.format(theform.getStartDate()));
                        if(!temp1.after(temp))
                        {
                            theList.add(theList1.get(i));
                        }
                    } catch(Exception e)
                    {
                        ;
                    }
                }
                theList1.clear();
                theList1.addAll(theList);
                theList.clear();
                for(int i = 0; i < theList1.size(); i++)
                {
                    try {
                        Date temp = dt1.parse(theList1.get(i).getDate());
                        Date temp1 = dt1.parse(dt1.format(theform.getEndDate()));
                        if(!temp1.before(temp))
                        {
                            theList.add(theList1.get(i));
                        }
                    } catch(Exception e)
                    {
                        ;
                    }
                    
                }
            }
            if(key == 1)
            {
                theList = bankVoucherService.getBankVoucherByUserName(userName);
            }
            if(theform.getScheduleId() == null)
            {
                ;
            }
            else
            {
                logger.info("The List size : " + Integer.toString(theList.size()));
                List<BankVoucher> theList1 = new ArrayList<> ();
                for(int i = 0; i < theList.size(); i++)
                {
                    logger.info("i");
                    logger.info(theform.getScheduleId());
                    logger.info(theList.get(i).getAccountId());
                    if(groupService.getGroupById(theList.get(i).getAccountId()).getSchedule() == theform.getScheduleId())
                    {
                        theList1.add(theList.get(i));
                    }
                }
                Schedule theaccount = scheduleService.get(theform.getScheduleId());
                theModel.addAttribute("id", theaccount);
                theList.clear();
                theList.addAll(theList1);
                logger.info("The List size : " + Integer.toString(theList.size()));
                
            }
            double price = 0.00;
            for(int i = 0 ; i < theList.size(); i++)
            {
                price += theList.get(i).getCreditTotal();
                price -= theList.get(i).getDebitTotal();
            }
            String status = "Credit";
            if(price < 0.00)
            {
                status = "Debit";
                price = -price;
            }
            price = Double.parseDouble(df.format(price));
            theModel.addAttribute("theList", theList);
            theModel.addAttribute("status", status);
            theModel.addAttribute("theform", theform);
            theModel.addAttribute("price", price);
            List<Schedule> thel = scheduleService.getScheduleByUserName(userName);
            theModel.addAttribute("items", thel);
            return "show-bankvoucherbetweendatesbyschedule";
        }
      
        ra.addFlashAttribute("someerror", "Please Login to continue");
        
        return "redirect:/";
    }
    @RequestMapping("/journalvoucherbetweendates")
    public String showJournalVoucherBetweenDates(
            @ModelAttribute("theform") DateForm theform,
            BindingResult theBindingResult,
            Model theModel, 
            RedirectAttributes ra
            )
    {
        Object authentication = 
                SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        if(authentication instanceof UserDetails)
        {
            String userName = ((UserDetails)authentication)
                    .getUsername();
            if(theform == null || (theform.getEndDate() == null && theform.getStartDate() == null && theform.getAccountId() == null))
            {
                theModel.addAttribute("registrationError" ,"Choose atleast one of Start Date or End Date or Account to proceed for query!");
                theform = new DateForm();
                theModel.addAttribute("theform", theform);
                List<Account> thel = accountService.getAccountByUserName(userName);
                theModel.addAttribute("items", thel);
                return "show-journalvoucherbetweendates";
            }
            logger.info(theform.toString());
            List<JournalVoucher> theList = new ArrayList<> ();
            int key = 0;
            if(theform.getStartDate() == null && theform.getEndDate() == null)
            {
                key = 1;
            }
            else if(theform.getStartDate() == null)
            {
                List<JournalVoucher> theList1 = journalVoucherService.getJournalVoucherByUserName(userName);
                for(int i = 0; i < theList1.size(); i++)
                {
                    try {
                        Date temp = dt1.parse(dt1.format(theList1.get(i).getDate()));
                        Date temp1 = dt1.parse(dt1.format(theform.getEndDate()));
                        if(temp1.after(temp))
                        {
                            theList.add(theList1.get(i));
                        }
                    } catch(Exception e)
                    {
                        ;
                    }
                }
            }
            else if(theform.getEndDate() == null)
            {
                List<JournalVoucher> theList1 = journalVoucherService.getJournalVoucherByUserName(userName);
                for(int i = 0; i < theList1.size(); i++)
                {
                    try {
                        Date temp = dt1.parse(dt1.format(theList1.get(i).getDate()));
                        Date temp1 = dt1.parse(dt1.format(theform.getStartDate()));
                        if(!temp1.after(temp))
                        {
                            theList.add(theList1.get(i));
                        }
                    } catch(Exception e)
                    {
                        ;
                    }
                }
                
            }
            else
            {
                List<JournalVoucher> theList1 = journalVoucherService.getJournalVoucherByUserName(userName);
                for(int i = 0; i < theList1.size(); i++)
                {
                    try {
                        Date temp = dt1.parse(dt1.format(theList1.get(i).getDate()));
                        Date temp1 = dt1.parse(dt1.format(theform.getStartDate()));
                        if(!temp1.after(temp))
                        {
                            theList.add(theList1.get(i));
                        }
                    } catch(Exception e)
                    {
                        ;
                    }
                }
                theList1.clear();
                theList1.addAll(theList);
                theList.clear();
                for(int i = 0; i < theList1.size(); i++)
                {
                    try {
                        Date temp = dt1.parse(dt1.format(theList1.get(i).getDate()));
                        Date temp1 = dt1.parse(dt1.format(theform.getEndDate()));
                        if(!temp1.before(temp))
                        {
                            theList.add(theList1.get(i));
                        }
                    } catch(Exception e)
                    {
                        ;
                    }
                    
                }
            }
            if(key == 1)
            {
                theList = journalVoucherService.getJournalVoucherByUserName(userName);
            }
            if(theform.getAccountId() == null)
            {
                ;
            }
            else
            {
                logger.info("The List size : " + Integer.toString(theList.size()));
                List<JournalVoucher> theList1 = new ArrayList<> ();
                for(int i = 0; i < theList.size(); i++)
                {
                    logger.info("i");
                    logger.info(theform.getAccountId());
                    logger.info(theList.get(i).getAccountId());
                    if(theList.get(i).getAccountId() == theform.getAccountId())
                    {
                        theList1.add(theList.get(i));
                    }
                }
                Account theaccount = accountService.getAccount(theform.getAccountId());
                theModel.addAttribute("id", theaccount);
                theList.clear();
                theList.addAll(theList1);
                logger.info("The List size : " + Integer.toString(theList.size()));
                
            }
            double price = 0.00;
            for(int i = 0 ; i < theList.size(); i++)
            {
                price += theList.get(i).getCreditTotal();
                price -= theList.get(i).getDebitTotal();
            }
            String status = "Credit";
            if(price < 0.00)
            {
                status = "Debit";
                price = -price;
            }
            price = Double.parseDouble(df.format(price));
            theModel.addAttribute("theList", theList);
            theModel.addAttribute("status", status);
            theModel.addAttribute("theform", theform);
            theModel.addAttribute("price", price);
            List<Account> thel = accountService.getAccountByUserName(userName);
            theModel.addAttribute("items", thel);
            return "show-journalvoucherbetweendates";
        }
      
        ra.addFlashAttribute("someerror", "Please Login to continue");
        
        return "redirect:/";
    }
    @RequestMapping("/journalvoucherbetweendatesbygroup")
    public String showJournalVoucherBetweenDates(
            @ModelAttribute("theform") DateGroupForm theform,
            BindingResult theBindingResult,
            Model theModel, 
            RedirectAttributes ra
            )
    {
        Object authentication = 
                SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        if(authentication instanceof UserDetails)
        {
            String userName = ((UserDetails)authentication)
                    .getUsername();
            if(theform == null || (theform.getEndDate() == null && theform.getStartDate() == null && theform.getGroupId() == null))
            {
                theModel.addAttribute("registrationError" ,"Choose atleast one of Start Date or End Date or Group to proceed for query!");
                theform = new DateGroupForm();
                theModel.addAttribute("theform", theform);
                List<Group> thel = groupService.getGroupByUserName(userName);
                theModel.addAttribute("items", thel);
                return "show-journalvoucherbetweendatesbygroup";
            }
            logger.info(theform.toString());
            List<JournalVoucher> theList = new ArrayList<> ();
            int key = 0;
            if(theform.getStartDate() == null && theform.getEndDate() == null)
            {
                key = 1;
            }
            else if(theform.getStartDate() == null)
            {
                List<JournalVoucher> theList1 = journalVoucherService.getJournalVoucherByUserName(userName);
                for(int i = 0; i < theList1.size(); i++)
                {
                    try {
                        Date temp = dt1.parse(dt1.format(theList1.get(i).getDate()));
                        Date temp1 = dt1.parse(dt1.format(theform.getEndDate()));
                        logger.info(temp1.after(temp));
                        if(temp1.after(temp))
                        {
                            theList.add(theList1.get(i));
                        }
                    } catch(Exception e)
                    {
                        ;
                    }
                }
            }
            else if(theform.getEndDate() == null)
            {
                List<JournalVoucher> theList1 = journalVoucherService.getJournalVoucherByUserName(userName);
                for(int i = 0; i < theList1.size(); i++)
                {
                    try {
                        Date temp = dt1.parse(dt1.format(theList1.get(i).getDate()));
                        Date temp1 = dt1.parse(dt1.format(theform.getStartDate()));
                        if(!temp1.after(temp))
                        {
                            theList.add(theList1.get(i));
                        }
                    } catch(Exception e)
                    {
                        ;
                    }
                }
                
            }
            else
            {
                List<JournalVoucher> theList1 = journalVoucherService.getJournalVoucherByUserName(userName);
                for(int i = 0; i < theList1.size(); i++)
                {
                    try {
                        Date temp = dt1.parse(dt1.format(theList1.get(i).getDate()));
                        Date temp1 = dt1.parse(dt1.format(theform.getStartDate()));
                        if(!temp1.after(temp))
                        {
                            theList.add(theList1.get(i));
                        }
                    } catch(Exception e)
                    {
                        ;
                    }
                }
                theList1.clear();
                theList1.addAll(theList);
                theList.clear();
                for(int i = 0; i < theList1.size(); i++)
                {
                    try {
                        Date temp = dt1.parse(dt1.format(theList1.get(i).getDate()));
                        Date temp1 = dt1.parse(dt1.format(theform.getEndDate()));
                        if(!temp1.before(temp))
                        {
                            theList.add(theList1.get(i));
                        }
                    } catch(Exception e)
                    {
                        ;
                    }
                    
                }
            }
            if(key == 1)
            {
                theList = journalVoucherService.getJournalVoucherByUserName(userName);
            }
            if(theform.getGroupId() == null)
            {
                ;
            }
            else
            {
//              List<Account> theAccountList = accountService.getAccountByGroupId(theform.getGroupId());
                logger.info("The List size : " + Integer.toString(theList.size()));
                List<JournalVoucher> theList1 = new ArrayList<> ();
                for(int i = 0; i < theList.size(); i++)
                {
                    logger.info("i");
                    logger.info(theform.getGroupId());
                    logger.info(theList.get(i).getAccountId());
//                    for(int j = 0 ; j < theAccountList.size(); j++) {
//                      if(theList.get(i).getAccountId() == theAccountList.get(j).getId())
//                      {
//                          theList1.add(theList.get(i));
//                      }
//                    }
                    if(accountService.getAccount(theList.get(i).getAccountId()).getGroupId() == theform.getGroupId())
                    {
                        theList1.add(theList.get(i));
                    }
                }
                Group theaccount = groupService.getGroupById(theform.getGroupId());
                theModel.addAttribute("id", theaccount);
                theList.clear();
                theList.addAll(theList1);
                logger.info("The List size : " + Integer.toString(theList.size()));
                
            }
            double price = 0.00;
            for(int i = 0 ; i < theList.size(); i++)
            {
                price += theList.get(i).getCreditTotal();
                price -= theList.get(i).getDebitTotal();
            }
            String status = "Credit";
            if(price < 0.00)
            {
                status = "Debit";
                price = -price;
            }
            price = Double.parseDouble(df.format(price));
            theModel.addAttribute("theList", theList);
            theModel.addAttribute("status", status);
            theModel.addAttribute("theform", theform);
            theModel.addAttribute("price", price);
            List<Group> thel = groupService.getGroupByUserName(userName);
            theModel.addAttribute("items", thel);
            return "show-journalvoucherbetweendatesbygroup";
        }
      
        ra.addFlashAttribute("someerror", "Please Login to continue");
        
        return "redirect:/";
    }
    @RequestMapping("/journalvoucherbetweendatesbyschedule")
    public String showJournalVoucherBetweenDates(
            @ModelAttribute("theform") DateScheduleForm theform,
            BindingResult theBindingResult,
            Model theModel, 
            RedirectAttributes ra
            )
    {
        Object authentication = 
                SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        if(authentication instanceof UserDetails)
        {
            String userName = ((UserDetails)authentication)
                    .getUsername();
            if(theform == null || (theform.getEndDate() == null && theform.getStartDate() == null && theform.getScheduleId() == null))
            {
                theModel.addAttribute("registrationError" ,"Choose atleast one of Start Date or End Date or Schedule to proceed for query!");
                theform = new DateScheduleForm();
                theModel.addAttribute("theform", theform);
                List<Schedule> thel = scheduleService.getScheduleByUserName(userName);
                theModel.addAttribute("items", thel);
                return "show-journalvoucherbetweendatesbyschedule";
            }
            logger.info(theform.toString());
            List<JournalVoucher> theList = new ArrayList<> ();
            int key = 0;
            if(theform.getStartDate() == null && theform.getEndDate() == null)
            {
                key = 1;
            }
            else if(theform.getStartDate() == null)
            {
                List<JournalVoucher> theList1 = journalVoucherService.getJournalVoucherByUserName(userName);
                for(int i = 0; i < theList1.size(); i++)
                {
                    try {
                        Date temp = dt1.parse(dt1.format(theList1.get(i).getDate()));
                        Date temp1 = dt1.parse(dt1.format(theform.getEndDate()));
                        logger.info(temp1.after(temp));
                        if(temp1.after(temp))
                        {
                            theList.add(theList1.get(i));
                        }
                    } catch(Exception e)
                    {
                        ;
                    }
                }
            }
            else if(theform.getEndDate() == null)
            {
                List<JournalVoucher> theList1 = journalVoucherService.getJournalVoucherByUserName(userName);
                for(int i = 0; i < theList1.size(); i++)
                {
                    try {
                        Date temp = dt1.parse(dt1.format(theList1.get(i).getDate()));
                        Date temp1 = dt1.parse(dt1.format(theform.getStartDate()));
                        if(!temp1.after(temp))
                        {
                            theList.add(theList1.get(i));
                        }
                    } catch(Exception e)
                    {
                        ;
                    }
                }
                
            }
            else
            {
                List<JournalVoucher> theList1 = journalVoucherService.getJournalVoucherByUserName(userName);
                for(int i = 0; i < theList1.size(); i++)
                {
                    try {
                        Date temp = dt1.parse(dt1.format(theList1.get(i).getDate()));
                        Date temp1 = dt1.parse(dt1.format(theform.getStartDate()));
                        if(!temp1.after(temp))
                        {
                            theList.add(theList1.get(i));
                        }
                    } catch(Exception e)
                    {
                        ;
                    }
                }
                theList1.clear();
                theList1.addAll(theList);
                theList.clear();
                for(int i = 0; i < theList1.size(); i++)
                {
                    try {
                        Date temp = dt1.parse(dt1.format(theList1.get(i).getDate()));
                        Date temp1 = dt1.parse(dt1.format(theform.getEndDate()));
                        if(!temp1.before(temp))
                        {
                            theList.add(theList1.get(i));
                        }
                    } catch(Exception e)
                    {
                        ;
                    }
                    
                }
            }
            if(key == 1)
            {
                theList = journalVoucherService.getJournalVoucherByUserName(userName);
            }
            if(theform.getScheduleId() == null)
            {
                ;
            }
            else
            {
                logger.info("The List size : " + Integer.toString(theList.size()));
                List<JournalVoucher> theList1 = new ArrayList<> ();
                for(int i = 0; i < theList.size(); i++)
                {
                    logger.info("i");
                    logger.info(theform.getScheduleId());
                    logger.info(theList.get(i).getAccountId());
                    if(groupService.getGroupById(theList.get(i).getAccountId()).getSchedule() == theform.getScheduleId())
                    {
                        theList1.add(theList.get(i));
                    }
                }
                Schedule theaccount = scheduleService.get(theform.getScheduleId());
                theModel.addAttribute("id", theaccount);
                theList.clear();
                theList.addAll(theList1);
                logger.info("The List size : " + Integer.toString(theList.size()));
                
            }
            double price = 0.00;
            for(int i = 0 ; i < theList.size(); i++)
            {
                price += theList.get(i).getCreditTotal();
                price -= theList.get(i).getDebitTotal();
            }
            String status = "Credit";
            if(price < 0.00)
            {
                status = "Debit";
                price = -price;
            }
            price = Double.parseDouble(df.format(price));
            theModel.addAttribute("theList", theList);
            theModel.addAttribute("status", status);
            theModel.addAttribute("theform", theform);
            theModel.addAttribute("price", price);
            List<Schedule> thel = scheduleService.getScheduleByUserName(userName);
            theModel.addAttribute("items", thel);
            return "show-journalvoucherbetweendatesbyschedule";
        }
      
        ra.addFlashAttribute("someerror", "Please Login to continue");
        
        return "redirect:/";
    }
}
