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

    <s:iterator value="updateList">
    	<s:property value="familyName"/>

    </s:iterator>

    </div>

</body>
</html>