package com.lcf.app.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.instrument.classloading.tomcat.TomcatLoadTimeWeaver;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcf.app.beans.AccountDetails;
import com.lcf.app.beans.AddressDetails;
import com.lcf.app.beans.BranchDetails;
import com.lcf.app.beans.CustomerDetails;
import com.lcf.app.beans.CustomerTransactionStatement;
import com.lcf.app.beans.IdentityDocuments;
import com.lcf.app.beans.User;
import com.lcf.app.beans.VerificationStatus;
import com.lcf.app.dao.TransactionDao;
import com.lcf.app.beans.LoginCredentials;
import com.lcf.app.beans.Summary;
import com.lcf.app.beans.TransactionDetails;
import com.lcf.app.services.AccountService;
import com.lcf.app.services.AddressService;
import com.lcf.app.services.BranchService;
import com.lcf.app.services.CustomerService;
import com.lcf.app.services.CustomerTransactionStatementService;
import com.lcf.app.services.IdentityService;
import com.lcf.app.services.LoginService;
import com.lcf.app.services.TransactionService;
import com.lcf.app.services.VerificationStatusService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/banking/lcf/user-page")
public class UserController {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private AddressService addressService;
	
	@Autowired
	IdentityService identityService;

	@Autowired
	VerificationStatusService referenceService;


	private User user = new User();

	// taking new personal details
	// hoarding the details
	// http://localhost:8090/banking/lcf/user-page/register/personal-details
	@PostMapping("/register/personal-details")
	public long newCustomer(@RequestBody CustomerDetails customer) {
		// long customerId = customerService.newCustomer(customer);
		// long addressId =
		// addressController.insertAddress(customer.getResidentialAddressObj());
		// customer.setResidentialAddressId(addressId);
		user.setCustomerDetailsObj(customer);
		System.out.println(customer);
		return 1;
		// return customerId;
	}
	
	// Taking address details
	// combining with personal details, sending it to registration()
	// http://localhost:8090/banking/lcf/user-page/register/address-details
	@PostMapping("/register/address-details")
	public long insertAddress(@RequestBody AddressDetails address) {
		//long id = addressService.insertAddress(address);
		user.setPermanentAddressObj(address);
		// int id = addressService.insertAddress(address);
		System.out.println(address);

		long id = registration(user);
		return id;
	}
	
	@GetMapping("/check-status/{id}")
	public long isVerified(@PathVariable(value = "id") long referenceId) {

		System.out.println("ref \n" + referenceId);
		VerificationStatus reference = referenceService.getReferenceById(referenceId);
		System.out.println("\n 1234 \n " + reference);
		char flag = reference.getVerified();
		System.out.println("\n done" + flag);
		long acctNo = accountService.searchAccountByCustomerId(reference.getCustomerId()).getAccountNumber();
		System.out.println("\n done acctno" + acctNo);
		if (flag == 'Y') {
			return acctNo;
		}
		return 0;
	}
	
	// persisting address then personal details
	// http://localhost:8090/banking/lcf/user-page/register
		@PostMapping("/register")
		public long registration(@RequestBody User register) {

			long id1, id2;

			// AddressDetails tempResidential = register.getResidentialAddressObj();
			AddressDetails tempPermanent = register.getPermanentAddressObj();

			// id1 = addressService.insertAddress(register.getResidentialAddressObj());

//			if (!(tempResidential.getAddressLine1().equals(tempPermanent.getAddressLine1()))
//					|| !(tempResidential.getAddressLine2().equals(tempPermanent.getAddressLine2()))
//					|| !(tempResidential.getCity().equals(tempPermanent.getCity()))
//					|| !(tempResidential.getLandmark().equals(tempPermanent.getLandmark()))
//					|| !(tempResidential.getAddressLine2().equals(tempPermanent.getAddressLine2()))
//					|| !(tempResidential.getState().equals(tempPermanent.getState()))
//					|| !(tempResidential.getPinCode() == (tempPermanent.getPinCode()))) {
	//
			id2 = addressService.insertAddress(register.getPermanentAddressObj());
	//
//			}
	//
//			else {
//				id2 = id1;
//			}

			CustomerDetails temp = register.getCustomerDetailsObj();
			temp.setPermanentAddressId(id2);

			// temp.setResidentialAddressId(id1);
			long id = customerService.newCustomer(temp);

			// temp.setResidentialAddressId(id1);
			return id;
		}
		
		// putting identification details
		// http://localhost:8090/banking/lcf/user-page/register/identity-details
		@PostMapping("/register/identity-details")
		public long insertIdentityDocuments(@RequestBody IdentityDocuments identityDocuments) {
			long customerId = identityService.insertIdentityDocuments(identityDocuments);
			AccountDetails account = new AccountDetails();
			account.setCustomerId(customerId);
			accountService.insertAccount(account);
			VerificationStatus verified = new VerificationStatus();
			verified.setCustomerId(customerId);
			long referenceId = referenceService.createReference(verified);
			return referenceId;
		}
		
