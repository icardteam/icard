package com.icard.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icard.web.severity.UserAuthenticationSeverity;

@Controller
@EnableAutoConfiguration
public class HelloController {

	@Autowired
	private UserAuthenticationSeverity userAuthenticationSeverity;
	
    @RequestMapping("/hello")
    @ResponseBody
    String home() {
    	try {
			userAuthenticationSeverity.getOpenId("abcd");
		} catch (JSONException e) {
			return "get info from JSONObject failed!";
		}
        return "iCard!";
    }
}
