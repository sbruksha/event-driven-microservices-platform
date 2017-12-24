package com.eodessa;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface TestService {

	/**
	 * Finds account by given name
	 *
	 * @param accountName
	 * @return found string
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/accounts/demo", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	String findByName(String name);


}
