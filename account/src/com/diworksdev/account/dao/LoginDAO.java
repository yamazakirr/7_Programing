package com.diworksdev.account.dao;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.diworksdev.account.action.RegistCompleteAction;
import com.diworksdev.account.util.DBConnector;


public class LoginDAO {
	String result = "error";
	private String authority;
	private String loginErrorMessage = "";

	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();
	private String sql ="SELECT id, mail, password, authority, postal_code"
					  + " FROM login_user_transaction"
			          + " WHERE mail=? AND password=?";

	private RegistCompleteAction registCompleteAction = new RegistCompleteAction();


	public String getLoginResult(String loginUserId, String loginUserPassword)throws SQLException{

		try{
//			■パスワードをハッシュ化する処理
			try{
				loginUserPassword = new String(registCompleteAction.hashPassword(loginUserPassword));


			}catch(NoSuchAlgorithmException e){
				System.out.println("パスワードのハッシュ化でエラー発生");
				e.printStackTrace();
			}

			System.out.println("ハッシュ化後のパスワード : "+loginUserPassword);

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, loginUserId);
			preparedStatement.setString(2, loginUserPassword);

			ResultSet resultSet = preparedStatement.executeQuery();


//			■ログイン判定
			if(resultSet.next()){

				this.authority = resultSet.getString("authority");
				this.loginErrorMessage = "";
				result = "success";


				System.out.println("idの番号 : "+resultSet.getString("id"));
				System.out.println("アカウント権限 : "+resultSet.getString("authority"));
				System.out.println("郵便番号 : "+resultSet.getString("postal_code"));

			}else{
				this.loginErrorMessage = "メールアドレスまたはパスワードが違います。";
				return result;
			}

		}catch(Exception e){
			System.out.println("getLoginResultにてエラー発生");
			e.printStackTrace();
		}finally{
			if(connection == null){
				result = "networkError";
				return result;
			}else{
				connection.close();
			}
		}
		return result;
	}

	public String getAuthority(){
		return authority;
	}
	public String getLoginErrorMessage(){
		return loginErrorMessage;
	}

}
