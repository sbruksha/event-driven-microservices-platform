package com.eodessa;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class AccountService {
	
    @HystrixCommand(fallbackMethod = "defaultAccountName")
    public String getAccountName(String username) {
        return new RestTemplate()
          .getForObject("http://account-service:6000/accounts/{username}", 
          Account.class, username).getName();
    }
  
    private String defaultAccountName(String username) {
        return "Hi there!";
    }
}

