package com.diworksdev.account.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.diworksdev.account.dao.RegistCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class RegistCompleteAction extends ActionSupport implements SessionAware{

	public Map<String, Object> session;
	private int id;
	private String familyName;
	private String lastName;
	private String familyNameKana;
	private String lastNameKana;
	private String mail;
	private String password;
	private String gender;
	private int postalCode;
	private String prefecture;
	private String address1;
	private String address2;
	private String authority;

	private String errorMessage;

	private RegistCompleteDAO registCompleteDAO = new RegistCompleteDAO();

	public String execute() throws SQLException{
		registCompleteDAO.createUser(session.get("familyName").toString(),
				session.get("lastName").toString(),
				session.get("familyNameKana").toString(),
				session.get("lastNameKana").toString(),
				session.get("mail").toString(),
				session.get("password").toString(),
				session.get("gender").toString(),
				session.get("postalCode").toString(),
				session.get("prefecture").toString(),
				session.get("address1").toString(),
				session.get("address2").toString(),
				session.get("authorityNum").toString()
				);

		String result = SUCCESS;
		return result;
	}


//	getterとsetter
	public int getId(){
		return id;
	}
	public void setId(int id){
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
	public String getPassword(){
		return password;
	}
	public void setPassword(String password){
		this.password = password;
	}
	public String getGender(){
		return gender;
	}
	public void setGender(String gender){
		System.out.println(gender);
		this.gender = gender;
	}
	public int getPostalCode(){
		return postalCode;
	}
	public void setPostalCode(int postalCode){
		this.postalCode = postalCode;
	}
	public String getPrefecture(){
		return prefecture;
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
	public String getAuthority(){
		return authority;
	}
	public void setAuthority(String authority){
		this.authority = authority;
	}

	public String getErrorMessage(){
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage){
		this.errorMessage = errorMessage;
	}

//	@Override
	public void setSession(Map<String, Object> session){
		this.session = session;
	}


}
