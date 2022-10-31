package com.diworksdev.account.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.diworksdev.account.dao.LoginDAO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware{

	public Map<String, Object> session;

	private String loginUserId;
	private String loginUserPassword;
	private String authority;

	private String loginErrorMessage;

	LoginDAO dao = new LoginDAO();

	public String execute(){
		System.out.println("loginUserId : "+session.get("login_user_id"));
		System.out.println("loginUserPassword : "+session.get("loginUserPassword"));
		System.out.println("authority : "+session.get("authority"));

		String result = ERROR;

//		データベース上のログイン情報を取得するメソッド呼び出し

//			■ログイン済み判定
			if(session.containsKey("authority") && session.containsKey("login_user_id")){
				System.out.println("ログイン済み");
				System.out.println("ログインID"+session.get("login_user_id"));
				System.out.println("アカウント権限"+session.get("authority"));

				result = SUCCESS;
				return result;
			}else{
//				■未ログインの場合
				try{
				System.out.println("未ログイン");
				result = dao.getLoginResult(loginUserId, loginUserPassword);
				setAuthority(dao.getAuthority());

				String loginErrorMessage = dao.getLoginErrorMessage();
				if(loginErrorMessage.equals("")){

//					■sessionにmailとauthorityの情報を格納
					session.put("login_user_id", loginUserId);
					session.put("authority", authority);
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

//	@Override
	public void setSession(Map<String, Object> session){
		this.session = session;
	}
	public Map<String, Object> getSession(){
		return session;
	}
}
