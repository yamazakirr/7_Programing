package com.diworksdev.account.action;

import java.sql.SQLException;
import java.util.ArrayList;

import com.diworksdev.account.dao.UpdateDAO;
import com.diworksdev.account.dto.UpdateDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateAction extends ActionSupport{

	private String id;
	private String prefecture;


	private ArrayList<UpdateDTO> updateList = new ArrayList<UpdateDTO>();
	private UpdateDAO updateDAO = new UpdateDAO();

	public String execute(){
		String result = ERROR;

		try{
//			■アカウント情報出力処理
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

		System.out.println("result : "+result);
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
	public String getPrefecture(){
		return prefecture;
	}
	public void setPrefecture(String prefecture){
		this.prefecture = prefecture;
	}
	public ArrayList<UpdateDTO> getUpdateList(){
		return this.updateList;
	}

}


