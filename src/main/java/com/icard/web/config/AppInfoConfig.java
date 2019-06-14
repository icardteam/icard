package com.icard.web.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@ConfigurationProperties(prefix = "icard.appinfo")
@Data
public class AppInfoConfig {

	/* 小程序 appId */
	private String appid = new String();
	/* 小程序 appSecret */
	private String secret = new String();

	/* 授权类型，此处只需填写 authorization_code */
	private String grantType = "authorization_code";
	
	public Map<String, String> makeMap() {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("appId", this.getAppid());
		map.put("appSecret", this.getSecret());
		map.put("grant_type", this.getGrantType());
		return map;
	}
}
