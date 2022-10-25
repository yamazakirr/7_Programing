package com.diworksdev.account.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.diworksdev.account.dao.SearchDAO;
import com.diworksdev.account.dto.SearchDTO;
import com.opensymphony.xwork2.ActionSupport;

public class SearchAction extends ActionSupport implements SessionAware{

//	■インスタンス化、フィールドの宣言
	private String searchFamilyName;
	private String searchLastName;
	private String searchFamilyNameKana;
	private String searchLastNameKana;
	private String searchMail;

	private String searchGender;
	private String searchAuthority;


	public Map<String, Object> session;
	SearchDAO searchDAO = new SearchDAO();
	private ArrayList<SearchDTO> accountList = new ArrayList<SearchDTO>();


	public String execute() throws SQLException{

//		■ログイン済み、アカウント権限判定
		if(session.containsKey("login_user_id") && session.get("authority").equals("1")){
			accountList = searchDAO.getListUserInfo(searchFamilyName, searchLastName, searchFamilyNameKana, searchLastNameKana, searchMail, searchGender, searchAuthority);

			if(accountList == null){
				return ERROR;
			}else{
				return SUCCESS;
			}

		}else{
			String result = "noAuthority";
			return result;
		}

	}

// @Override
	public void setSession(Map<String, Object> session){
		this.session = session;
	}
	public ArrayList<SearchDTO> getAccountList(){
		return this.accountList;
	}

//	■getterとsetter
	public String getSearchFamilyName(){
		return searchFamilyName;
	}
	public void setSearchFamilyName(String searchFamilyName){
		if(searchFamilyName.equals("")){
			this.searchFamilyName = "";
		}else{
			this.searchFamilyName = searchFamilyName;
		}
	}
	public String getSearchLastName(){
		return searchLastName;
	}
	public void setSearchLastName(String searchLastName){
		if(searchLastName.equals("")){
			this.searchLastName = "";
		}else{
			this.searchLastName = searchLastName;
		}
	}
	public String getSearchFamilyNameKana(){
		return searchFamilyNameKana;
	}
	public void setSearchFamilyNameKana(String searchFamilyNameKana){
		if(searchFamilyNameKana.equals("")){
			this.searchFamilyNameKana = "";
		}else{
			this.searchFamilyNameKana = searchFamilyNameKana;
		}
	}
	public String getSearchLastNameKana(){
		return searchLastNameKana;
	}
	public void setSearchLastNameKana(String searchLastNameKana){
		if(searchLastNameKana.equals("")){
			this.searchLastNameKana = "";
		}else{
			this.searchLastNameKana = searchLastNameKana;
		}
	}
	public String getSearchMail(){
		return searchMail;
	}
	public void setSearchMail(String searchMail){
		if(searchMail.equals("")){
			this.searchMail = "";
		}else{
			this.searchMail = searchMail;
		}
	}
	public String getSearchGender(){
		return searchGender;
	}
	public void setSearchGender(String searchGender){
		this.searchGender = searchGender;
	}
	public String getSearchAuthority(){
		return searchAuthority;
	}
	public void setSearchAuthority(String searchAuthority){
		this.searchAuthority = searchAuthority;
	}

}


