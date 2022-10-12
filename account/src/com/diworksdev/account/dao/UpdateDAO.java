package com.diworksdev.account.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.diworksdev.account.util.DBConnector;

public class UpdateDAO {
	private String result = "error";


	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();
	private String sql="SELECT id, family_name, last_name, family_name_kana, last_name_kana, mail, password,"
			+ " gender, postal_code, prefecture, address_1, address_2, authority"
			+ " FROM login_user_transaction "
			+ " WHERE id=?";

	public String getUserInfo(String id)throws SQLException{

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,id);

		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(connection != null){
				connection.close();
			}else if(connection == null){

				return result;
			}
		}
		result = "success";
		return result;

	}

}
