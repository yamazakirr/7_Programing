<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"  %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css" href="./css/delete.css">


<title>アカウント削除画面</title>
</head>
<body>
	<div id="navigation">
		<p>ナビゲーションバー</p>
	</div>
	<div id="header">
		<p><b>アカウント削除画面</b></p>
	</div>

    <div id="main">


    <table>

		<s:iterator value="deleteList">
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
		</s:iterator>
	</table>

	<div id="botton">
		<s:form action="DeleteConfirmAction">
			<s:submit value="確認する"/>
		</s:form>
	</div>

</div>

	<div id="footer">
      	<p>フッター</p>
    </div>








</body>
</html>