package com.diworksdev.account.dto;

public class ListDTO {
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

		this.registeredTime = registeredTime;
	}
	public String getUpdateTime(){
		return updateTime;
	}
	public void setUpdateTime(String updateTime){
		this.updateTime = updateTime;
	}




}


