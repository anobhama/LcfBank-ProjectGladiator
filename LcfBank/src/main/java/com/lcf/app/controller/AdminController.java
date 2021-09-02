package com.lcf.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcf.app.beans.CustomerDetails;
import com.lcf.app.beans.VerificationStatus;
import com.lcf.app.services.CustomerService;
import com.lcf.app.services.VerificationStatusService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/banking/lcf/admin-page")
public class AdminController {

	@Autowired
	VerificationStatusService referenceService;

	@Autowired
	CustomerService customerService;

	// http://localhost:8090/banking/lcf/admin-page/verification-status-list
	@GetMapping("/verification-status-list")
	public List<VerificationStatus> displayAll() {
		List<VerificationStatus> referenceList = referenceService.displayAll();
		return referenceList;
	}

	// http://localhost:8090/banking/lcf/admin-page/customer-details/{id}
	@GetMapping("/customer-details/{id}")
	public CustomerDetails getCustomerById(@PathVariable(value = "id") long id) {
		CustomerDetails customerDetails = customerService.getCustomerById(id);
		return customerDetails;
	}

	@GetMapping("/verification-status/{referenceId}")
	public boolean getStatusByReferenceId(@PathVariable(value = "referenceId") long referenceId) {
		boolean check = referenceService.getStatusByReferenceId(referenceId);
		return check;
	}

}