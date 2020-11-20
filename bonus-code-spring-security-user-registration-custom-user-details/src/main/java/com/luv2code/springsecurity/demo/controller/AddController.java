package com.luv2code.springsecurity.demo.controller;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.love2code.springsecurity.demo.form.ListOfStockPurchaseForm;
import com.love2code.springsecurity.demo.form.ListOfStockSaleForm;
import com.love2code.springsecurity.demo.form.PurchaseBillVoucherForm;
import com.love2code.springsecurity.demo.form.SaleBillForm;
import com.love2code.springsecurity.demo.form.StockForm;
import com.love2code.springsecurity.demo.form.StockItemForm;
import com.love2code.springsecurity.demo.form.StockPurchaseForm;
import com.love2code.springsecurity.demo.form.StockSaleForm;
import com.luv2code.springsecurity.demo.entity.Account;
import com.luv2code.springsecurity.demo.entity.BankVoucher;
import com.luv2code.springsecurity.demo.entity.CashVoucher;
import com.luv2code.springsecurity.demo.entity.Group;
import com.luv2code.springsecurity.demo.entity.JournalVoucher;
import com.luv2code.springsecurity.demo.entity.Schedule;
import com.luv2code.springsecurity.demo.entity.StockItem;
import com.luv2code.springsecurity.demo.entity.StockTax;
import com.luv2code.springsecurity.demo.entity.Tax;
import com.luv2code.springsecurity.demo.entity.User;
import com.luv2code.springsecurity.demo.service.AccountService;
import com.luv2code.springsecurity.demo.service.CashVoucherService;
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
	private static DecimalFormat df = new DecimalFormat("0.00");
	@Autowired
	private ScheduleService scheduleService;
	@Autowired
	private GroupService groupService;
	@Autowired
	private AccountService accountService;
	@Autowired
	private UserService userService;
	@Autowired
	private TaxService taxService;
	@Autowired
	private CashVoucherService cashVoucherService;
	@Autowired
	private StockTaxService stockTaxService;
	@Autowired
	private StockItemService stockItemService;
	
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
	@RequestMapping("/scheduleupdate")
	public String addScheduleUpdate(Model theModel, RedirectAttributes ra)
	{
		Object authentication = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(authentication instanceof UserDetails)
		{
			ra.addFlashAttribute("registrationError", "Select the Schedule you want to update!");
			logger.info("Processing Update schedule step 1 for user : " + ((UserDetails)authentication).getUsername());
			return "redirect:/view/Schedule";
		}
		ra.addFlashAttribute("someerror", "Please Login to continue");
		return "redirect:/";
	}
	@RequestMapping("/groupupdate")
	public String addGroupUpdate(Model theModel, RedirectAttributes ra)
	{
		Object authentication = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(authentication instanceof UserDetails)
		{
			ra.addFlashAttribute("registrationError", "Select the Group you want to update!");
			logger.info("Processing Update group step 1 for user : " + ((UserDetails)authentication).getUsername());
			return "redirect:/view/group";
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
    @RequestMapping("/accountupdate")
    public String addAccountUpdate(Model theModel, RedirectAttributes ra)
    {
            Object authentication = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if(authentication instanceof UserDetails)
            {
                    ra.addFlashAttribute("registrationError", "Select the Account you want to update!");
                    logger.info("Processing Update account step 1 for user : " + ((UserDetails)authentication).getUsername());
                    return "redirect:/view/account";
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

    @RequestMapping("/cashvoucher")
    public String addCashVoucher(Model theModel, RedirectAttributes ra)
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
            CashVoucher toadd = new CashVoucher();
//          toadd.setDate(curDate);

            {
                Double debt = 0.0;
                List<CashVoucher> tle = cashVoucherService.getCashVoucherByUserName(userName);
                for(int i = 0; i < tle.size(); i++)
                {
                    debt += tle.get(i).getCreditTotal();
                    debt -= tle.get(i).getDebitTotal();
                }
                theModel.addAttribute("cashbalance", Math.round(debt));
            }
            toadd.setDebitTotal(debit);
            toadd.setCreditTotal(credit);
            toadd.setUserName(userName);
            theModel.addAttribute("addelem",toadd);
            List<Account> thelist = accountService.getAccountByUserName(userName);
            theModel.addAttribute("theaccountlist", thelist);
            return "add-cashvoucher";
        }
        ra.addFlashAttribute("someerror", "Please Login to continue");
        return "redirect:/";
    }
    @RequestMapping("/stockitemsforpurchaseitems")
    public String addStockItemsForPurchaseItems(Model theModel, RedirectAttributes ra)
    {
        Object authentication = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(authentication instanceof UserDetails)
        {
            String userName = ((((UserDetails)authentication).getUsername()));
//          DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//          SimpleDateFormat dft= new SimpleDateFormat("yyyy-MM-dd");
//          LocalDateTime now = LocalDateTime.now();
//          Date curDate = (Date) df.parse(dft.format(now));
            List<StockItem> theitems = stockItemService.getStockItemByUserName(userName);
            StockItemForm theform = new StockItemForm();
            theModel.addAttribute("items", theitems);
            theModel.addAttribute("theform", theform);
            return "add-stockitemsforpurchaseitems";
        }
        ra.addFlashAttribute("someerror", "Please Login to continue");
        return "redirect:/";
    }
    @RequestMapping("/purchasebillstep")
    public String addPurchaseBill(
    		@ModelAttribute("theform")@Valid StockItemForm theform,
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
            	ra.addFlashAttribute("registrationError", "Invalid Request!");
            	return "redirect:/add";
            }
            if(theform == null)
            {
            	ra.addFlashAttribute("registrationError", "Invalid Request!");
            	return "redirect:/add";        	
            }
            if(0 == theform.getStockitems().size())
            {
            	ra.addFlashAttribute("registrationError", "Please select atleast one item");
            	return "redirect:/add/stockitemsforpurchaseitems";
            }
            List<StockPurchaseForm> theList1 = new ArrayList<StockPurchaseForm> ();
            for(int i = 0; i < theform.getStockitems().size(); i++)
            {
            	logger.info(theform.getStockitems().get(i).toString());
            	StockPurchaseForm e = new StockPurchaseForm();
            	e.setStockitemName(theform.getStockitems().get(i).getStockItemName());
            	e.setId(theform.getStockitems().get(i).getId());
            	e.setStockitemquantity(theform.getStockitems().get(i).getQuantity());
            	theList1.add(e);
            }
            ListOfStockPurchaseForm theList = new ListOfStockPurchaseForm();
            theList.setTheStockPurchaseFormList(theList1);
            theModel.addAttribute("addelem", theList);
            return "add-purchasebillstep";
        }
        ra.addFlashAttribute("someerror", "Please Login to continue");
        return "redirect:/";
    }
    @RequestMapping("/purchasebill")
    public String addPurchaseBillVoucher(@ModelAttribute("addelem")@Valid ListOfStockPurchaseForm theform,
            BindingResult theBindingResult,
            Model theModel,
            RedirectAttributes ra
        )
    {
        Object authentication = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(authentication instanceof UserDetails)
        {
            String userName = ((UserDetails)authentication).getUsername();

            if(theform == null || theform.getTheStockPurchaseFormList() == null)
            {
            	ra.addFlashAttribute("registrationError", "Invalid Request!");
            	return "redirect:/add";        	
            }
            if(theBindingResult.hasErrors())
            {
                logger.info(theBindingResult.toString());
                ra.addFlashAttribute("registrationError", "Invalid Request!");
                return "redirect:/add";
            }
            try 
            {   
                List<Account> tl = accountService.getAccountByUserName(userName);
                logger.info("processing add cash voucher for user :"
                        + " " + userName + " in "
                                + "AddController, /add/purchasebill");
                theModel.addAttribute("listofaccounts" ,tl);
                double fp = 0.0;
                String ts = new String();
                for(int i = 0; i < theform.getTheStockPurchaseFormList().size(); i++)
                {
                	if(theform.getTheStockPurchaseFormList().get(i).getQuantity() <= 0)
                	{
                		ts = ts + theform.getTheStockPurchaseFormList().get(i).getStockitemName() + " ";
                	}
                }
                if(ts.length() > 0)
                {
                	ra.addFlashAttribute("registrationError", "The following stock items had invalid quantity : " + ts);
                	return "redirect:/add";
                }
                for(int i = 0; i < theform.getTheStockPurchaseFormList().size(); i++)
                {
                	StockPurchaseForm itm = theform.getTheStockPurchaseFormList().get(i);
                	StockItem st = stockItemService.get(itm.getId());
                	theform.getTheStockPurchaseFormList().get(i).setId(st.getId());
                	List<StockTax> thestocktaxlist = stockTaxService.getStockTaxByStockId(st.getId());
                	{
                		double taxation = 0.0;
                		taxation = taxation + Double.parseDouble(st.getCommision());
                		taxation = taxation + Double.parseDouble(st.getKkFee());
                		taxation = taxation + Double.parseDouble(st.getLabourCharge());
                		taxation = taxation + Double.parseDouble(st.getMandiTax());
                		taxation = taxation / 100.00;
                		double price = 0.0;
                		double perc = taxation * 100.0;
                		double stocktax = 0.0;
                		String sttax = new String();
                		price += (itm.getRate() * itm.getQuantity());
//                		price += (itm.getQuantity() * Double.parseDouble(st.getPacking()));
                		for(int j = 0; j < thestocktaxlist.size(); j++)
                		{
                			Tax thetax = taxService.get(thestocktaxlist.get(j).getTaxId());
                			stocktax += Double.parseDouble(thetax.getTaxPercent());
                			sttax += thetax.getTaxName() + ":" + thetax.getTaxPercent() + "% ";
                    	}
                        perc += stocktax;
                		stocktax /= 100.00;
                		String ffg = "Total tax:Rs." + df.format(price * ((taxation + stocktax))) + "(" + df.format(perc)+ 
                				"%: " + "KKFee:" + df.format(Double.parseDouble(st.getKkFee()))+
                				"% Commision:" + df.format(Double.parseDouble(st.getCommision())) +
                				"% Labour Charge:"+df.format(Double.parseDouble(st.getLabourCharge()))+
                				"% Mandi Tax:"+df.parse(st.getMandiTax()) + "% " + sttax + ") Packing Charges:Rs" + st.getPacking()+" Per Unit";
                		theform.getTheStockPurchaseFormList().get(i).setTax(Double.parseDouble(df.format(price * (stocktax + taxation))));
                		logger.info(ffg);
                		price *= (1.00 + stocktax + taxation);
                		price += (itm.getQuantity() * Double.parseDouble(st.getPacking()));
                        price = Double.parseDouble(df.format(price));                		
                		theform.getTheStockPurchaseFormList().get(i).setTotal(price);
                		theform.getTheStockPurchaseFormList().get(i).setTaxbreakup(ffg);
                		fp += price;
                	}
                }
                
                if(fp - 0.0 <= 0.0)
                {
                    ra.addFlashAttribute("registrationError", "Billing amount must be greater than zero.");
                    return "redirect:/add";
                	
                }
                PurchaseBillVoucherForm theform1 = new PurchaseBillVoucherForm();
                theform1.setCost(fp);
                theform1.setTheform(theform.getTheStockPurchaseFormList());
                theform1.setUserName(userName);
                theModel.addAttribute("addelem", theform1);
                logger.info("Successfully reached step 2 for adding purchase bill, redirecting to final url!");
                return "add-purchasevoucher";
            }
            catch(Exception e) {
                logger.info("Couldn't execute the processing phase of purchase voucher command due to exception: " + e);
                ra.addFlashAttribute("registrationError", "Invalid request!");
                return "redirect:/add";
            }
        }
        theModel.addAttribute("registrationError", "Log in first to continue.");
        return "redirect:/";
    }
    @RequestMapping("/stockitemsforsaleitems")
    public String addStockItemsForSaleItems(Model theModel, RedirectAttributes ra)
    {
        Object authentication = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(authentication instanceof UserDetails)
        {
            String userName = ((((UserDetails)authentication).getUsername()));
//          DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//          SimpleDateFormat dft= new SimpleDateFormat("yyyy-MM-dd");
//          LocalDateTime now = LocalDateTime.now();
//          Date curDate = (Date) df.parse(dft.format(now));
            List<StockItem> theitems = stockItemService.getStockItemByUserName(userName);
            StockItemForm theform = new StockItemForm();
            theModel.addAttribute("items", theitems);
            theModel.addAttribute("theform", theform);
            return "add-stockitemsforsaleitems";
        }
        ra.addFlashAttribute("someerror", "Please Login to continue");
        return "redirect:/";
    }
    @RequestMapping("/salebillstep")
    public String addSaleBillStep(
            @ModelAttribute("theform") StockItemForm theform,
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
            	ra.addFlashAttribute("registrationError", "Invalid Request!");
            	return "redirect:/add";
            }
            if(theform == null)
            {
            	ra.addFlashAttribute("registrationError", "Invalid Request!");
            	return "redirect:/add";        	
            }
            if(0 == theform.getStockitems().size())
            {
            	ra.addFlashAttribute("registrationError", "Please select atleast one item");
            	return "redirect:/add/stockitemsforsaleitems";
            }
            List<StockSaleForm> theList1 = new ArrayList<StockSaleForm> ();
            for(int i = 0; i < theform.getStockitems().size(); i++)
            {
                logger.info(theform.getStockitems().get(i).toString());
                StockSaleForm e = new StockSaleForm();
                e.setStockitemName(theform.getStockitems().get(i).getStockItemName());
                e.setId(theform.getStockitems().get(i).getId());
                e.setStockitemquantity(theform.getStockitems().get(i).getQuantity());
                theList1.add(e);
            }
            ListOfStockSaleForm theList = new ListOfStockSaleForm();
            theList.setTheStockSaleFormList(theList1);
            theModel.addAttribute("addelem", theList);
            return "add-salebillstep";
        }
        ra.addFlashAttribute("someerror", "Please Login to continue");
        return "redirect:/";
    }
    @RequestMapping("/salebill")
    public String addSaleBill(@ModelAttribute("addelem")@Valid ListOfStockSaleForm theform,
            BindingResult theBindingResult,
            Model theModel,
            RedirectAttributes ra
        )
    {
        Object authentication = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(authentication instanceof UserDetails)
        {
            String userName = ((UserDetails)authentication).getUsername();

            if(theform == null)
            {
            	ra.addFlashAttribute("registrationError", "Invalid Request!");
            	return "redirect:/add";        	
            }
            if(theBindingResult.hasErrors())
            {
                logger.info(theBindingResult.toString());
                theModel.addAttribute("addelem", theform);
                theModel.addAttribute("registrationError", theBindingResult.toString());
                return "add-salebillstep";
            }
            try 
            {   
                List<Account> tl = accountService.getAccountByUserName(userName);
                logger.info("processing add cash voucher for user :"
                        + " " + userName + " in "
                                + "AddController, /add/salebill");
                theModel.addAttribute("listofaccounts" ,tl);
                double fp = 0.0;
                String ts = new String();
                for(int i = 0; i < theform.getTheStockSaleFormList().size(); i++)
                {
                	if(theform.getTheStockSaleFormList().get(i).getQuantity() <= 0)
                	{
                		ts = ts + theform.getTheStockSaleFormList().get(i).getStockitemName() + " ";
                	}
                }
                if(ts.length() > 0)
                {
                	ra.addFlashAttribute("registrationError", "The following stock items had invalid quantity : " + ts);
                	return "redirect:/add";
                }
                ts = new String();
                
                for(int i = 0; i < theform.getTheStockSaleFormList().size(); i++)
                {
                    StockSaleForm itm = theform.getTheStockSaleFormList().get(i);
                    StockItem st = stockItemService.get(itm.getId());
                    theform.getTheStockSaleFormList().get(i).setId(st.getId());
                    List<StockTax> thestocktaxlist = stockTaxService.getStockTaxByStockId(st.getId());
                    if(itm.getQuantity() > st.getQuantity())
                    {
                      if(ts.length() > 0) {
                        ts = ts + ", ";
                      }
                      else
                      {
                        ts = ts + " ";
                      }
                      ts = ts + itm.getStockitemName();
                    }
                    {
                        double taxation = 0.0;
                        taxation = taxation + Double.parseDouble(st.getCommision());
                        taxation = taxation + Double.parseDouble(st.getKkFee());
                        taxation = taxation + Double.parseDouble(st.getLabourCharge());
                        taxation = taxation + Double.parseDouble(st.getMandiTax());
                        taxation = taxation / 100.00;
                        double price = 0.0;
                        double perc = taxation * 100.0;
                        double stocktax = 0.0;
                        String sttax = new String();
                        
                        price += (itm.getRate() * itm.getQuantity());
//                		price += (itm.getQuantity() * Double.parseDouble(st.getPacking()));
                        sttax = "Packing Charges: Rs" + st.getPacking() + " per unit ";
                        for(int j = 0; j < thestocktaxlist.size(); j++)
                        {
                            Tax thetax = taxService.get(thestocktaxlist.get(j).getTaxId());
                            stocktax += Double.parseDouble(thetax.getTaxPercent());
                            sttax += thetax.getTaxName() + ":" + thetax.getTaxPercent() + "% ";
                        }
                        perc += stocktax;
                        stocktax /= 100.00;
                        String ffg = "Total tax:Rs." + df.format(price * ((taxation + stocktax))) + "(" + df.format(perc)+ 
                				"%: " + "KKFee:" + df.format(Double.parseDouble(st.getKkFee()))+
                				"% Commision:" + df.format(Double.parseDouble(st.getCommision())) +
                				"% Labour Charge:"+df.format(Double.parseDouble(st.getLabourCharge()))+
                				"% Mandi Tax:"+df.parse(st.getMandiTax()) + "% " + sttax + ") Packing Charges:Rs" + st.getPacking()+" Per Unit";theform.getTheStockSaleFormList().get(i).setTax(Double.parseDouble(df.format(price * (stocktax + taxation))));
                        logger.info(ffg);
                        price *= (1.00 + stocktax + taxation);
                        price += (itm.getQuantity() * Double.parseDouble(st.getPacking()));
                        price = Double.parseDouble(df.format(price));                       
                        theform.getTheStockSaleFormList().get(i).setTotal(price);
                        theform.getTheStockSaleFormList().get(i).setTaxbreakup(ffg);
                        fp += price;
                    }
                }
                if(fp - 0.0 <= 0.0)
                {
                    ra.addFlashAttribute("registrationError", "Billing amount must be greater than zero.");
                    return "redirect:/add";
                	
                }
                if(ts.length() > 0)
                {
                  theModel.addAttribute("addelem", theform);
                  theModel.addAttribute("registrationError", "The following stocks had less quantity left than being entered: " + ts);
                  return "add-salebillstep";
                }
                SaleBillForm theform1 = new SaleBillForm();
                theform1.setCost(fp);
                theform1.setTheform(theform.getTheStockSaleFormList());
                theform1.setUserName(userName);
                theModel.addAttribute("addelem", theform1);
                logger.info("Successfully reached step 2 for adding purchase bill, redirecting to final url!");
                return "add-salebill";
            }
            catch(Exception e) {
                logger.info("Couldn't execute the processing phase of sale voucher command due to exception: " + e);
                ra.addFlashAttribute("registrationError", "Invalid request!");
                return "redirect:/add";
            }
        }
        theModel.addAttribute("registrationError", "Log in first to continue.");
        return "redirect:/";
    }
}
