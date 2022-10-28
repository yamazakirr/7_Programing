<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css"/>
<meta http-equiv="Content-Script-Type" content="text/javascript"/>
<meta http-equiv="imagetoolbar" content="no"/>
<meta name="description" content="記事の説明欄です。"/>
<meta name="keywords" content="現在Googleでは検索キーワードとして重視されていない"/>


<link rel="stylesheet" type="text/css" href="./css/index.css">

<title>D.I.BLOG</title>

</head>
<body>

	アカウント権限 : <s:property value="authority"/>

	<div id="header">
		<ul>
			<li>トップ</li>
			<li>プロフィール</li>
			<li>D.I.Blogについて</li>
			<li>登録フォーム</li>
			<li>問い合わせ</li>
			<li>その他</li>

			<!-- アカウント権限が「管理者」の人のみ表示 -->
			<s:if test="authority == 1">
				<li><a href='<s:url action="RegistAction"/>'>アカウント登録</a></li>
				<li><a href='<s:url action="ListAction"/>'>アカウント一覧</a></li>
			</s:if>
			<li><a href='<s:url action="LogoutAction"/>'>ログアウト</a></li>
		</ul>
	</div>
	<div id="main">

		<div id="main-container">
			<div id="left">
				<p>画像</p>
			</div>
			<div id="right">
				<!-- 記事① -->
		         <h2 class="list_title">人気の記事</h2>
		         <ul>
		           <li>PHPオススメ本</li>
		           <li>PHP MyAdminの使い方</li>
		           <li>今人気のエディタ</li>
		           <li>HTMLの基礎</li>
		         </ul>
		         <!-- 記事② -->
		         <h2 class="list_title">オススメリンク</h2>
		         <ul>
		           <li>ﾃﾞｨｰｱｲﾜｰｸｽ株式会社</li>
		           <li>XAMPPのダウンロード</li>
		           <li>Eclipseのダウンロード</li>
		           <li>Braketsのダウンロード</li>
		         </ul>
		         <!-- 記事③ -->
		         <h2 class="list_title">カテゴリ</h2>
		         <ul>
		           <li>HTML</li>
		           <li>PHP</li>
		           <li>MySQL</li>
		           <li>JavaScript</li>
		         </ul>
			</div>
		</div>

	</div>

	<div id="footer">
      <p>
        Copyright D.I.works D.I.blog is the one which provides A to Z about programming
      </p>
	</div>


</body>
</html>