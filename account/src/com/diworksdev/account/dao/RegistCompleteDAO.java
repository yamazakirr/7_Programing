package com.diworksdev.account.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.diworksdev.account.util.DBConnector;
import com.diworksdev.account.util.DateUtil;

public class RegistCompleteDAO {

	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();
	private DateUtil dateUtil = new DateUtil();



	private String sql = "INSERT INTO login_user_transaction(family_name, last_name, family_name_kana, last_name_kana,"
			+ " mail, password, gender, postal_code, prefecture, address_1, address_2, authority, registered_time)"
			+ " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";

	public String createUser(String familyName, String lastName, String familyNameKana, String lastNameKana,
			String mail, String password, String gender, String postalCode, String prefecture, String address1,
			String address2, String authorityNum) throws SQLException{



		String result = "";

		try{

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
		preparedStatement.setInt(7, Integer.parseInt(gender));
		preparedStatement.setString(8, postalCode);
		preparedStatement.setString(9, prefecture);
		preparedStatement.setString(10, address1);
		preparedStatement.setString(11, address2);
		preparedStatement.setInt(12, Integer.parseInt(authorityNum));
		preparedStatement.setString(13, dateUtil.getDate());

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
