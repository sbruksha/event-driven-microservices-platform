package com.eodessa.notification.controller;

import com.eodessa.notification.domain.Recipient;
import com.eodessa.notification.service.RecipientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

	@Autowired
	private RecipientService recipientService;

	@RequestMapping(path = "/notifications/welcome/{name}", method = RequestMethod.GET)
	public Object getAccountByName(@PathVariable String name) {
		return recipientService.sendWelcomeEmail(name);
	}

}
