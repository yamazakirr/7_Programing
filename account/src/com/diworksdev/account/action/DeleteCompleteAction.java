package com.diworksdev.account.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.diworksdev.account.dao.DeleteCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;


public class DeleteCompleteAction extends ActionSupport implements SessionAware{

	private String id;
	public Map<String, Object> session;

	public String execute(){
		String result = ERROR;

//		■DeleteCompleteDAO.javaにてデータベースのdelete_flgを更新する
		try{
			System.out.println("ログインID "+session.get("login_user_id"));
			System.out.println("アカウント権限 "+session.get("authority"));
			DeleteCompleteDAO dao = new DeleteCompleteDAO();
			result = dao.deleteInfo(id);
		}catch(SQLException e){
			e.printStackTrace();
		}

		System.out.println("result : "+result);
		return result;
	}

//	■getterとsetter
	public String getId(){
		System.out.println("DeleteCompleteAction の get のid : "+id);
		return id;
	}
	public void setId(String id){
		System.out.println("DeleteCompleteAction の set のid : "+id);
		this.id = id;
	}
//	@Override
	public void setSession(Map<String, Object> session){
		this.session = session;
	}
}
