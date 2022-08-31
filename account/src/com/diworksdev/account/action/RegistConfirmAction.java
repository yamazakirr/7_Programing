package com.diworksdev.account.action;

import java.util.ArrayList;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

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


//	エラー用のフィールド
	private String familyNameErrorMessage;
//	以降に各項目のフィールドを追加予定----------------------



//	--------------------------------------------




//	メソッド一覧
	public String execute(){
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

//			Mapに値を格納
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


//			項目ごとのエラーチェック
			String familyNameErrorMessage = errorCheck(regexHiraKan,familyName);
			errorCheckLists.add(familyNameErrorMessage);
//			以降に各項目ごとに処理を追加する----------------------



//			--------------------------------------------


//			全体のエラーチェック
			int s = errorCheckAll();
			if(s == 0){
				result = SUCCESS;
			}

		}else{
			setErrorMessage("未入力の項目があります。");
			result = ERROR;
		}

// genderの処理を記述する

		return result;
	}





//	■項目ごとのエラー判定処理

//		checkTextErrorMessage = "": エラーなし
//		checkTextErrorMessage = "ひらがなと漢字のみを入力が出来ます。": ひらがなと漢字以外の文字がある
//		checkTextErrorMessage = "入力必須項目です。": 入力されていない

	public String errorCheck(String regex,String checkText){
		String checkTextErrorMessage = "";

		if(!(checkText == null) && !(checkText.equals(""))){
			boolean checkResult = textError(regex,checkText);
			if(checkResult == true){
				System.out.println("familyNameCheck :"+checkResult);
				checkTextErrorMessage = "";

			}else{
				System.out.println("familyNameCheck :"+checkResult);
				checkTextErrorMessage = "ひらがなと漢字のみを入力が出来ます。";
			}
//		入力欄が空欄の場合
		}else if((checkText == null) || (checkText.equals(""))){
			checkTextErrorMessage = "入力必須項目です。";
		}

		return checkTextErrorMessage;
	}


//	■入力エラー判定処理
	String regexHiraKan = "^[ぁ-ん一-龠]*$";
//	以降に英数字、半角判定の変数を追加予定----------------------


//	--------------------------------------------

	public boolean textError(String regex, String text){

		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(text);
		boolean result = m.find();

		return result;
	}

//	■項目全体のエラー判定処理
//	errorCount = 0 : 項目全体でエラーなし

	ArrayList<String> errorCheckLists = new ArrayList<>();
	int successCount = 0;
	int errorCount = 0;

	public int errorCheckAll(){
		for(String errorCheckList: errorCheckLists){
			if(errorCheckList == ""){
				successCount += successCount + 1;
			}else{
				errorCount += errorCount + 1;
			}
		}
		return errorCount;
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

	public String getFamilyNameErrorMessage(){
		return familyNameErrorMessage;
	}
	public void setFamilyNameErrorMessage(String familyNameErrorMessage){
		this.familyNameErrorMessage = familyNameErrorMessage;
	}

//	@Override
	public void setSession(Map<String, Object> session){
		this.session = session;
	}



}
