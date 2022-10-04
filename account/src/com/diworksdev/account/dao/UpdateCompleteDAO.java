package com.diworksdev.account.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.diworksdev.account.util.DBConnector;


public class UpdateCompleteDAO {

	String result = "error";
	private String updateTime;
	DBConnector dbConnector = new DBConnector();
	Connection connection = dbConnector.getConnection();


//	■コンストラクタ
	public UpdateCompleteDAO(){
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		this.updateTime = simpleDateFormat.format(date);
	}

//	■パスワード変更ありのupdateInfoメソッド
	public String updateInfo(String id,String familyName, String lastName, String familyNameKana, String lastNameKana, String mail, String password, String gender, String postalCode, String prefecture, String address1, String address2, String authority )throws SQLException{
		String sql ="UPDATE login_user_transaction SET family_name=?,last_name=?,family_name_kana=?,last_name_kana=?,mail=?,password=?,gender=?,postal_code=?,prefecture=?,address_1=?,address_2=?,authority=?,update_time=?"
				+ " WHERE id=?";
		System.out.println("DAOのpassword : "+password);
		System.out.println("DAOのfamilyNameKana : "+familyNameKana);

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,familyName);
			preparedStatement.setString(2,lastName);
			preparedStatement.setString(3,familyNameKana);
			preparedStatement.setString(4,lastNameKana);
			preparedStatement.setString(5,mail);
			preparedStatement.setString(6,password);
			preparedStatement.setString(7,gender);
			preparedStatement.setString(8,postalCode);
			preparedStatement.setString(9,prefecture);
			preparedStatement.setString(10,address1);
			preparedStatement.setString(11,address2);
			preparedStatement.setString(12,authority);
			preparedStatement.setString(13, updateTime);
			preparedStatement.setString(14,id);

			int res = preparedStatement.executeUpdate();

//			■更新判定処理
			if(res == 0){
				return result;
			}else{
				;
			}

		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(connection != null){
				connection.close();
			}else{
				return result;
			}
		}
		result = "success";
		return result;

	}
//------------------------------------------------------------------------

//	■パスワード変更なしのupdateInfoメソッド
	public String updateInfo(String id,String familyName, String lastName, String familyNameKana, String lastNameKana, String mail, String gender, String postalCode, String prefecture, String address1, String address2, String authority )throws SQLException{
		String sql ="UPDATE login_user_transaction SET family_name=?,last_name=?,family_name_kana=?,last_name_kana=?,mail=?,gender=?,postal_code=?,prefecture=?,address_1=?,address_2=?,authority=?,update_time=?"
				+ " WHERE id=?";

		System.out.println("DAOのfamilyNameKana : "+familyNameKana);

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,familyName);
			preparedStatement.setString(2,lastName);
			preparedStatement.setString(3,familyNameKana);
			preparedStatement.setString(4,lastNameKana);
			preparedStatement.setString(5,mail);
			preparedStatement.setString(6,gender);
			preparedStatement.setString(7,postalCode);
			preparedStatement.setString(8,prefecture);
			preparedStatement.setString(9,address1);
			preparedStatement.setString(10,address2);
			preparedStatement.setString(11,authority);
			preparedStatement.setString(12, updateTime);
			preparedStatement.setString(13,id);

			int res = preparedStatement.executeUpdate();

//			■更新判定処理
			if(res == 0){
				return result;
			}else{
				;
			}

		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(connection != null){
				connection.close();
			}else{
				return result;
			}
		}
		result = "success";
		return result;

	}

}