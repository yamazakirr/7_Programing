package com.diworksdev.account.action;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Map;

import com.diworksdev.account.dao.UpdateCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateCompleteAction extends ActionSupport{

	public Map<String, Object> session;

	private String id;
	private String familyName;
	private String lastName;
	private String familyNameKana;
	private String lastNameKana;
	private String mail;
	private String password;
	private String passwordText = "";
	private String passwordChange;
	private String gender;
	private String postalCode;
	private String prefecture;
	private String address1;
	private String address2;
	private String authority;

	UpdateCompleteDAO dao = new UpdateCompleteDAO();



	public String execute(){
		String result = ERROR;


		if(passwordChange.equals("1")){
			try{
				//			■パスワードのハッシュ化処理
				String passwordHash = new String(hashPassword(this.password));
				this.password = passwordHash;

				//			■データベースの更新処理
				result = dao.updateInfo(id, familyName, lastName, familyNameKana, lastNameKana, mail, password, gender, postalCode, prefecture, address1, address2, authority);

			}catch(SQLException e){
				e.printStackTrace();
			}catch(NoSuchAlgorithmException e){
				e.printStackTrace();
			}
		}else if(passwordChange.equals("0")){
			try{
				result = dao.updateInfo(id, familyName, lastName, familyNameKana, lastNameKana, mail,gender, postalCode, prefecture, address1, address2, authority);

			}catch(SQLException e){
				e.printStackTrace();
			}
		}

		return result;
	}

//	■パスワードのハッシュ化するメソッド
	public byte[] hashPassword(String password) throws NoSuchAlgorithmException{
		MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");

		byte[] b = password.getBytes();
		return messageDigest.digest(b);
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
		System.out.println("SET の familyNameKana : "+familyNameKana);
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
		System.out.println("GET passwordの値 :"+password);
		return password;
	}
	public void setPassword(String password){
		System.out.println("SET passwordの値 :"+password);
		this.password = password;
	}
	public String getPasswordText(){
		return passwordText;
	}
	public void setPasswordText(String passwordText){
		this.passwordText = passwordText;
	}
	public String getPasswordChange(){
		return passwordChange;
	}
	public void setPasswordChange(String passwordChange){
		this.passwordChange = passwordChange;
	}
	public String getGender(){
		return gender;
	}
	public void setGender(String gender){
		if(gender.equals("男性")){
			this.gender = "0";
		}else if(gender.equals("女性")){
			this.gender = "1";
		}
	}
	public String getPostalCode(){
		return postalCode;
	}
	public void setPostalCode(String postalCode){
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
		if(authority.equals("一般")){
			this.authority = "0";
		}else if(authority.equals("管理者")){
			this.authority = "1";
		}
	}

}
