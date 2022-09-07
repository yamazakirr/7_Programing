<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css"/>
<meta http-equiv="Content-Script-Type" content="text/javasctipt"/>

<link rel="stylesheet" type="text/css" href="./css/regist.css"/>


<title>アカウント登録画面</title>
</head>
<body>
	<div id="navigation">
		<p>ナビゲーションバー</p>
	</div>
	<div id="header">
		<p><b>アカウント登録画面</b></p>
	</div>

    <div id="main">


      <s:form action="RegistConfirmAction">
      <table>

		<tr>
          <td>
            <label>名前（姓）</label>
          </td>
          <td>
            <input type="text" class="text" name="familyName" maxlength="10" value="たなか"/><br>
            <div class="errorMessage">
				<s:if test="familyNameErrorMessage != null">
	            	<s:property value="familyNameErrorMessage"/>
				</s:if>
            </div>
          </td>
        </tr>
        <tr>
          <td>
            <label>名前（名）</label>
          </td>
          <td>
            <input type="text" class="text" name="lastName" maxlength="10" value="たろう"/><br>
            <div class="errorMessage">
	            <s:if test="lastNameErrorMessage != null">
	            	<s:property value="lastNameErrorMessage"/>
				</s:if>
            </div>
          </td>
        </tr>
        <tr>
          <td>
            <label>カナ（姓）</label>
          </td>
          <td>
            <input type="text" class="text" name="familyNameKana" maxlength="10" value="タナカ"/><br>
            <div class="errorMessage">
	            <s:if test="familyNameKanaErrorMessage != null">
	            	<s:property value="familyNameKanaErrorMessage"/>
				</s:if>
            </div>
          </td>
        </tr>
        <tr>
          <td>
            <label>カナ（名）</label>
          </td>
          <td>
            <input type="text" class="text" name="lastNameKana" maxlength="10" value="タロウ"/><br>
            <div class="errorMessage">
	            <s:if test="lastNameKanaErrorMessage != null">
	            	<s:property value="lastNameKanaErrorMessage"/>
				</s:if>
            </div>
          </td>
        </tr>
        <tr>
          <td>
            <label>メールアドレス</label>
          </td>
          <td>
            <input type="text" class="text" name="mail" maxlength="100" value="test@gmail.com"/><br>
            <div class="errorMessage">
	            <s:if test="mailErrorMessage != null">
	            	<s:property value="mailErrorMessage"/>
				</s:if>
            </div>
          </td>
        </tr>
        <tr>
          <td>
            <label>パスワード</label>
          </td>
          <td>
            <input type="text" class="text" name="password" maxlength="10" value="ssssss"/><br>
            <div class="errorMessage">
	            <s:if test="passwordErrorMessage != null">
	            	<s:property value="passwordErrorMessage"/>
				</s:if>
            </div>
          </td>
        </tr>
        <tr>
          <td>
            <label>性別</label>
          </td>
          <td>
            <input type="radio"  name="gender" value="0" checked="checked">男性
            <input type="radio"  name="gender" value="1">女性
          </td>
        </tr>
        <tr>
          <td>
            <label>郵便番号</label>
          </td>
          <td>
            <input type="text" class="text" name="postalCode" maxlength="7" value="12345"/><br>
            <div class="errorMessage">
	            <s:if test="postalCodedErrorMessage != null">
	            	<s:property value="postalCodedErrorMessage"/>
				</s:if>
            </div>
          </td>
        </tr>
        <tr>
          <td>
            <label>住所（都道府県）</label>
          </td>
          <td>
            <select name="prefecture">
              <option value="北海道" selected>北海道</option>
              <option value="青森県">青森県</option>
              <option value="岩手県">岩手県</option>
              <option value="宮城県">宮城県</option>
              <option value="秋田県">秋田県</option>
              <option value="山形県">山形県</option>
              <option value="福島県">福島県</option>
              <option value="茨城県">茨城県</option>
              <option value="栃木県">栃木県</option>
              <option value="群馬県">群馬県</option>
              <option value="埼玉県">埼玉県</option>
              <option value="千葉県">千葉県</option>
              <option value="東京都">東京都</option>
              <option value="神奈川県">神奈川県</option>
              <option value="新潟県">新潟県</option>
              <option value="富山県">富山県</option>
              <option value="石川県">石川県</option>
              <option value="福井県">福井県</option>
              <option value="山梨県">山梨県</option>
              <option value="長野県">長野県</option>
              <option value="岐阜県">岐阜県</option>
              <option value="静岡県">静岡県</option>
              <option value="愛知県">愛知県</option>
              <option value="三重県">三重県</option>
              <option value="滋賀県">滋賀県</option>
              <option value="京都府">京都府</option>
              <option value="大阪府">大阪府</option>
              <option value="兵庫県">兵庫県</option>
              <option value="奈良県">奈良県</option>
              <option value="和歌山県">和歌山県</option>
              <option value="鳥取県">鳥取県</option>
              <option value="島根県">島根県</option>
              <option value="岡山県">岡山県</option>
              <option value="広島県">広島県</option>
              <option value="山口県">山口県</option>
              <option value="徳島県">徳島県</option>
              <option value="香川県">香川県</option>
              <option value="愛媛県">愛媛県</option>
              <option value="高知県">高知県</option>
              <option value="福岡県">福岡県</option>
              <option value="佐賀県">佐賀県</option>
              <option value="長崎県">長崎県</option>
              <option value="熊本県">熊本県</option>
              <option value="大分県">大分県</option>
              <option value="宮崎県">宮崎県</option>
              <option value="鹿児島県">鹿児島県</option>
              <option value="沖縄県">沖縄県</option>
            </select>
          </td>
        </tr>
        <tr>
          <td>
            <label>住所（市区町村）</label>
          </td>
          <td>
            <input type="text" class="text" name="address1" maxlength="10" value="旭川市"/><br>
            <div class="errorMessage">
	            <s:if test="address1ErrorMessage != null">
	            	<s:property value="address1ErrorMessage"/>
				</s:if>
            </div>
          </td>
        </tr>
        <tr>
          <td>
            <label>住所（番地）</label>
          </td>
          <td>
            <input type="text" class="text" name="address2" maxlength="100" value="アイウエオ1-2-3"/>
            <div class="errorMessage">
	            <s:if test="address2ErrorMessage != null">
	            	<s:property value="address2ErrorMessage"/>
				</s:if>
            </div>
          </td>
        </tr>
        <tr>
          <td>
            <label>アカウント権限</label>
          </td>
          <td>
            <select name="authority">
            	<option value="0">一般</option>
            	<option value="1">管理者</option>
            </select>
          </td>
        </tr>

      </table>
		<div class="button">
			<s:submit class="b" value="確認する"/>
		</div>
      </s:form>
    </div>

    <div id="footer">
      <p>フッター</p>
    </div>


</body>
</html>