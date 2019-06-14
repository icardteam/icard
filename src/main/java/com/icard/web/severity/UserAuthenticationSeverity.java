package com.icard.web.severity;

import org.springframework.boot.configurationprocessor.json.JSONException;

import com.icard.web.model.UserInfoFromWeChat;

public interface UserAuthenticationSeverity {
	UserInfoFromWeChat getOpenId(String js_code) throws JSONException;
}
