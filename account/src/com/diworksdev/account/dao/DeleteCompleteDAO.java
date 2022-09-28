package com.diworksdev.account.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.diworksdev.account.util.DBConnector;

public class DeleteCompleteDAO {

	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();



	public String deleteInfo(String id)throws SQLException{
		String result = "error";
		String sql ="UPDATE login_user_transaction SET delete_flg = 1 "
				+ " WHERE id=?";

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, id);

			int res = preparedStatement.executeUpdate();

//			■削除判定処理
			if(res == 0){
				return result;
			}else{
				;
			}

			System.out.println("res : "+res);

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

