<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>アカウント削除完了画面</title>
</head>
<body>
	<div id="navigation">
		<p>ナビゲーションバー</p>
	</div>
	<div id="header">
		<p><b>アカウント削除完了画面</b></p>
	</div>

    <div id="main">
	    <h1>削除完了しました</h1>
    </div>

    <s:form action="index.jsp">
		<s:submit value="TOPページへ戻る"/>
		<input type="hidden" value="<s:property value='#session.login_user_id'/>">
    	<input type="hidden" value="<s:property value='#session.authority'/>">
	</s:form>
	<s:property value="authority"/>

    <s:form action="LogoutAction">
		<s:submit value="ログアウト"/>
	</s:form>


    <div id="footer">
      	<p>フッター</p>
    </div>

</body>
</html>