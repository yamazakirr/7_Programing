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
		String prefecture;


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
				prefecture = resultSet.getString("prefecture");
				dto.setAddress1(resultSet.getString("address_1"));
				dto.setAddress2(resultSet.getString("address_2"));
				dto.setAuthority(resultSet.getString("authority"));

				System.out.println("データベースのfamilyName : "+resultSet.getString("family_name"));

//				■都道府県のselect処理-------------------------
				int prefectureInt = prefecture.length();

				StringBuilder prefectureAll = new StringBuilder();
				prefectureAll.append("<option value='北海道'>北海道</option>"
						+"<option value='青森県'>青森県</option><option value='岩手県'>岩手県</option><option value='宮城県'>宮城県</option><option value='秋田県'>秋田県</option><option value='山形県'>山形県</option><option value='福島県'>福島県</option>"
						+"<option value='茨城県'>茨城県</option><option value='栃木県'>栃木県</option><option value='群馬県'>群馬県</option><option value='埼玉県'>埼玉県</option><option value='千葉県'>千葉県</option><option value='東京都'>東京都</option>"
						+"<option value='神奈川県'>神奈川県</option><option value='新潟県'>新潟県</option><option value='富山県'>富山県</option><option value='石川県'>石川県</option><option value='福井県'>福井県</option><option value='山梨県'>山梨県</option>"
						+"<option value='長野県'>長野県</option><option value='岐阜県'>岐阜県</option><option value='静岡県'>静岡県</option><option value='愛知県'>愛知県</option><option value='三重県'>三重県</option><option value='滋賀県'>滋賀県</option>"
						+"<option value='京都府'>京都府</option><option value='大阪府'>大阪府</option><option value='兵庫県'>兵庫県</option><option value='奈良県'>奈良県</option><option value='和歌山県'>和歌山県</option><option value='鳥取県'>鳥取県</option>"
						+"<option value='島根県'>島根県</option><option value='岡山県'>岡山県</option><option value='広島県'>広島県</option><option value='山口県'>山口県</option><option value='徳島県'>徳島県</option><option value='香川県'>香川県</option>"
						+"<option value='愛媛県'>愛媛県</option><option value='高知県'>高知県</option><option value='福岡県'>福岡県</option><option value='佐賀県'>佐賀県</option><option value='長崎県'>長崎県</option><option value='熊本県'>熊本県</option>"
						+"<option value='大分県'>大分県</option><option value='宮崎県'>宮崎県</option><option value='鹿児島県'>鹿児島県</option><option value='沖縄県'>沖縄県</option>");

				int prefecturePosition = prefectureAll.indexOf(prefecture);
				int setOff = prefecturePosition + prefectureInt + 1;
				prefectureAll.insert(setOff, " selected");
				this.prefectureAll = prefectureAll.toString();
//				------------------------------------------

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
