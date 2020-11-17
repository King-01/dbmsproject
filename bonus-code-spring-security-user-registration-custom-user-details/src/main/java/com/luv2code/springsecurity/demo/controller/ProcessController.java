package com.luv2code.springsecurity.demo.controller;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
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

import com.love2code.springsecurity.demo.form.PurchaseBillVoucherForm;
import com.love2code.springsecurity.demo.form.SaleBillForm;
import com.love2code.springsecurity.demo.form.StockForm;
import com.love2code.springsecurity.demo.form.StockPurchaseForm;
import com.love2code.springsecurity.demo.form.StockSaleForm;
import com.luv2code.springsecurity.demo.entity.Account;
import com.luv2code.springsecurity.demo.entity.BankVoucher;
import com.luv2code.springsecurity.demo.entity.CashVoucher;
import com.luv2code.springsecurity.demo.entity.Group;
import com.luv2code.springsecurity.demo.entity.JournalVoucher;
import com.luv2code.springsecurity.demo.entity.PurchaseBillTransactions;
import com.luv2code.springsecurity.demo.entity.PurchaseBillVoucher;
import com.luv2code.springsecurity.demo.entity.SaleBill;
import com.luv2code.springsecurity.demo.entity.SaleBillTransactions;
import com.luv2code.springsecurity.demo.entity.Schedule;
import com.luv2code.springsecurity.demo.entity.StockItem;
import com.luv2code.springsecurity.demo.entity.StockTax;
import com.luv2code.springsecurity.demo.entity.Tax;
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
import com.luv2code.springsecurity.demo.service.StockTaxService;
import com.luv2code.springsecurity.demo.service.TaxService;
import com.luv2code.springsecurity.demo.user.ScheduleUser;

