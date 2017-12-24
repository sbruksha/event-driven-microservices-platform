package com.eodessa.store.controller;

import com.eodessa.store.domain.Store;
import com.eodessa.store.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
public class StoreController {

	@Autowired
	private StoreService storeService;

	@PreAuthorize("#oauth2.hasScope('server') or #name.equals('demo')")
	@RequestMapping(path = "/{name}", method = RequestMethod.GET)
	public Store getByName(@PathVariable String name) {
		return storeService.findByName(name);
	}

}
