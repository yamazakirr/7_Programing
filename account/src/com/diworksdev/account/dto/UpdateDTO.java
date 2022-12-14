package com.diworksdev.account.dto;

//UpdateAction.javaとUpdateDAO.javaの処理内容を更新後、削除予定

public class UpdateDTO {

	private String id;
	private String familyName;
	private String lastName;
	private String familyNameKana;
	private String lastNameKana;
	private String mail;
	private String password;
	private String gender;
	private String postalCode;
	private String prefecture;
	public static String p;

	private String prefectureAll;
	private String address1;
	private String address2;
	private String authority;

	private String errorMessage;

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
		this.gender = gender;
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
		p = prefecture;
	}


	public String getPrefectureAll(){
		return prefectureAll;
	}
	public void setPrefectureAll(String prefectureAll){
		System.out.println("prefectureAll : "+prefectureAll);
		this.prefectureAll = prefectureAll;
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
		System.out.println("UpdateDTO.javaのauthority : "+authority);
		this.authority = authority;
	}


//	■エラーメッセージのgetter,setter

	public String getErrorMessage(){
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage){
		this.errorMessage = errorMessage;
	}

}
