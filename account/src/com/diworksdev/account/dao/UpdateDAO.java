package com.diworksdev.account.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.diworksdev.account.dto.UpdateDTO;
import com.diworksdev.account.util.DBConnector;

public class UpdateDAO {
	String prefectureAll;


	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();
	private String sql="SELECT id, family_name, last_name, family_name_kana, last_name_kana, mail, password,"
			+ " gender, postal_code, prefecture, address_1, address_2, authority"
			+ " FROM login_user_transaction "
			+ " WHERE id=?";

	public ArrayList<UpdateDTO> getUserInfo(String id)throws SQLException{

		ArrayList<UpdateDTO> updateDTO = new ArrayList<UpdateDTO>();



		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,id);

			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next()){
				UpdateDTO dto = new UpdateDTO();
				dto.setId(resultSet.getString("id"));
				dto.setFamilyName(resultSet.getString("family_name"));
				dto.setLastName(resultSet.getString("last_name"));
				dto.setFamilyNameKana(resultSet.getString("family_name_kana"));
				dto.setLastNameKana(resultSet.getString("last_name_kana"));
				dto.setMail(resultSet.getString("mail"));
				dto.setPassword(resultSet.getString("password"));
				dto.setGender(resultSet.getString("gender"));
				dto.setPostalCode(resultSet.getString("postal_code"));
				dto.setPrefecture(resultSet.getString("prefecture"));

				dto.setAddress1(resultSet.getString("address_1"));
				dto.setAddress2(resultSet.getString("address_2"));
				dto.setAuthority(resultSet.getString("authority"));

				dto.setPrefectureAll(this.prefectureAll);
				updateDTO.add(dto);

			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(connection != null){
				connection.close();
			}else if(connection == null){
				updateDTO = null;
				return updateDTO;
			}
		}
		return updateDTO;

	}

}
