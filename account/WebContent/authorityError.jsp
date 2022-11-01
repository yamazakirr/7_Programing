<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>アカウント権限エラー画面</title>

<style type="text/css">

h1{
	color:red;
}


</style>

</head>
<body>

<h1>アカウント権限がありません。</h1>

	<s:form action="login.jsp">
		<s:submit value="ログイン画面へ戻る"/>
	</s:form>

</body>
</html>