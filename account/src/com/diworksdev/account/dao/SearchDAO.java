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
	ArrayList<SearchDTO> listDTO = new ArrayList<SearchDTO>();
	String sql;
	ResultSet resultSet;

//	■条件指定ありのアカウント検索
	public ArrayList<SearchDTO> getListUserInfo(String familyName, String lastName, String familyNameKana, String lastNameKana, String mail, String gender, String authority) throws SQLException{

		System.out.println("familyName "+familyName);
		System.out.println("lastName "+lastName);
		System.out.println("familyNameKana "+familyNameKana);
		System.out.println("lastNameKana "+lastNameKana);
		System.out.println("mail "+mail);
		System.out.println("gender "+gender);
		System.out.println("authority "+authority);


		ArrayList<String> checkLists = new ArrayList<String>();

//		■引数をlistsに格納する処理
		ArrayList<String> list = new ArrayList<String>();
		list.add(familyName);
		list.add(lastName);
		list.add(familyNameKana);
		list.add(familyNameKana);
		list.add(mail);
		list.add(gender);
		list.add(authority);

//		■checkListsの作成
//		 listに値が入っている場合のみcheckListsに変数名を追加する
		for(int i=0; i < list.size(); i++){
			if(!list.get(i).equals("")){
				if(i == 0){
					checkLists.add("familyName");
				}else if(i == 1){
					checkLists.add("lastName");
				}else if(i == 2){
					checkLists.add("familyNameKana");
				}else if(i == 3){
					checkLists.add("lastNameKana");
				}else if(i == 4){
					checkLists.add("mail");
				}else if(i == 5){
					checkLists.add("gender");
				}else if(i == 6){
					checkLists.add("authority");
				}
			}
		}

		System.out.println("checkListのサイズ ■"+checkLists.size());

		sql = "SELECT id, family_name, last_name, family_name_kana, last_name_kana, mail, gender, authority, delete_flg, registered_time, update_time,"
				+ " postal_code, prefecture, address_1, address_2"
				+ " FROM login_user_transaction"
				+ " WHERE";


//		■SQL文にWHERE句以降を追加する処理
		for(int i =0; i < checkLists.size(); i++){
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
			if(i != checkLists.size()-1){
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
						preparedStatement.setString(i, gender);
						i++;
					}else if(checkList.equals("authority")){
						System.out.println("authorityの値 :"+ authority);
						preparedStatement.setString(i, authority);
						i++;
					}
				}

				System.out.println("checkListsのサイズ "+checkLists.size());
				System.out.println("?の数 "+(i-1));


				resultSet = preparedStatement.executeQuery();

//			■SearchDTOに検索した情報を格納する処理
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

//	■全てのアカウント情報を検索
	public ArrayList<SearchDTO> getListUserInfo() throws SQLException{
		sql = "SELECT id, family_name, last_name, family_name_kana, last_name_kana, mail, gender, authority, delete_flg, registered_time, update_time,"
				+ " postal_code, prefecture, address_1, address_2"
				+ " FROM login_user_transaction"
				+ " ORDER BY id DESC";
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
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

	public int empty(){
		if(listDTO.isEmpty()){
			return 1;
		}else{
			return 0;
		}
	}


}
