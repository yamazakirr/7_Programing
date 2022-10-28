package com.diworksdev.account.action;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.diworksdev.account.dao.DeleteDAO;
import com.diworksdev.account.dto.DeleteDTO;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteAction extends ActionSupport implements SessionAware{

	private String id;
	public Map<String, Object> session;
	private String authority;

	DeleteDAO deleteDAO = new DeleteDAO();
	private ArrayList<DeleteDTO> deleteList = new ArrayList<DeleteDTO>();

	public String execute() throws SQLException{

//		■テスト用===========================
//		session.put("authority", "0");
//		==================================


		if(session.containsKey("login_user_id") && session.get("authority").equals("1")){
			deleteList = deleteDAO.getListDeleteUserInfo(id);

			System.out.println("deleteList : "+deleteList);
			System.out.println("id : "+id);
			System.out.println("login_user_id : "+session.get("login_user_id"));
			System.out.println("authority : "+session.get("authority"));

			if(deleteList == null){
				return ERROR;
			}else{
				return SUCCESS;
			}

		}else{
			String result = "noAuthority";
			return result;
		}
	}



//	■getterとsetter
	public String getId(){
		return id;
	}
	public void setId(String id){
		this.id = id;
	}
	public String getAuthority(){
		return authority;
	}
	public void setAuthority(String authority){
		this.authority = authority;
	}

	public ArrayList<DeleteDTO> getDeleteList(){
		return this.deleteList;
	}

//	@Override
	public void setSession(Map<String, Object> session){
		this.session = session;
	}

}
