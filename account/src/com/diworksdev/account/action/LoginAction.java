package com.diworksdev.account.action;

import java.sql.SQLException;

import com.diworksdev.account.dao.LoginDAO;
import com.opensymphony.xwork2.ActionSupport;


public class LoginAction extends ActionSupport{



	private String loginUserId;
	private String loginUserPassword;
	private String authority;

	private String loginErrorMessage;

	LoginDAO dao = new LoginDAO();

	public String execute(){
		System.out.println("loginUserId : "+loginUserId);
		System.out.println("loginUserPassword : "+loginUserPassword);

		String result = ERROR;

//		データベース上のログイン情報を取得するメソッド呼び出し
		try{
			result = dao.getLoginResult(loginUserId, loginUserPassword);
			setAuthority(dao.getAuthority());

			String s = dao.getLoginErrorMessage();
			if(s.equals("")){
				;
			}else{
				this.loginErrorMessage = dao.getLoginErrorMessage();
			}

			System.out.println("認証の結果 : "+result);
			System.out.println("アカウント権限の値 ： "+this.authority);


		}catch(SQLException e){
			e.printStackTrace();
		}

		return result;
	}



//	■getterとsetter
	public String getLoginUserId(){
		return loginUserId;
	}
	public void setLoginUserId(String loginUserId){
		this.loginUserId = loginUserId;
	}
	public String getLoginUserPassword(){
		return loginUserPassword;
	}
	public void setLoginUserPassword(String loginUserPassword){
		this.loginUserPassword = loginUserPassword;
	}
	public String getAuthority(){
		return authority;
	}
	public void setAuthority(String authority){
		this.authority = authority;
	}

//	■エラーメッセージのgetterとsetter
	public String getLoginErrorMessage(){
		return loginErrorMessage;
	}
	public void setLoginErrorMessage(String loginErrorMessage){
		this.loginErrorMessage = loginErrorMessage;
	}
}
