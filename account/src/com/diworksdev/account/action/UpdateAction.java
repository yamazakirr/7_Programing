package com.diworksdev.account.action;

import java.sql.SQLException;
import java.util.ArrayList;

import com.diworksdev.account.dao.UpdateDAO;
import com.diworksdev.account.dto.UpdateDTO;
import com.opensymphony.xwork2.ActionSupport;
public class UpdateAction extends ActionSupport{

	private String id;
	private ArrayList<UpdateDTO> updateList = new ArrayList<UpdateDTO>();
	private UpdateDAO updateDAO = new UpdateDAO();

	public String execute(){
		String result = ERROR;

		try{
			updateList = updateDAO.getUserInfo(id);

			System.out.println("updateList : "+ updateList);
			System.out.println("id : "+id);


//			■エラー処理判定
			if(updateList == null){
				return result;
			}else{
				;
			}

		}catch(SQLException e){
			e.printStackTrace();
		}


		result = SUCCESS;
		return result;
	}

//	■getterとsetter
	public String getId(){
		return id;
	}
	public void setId(String id){
		this.id = id;
	}
	public ArrayList<UpdateDTO> getUpdateList(){
		return this.updateList;
	}

}

