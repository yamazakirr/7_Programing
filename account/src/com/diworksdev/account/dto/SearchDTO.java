package com.diworksdev.account.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class SearchDTO {
	public String id;
	public String familyName;
	public String lastName;
	public String familyNameKana;
	public String lastNameKana;
	public String mail;
	public String gender;
	public String authority;
	public String deleteFlg;
	public String registeredTime;
	public String updateTime;

//	■更新処理で使用
	private String postalCode;
	private String prefecture;
	private String address1;
	private String address2;

//	■日付のフォーマット変換
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");



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
		if(gender.equals("0")){
			this.gender = "男性";
		}else if(gender.equals("1")){
			this.gender = "女性";
		}
	}
	public String getAuthority(){
		return authority;
	}
	public void setAuthority(String authority){
		if(authority.equals("0")){
			this.authority = "一般";
		}else if(authority.equals("1")){
			this.authority = "管理者";
		}
	}
	public String getDeleteFlg(){
		return deleteFlg;
	}
	public void setDeleteFlg(String deleteFlg){
		if(deleteFlg.equals("0")){
			this.deleteFlg = "有効";
		}else if(deleteFlg.equals("1")){
			this.deleteFlg = "無効";
		}
	}
	public String getRegisteredTime(){
		return registeredTime;
	}
	public void setRegisteredTime(String registeredTime){
		try{
			Date date = sdf.parse(registeredTime);
			String str = new SimpleDateFormat("yyyy/MM/dd").format(date);
			this.registeredTime = str;
		}catch(ParseException e){
			e.printStackTrace();
		}
	}
	public String getUpdateTime(){
		return updateTime;
	}
	public void setUpdateTime(String updateTime){
		try{
			Date date = sdf.parse(updateTime);
			String str = new SimpleDateFormat("yyyy/MM/dd").format(date);
			this.updateTime = str;
		}catch(ParseException e){
			e.printStackTrace();
		}
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




}


