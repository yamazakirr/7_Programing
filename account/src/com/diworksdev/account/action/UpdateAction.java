package com.diworksdev.account.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.diworksdev.account.dao.UpdateDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateAction extends ActionSupport implements SessionAware{

	private String id;
	private String familyName;
	private String lastName;
	private String familyNameKana;
	private String lastNameKana;
	private String mail;
	private String gender;
	private String authority;

	private String postalCode;
	private String prefecture;
	private String address1;
	private String address2;

	public Map<String, Object> session;


	private UpdateDAO updateDAO = new UpdateDAO();

	public String execute(){
		String result = ERROR;

		if(session.containsKey("login_user_id") && session.get("authority").equals("1")){
			try{
				//			■アカウント情報出力処理
				result = updateDAO.getUserInfo(id);

				//			■エラー処理判定
				if(result.equals("error")){
					return result;
				}else{
					//				■prefectureに値を格納
					//				setPrefecture(updateList)
					;
				}

			}catch(SQLException e){
				e.printStackTrace();
			}

			result = SUCCESS;
			return result;

		}
		result = "noAuthority";
		return result;
	}

//	■getterとsetter
	public String getId(){
		return id;
	}
	public void setId(String id){
		this.id = id;
	}
	public String getFamilyName(){
		return familyName;
	}
	public void setFamilyName(String familyName){
		this.familyName = familyName;
	}
	public String getLastName(){
		return lastName;
	}
	public void setLastName(String lastName){
		this.lastName = lastName;
	}
	public String getFamilyNameKana(){
		return familyNameKana;
	}
	public void setFamilyNameKana(String familyNameKana){
		this.familyNameKana = familyNameKana;
	}
	public String getLastNameKana(){
		return lastNameKana;
	}
	public void setLastNameKana(String lastNameKana){
		this.lastNameKana = lastNameKana;
	}
	public String getMail(){
		return mail;
	}
	public void setMail(String mail){
		this.mail = mail;
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
	public String getPostalCode(){
		return postalCode;
	}
	public void setPostalCode(String postalCode){
		this.postalCode = postalCode;
	}
	public String getPrefecture(){
		return this.prefecture;
	}
	public void setPrefecture(String prefecture){
		this.prefecture = prefecture;
	}
	public String getAddress1(){
		return address1;
	}
	public void setAddress1(String address1){
		this.address1 = address1;
	}
	public String getAddress2(){
		return address2;
	}
	public void setAddress2(String address2){
		this.address2 = address2;
	}

//	@Override
	public void setSession(Map<String, Object> session){
		this.session = session;
	}

}


