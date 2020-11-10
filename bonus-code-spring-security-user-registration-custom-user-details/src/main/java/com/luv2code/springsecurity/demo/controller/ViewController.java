package com.luv2code.springsecurity.demo.controller;

import java.text.DecimalFormat;
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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
import com.luv2code.springsecurity.demo.service.AccountService;
import com.luv2code.springsecurity.demo.service.BankVoucherService;
import com.luv2code.springsecurity.demo.service.GroupService;
import com.luv2code.springsecurity.demo.service.JournalVoucherService;
import com.luv2code.springsecurity.demo.service.ScheduleService;
import com.luv2code.springsecurity.demo.service.StockItemService;
import com.luv2code.springsecurity.demo.service.TaxService;

@Controller
@RequestMapping("/view")
public class ViewController {
	private static DecimalFormat df = new DecimalFormat("0.00");
	@Autowired
	private ScheduleService scheduleService;
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
	@Transactional
	public String showTaxById(Model theModel
			, @RequestParam("taxId") Long theId
			, RedirectAttributes ra)
	{
		Object authentication = SecurityContextHolder
				.getContext().getAuthentication()
				.getPrincipal();
		if(authentication instanceof UserDetails)
		{
			Session crs = sessionFactory.getCurrentSession();
			Tax obj = crs.get(Tax.class, theId);
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
	@Transactional
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
			Long jvoucherId =  (long)jvoucherid;
			String userName = ((UserDetails)authentication)
					.getUsername();

			Session crs = sessionFactory.getCurrentSession();
			JournalVoucher item = crs.get(JournalVoucher.class, jvoucherId);
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
            @RequestParam("jvoucherId")int jvoucherid,
            RedirectAttributes ra)
    {
        Object authentication = 
                SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        if(authentication instanceof UserDetails)
        {
            Long jvoucherId =  (long)jvoucherid;
            String userName = ((UserDetails)authentication)
                    .getUsername();

            Session crs = sessionFactory.getCurrentSession();
            BankVoucher item = crs.get(BankVoucher.class, jvoucherId);
            logger.info("I'm in showspecificbankvoucher " + Long.toString(item.getAccountId()));
            theModel.addAttribute("addelem", item);
            return "show-specific-bankvoucher";
        }
        
        ra.addFlashAttribute("someerror", "Please Login to continue");
        
        return "redirect:/";
    }
}
