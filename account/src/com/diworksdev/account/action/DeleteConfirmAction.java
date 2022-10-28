package com.diworksdev.account.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class DeleteConfirmAction extends ActionSupport implements SessionAware{

	private String id;
	public Map<String, Object> session;
	private String authority;

	public String execute(){
		System.out.println("ログインID "+session.get("login_user_id"));
		System.out.println("アカウント権限 "+session.get("authority"));
		return SUCCESS;
	}


//	■getterとsetter
	public String getId(){
		System.out.println("DeleteConfirmAction の get のid : "+id);
		return id;
	}
	public void setId(String id){
		System.out.println("DeleteConfirmAction の set のid : "+id);
		this.id = id;
	}
	public String getAuthority(){
		return authority;
	}
	public void setAuthority(String authority){
		this.authority = authority;
	}

//	@Override
	public void setSession(Map<String, Object> session){
		this.session = session;
	}
}
