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
	private String familyName;
	private String lastName;
	private String familyNameKana;
	private String lastNameKana;
	private String mail;

	private String gender;
	private String authority;

//	■検索の種類
//	allSearchが「0」は条件指定での検索、「1」は全データの検索
	private int allSearch;

	int empty;


	public Map<String, Object> session;
	SearchDAO searchDAO = new SearchDAO();
	private ArrayList<SearchDTO> accountList = new ArrayList<SearchDTO>();


	public String execute() throws SQLException{

//		■ログイン済み、アカウント権限判定
		if(session.containsKey("login_user_id") && session.get("authority").equals("1")){

//			■アカウント検索の方法を判定
//			 「0」なら条件検索、「1」なら全データを検索
			if(allSearch == 0){
				accountList = searchDAO.getListUserInfo(familyName, lastName, familyNameKana, lastNameKana, mail, gender, authority);

			}else if(allSearch == 1){
				accountList = searchDAO.getListUserInfo();
			}

//			■登録情報の有無判定
//			「0」なら検索実行後に該当情報あり、「1」なら該当情報なし
			empty = searchDAO.empty();

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
	public String getFamilyName(){
		return familyName;
	}
	public void setFamilyName(String familyName){
		if(familyName.equals("")){
			this.familyName = "";
		}else{
			this.familyName = familyName;
		}
	}
	public String getLastName(){
		return lastName;
	}
	public void setLastName(String lastName){
		if(lastName.equals("")){
			this.lastName = "";
		}else{
			this.lastName = lastName;
		}
	}
	public String getFamilyNameKana(){
		return familyNameKana;
	}
	public void setFamilyNameKana(String familyNameKana){
		if(familyNameKana.equals("")){
			this.familyNameKana = "";
		}else{
			this.familyNameKana = familyNameKana;
		}
	}
	public String getLastNameKana(){
		return lastNameKana;
	}
	public void setLastNameKana(String lastNameKana){
		if(lastNameKana.equals("")){
			this.lastNameKana = "";
		}else{
			this.lastNameKana = lastNameKana;
		}
	}
	public String getMail(){
		return mail;
	}
	public void setMail(String mail){
		if(mail.equals("")){
			this.mail = "";
		}else{
			this.mail = mail;
		}
	}
	public String getGender(){
		return gender;
	}
	public void setGender(String gender){
		this.gender = gender;
	}
	public String getAuthority(){
		return authority;
	}
	public void setAuthority(String authority){
		this.authority = authority;
	}

	public int getAllSearch(){
		return allSearch;
	}
	public void setAllSearch(int allSearch){
		this.allSearch = allSearch;
	}
	public int getEmpty(){
		return empty;
	}
	public void setEmpty(int empty){
		this.empty = empty;
	}

}


