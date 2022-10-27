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


		ArrayList<String> checkLists = new ArrayList<String>();
//		■checkListsの作成
//		 値が入っている場合のみcheckListsに変数名を追加する

//		■見にくいためArrayListなどに格納し繰り返し処理として変更予定========================
		if(!familyName.equals("")){
			checkLists.add("familyName");
		}
		if(!lastName.equals("")){
			checkLists.add("lastName");
		}
		if(!familyNameKana.equals("")){
			checkLists.add("familyNameKana");
		}
		if(!lastNameKana.equals("")){
			checkLists.add("lastNameKana");
		}
		if(!mail.equals("")){
			checkLists.add("mail");
		}
		if(!gender.equals("")){
			checkLists.add("gender");
		}
		if(!authority.equals("")){
			checkLists.add("authority");
		}
//		========================================================================

		System.out.println("checkListのサイズ ■"+checkLists.size());

		sql = "SELECT id, family_name, last_name, family_name_kana, last_name_kana, mail, gender, authority, delete_flg, registered_time, update_time,"
				+ " postal_code, prefecture, address_1, address_2"
				+ " FROM login_user_transaction"
				+ " WHERE";


		int size = checkLists.size() -1;

//		■SQL文にWHERE句以降を追加する処理
		for(int i =0; i <= size; i++){
			if(checkLists.get(i).equals("familyName")){
				sql += " family_name LIKE ?";
			}else if(checkLists.get(i).equals("lastName")){
				sql += " last_name LIKE ?";
			}else if(checkLists.get(i).equals("familyNameKana")){
				sql += " family_name_kana LIKE ?";
			}else if(checkLists.get(i).equals("lastNameKana")){
				sql += " last_name_kana LIKE ?";
			}else if(checkLists.get(i).equals("mail")){
				sql += " mail LIKE ?";
			}else if(checkLists.get(i).equals("gender")){
				sql += " gender=?";
			}else if(checkLists.get(i).equals("authority")){
				sql += " authority=?";
			}

//			■checkListsの最後の要素の場合は「AND」は追加しない
			if(i != size){
				sql += " AND";
			}
		}

		sql += " ORDER BY id DESC";

		System.out.println("sql文 "+sql);

		try{
				PreparedStatement preparedStatement = connection.prepareStatement(sql);

//				■checkListsの内容ごとに「？」に値を挿入する処理
				int i = 1;
				for(String checkList : checkLists){
					if(checkList.equals("familyName")){
						preparedStatement.setString(i, "%" +familyName + "%");
						i++;
					}else if(checkList.equals("lastName")){
						preparedStatement.setString(i, "%" +lastName + "%");
						i++;
					}else if(checkList.equals("familyNameKana")){
						preparedStatement.setString(i, "%" +familyNameKana + "%");
						i++;
					}else if(checkList.equals("lastNameKana")){
						preparedStatement.setString(i, "%" +lastNameKana + "%");
						i++;
					}else if(checkList.equals("mail")){
						preparedStatement.setString(i, "%" +mail + "%");
						i++;
					}else if(checkList.equals("gender")){
						preparedStatement.setString(i, "%" +gender + "%");
						i++;
					}else if(checkList.equals("authority")){
						preparedStatement.setString(i, "%" +authority + "%");
						i++;
					}
				}

				System.out.println("checkListsのサイズ "+checkLists.size());
				System.out.println("?の数 "+(i-1));


				resultSet = preparedStatement.executeQuery();

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
