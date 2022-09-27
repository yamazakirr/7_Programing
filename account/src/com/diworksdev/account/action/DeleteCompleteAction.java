package com.diworksdev.account.action;

import java.sql.SQLException;

import com.diworksdev.account.dao.DeleteCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteCompleteAction extends ActionSupport{

	private String id;

	public String execute(){
		String result = ERROR;

//		■DeleteCompleteDAO.javaにてデータベースのdelete_flgを更新する
		try{
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
}
