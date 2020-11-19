package com.luv2code.springsecurity.demo.controller;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.validation.Valid;

import org.hibernate.SessionFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.love2code.springsecurity.demo.form.AccountForm;
import com.love2code.springsecurity.demo.form.GroupForm;
import com.love2code.springsecurity.demo.form.ScheduleForm;
import com.luv2code.springsecurity.demo.entity.Account;
import com.luv2code.springsecurity.demo.entity.Group;
import com.luv2code.springsecurity.demo.entity.Schedule;
import com.luv2code.springsecurity.demo.service.AccountService;
import com.luv2code.springsecurity.demo.service.BankVoucherService;
import com.luv2code.springsecurity.demo.service.CashVoucherService;
import com.luv2code.springsecurity.demo.service.GroupService;
import com.luv2code.springsecurity.demo.service.JournalVoucherService;
import com.luv2code.springsecurity.demo.service.PurchaseBillTransactionsService;
import com.luv2code.springsecurity.demo.service.PurchaseBillVoucherService;
import com.luv2code.springsecurity.demo.service.SaleBillService;
import com.luv2code.springsecurity.demo.service.SaleBillTransactionsService;
import com.luv2code.springsecurity.demo.service.ScheduleService;
import com.luv2code.springsecurity.demo.service.StockItemService;
import com.luv2code.springsecurity.demo.service.TaxService;
import com.luv2code.springsecurity.demo.service.UserService;

@Controller
@RequestMapping("/update")
public class UpdateController {
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
	@Autowired
	private PurchaseBillVoucherService purchaseBillVoucherService;
	@Autowired
	private PurchaseBillTransactionsService purchaseBillTransactionsService;
	@Autowired
	private SaleBillTransactionsService saleBillTransactionsService;
	@Autowired
	private SaleBillService saleBillService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}	
	@RequestMapping("/schedule")
	public String updateSchedule(
			@ModelAttribute("theform")@Valid ScheduleForm theform,
			Model theModel,
			BindingResult theBindingResult,
			RedirectAttributes ra
			)
	{
		Object authentication = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if((authentication instanceof UserDetails))
		{
			String userName = ((UserDetails)authentication).getUsername();
			if(theBindingResult.hasErrors())
			{
				theModel.addAttribute("theform", theform);
				return "update-schedule";	
				
			}
			logger.info(theform);
			if(!passwordEncoder.matches(theform.getConfirmPassword(), userService.findByUserName(userName).getPassword()))
			{
				theModel.addAttribute("registrationError", "Password and confirm password does not match!");
				theModel.addAttribute("theform", theform);
				return "update-schedule";	
				
			}
			List<Schedule> thes = scheduleService.getScheduleByUserName(userName);
			for(int i = 0; i < thes.size(); i++)
			{
				if(!thes.get(i).getScheduleName().equals(theform.getPrev()));
				{
					if(thes.get(i).getScheduleName().equals(theform.getScheduleName()))
					{
						theModel.addAttribute("registrationError", "Another Schedule with the same name already exists!");
						theModel.addAttribute("theform", theform);
						return "update-schedule";						
					}
				}
			}
			Schedule tou = scheduleService.getSchedule(theform.getPrev(), userName);
			tou.setScheduleName(theform.getScheduleName());
			scheduleService.save(tou);
			ra.addFlashAttribute("successMessage", "Schedule Updated Successfully!");
			return "redirect:/update";
		}
		ra.addFlashAttribute("someerror", "Please Login to continue");
		return "redirect:/";
		
	}
	@RequestMapping("/group")
	public String updateGroupForm(
			@ModelAttribute("theform")@Valid GroupForm theform,
			BindingResult theBindingResult,
			Model theModel,
			RedirectAttributes ra
			)
	{
		Object authentication = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if((authentication instanceof UserDetails))
		{
			String userName = ((UserDetails)authentication).getUsername();
			if(theBindingResult.hasErrors())
			{
				theModel.addAttribute("theform", theform);
				return "update-group";	
				
			}
			if(!passwordEncoder.matches(theform.getConfirmPassword(), userService.findByUserName(userName).getPassword()))
			{
				theModel.addAttribute("registrationError", "Password and confirm password does not match!");
				theModel.addAttribute("theform", theform);
				return "update-group";	
				
			}
			logger.info(theform);
			List<Group> thes = groupService.getGroupByUserName(userName);
			String prev = groupService.getGroupById(theform.getGroupId()).getGroupName();
			for(int i = 0; i < thes.size(); i++)
			{
				if(!thes.get(i).getGroupName().equals(prev))
				{
					if(thes.get(i).getGroupName().equals(theform.getGroupName()))
					{
						theModel.addAttribute("registrationError", "Another Group with the same name already exists!");
						theModel.addAttribute("theform", theform);
						return "update-group";						
					}
				}
			}
			Group tou = groupService.getGroupById(theform.getGroupId());
			tou.setGroupName(theform.getGroupName());
			groupService.save(tou);
			ra.addFlashAttribute("successMessage", "Group Updated Successfully!");
			return "redirect:/update";
		}
		ra.addFlashAttribute("someerror", "Please Login to continue");
		return "redirect:/";
		
	}
	@RequestMapping("/account")
    public String updateAccount(
            @ModelAttribute("theform")@Valid AccountForm theform,
            BindingResult theBindingResult,
            Model theModel,
            RedirectAttributes ra
            )
    {
        Object authentication = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if((authentication instanceof UserDetails))
        {
            String userName = ((UserDetails)authentication).getUsername();
            if(theBindingResult.hasErrors())
            {
                theModel.addAttribute("theform", theform);
//                theModel.addAttribute("registrationError", theBindingResult.toString());
                return "update-account";  
                
            }
            if(!passwordEncoder.matches(theform.getConfirmPassword(), userService.findByUserName(userName).getPassword()))
            {
                theModel.addAttribute("registrationError", "Password and confirm password does not match!");
                theModel.addAttribute("theform", theform);
                return "update-schedule";   
                
            }
            List<Account> thes = accountService.getAccountByUserName(userName);
            for(int i = 0; i < thes.size(); i++)
            {
                if(!thes.get(i).getAccountName().equals(theform.getPrev()))
                {
                    if(thes.get(i).getAccountName().equals(theform.getAccountName()))
                    {
                        theModel.addAttribute("registrationError", "Another Account with the same name already exists!");
                        theModel.addAttribute("theform", theform);
                        return "update-account";                      
                    }
                }
            }
            Account tou = accountService.getAccount(theform.getPrev());
            tou.setAccountName(theform.getAccountName());
            tou.setAddressLine1(theform.getAddressLine1());
            tou.setAddressLine2(theform.getAddressLine2());
            tou.setCity(theform.getCity());
            tou.setEmail(theform.getEmail());
            tou.setHsnNumber(theform.getHsnNumber());
            tou.setPan(theform.getPan());
            tou.setPincode(theform.getPincode());
            tou.setGuarantorName(theform.getGuarantorName());
            tou.setMobileNumber1(theform.getMobileNumber1());
            tou.setMobileNumber2(theform.getMobileNumber2());
            accountService.save(tou);
            ra.addFlashAttribute("successMessage", "Account Updated Successfully!");
            return "/update";
        }
        ra.addFlashAttribute("someerror", "Please Login to continue");
        return "redirect:/update";
        
    }
}
