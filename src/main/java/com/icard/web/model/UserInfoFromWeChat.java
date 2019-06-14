package com.icard.web.model;

import lombok.Data;

@Data
public class UserInfoFromWeChat {

	/* 用户唯一标识 */
	private String openid;
	/* 会话密钥 (BE侧保留) */
	private String session_key;
	/* 唯一标识符 */
	private String unionid;
	/* 错误码 */
	private int errcode;
	/* 错误信息 */
	private String errmsg;
}
