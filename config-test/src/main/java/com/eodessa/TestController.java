package com.eodessa;

import com.eodessa.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@RestController
public class TestController {
	
	@Autowired
	private AccountService accountservice;
	
	@Autowired
	private TestService service;

	@Value("${encrypttest}")
	private String test = "1";
	
	//@PreAuthorize("#oauth2.hasScope('server') or #name.equals('demo')")
	@RequestMapping(path = "/demo", method = RequestMethod.GET)
	public String getConfigValue() {
		return service.findByName(test);
	}
	
	//CircuitBreaker
	@RequestMapping(path = "/circuitbreaker", method = RequestMethod.GET)
	public String getCircuitBreaker() {
		return accountservice.getAccountName("demo");
	}
}