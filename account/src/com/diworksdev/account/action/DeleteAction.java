package com.diworksdev.account.action;


import java.sql.SQLException;
import java.util.ArrayList;

import com.diworksdev.account.dao.DeleteDAO;
import com.diworksdev.account.dto.DeleteDTO;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteAction extends ActionSupport {

	private String id;

	DeleteDAO deleteDAO = new DeleteDAO();
	private ArrayList<DeleteDTO> deleteList = new ArrayList<DeleteDTO>();

	public String execute() throws SQLException{
		deleteList = deleteDAO.getListDeleteUserInfo(id);

		System.out.println("deleteList : "+deleteList);
		System.out.println("id : "+id);

		if(deleteList == null){
			return ERROR;
		}else{
			return SUCCESS;
		}
	}



//	■getterとsetter
	public String getId(){
		return id;
	}
	public void setId(String id){
		this.id = id;
	}

	public ArrayList<DeleteDTO> getDeleteList(){
		return this.deleteList;
	}

}
