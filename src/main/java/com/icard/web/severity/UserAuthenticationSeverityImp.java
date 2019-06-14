package com.icard.web.severity;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import com.icard.web.config.AppInfoConfig;
import com.icard.web.model.UserInfoFromWeChat;


import lombok.RequiredArgsConstructor;

@Service
@Component
@RequiredArgsConstructor
public class UserAuthenticationSeverityImp implements  UserAuthenticationSeverity{

	@Autowired
	private AppInfoConfig appInfoConfig;

	
	@Override
	public UserInfoFromWeChat getOpenId(String js_code) throws JSONException {
		HttpRequestSeverity httpRequest = new HttpRequestSeverity("https://api.weixin.qq.com/sns/jscode2session");	
		Map<String, String> info = this.appInfoConfig.makeMap();
		info.put("js_code", js_code);
		JSONObject result = httpRequest.get(info);
		if (!result.get("errcode").toString().equals("0")) {
			return null;
		}
		
		UserInfoFromWeChat userInfoFromWeChat = new UserInfoFromWeChat();
		userInfoFromWeChat.setOpenid(result.get("openid").toString());
		userInfoFromWeChat.setSession_key(result.get("session_key").toString());
		userInfoFromWeChat.setUnionid(result.get("unionid").toString());
		return userInfoFromWeChat;
		
	}
	
}
