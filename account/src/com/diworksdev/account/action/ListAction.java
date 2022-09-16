package com.diworksdev.account.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.diworksdev.account.dao.ListDAO;
import com.diworksdev.account.dto.ListDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ListAction extends ActionSupport implements SessionAware{

	public Map<String, Object> session;
	private ListDAO listDAO = new ListDAO();
	private ArrayList<ListDTO> list = new ArrayList<ListDTO>();


	public String execute() throws SQLException{
		return SUCCESS;
	}

// @Override
	public void setSession(Map<String, Object> session){
		this.session = session;
	}
	public ArrayList<ListDTO> getList(){
		return this.list;
	}


}


