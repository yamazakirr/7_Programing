package com.diworksdev.account.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.diworksdev.account.util.DBConnector;

public class RegistCompleteDAO {

	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();
	private String nowString;


//	■コンストラクタ
	public RegistCompleteDAO(){
//		■現在時刻の取得
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		this.nowString = simpleDateFormat.format(date);
	}

	private String sql = "INSERT INTO login_user_transaction(family_name, last_name, family_name_kana, last_name_kana,"
			+ " mail, password, gender, postal_code, prefecture, address_1, address_2, authority, delete_flg, registered_time, update_time)"
			+ " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

	public String createUser(String familyName, String lastName, String familyNameKana, String lastNameKana,
			String mail, String password, String gender, String postalCode, String prefecture, String address1,
			String address2, String authorityNum) throws SQLException{


		System.out.println("postalCodeTextの型 : "+postalCode.getClass().getSimpleName());



		String result = "";

		try{
		String deleteFlg = "0";

		System.out.println("familyName "+familyName);
		System.out.println("lastName "+lastName);
		System.out.println("familyNameKana "+familyNameKana);
		System.out.println("lastNameKana "+lastNameKana);
		System.out.println("mail "+mail);

		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		preparedStatement.setString(1, familyName);
		preparedStatement.setString(2, lastName);
		preparedStatement.setString(3, familyNameKana);
		preparedStatement.setString(4, lastNameKana);
		preparedStatement.setString(5, mail);
		preparedStatement.setString(6, password);
		preparedStatement.setString(7, gender);
		preparedStatement.setString(8, postalCode);
		preparedStatement.setString(9, prefecture);
		preparedStatement.setString(10, address1);
		preparedStatement.setString(11, address2);
		preparedStatement.setString(12, authorityNum);
		preparedStatement.setString(13, deleteFlg);
		preparedStatement.setString(14, nowString);
		preparedStatement.setString(15, nowString);

		preparedStatement.execute();

		result = "success";

		}catch(Exception e){
			result = "error";
			e.printStackTrace();
		}finally{

			if(connection != null){
				connection.close();
			}
		}
		return result;
	}

}