		// 
		// http://localhost:8090/banking/lcf/user-page/register/net-banking
		@PostMapping("/register/net-banking")
		public long netBankingRegistration(@RequestBody LoginCredentials register) {

			AccountDetails account = searchAccountByAccountNumber(register.getCustomerId());

			if (account == null) {
				return 0;
			}

			long userId = account.getCustomerId();
			String password = register.getLoginPassword();
			int tPin = register.getTransactionPin();

			LoginCredentials loginObj = new LoginCredentials();
			loginObj.setCustomerId(userId);
			loginObj.setLoginPassword(password);
			loginObj.setTransactionPin(tPin);

			long flag = loginService.netBankingRegistration(loginObj);

			return flag;
		}

	
	
	
	
	
	
	
	
	
	@Autowired
	AccountService accountService;

	// http://localhost:8090/banking/lcf/user-page/user-profile/account-details/{id}
	@GetMapping("/user-profile/account-details/{id}")
	public AccountDetails searchAccountByAccountNumber(@PathVariable(value = "id") long accountNumber) {
		AccountDetails account = accountService.searchAccountByAccountNumber(accountNumber);

		return account;
	}

	// http://localhost:8090/banking/lcf/user-page/register/account-details
	@PostMapping("/register/account-details")
	public long insertAccount(@RequestBody AccountDetails accountDetails) {

		long accountNumber = accountService.insertAccount(accountDetails);

		return accountNumber;

	}

	@GetMapping("/user-profile/account-details-id/{id}")
	public AccountDetails searchAccountByCustomerId(@PathVariable(value = "id") long customerId) {
		System.out.println(customerId);
		AccountDetails account = accountService.searchAccountByCustomerId(customerId);

		return account;
	}

	

	// http://localhost:8090/banking/lcf/user-page/user-profile/address-details/{id}
	@GetMapping("/user-profile/address-details/{id}")
	public AddressDetails getAddressById(@PathVariable(value = "id") long addressId) {

		AddressDetails address = addressService.getAddressById(addressId);

		return address;
	}

	@Autowired
	BranchService branchService;

	// http://localhost:8090/banking/lcf/user-page/user-profile/branch-details/{ifsc}
	@GetMapping("/user-profile/branch-details/{ifsc}")
	public BranchDetails getBranchByIfsc(@PathVariable(value = "ifsc") String ifsc) {

		BranchDetails branch = branchService.getBranchByIfsc(ifsc);

		return branch;

	}

	// http://localhost:8090/banking/lcf/user-page/register/branch-details
	@PostMapping("/register/branch-details")
	public String insertBranch(@RequestBody BranchDetails branchDetails) {

		String ifsc = branchService.insertBranch(branchDetails);

		return ifsc;

	}

	

	// providing customer details by id
	// http://localhost:8090/banking/lcf/user-page/user-profile/personal-details/10000001
	@GetMapping("/user-profile/personal-details/{id}")
	public CustomerDetails getCustomerById(@PathVariable(value = "id") long id) {
		CustomerDetails customer = customerService.getCustomerById(id);

		return customer;
	}

	@Autowired
	private LoginService loginService;

	// taking customerId and password as input
	// http://localhost:8090/banking/lcf/user-page/login
	@PostMapping("/login")
	public int login(@RequestBody LoginCredentials log) {
		long userId = log.getCustomerId();
		String password = log.getLoginPassword();
		int flag = loginService.login(userId, password);
		System.out.println(flag);
		System.out.println(log);

		return flag;
	}

	public LoginCredentials getLoginCredentialsById(long id) {

		LoginCredentials loginObj = loginService.getLoginCredentialsById(id);

		return loginObj;
	}

	

	// http://localhost:8090/banking/lcf/user-page/user-profile/identity-details/{id}
	@GetMapping("/user-profile/identity-details/{id}")
	public IdentityDocuments getIdentityDocumentsById(@PathVariable(value = "id") long customerId) {
		IdentityDocuments identity = identityService.getIdentityDocumentsById(customerId);
		return identity;
	}

	@Autowired
	TransactionService transactionService;

	LocalDateTime now = LocalDateTime.now();

	DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");

	String today = now.format(format);

