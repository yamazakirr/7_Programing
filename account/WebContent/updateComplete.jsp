<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>アカウント更新完了画面</title>
</head>
<body>

<h1>アカウントの更新が完了しました。</h1>

<div>
	<s:form action="LoginAction">
		<s:submit value="TOPページに戻る"/>

		<input type="hidden" value="<s:property value='#session.login_user_id'/>">
    	<input type="hidden" value="<s:property value='#session.authority'/>">
	</s:form>

	<s:form action="LogoutAction">
		<s:submit value="ログアウト"/>
	</s:form>
</div>

</body>
</html>