<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Test</title>
</head>
<body>

<p>こんにちは！</p>
<% out.println(new java.util.Date()); %>

<%!
static int add(int a, int b){
	return a+b;
}
%>

<p>1+2=<%=add(1,2) %></p>
<p>3+4=<%=add(3,4) %></p>
<br>

<%! static int countA=0; %>
<%
int countB=0;
countA++;
countB++;
%>
<p>宣言による変数 countA=<%=countA %></p>
<p>スクリプトレットによる変数 countB=<%=countB %></p>
<br>

<p><% out.println(Math.random()); %></p>
<p><%=Math.random() %></p>
<p><%=(int)Math.ceil(Math.random()*10) %></p>
<p><%=(int)Math.floor((Math.random()+0.1)*10) %></p>
<br>

<p>お名前を入力してください</p>
<form method="post" action="greeting-out.jsp">
<input type="text" name="user">
<input type="submit" value="確定">
</form>
<br>

<form method="post" action="total-out.jsp">
<input type="text" name="price">
円
<input type="text" name="count">
個＋送料
<input type="text" name="delivery">
円＝
<input type="submit" value="計算">
</form>


</body>
</html>