	// http://localhost:8090/banking/lcf/user-page/funds-transfer
	@PostMapping("/funds-transfer")
	public long commitTransaction(@RequestBody TransactionDetails transaction) {
		long tPin = transaction.getTransactionId();
		long accountNo = transaction.getBenefactorAccNumber();
		System.out.println("test"+ accountNo+ " ");
		AccountDetails benefactorDetails = searchAccountByAccountNumber(accountNo);
		long customerId = benefactorDetails.getCustomerId();

		AccountDetails beneficiaryDetails = searchAccountByAccountNumber(transaction.getBeneficiaryAccNumber());
		if (beneficiaryDetails == null) {
			System.out.println("Transaction Failed!");
			return -1;
		}

		String accountName = getCustomerById(beneficiaryDetails.getCustomerId()).getCustomerName();
		if (!accountName.toLowerCase().equals(transaction.getBeneficiaryAccountInfo().toLowerCase())) {
			System.out.println("Transaction Failed!");
			return -2;
		}

		long tempTPin = getLoginCredentialsById(customerId).getTransactionPin();
		if (tPin != tempTPin) {
			System.out.println("Transaction Failed!");
			return 0;
		}

		transaction.setTransactionId(0);

		long benefactorClosingBalance = benefactorDetails.getAvailableBalance() - transaction.getAmount();
		long beneficiaryClosingBalance = beneficiaryDetails.getAvailableBalance() + transaction.getAmount();

		benefactorDetails.setAvailableBalance(benefactorClosingBalance);
		beneficiaryDetails.setAvailableBalance(beneficiaryClosingBalance);

		System.out.println("\n\n\n\n" + today + "\n\n\n\n");

		transaction.setDateOfTransaction(today);
		long transactionId = transactionService.commitTransaction(transaction);

		CustomerTransactionStatement benefactorTransactionStatement = new CustomerTransactionStatement(0, transactionId,
				customerId, benefactorClosingBalance, -1);
		setCustomerTransactionStatement(benefactorTransactionStatement);

		CustomerTransactionStatement beneficiaryTransactionStatement = new CustomerTransactionStatement(0,
				transactionId, beneficiaryDetails.getCustomerId(), beneficiaryClosingBalance, 1);
		setCustomerTransactionStatement(beneficiaryTransactionStatement);

		accountService.insertAccount(benefactorDetails);
		accountService.insertAccount(beneficiaryDetails);

		generateSummary(customerId);

		return transactionId;
	}

	// http://localhost:8090/banking/lcf/user-page/user-profile/transaction-summary/{id}
	@GetMapping("/user-profile/transaction-summary/{id}")
	public TransactionDetails transactionDetails(@PathVariable(value = "id") long transactionId) {
		TransactionDetails transactionDetails = transactionService.transactionDetails(transactionId);
		return transactionDetails;
	}

	@Autowired
	CustomerTransactionStatementService customerTransactionStatementService;

	// http://localhost:8090/banking/lcf/user-page/transfer
	@PostMapping("/transfer")
	public long setCustomerTransactionStatement(
			@RequestBody CustomerTransactionStatement customerTransactionStatement) {
		long sNo = customerTransactionStatementService.setCustomerTransactionStatement(customerTransactionStatement);
		return sNo;
	}

	// http://localhost:8090/banking/lcf/user-page/user-profile/transaction/{id}
	@GetMapping("/user-profile/transaction/{id}")
	public List<CustomerTransactionStatement> getCustomerTransactionStatement(
			@PathVariable(value = "id") long customerId) {
		List<CustomerTransactionStatement> customerTransactionStatement = customerTransactionStatementService
				.getCustomerTransactionStatement(customerId);
		return customerTransactionStatement;
	}

	@GetMapping("/summary/{id}")
	public List<Summary> generateSummary(@PathVariable(value = "id") long customerId) {

		List<CustomerTransactionStatement> customerTransactionStatement = getCustomerTransactionStatement(customerId);
		System.out.println("1" + customerTransactionStatement);
		int len = customerTransactionStatement.size();
		System.out.println("2" + len);
		TransactionDetails tD;
		CustomerTransactionStatement cT;
		// List<Long> transactionId = new ArrayList<>();
		List<Summary> summary = new ArrayList<>();

		for (int i = 0; i < len; i++) {
			cT = customerTransactionStatement.get(i);
			System.out.println(cT);
			tD = transactionDetails(cT.getTransactionId());
			String tInfo = tD.getBeneficiaryAccNumber() + " " + tD.getModeOfTransaction();
			Summary summ = new Summary(tD.getDateOfTransaction(), cT.getTransactionId(), tInfo, tD.getAmount(),
					cT.getAction(), cT.getClosingBalance());
			summary.add(summ);
		}

		System.out.println("/n/n/n" + summary);

		return summary;
	}
	
	@GetMapping("/reset/{id}")
	public boolean resetPassword(LoginCredentials newLoginCredentials){

		//LoginService login = new LoginService();
		LoginCredentials lg = new LoginCredentials();
		lg = loginService.getLoginCredentialsById(newLoginCredentials.getCustomerId());
		lg.setLoginPassword(newLoginCredentials.getLoginPassword());

		boolean success = loginService.resetPassword(lg);
		return success;
		}

}