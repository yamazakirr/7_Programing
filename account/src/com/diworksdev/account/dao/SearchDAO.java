package com.diworksdev.account.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.diworksdev.account.dto.SearchDTO;
import com.diworksdev.account.util.DBConnector;


public class SearchDAO {

	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();

	public ArrayList<SearchDTO> getListUserInfo(String familyName, String lastName, String familyNameKana, String lastNameKana, String mail, String gender, String authority) throws SQLException{
		ArrayList<SearchDTO> listDTO = new ArrayList<SearchDTO>();
		String sql;
		ResultSet resultSet;

		System.out.println("familyName "+familyName);
		System.out.println("lastName "+lastName);
		System.out.println("familyNameKana "+familyNameKana);
		System.out.println("lastNameKana "+lastNameKana);
		System.out.println("mail "+mail);
		System.out.println("gender "+gender);
		System.out.println("authority "+authority);



		try{
//			■genderとauthority以外は空欄で検索
			if(familyName.equals("") && lastName.equals("") && familyNameKana.equals("") && lastNameKana.equals("") && mail.equals("")){
				System.out.println("genderとauthority以外は文字指定なし");

				sql = "SELECT id, family_name, last_name, family_name_kana, last_name_kana, mail, gender, authority, delete_flg, registered_time, update_time,"
					+ " postal_code, prefecture, address_1, address_2"
					+ " FROM login_user_transaction"
					+ " WHERE gender=? OR authority=?"
					+ " ORDER BY id DESC";

				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, gender);
				preparedStatement.setString(2, authority);

				resultSet = preparedStatement.executeQuery();

//			■genderとauthority以外に文字指定ありで検索
			}else{
				System.out.println("文字指定あり");

				sql = "SELECT id, family_name, last_name, family_name_kana, last_name_kana, mail, gender, authority, delete_flg, registered_time, update_time,"
						+ " postal_code, prefecture, address_1, address_2"
						+ " FROM login_user_transaction"
						+ " WHERE family_name LIKE '%?%' OR last_name LIKE '%?%' OR family_name_kana LIKE '%?%' OR last_name_kana LIKE '%?%' OR"
						+ " mail LIKE '%?%' OR gender LIKE '%?%' OR authority LIKE '%?%' "
						+ " ORDER BY id DESC";

				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, familyName);
				preparedStatement.setString(2, lastName);
				preparedStatement.setString(3, familyNameKana);
				preparedStatement.setString(4, lastNameKana);
				preparedStatement.setString(5, mail);
				preparedStatement.setString(6, gender);
				preparedStatement.setString(7, authority);

				resultSet = preparedStatement.executeQuery();
			}

			while(resultSet.next()){
				SearchDTO dto = new SearchDTO();
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


				dto.setPostalCode(resultSet.getString("postal_code"));
				dto.setPrefecture(resultSet.getString("prefecture"));

				dto.setAddress1(resultSet.getString("address_1"));
				dto.setAddress2(resultSet.getString("address_2"));

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
