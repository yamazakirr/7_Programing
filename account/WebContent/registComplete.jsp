<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css" href="./css/registComplete.css"/>

<title>アカウント登録画面</title>
</head>
<body>
	<div id="navigation">
		<p>ナビゲーションバー</p>
	</div>

	<div id="header">
		<p><b>アカウント登録完了画面</b></p>
	</div>
	<div id="main">
		<p><b>登録完了しました。</b></p>

		<s:form action="HomeAction">
			<s:submit value="TOPページへ戻る"/>
		</s:form>
	</div>
	<div id="footer">
		<p>フッター</p>
	</div>

</body>
</html>