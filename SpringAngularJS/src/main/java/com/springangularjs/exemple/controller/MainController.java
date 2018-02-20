package com.springangularjs.exemple.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springangularjs.exemple.serviceConfig.MyConfiguration;

@Controller
public class MainController {

	@Autowired
	ReloadableResourceBundleMessageSource messageSource;
	@Autowired
	MyConfiguration config;

	@RequestMapping(path = "/")
	public String homepage() {
		return "homepage";
	}

	@RequestMapping(path = "/messages", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	String getMessages(@RequestParam(value = "first", required = false) String first,
			@RequestParam(value = "second", required = false) String second,
			@RequestParam(value = "third", required = false) String third) {
		String message = null;
		String code = null;
		if (first == null) {
			message = "Not Found";
		} else {
			if (second == null) {
				code = first;
			} else {
				if (third == null) {
					code = first + "." + second;
				} else {
					code = first + "." + second + "." + third;
				}
			}
		}

		message = messageSource.getMessage(code, null, "Default", null);
		return message;
	}

	@RequestMapping(path = "/users", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	ArrayList<HashMap<?, ?>> getUsers() throws IOException {

		return config.injectUsingApplicationContext("classpath:users.json");
	}

}
