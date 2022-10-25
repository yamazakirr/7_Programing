<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css" href="./css/list.css">

<title>アカウント一覧</title>
</head>
<body>

<div id="navigation">
	<p>ナビゲーションバー</p>
</div>

<div id="header">
		<p><b>アカウント一覧画面</b></p>
	</div>

    <div id="main">

    	<s:property value="#session.login_user_id"/>
    	<s:property value="#session.authority"/>


		<s:form action="SearchAction">
			<table border="1">
				<tr>
					<td>名前（姓）</td>
					<td><input type="text" name="searchFamilyName"></td>
					<td>名前（名）</td>
					<td><input type="text" name="searchLastName"></td>
				</tr>
				<tr>
					<td>カナ（姓）</td>
					<td><input type="text" name="searchFamilyNameKana"></td>
					<td>カナ（名）</td>
					<td><input type="text" name="searchLastName"></td>
				</tr>
				<tr>
					<td>メールアドレス</td>
					<td><input type="text" name="searchMail"></td>
					<td>性別</td>
					<td>
						<input type="radio"  name="searchGender" value="0" checked="checked">男性
						<input type="radio"  name="searchGender" value="1">女性
					</td>
				</tr>
				<tr>
					<td>アカウント権限</td>
					<td>
						<select name="searchAuthority">
			            	<option value="0">一般</option>
			            	<option value="1">管理者</option>
			            </select>
					</td>
				</tr>
			</table>

			<s:submit value="検索"/>
		</s:form>


    	<s:if test="accountList == null">
    		<h3>該当する登録情報はありません。</h3>
    	</s:if>
    	<s:elseif test="accountList != null">
    		<table border="1">
    		<tr>
    			<th>ID</th>
    			<th>名前（姓）</th>
    			<th>名前（名）</th>
    			<th>カナ（姓）</th>
    			<th>カナ（名）</th>
    			<th>メールアドレス</th>
    			<th>性別</th>
    			<th>アカウント権限</th>
    			<th>削除フラグ</th>
    			<th>登録日時</th>
    			<th>更新日時</th>
    			<th colspan="2">操作</th>
    		</tr>




    		<s:iterator value="accountList">
    			<tr>
    				<td><s:property value="id"/></td>
    				<td><s:property value="familyName"/></td>
    				<td><s:property value="lastName"/></td>
    				<td><s:property value="familyNameKana"/></td>
    				<td><s:property value="lastNameKana"/></td>
    				<td><s:property value="mail"/></td>
    				<td><s:property value="gender"/></td>
    				<td><s:property value="authority"/></td>
    				<td><s:property value="deleteFlg"/></td>
    				<td><s:property value="registeredTime"/></td>
    				<td><s:property value="updateTime"/></td>
    				<td>
    					<s:form action="DeleteAction">
    						<s:submit value="削除"/>
							<input type="hidden" value='<s:property value="id"/>' name="id">
    					</s:form>
    				</td>

    				<td>
    					<s:form action="UpdateAction">
    						<s:submit value="更新"/>
    						<input type="hidden" value='<s:property value="id"/>' name="id">
    						<input type="hidden" value='<s:property value="familyName"/>' name="familyName">
    						<input type="hidden" value='<s:property value="lastName"/>' name="lastName">
    						<input type="hidden" value='<s:property value="familyNameKana"/>' name="familyNameKana">
    						<input type="hidden" value='<s:property value="lastNameKana"/>' name="lastNameKana">
    						<input type="hidden" value='<s:property value="mail"/>' name="mail">
    						<input type="hidden" value='<s:property value="gender"/>' name="gender">
    						<input type="hidden" value='<s:property value="postalCode"/>' name="postalCode">
    						<input type="hidden" value='<s:property value="authority"/>' name="authority">
    						<input type="hidden" value='<s:property value="prefecture"/>' name="prefecture">
    						<input type="hidden" value='<s:property value="address1"/>' name="address1">
    						<input type="hidden" value='<s:property value="address2"/>' name="address2">
    					</s:form>
    				</td>
    			</tr>
    		</s:iterator>
    		</table>


    	</s:elseif>

    </div>


    <div id="footer">
      	<p>フッター</p>
    </div>

</body>
</html>