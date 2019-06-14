package com.icard.web.controller;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icard.web.model.UserInfoFromWeChat;
import com.icard.web.model.UserInfoRequest;
import com.icard.web.severity.UserAuthenticationSeverity;

@Controller
@EnableAutoConfiguration
public class UserController {

	@Autowired
	private UserAuthenticationSeverity userAuthenticationSeverity;
	
	@PostMapping(path = "/user")
    @ResponseBody
	public @NotNull UserInfoFromWeChat getSeverityRatio(
			@RequestBody @Validated UserInfoRequest info) {
		UserInfoFromWeChat result = null;
		try {
    		result = userAuthenticationSeverity.getOpenId(info.getCode());
		} catch (JSONException e) {
			return null;
		}

		return result;
	}
	
}
