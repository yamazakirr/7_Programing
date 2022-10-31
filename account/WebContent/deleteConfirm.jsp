<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>アカウント削除確認画面</title>
</head>
<body>
	<div id="navigation">
		<p>ナビゲーションバー</p>
	</div>
	<div id="header">
		<p><b>アカウント削除画面</b></p>
	</div>

    <div id="main">
	    <h1>本当に削除してよろしいですか？</h1>

		<button type="button" onclick="history.back()">前に戻る</button>

		<s:form action="DeleteCompleteAction">
			<s:submit value="削除する"/>
			<input type="hidden" value="<s:property value='id'/>" name="id">
			<input type="hidden" value="<s:property value='#session.login_user_id'/>">
    		<input type="hidden" value="<s:property value='#session.authority'/>">
		</s:form>
    </div>

    <div id="footer">
      	<p>フッター</p>
    </div>


</body>
</html>