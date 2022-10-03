package com.diworksdev.account.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.diworksdev.account.dto.ListDTO;
import com.diworksdev.account.util.DBConnector;


public class ListDAO {

	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();

	public ArrayList<ListDTO> getListUserInfo() throws SQLException{
		ArrayList<ListDTO> listDTO = new ArrayList<ListDTO>();

		String sql = "SELECT id, family_name, last_name, family_name_kana, last_name_kana, mail, gender, authority, delete_flg, registered_time, update_time"
				+ " FROM login_user_transaction"
				+ " ORDER BY id DESC";

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);


			ResultSet resultSet = preparedStatement.executeQuery();

			System.out.println("DAO ①");
			System.out.println("DAO ①");

			while(resultSet.next()){
				ListDTO dto = new ListDTO();
				dto.setId(resultSet.getString("id"));
				dto.setFamilyName(resultSet.getString("family_name"));
				dto.setLastName(resultSet.getString("last_name"));
				dto.setFamilyNameKana(resultSet.getString("family_name_kana"));
				dto.setLastNameKana(resultSet.getString("last_name_kana"));
				dto.setMail(resultSet.getString("mail"));
				dto.setGender(resultSet.getString("gender"));
				dto.setAuthority(resultSet.getString("authority"));
				dto.setDeleteFlg(resultSet.getString("delete_flg"));
				dto.setRegisteredTime(resultSet.getString("registered_time"));
				dto.setUpdateTime(resultSet.getString("update_time"));

				listDTO.add(dto);

				System.out.println("id  :"+resultSet.getString("id"));
				System.out.println("family_name  :"+resultSet.getString("family_name"));
				System.out.println("listDTO : "+ listDTO);

			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(connection != null){
				connection.close();
			}else if(connection == null){
				listDTO = null;
				return listDTO;
			}
		}
		return listDTO;

	}

}
