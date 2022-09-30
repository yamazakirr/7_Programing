package com.diworksdev.account.action;

import java.sql.SQLException;
import java.util.ArrayList;

import com.diworksdev.account.dao.UpdateDAO;
import com.diworksdev.account.dto.UpdateDTO;
import com.opensymphony.xwork2.ActionSupport;


public class UpdateConfirmAction extends ActionSupport{

	private ArrayList<UpdateDTO> updateList = new ArrayList<UpdateDTO>();
	private UpdateDAO updateDAO = new UpdateDAO();

	private String id;
	private String familyName;
	private String lastName;
	private String familyNameKana;
	private String lastNameKana;
	private String mail;
	private String password;
	private String passwordText = "";
	private String gender;
	private String postalCode;
	private String prefecture;
	private String address1;
	private String address2;
	private String authority;

//	private String errorMessage;

//エラー用のフィールド
//	「ひらがな、漢字」のみ
	private String familyNameErrorMessage;
	private String lastNameErrorMessage;
//	「カタカナ」のみ
	private String familyNameKanaErrorMessage;
	private String lastNameKanaErrorMessage;
//	「半角英数字」のみ
	private String passwordErrorMessage;
//	「半角英数字、半角ハイフン、半角記号(-と@)」のみ
	private String mailErrorMessage;
//	「半角数字」のみ
	private String postalCodeErrorMessage;
//	「ひらがな、漢字、数字、カタカナ、」
	private String address1ErrorMessage;
	private String address2ErrorMessage;
//	--------------------------------------------

	private RegistConfirmAction rca = new RegistConfirmAction();

	public String execute(){
		String result = ERROR;

//		■パスワード黒まる表示用の処理
		int passwordNum = password.length();
		for(int i=0; i < passwordNum; i++){
			this.passwordText += "●";
		}

//		■入力値エラー判定処理
		System.out.println("rca.regexHiraKan : "+rca.regexHiraKan);

		this.familyNameErrorMessage = rca.errorCheck(rca.regexHiraKan,familyName);
		rca.errorCheckLists.add(this.familyNameErrorMessage);
		this.lastNameErrorMessage = rca.errorCheck(rca.regexHiraKan, lastName);
		rca.errorCheckLists.add(this.lastNameErrorMessage);
		this.familyNameKanaErrorMessage = rca.errorCheck(rca.regexKana, familyNameKana);
		rca.errorCheckLists.add(this.familyNameKanaErrorMessage);
		this.lastNameKanaErrorMessage = rca.errorCheck(rca.regexKana, lastNameKana);
		rca.errorCheckLists.add(this.lastNameKanaErrorMessage);
		this.mailErrorMessage = rca.errorCheck(rca.regexMail, mail);
		rca.errorCheckLists.add(this.mailErrorMessage);
		this.passwordErrorMessage = rca.errorCheck(rca.regexNumAl, password);
		rca.errorCheckLists.add(this.passwordErrorMessage);
		this.postalCodeErrorMessage = rca.errorCheck(rca.regexNum, postalCode);
		rca.errorCheckLists.add(this.postalCodeErrorMessage);
		this.address1ErrorMessage = rca.errorCheck(rca.regexAddress, address1);
		rca.errorCheckLists.add(this.address1ErrorMessage);
		this.address2ErrorMessage = rca.errorCheck(rca.regexAddress, address2);
		rca.errorCheckLists.add(this.address2ErrorMessage);

		System.out.println("errorCheckLists :"+rca.errorCheckLists);

//		■UpdateActionからupdateListの値を取得
		try{
			updateList = updateDAO.getUserInfo(id);
			System.out.println("updateListの結果 : "+updateList);
			System.out.println("idの結果 :"+id);

		}catch(SQLException e){
			e.printStackTrace();
		}

//		--------------------------------------------
//		■全体のエラーチェック
		int s = rca.errorCheckAll();
		if(s == 0){
			result = SUCCESS;
		}else{
			result = ERROR;
		}
//		--------------------------------------------

		System.out.println("resultの結果 : "+result);
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
	public String getPassword(){
		return password;
	}
	public void setPassword(String password){
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
		this.gender = gender;
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
		this.authority = authority;
	}



//	■エラーメッセージのgetter,setter

	public String getFamilyNameErrorMessage(){
		return familyNameErrorMessage;
	}
	public void setFamilyNameErrorMessage(String familyNameErrorMessage){
		this.familyNameErrorMessage = familyNameErrorMessage;
	}

	public String getLastNameErrorMessage(){
		return lastNameErrorMessage;
	}
	public void setLastNameErrorMessage(String lastNameErrorMessage){
		this.lastNameErrorMessage = lastNameErrorMessage;
	}
	public String getFamilyNameKanaErrorMessage(){
		return familyNameKanaErrorMessage;
	}
	public void setFamilyNameKanaErrorMessage(String familyNameKanaErrorMessage){
		this.familyNameKanaErrorMessage = familyNameKanaErrorMessage;
	}
	public String getLastNameKanaErrorMessage(){
		return lastNameKanaErrorMessage;
	}
	public void setLastNameKanaErrorMessage(String lastNameKanaErrorMessage){
		this.lastNameKanaErrorMessage = lastNameKanaErrorMessage;
	}
	public String getPasswordErrorMessage(){
		return passwordErrorMessage;
	}
	public void setPasswordErrorMessage(String passwordErrorMessage){
		this.passwordErrorMessage = passwordErrorMessage;
	}
	public String getMailErrorMessage(){
		return mailErrorMessage;
	}
	public void setMailErrorMessage(String mailErrorMessage){
		this.mailErrorMessage = mailErrorMessage;
	}
	public String getPostalCodeErrorMessage(){
		System.out.println("postalCodeErrorMessage :"+postalCodeErrorMessage);
		return postalCodeErrorMessage;
	}
	public void setPostalCodeErrorMessage(String postalCodeErrorMessage){
		this.postalCodeErrorMessage = postalCodeErrorMessage;
	}
	public String getAddress1ErrorMessage(){
		return address1ErrorMessage;
	}
	public void setAddress1ErrorMessage(String address1ErrorMessage){
		this.address1ErrorMessage = address1ErrorMessage;
	}
	public String getAddress2ErrorMessage(){
		return address2ErrorMessage;
	}
	public void setAddress2CodeErrorMessage(String address2ErrorMessage){
		this.address2ErrorMessage = address2ErrorMessage;
	}
	public ArrayList<UpdateDTO> getUpdateList(){
		return this.updateList;
	}

}
