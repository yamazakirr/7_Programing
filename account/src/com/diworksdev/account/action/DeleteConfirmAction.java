package com.diworksdev.account.action;

import com.opensymphony.xwork2.ActionSupport;

public class DeleteConfirmAction extends ActionSupport{

	private String id;

	public String execute(){
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
}
