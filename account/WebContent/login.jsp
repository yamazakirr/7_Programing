<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css" href="./css/login.css"/>

<title>ログイン画面</title>
</head>
<body>

	<s:form action="LoginAction">

		<div class="errorMessage">
			<s:if test="loginErrorMessage != null">
				<s:property value="loginErrorMessage"/>
			</s:if>
		</div>

		<table>

		<tr>
			<td>
				メールアドレス
			</td>
			<td>
				<input type="text" name="loginUserId" maxlength="100"><br>
			</td>
		</tr>

		<tr>
			<td>
				パスワード
			</td>
			<td>
				<input type="password" name="loginUserPassword" maxlength="10"><br>
			</td>
		</tr>



		</table>

		<s:submit value="ログイン"/>


	</s:form>

</body>
</html>