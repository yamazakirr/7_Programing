package com.diworksdev.account.dto;

public class DeleteDTO {

	private String id;
	private String familyName;
	private String lastName;
	private String familyNameKana;
	private String lastNameKana;
	private String mail;
	private String password;
	private String passwordText;

	private String gender;

	private String postalCode;

	private String prefecture;
	private String address1;
	private String address2;
	private String authority;


//	■getterとsetter
	public String getId(){
		return id;
	}
	public void setId(String id){
		System.out.println("id : "+id);
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
		System.out.println("getの password : "+password);
		return password;
	}
	public void setPassword(String password){
		System.out.println("setの password : "+password);
		this.password = password;
	}
	public String getPasswordText(){
		return passwordText;
	}
	public void setPasswordText(String passwordText){
		this.passwordText = passwordText;
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
		if(authority.equals("0")){
			this.authority = "一般";
		}else if(authority.equals("1")){
			this.authority = "管理者";
		}
	}
}