@Controller
@RequestMapping("/process")
public class ProcessController {
	private static DecimalFormat df = new DecimalFormat("0.00");
    @Autowired
    private SaleBillTransactionsService saleBillTransactionsService;
    @Autowired
    private SaleBillService saleBillService;
	@Autowired
	private PurchaseBillTransactionsService purchaseBillTransactionsService;
	@Autowired
	private ScheduleService scheduleService;
	@Autowired
	private CashVoucherService cashVoucherService;
	@Autowired
	private BankVoucherService bankVoucherService;
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private GroupService groupService;
	@Autowired
	private TaxService taxService;
	@Autowired
	private AccountService accountService;
	@Autowired
	private PurchaseBillVoucherService purchaseBillVoucherService;
	@Autowired
	private StockItemService stockItemService;
	@Autowired
	private JournalVoucherService journalVoucherService;
	@Autowired
	private StockTaxService stockTaxService;
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
		dataBinder.registerCustomEditor(List.class, "stockitems", new CustomCollectionEditor(List.class)
        {
          @Override
          protected Object convertElement(Object element)
          {
              Long id = null;

              if(element instanceof String && !((String)element).equals("")){
                  //From the JSP 'element' will be a String
                  try{
                      id = Long.parseLong((String) element);
                  }
                  catch (NumberFormatException e) {
                      System.out.println("Element was " + ((String) element));
                      e.printStackTrace();
                  }
              }
              else if(element instanceof Long) {
                  //From the database 'element' will be a Long
                  id = (Long) element;
              }

              return id != null ? stockItemService.get(id) : null;
          }
        });
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
			Query<Schedule> theQuery = crs.createQuery("from Schedule where userName=:UserName"
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
			ra.addFlashAttribute("successMessage", "Schedule creation successful!");
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
			Query<Schedule> theQuery = crs.createQuery("from Schedule where userName=:UserName"
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
			ra.addFlashAttribute("successMessage", "Schedule creation successful!");
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
			String userName = ((UserDetails)authentication).getUsername();
			if(theBindingResult.hasErrors())
			{
				List<Schedule> thel = scheduleService.getScheduleByUserName(userName);
				theModel.addAttribute("listofschedule", thel);
				return "add-group";
			}
			try {	
				logger.info("processing add group for user : " + userName + "in ProcessController, /process/schedule");
				List<Group> theGroupList = groupService.getGroupByUserName(userName);
				for(int i = 0;i < theGroupList.size(); i++)
				{
					if(theGroupList.get(i).getGroupName().equals(theGroup.getGroupName()))
					{
						List<Schedule> thel = scheduleService.getScheduleByUserName(userName);
						theModel.addAttribute("listofschedule", thel);
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
				toSave.setQuantity((long) 0);
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
	@RequestMapping("/tax")
	public String addTax(
			@ModelAttribute("addelem") @Valid Tax addItem,
			BindingResult theBindingResult, 
			Model theModel, 
			RedirectAttributes ra)
	{
		Object authentication = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(authentication instanceof UserDetails)
		{
			String userName = ((UserDetails)authentication).getUsername();
			if(theBindingResult.hasErrors())
			{
				logger.info(theBindingResult.toString());
				return "add-tax";
			}
			try {	
				logger.info("processing add tax for user : " + userName + "in ProcessController, /process/tax" + " name of tax : " + addItem.getTaxName());
				List<Tax> theItemList = taxService.getTaxByUserName(userName);
				for(int i = 0;i < theItemList.size(); i++)
				{
					if(theItemList.get(i).getTaxName().equals(addItem.getTaxName()) && theItemList.get(i).getTaxPercent().equals(addItem.getTaxPercent()))
					{
						logger.info("Tax Item by the same name and percentage" + Long.toString(theItemList.get(i).getId()) + " already exists!");
						theModel.addAttribute("registrationError", "Tax Item by the same name and percentage already exists!");
						return "add-tax";
					}
				}
				taxService.save(addItem);
				logger.info("Stock Item creation by the name : " + addItem.getTaxName() + " successful!");
				ra.addFlashAttribute("successMessage", "Tax item creation by the name : " + addItem.getTaxName() + " successful!");
				return "redirect:/add";
			}
			catch(Exception e) {
				logger.info("Couldn't execute the add tax-item command due to exception: " + e);
				theModel.addAttribute("registrationError", "an unexpected error occured : " + e);
				return "add-tax";
			}
		}
		theModel.addAttribute("registrationError", "Log in first to continue.");
		return "redirect:/";
	}
	@RequestMapping("/stocktax")
	@Transactional
	public String processStockTax(
			@ModelAttribute("addelem") @Valid StockTax addItem,
			BindingResult theBindingResult, 
			Model theModel, 
			RedirectAttributes ra)
	{
		Object authentication = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(authentication instanceof UserDetails)
		{
			String userName = ((UserDetails)authentication).getUsername();
			if(theBindingResult.hasErrors())
			{
				logger.info(theBindingResult.toString());
				List<Tax> taxes = taxService.getTaxByUserName(userName);
				List<StockItem> items = stockItemService.getStockItemByUserName(userName);
				theModel.addAttribute("taxes", taxes);
				theModel.addAttribute("items", items);
				return "add-stocktax";
			}
			logger.info((Long.toString(addItem.getStockId())));
			try {	
				logger.info("processing add stocktax for user : " + userName + "in ProcessController, /process/stocktax" + " name of tax : " + addItem.getTaxId());
				Session crs = sessionFactory.getCurrentSession();
				Query<StockTax>
				theQuery = crs.createQuery("from StockTax where taxId =: TaxId"
						+ " and stockId =: StockId", StockTax.class);
				theQuery.setParameter("TaxId", addItem.getTaxId());
				theQuery.setParameter("StockId", addItem.getStockId());
				List<StockTax> itml = theQuery.getResultList();
				if(itml.size() > 0)
				{
					logger.info("Stock is already associated with this tax!");
					ra.addFlashAttribute("registrationError", "Stock is already associated with this tax!");
					return "redirect:/add/stocktax";
				}
				stockTaxService.save(addItem);
				logger.info("Stock with id : " + Long.toString(addItem.getStockId()) + " successfully associated with tax with id : " + Long.toString(addItem.getTaxId()) + "!");
				ra.addFlashAttribute("successMessage", "Opertion Successful!");
				return "redirect:/add";
			}
			catch(Exception e) {
				List<Tax> taxes = taxService.getTaxByUserName(userName);
				List<StockItem> items = stockItemService.getStockItemByUserName(userName);
				theModel.addAttribute("taxes", taxes);
				theModel.addAttribute("items", items);
				logger.info("Couldn't execute the add stocktax-item command due to exception: " + e);
				theModel.addAttribute("registrationError", "an unexpected error occured : " + e);
				return "add-stocktax";
			}
		}
		theModel.addAttribute("registrationError", "Log in first to continue.");
		return "redirect:/";
	}
	@RequestMapping("/stocktaxhandler")
	@Transactional
	public String processStockTaxHandler(
			@ModelAttribute("addelem") StockTax addItem,
			BindingResult theBindingResult, 
			Model theModel, 
			RedirectAttributes ra)
	{
		Object authentication = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(authentication instanceof UserDetails)
		{
			String userName = ((UserDetails)authentication).getUsername();
			if(theBindingResult.hasErrors())
			{
				logger.info(theBindingResult.toString());
				return "redirect:/view";
			}
			try {	
				logger.info("processing add stocktax for user : " + userName + "in ProcessController, /process/stocktax" + " name of tax : " + addItem.getTaxId());
				if(addItem.getStockId() != null && addItem.getTaxId() != null)
				{
					ra.addFlashAttribute("someerror", "Invalid choice, please try again!");
					return "redirect:/view";
				}
				if(addItem.getStockId() == null && addItem.getTaxId() == null)
				{
					ra.addFlashAttribute("someerror", "Invalid choice, please try again!");
					return "redirect:/view";
				}
				if(addItem.getStockId() != null)
				{
					Session crs = sessionFactory.getCurrentSession();
					Long id = addItem.getStockId();
					List<StockTax> theList = stockTaxService.getStockTaxByStockId(id);
					List<Tax> t = new ArrayList<Tax>();
					for(int i = 0; i < theList.size(); i++)
					{
						Session crs1 = sessionFactory.getCurrentSession();
						t.add(crs1.get(Tax.class, theList.get(i).getTaxId()));
					}
					logger.info("The size of Tax is : " + Integer.toString(t.size()) + " for stock item id : " + Long.toString(id));
					theModel.addAttribute("taxes", t);
					theModel.addAttribute("stock", crs.get(StockItem.class, id));
					return "show-taxbystock";
				}
				else
				{
					Session crs = sessionFactory.getCurrentSession();
					Long id = addItem.getTaxId();
					logger.info(Long.toString(id));
					List<StockTax> theList = stockTaxService.getStockTaxByTaxId(id);
					List<StockItem> t = new ArrayList<StockItem>();
					for(int i = 0; i < theList.size(); i++)
					{
						Session crs1 = sessionFactory.getCurrentSession();
						t.add(crs1.get(StockItem.class, theList.get(i).getStockId()));
					}
					logger.info("The size of Stock item is : " + Integer.toString(t.size()) + " for tax item id : " + Long.toString(id));
					theModel.addAttribute("stocks", t);
					theModel.addAttribute("tax", crs.get(Tax.class, id));
					return "show-stockbytax";
				}
			}
			catch(Exception e) {
				List<Tax> taxes = taxService.getTaxByUserName(userName);
				List<StockItem> items = stockItemService.getStockItemByUserName(userName);
				theModel.addAttribute("taxes", taxes);
				theModel.addAttribute("items", items);
				logger.info("Couldn't execute the add stocktax-item command due to exception: " + e);
				theModel.addAttribute("registrationError", "an unexpected error occured : " + e);
				return "add-stocktax";
			}
		}
		theModel.addAttribute("registrationError", "Log in first to continue.");
		return "redirect:/";
	}
	@RequestMapping("/journalvoucher")
	public String processJournalVoucher(@ModelAttribute("addelem")@Valid JournalVoucher addelem,
			BindingResult theBindingResult,
			Model theModel,
			RedirectAttributes ra
		)
	{
		Object authentication = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(authentication instanceof UserDetails)
		{
			String userName = ((UserDetails)authentication).getUsername();

			List<Account> tl = accountService.getAccountByUserName(userName);
			if(theBindingResult.hasErrors())
			{
				logger.info(theBindingResult.toString());
				theModel.addAttribute("addelem", addelem);
				theModel.addAttribute("theaccountlist", tl);
				return "add-journalvoucher";
			}
			try 
			{	
				logger.info("processing add journal voucher for user :"
						+ " " + userName + "in "
								+ "ProcessController, /process/journalvoucher" + " "
										+ "name of account to process for: "
										+ "" + Long.toString(addelem.getAccountId()));
				addelem.setAccountName(accountService.getAccount(addelem.getAccountId()).getAccountName());
				journalVoucherService.save(addelem);
				logger.info("Journal Voucher Creation Successful!");
				ra.addFlashAttribute("successMessage", "Journal Voucher with id : " + Long.toString(addelem.getJvoucherId()) + " Successful!");
				return "redirect:/add";
			}
			catch(Exception e) {
				theModel.addAttribute("addelem", addelem);
				theModel.addAttribute("theaccountlist", tl);
				logger.info("Couldn't execute the add journal voucher command due to exception: " + e);
				return "add-journalvoucher";
			}
		}
		theModel.addAttribute("registrationError", "Log in first to continue.");
		return "redirect:/";
	}
    @RequestMapping("/bankvoucher")
    public String processBankVoucher(@ModelAttribute("addelem")@Valid BankVoucher addelem,
            BindingResult theBindingResult,
            Model theModel,
            RedirectAttributes ra
        )
    {
        Object authentication = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(authentication instanceof UserDetails)
        {
            String userName = ((UserDetails)authentication).getUsername();

            List<Account> tl = accountService.getAccountByUserName(userName);
            if(theBindingResult.hasErrors())
            {
                logger.info(theBindingResult.toString());
                theModel.addAttribute("addelem", addelem);
                theModel.addAttribute("theaccountlist", tl);
                return "add-bankvoucher";
            }
            try 
            {   
                logger.info("processing add bank voucher for user :"
                        + " " + userName + "in "
                                + "ProcessController, /process/bankvoucher" + " "
                                        + "name of account to process for: "
                                        + "" + Long.toString(addelem.getAccountId()));
                addelem.setAccountName(accountService.getAccount(addelem.getAccountId()).getAccountName());
                
                bankVoucherService.save(addelem);
                logger.info("Bank Voucher Creation Successful!");
                ra.addFlashAttribute("successMessage", "Bank Voucher with id : " + Long.toString(addelem.getBvoucherId()) + " Successful!");
                return "redirect:/add";
            }
            catch(Exception e) {
                theModel.addAttribute("addelem", addelem);
                theModel.addAttribute("theaccountlist", tl);
                logger.info("Couldn't execute the add bank voucher command due to exception: " + e);
                return "add-bankvoucher";
            }
        }
        theModel.addAttribute("registrationError", "Log in first to continue.");
        return "redirect:/";
    }
    @RequestMapping("/cashvoucher")
    public String processCashVoucher(@ModelAttribute("addelem")@Valid CashVoucher addelem,
            BindingResult theBindingResult,
            Model theModel,
            RedirectAttributes ra
        )
    {
        Object authentication = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(authentication instanceof UserDetails)
        {
            String userName = ((UserDetails)authentication).getUsername();

            List<Account> tl = accountService.getAccountByUserName(userName);
            if(theBindingResult.hasErrors())
            {
                logger.info(theBindingResult.toString());
                theModel.addAttribute("addelem", addelem);
                theModel.addAttribute("theaccountlist", tl);
                return "add-cashvoucher";
            }
            try 
            {   
                {
                    Double debt = 0.0;
                    List<CashVoucher> tle = cashVoucherService.getCashVoucherByUserName(userName);
                    for(int i = 0; i < tle.size(); i++)
                    {
                        debt += tle.get(i).getCreditTotal();
                        debt -= tle.get(i).getDebitTotal();
                    }
                    debt += addelem.getCreditTotal();
                    debt -= addelem.getDebitTotal();
                    if(debt < 0)
                    {
                        ra.addFlashAttribute("registrationError", "Could not add this receit, otherwise"
                                + "you'll be in cash deficet of " + Long.toString(Math.round(debt)) + "!");
                        return "redirect:/add/cashvoucher";
                    }
                }
                logger.info("processing add cash voucher for user :"
                        + " " + userName + "in "
                                + "ProcessController, /process/cashvoucher" + " "
                                        + "name of account to process for: "
                                        + "" + Long.toString(addelem.getAccountId()));
                addelem.setAccountName(accountService.getAccount(addelem.getAccountId()).getAccountName());
                logger.info(addelem.toString());
                cashVoucherService.save(addelem);
                logger.info("Cash Voucher Creation Successful!");
                ra.addFlashAttribute("successMessage", "Cash Voucher with id : " + Long.toString(addelem.getCvoucherId()) + " Successful!");
                return "redirect:/add";
            }
            catch(Exception e) {
                theModel.addAttribute("addelem", addelem);
                theModel.addAttribute("theaccountlist", tl);
                logger.info("Couldn't execute the add cash voucher command due to exception: " + e);
                return "add-cashvoucher";
            }
        }
        theModel.addAttribute("registrationError", "Log in first to continue.");
        return "redirect:/";
    }

    @RequestMapping("/purchasebill")
    public String processPurchaseBillVoucher(@ModelAttribute("addelem")@Valid PurchaseBillVoucherForm addelem,
            BindingResult theBindingResult,
            Model theModel,
            RedirectAttributes ra
        )
    {
        Object authentication = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(authentication instanceof UserDetails)
        {
            String userName = ((UserDetails)authentication).getUsername();
            if(theBindingResult.hasErrors())
            {
                logger.info(theBindingResult.toString());
                theModel.addAttribute("addelem", addelem);
                return "add-purchasebill";
            }
            try 
            {   
                logger.info("processing add cash voucher for user :"
                        + " " + userName + "in "
                                + "ProcessController, /process/purchasebill");
                Account theAccount = accountService.getAccount(addelem.getAccountId());
                addelem.setAccountName(theAccount.getAccountName());
                PurchaseBillVoucher pbv = new PurchaseBillVoucher();
                pbv.setAccountId(addelem.getAccountId());
                pbv.setAccountName(addelem.getAccountName());
                pbv.setCost(addelem.getCost());
                pbv.setDate(addelem.getDate());
                pbv.setDescription(addelem.getDescription());
                pbv.setTrucknumber(addelem.getTrucknumber());
                pbv.setUserName(addelem.getUserName());
                purchaseBillVoucherService.save(pbv);
                logger.info("Successfully saved the element in purchase bill voucher, id : " + Long.toString(pbv.getId()));
                if(addelem.getTheform() == null)
                {
                	logger.info("Hi");
                }
                for(int i = 0; i < addelem.getTheform().size(); i++)
                {
                	PurchaseBillTransactions newbill = new PurchaseBillTransactions();
                	StockPurchaseForm itm = addelem.getTheform().get(i);
                	newbill.setItemName(itm.getStockitemName());

                	logger.info(itm.toString());
                	StockItem st = stockItemService.get(itm.getId());
                	st.setQuantity(st.getQuantity() + itm.getQuantity());
                	stockItemService.save(st);
                	newbill.setTax(itm.getTax());
                	newbill.setQuantity(itm.getQuantity());
                	newbill.setRate(itm.getRate());
                	newbill.setTaxBreakup(itm.getTaxbreakup());
                	newbill.setTotalAmount(itm.getTotal());
                	pbv.addPurchaseitem(newbill);
                	purchaseBillTransactionsService.save(newbill);
                    purchaseBillVoucherService.save(pbv);
                }
                ra.addFlashAttribute("successMessage" ,"Addition for purchase voucher successful!");
                return "redirect:/add";
            }
            catch(Exception e) {
                logger.info("Couldn't execute the process purchase voucher command due to exception: " + e);
                return "redirect:/add";
            }
        }
        theModel.addAttribute("registrationError", "Log in first to continue.");
        return "redirect:/";
    }
    @RequestMapping("/salebill")
    public String processSaleBill(@ModelAttribute("addelem")@Valid SaleBillForm addelem,
            BindingResult theBindingResult,
            Model theModel,
            RedirectAttributes ra
        )
    {
        Object authentication = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(authentication instanceof UserDetails)
        {
            String userName = ((UserDetails)authentication).getUsername();
            if(theBindingResult.hasErrors())
            {
                List<Account> tl = accountService.getAccountByUserName(userName);
                logger.info(theBindingResult.toString());
                theModel.addAttribute("addelem", addelem);
                theModel.addAttribute("listofaccounts" ,tl);
                return "add-salebill";
            }
            try 
            {   
                logger.info("processing add Sale bill for user :"
                        + " " + userName + "in "
                                + "ProcessController, /process/salebill");
                Account theAccount = accountService.getAccount(addelem.getAccountId());
                addelem.setAccountName(theAccount.getAccountName());
                SaleBill pbv = new SaleBill();
                pbv.setAccountId(addelem.getAccountId());
                pbv.setAccountName(addelem.getAccountName());
                pbv.setCost(addelem.getCost());
                pbv.setDate(addelem.getDate());
                pbv.setDescription(addelem.getDescription());
                pbv.setTrucknumber(addelem.getTrucknumber());
                pbv.setUserName(addelem.getUserName());
                saleBillService.save(pbv);
                logger.info("Successfully saved the element in purchase bill voucher, id : " + Long.toString(pbv.getId()));
                if(addelem.getTheform() == null)
                {
                    logger.info("Hi");
                }
                for(int i = 0; i < addelem.getTheform().size(); i++)
                {
                    SaleBillTransactions newbill = new SaleBillTransactions();
                    StockSaleForm itm = addelem.getTheform().get(i);
                    newbill.setItemName(itm.getStockitemName());

                    logger.info(itm.toString());
                    StockItem st = stockItemService.get(itm.getId());
                    st.setQuantity(st.getQuantity() + itm.getQuantity());
                    stockItemService.save(st);
                    newbill.setTax(itm.getTax());
                    newbill.setQuantity(itm.getQuantity());
                    newbill.setRate(itm.getRate());
                    newbill.setTaxBreakup(itm.getTaxbreakup());
                    newbill.setTotalAmount(itm.getTotal());
                    pbv.addSaleitem(newbill);
                    saleBillTransactionsService.save(newbill);
                    saleBillService.save(pbv);
                }
                ra.addFlashAttribute("successMessage" ,"Addition for Sale Bill successful!");
                return "redirect:/add";
            }
            catch(Exception e) {
                logger.info("Couldn't execute the process purchase voucher command due to exception: " + e);
                return "redirect:/add";
            }
        }
        theModel.addAttribute("registrationError", "Log in first to continue.");
        return "redirect:/";
    }
}
