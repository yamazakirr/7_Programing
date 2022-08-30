package com.diworksdev.account.action;

import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegistConfirmAction extends ActionSupport implements SessionAware{

//	フィールド一覧
	public Map<String, Object> session;

	private int id;
	private String familyName;
	private String lastName;
	private String familyNameKana;
	private String lastNameKana;
	private String mail;
	private String password;
	private int gender;
	private String genderType;
	private int postalCode;
	private String prefecture;
	private String address1;
	private String address2;
	private int authority;
	private String authorityText;

	private String errorMessage;

//	メソッド一覧
	public String execute(){
		System.out.println("①");
		String result = SUCCESS;


		if(!(familyName.equals("")) && !(lastName.equals(""))){

//			性別判定処理
			if(gender == 0){
				this.genderType = "男";
			}else if(gender == 1){
				this.genderType = "女";
			}
			System.out.println("gender "+gender);

//			権限判定処理
			if(authority==0){
				this.authorityText = "一般";
			}else if(authority==1){
				this.authorityText = "管理者";
			}

//			削除フラグ判定処理？



			session.put("familyName", familyName);
			session.put("lastName", lastName);
			session.put("familyNameKana", familyNameKana);
			session.put("lastNameKana", lastNameKana);
			session.put("mail", mail);
			session.put("password", password);
			session.put("gender", gender);
			session.put("postalCode", postalCode);
			session.put("prefecture", prefecture);
			session.put("address1", address1);
			session.put("address2", address2);
			session.put("authority", authority);
		}else{
			setErrorMessage("未入力の項目があります。");
			result = ERROR;
		}
//		エラー判定の処理を追加予定。JavaScriptで追加？

		public String textError(){
			String regexHiraKan = "^[ぁ-ん一-龠]*$";
			Pattern p = Pattern.compile(regexHiraKan);
			Matcher m = p.matcher(familyName);
			System.out.println(m.find());

			return "s";
		}




// genderの処理を記述する

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
	public int getGender(){
		return gender;
	}
	public void setGender(int gender){
		System.out.println(gender);
		this.gender = gender;
	}
	public String getGenderType(){
		return genderType;
	}
	public void setGenderType(String genderType){
		this.genderType = genderType;
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
	public int getAuthority(){
		return authority;
	}
	public void setAuthority(int authority){
		this.authority = authority;
	}
	public String getAuthorityText(){
		return authorityText;
	}
	public void setAuthorityNum(String authorityText){
		this.authorityText = authorityText;
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
