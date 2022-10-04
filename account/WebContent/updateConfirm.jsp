<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>アカウント更新確認画面</title>
</head>
<body>

<div id="navigation">
	<p>ナビゲーションバー</p>
</div>

<div id="header">
		<p><b>アカウント更新確認画面</b></p>
	</div>

    <div id="main">

	<s:form action="UpdateCompleteAction">
    	<table>

		<tr>
          <td>
            <label>名前（姓）</label>
          </td>
          <td>
				<s:property value="familyName"/>
          </td>
        </tr>
        <tr>
          <td>
            <label>名前（名）</label>
          </td>
          <td>
				<s:property value="lastName"/>
          </td>
        </tr>
        <tr>
          <td>
            <label>カナ（姓）</label>
          </td>
          <td>
				<s:property value="familyNameKana"/>
          </td>
        </tr>
        <tr>
          <td>
            <label>カナ（名）</label>
          </td>
          <td>
				<s:property value="lastNameKana"/>
          </td>
        </tr>
        <tr>
          <td>
            <label>メールアドレス</label>
          </td>
          <td>
				<s:property value="mail"/>
          </td>
        </tr>
        <s:if test="passwordText != null">
	        <tr>
	          <td>
	            <label>パスワード</label>
	          </td>
	          <td>
					<s:property value="passwordText"/>
	          </td>
	        </tr>
        </s:if>
        <tr>
          <td>
            <label>性別</label>
          </td>
          <td>
				<s:property value="gender"/>
          </td>
        </tr>
        <tr>
          <td>
            <label>郵便番号</label>
          </td>
          <td>
				<s:property value="postalCode"/>
          </td>
        </tr>
        <tr>
          <td>
            <label>住所（都道府県）</label>
          </td>
          <td>
				<s:property value="prefecture"/>
          </td>
        </tr>
        <tr>
          <td>
            <label>住所（市区町村）</label>
          </td>
          <td>
				<s:property value="address1"/>
          </td>
        </tr>
        <tr>
          <td>
            <label>住所（番地）</label>
          </td>
          <td>
				<s:property value="address2"/>
          </td>
        </tr>
        <tr>
          <td>
            <label>アカウント権限</label>
          </td>
          <td>
				<s:property value="authority"/>
          </td>
        </tr>

      </table>
		<div class="button">
			<div>
			<button type="button" onclick=history.back()>戻る</button>
			</div>
			<s:submit class="b" value="登録する"/>
			<input type="hidden" name="id" value="<s:property value='id'/>">
			<input type="hidden" name="familyName" value="<s:property value='familyName'/>">
			<input type="hidden" name="lastName" value="<s:property value='lastName'/>">
			<input type="hidden" name="familyNameKana" value="<s:property value='familyNameKana'/>">
			<input type="hidden" name="lastNameKana" value="<s:property value='lastNameKana'/>">
			<input type="hidden" name="mail" value="<s:property value='mail'/>">
			<input type="hidden" name="password" value="<s:property value='password'/>">
			<input type="hidden" name="passwordChange" value="<s:property value='passwordChange'/>">
			<input type="hidden" name="gender" value="<s:property value='gender'/>">
			<input type="hidden" name="postalCode" value="<s:property value='postalCode'/>">
			<input type="hidden" name="prefecture" value="<s:property value='prefecture'/>">
			<input type="hidden" name="address1" value="<s:property value='address1'/>">
			<input type="hidden" name="address2" value="<s:property value='address2'/>">
			<input type="hidden" name="authority" value="<s:property value='authority'/>">

		</div>
      </s:form>
    </div>

    <div id="footer">
      	<p>フッター</p>
    </div>




</body>
</html>