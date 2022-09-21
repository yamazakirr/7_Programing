package com.diworksdev.account.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.diworksdev.account.dao.ListDAO;
import com.diworksdev.account.dto.ListDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ListAction extends ActionSupport implements SessionAware{

//	■インスタンス化、フィールドの宣言
	public Map<String, Object> session;
	ListDAO listDAO = new ListDAO();
	private ArrayList<ListDTO> accountList = new ArrayList<ListDTO>();


	public String execute() throws SQLException{

		accountList = listDAO.getListUserInfo();

		if(accountList == null){
			return ERROR;
		}else{
			return SUCCESS;
		}
	}

// @Override
	public void setSession(Map<String, Object> session){
		this.session = session;
	}
	public ArrayList<ListDTO> getAccountList(){
		return this.accountList;
	}


}


