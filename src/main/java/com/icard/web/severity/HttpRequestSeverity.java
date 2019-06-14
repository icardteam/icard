package com.icard.web.severity;

import java.io.IOException;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;






public class HttpRequestSeverity {
	
	/* 设置http服务器url */
	private String serverUrl;


	HttpRequestSeverity (String url) {
		this.serverUrl = url;
	}
	
	/* 
	 * 
	 */
	public JSONObject get(Map<String, String> infos) {
		
		String getUrl = this.serverUrl + this.makeGetUrl(infos);
		
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpget = new HttpGet(getUrl);
		JSONObject result = null;
		
		try {
			HttpResponse response = httpClient.execute(httpget);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				result =  new JSONObject(EntityUtils.toString(entity, "UTF-8").trim());
 
			}
		} catch (IOException e) {
			//execute failed
			e.printStackTrace();
		} catch (ParseException e) {
			// make JSONObject faild
			e.printStackTrace();
		} catch (JSONException e) {
			// make JSONObject faild
			e.printStackTrace();
		} finally {
			httpget.abort();
		}
		return result;

		
	}

	private String makeGetUrl(Map<String, String> infos) {

		String result = new String();
		for(Map.Entry<String, String> info : infos.entrySet()){
		    String key = info.getKey();
		    String value = info.getValue();
		    result = (result==null? "?" + result: result + "&") + (key + "=" + value); 
		}

		return result;
	}
}
