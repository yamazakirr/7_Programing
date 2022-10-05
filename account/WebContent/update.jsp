<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="com.diworksdev.account.dto.UpdateDTO" %>
<%@ page import="com.diworksdev.account.action.UpdateAction" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css" href="./css/update.css"/>

<title>更新画面</title>
</head>
<body>

<div id="navigation">
	<p>ナビゲーションバー</p>
</div>

<div id="header">
		<p><b>アカウント更新画面</b></p>
	</div>

    <div id="main">

	<s:form action="UpdateConfirmAction">

    <s:iterator value="updateList">
	<table>

		<tr>
          <td>
            <label>名前（姓）</label>
          </td>
          <td>
            <input type="text" class="text" name="familyName" maxlength="10" value="<s:property value='familyName'/>"><br>
            <div class="errorMessage">
				<s:if test="familyNameErrorMessage != null">
	            	<s:property value="familyNameErrorMessage"/>
				</s:if>
            </div>
          </td>
        </tr>
        <tr>
          <td>
            <label>名前（名）</label>
          </td>
          <td>
            <input type="text" class="text" name="lastName" maxlength="10" value="<s:property value='lastName'/>"><br>
            <div class="errorMessage">
	            <s:if test="lastNameErrorMessage != null">
	            	<s:property value="lastNameErrorMessage"/>
				</s:if>
            </div>
          </td>
        </tr>
        <tr>
          <td>
            <label>カナ（姓）</label>
          </td>
          <td>
            <input type="text" class="text" name="familyNameKana" maxlength="10" value="<s:property value='familyNameKana'/>"><br>
            <div class="errorMessage">
	            <s:if test="familyNameKanaErrorMessage != null">
	            	<s:property value="familyNameKanaErrorMessage"/>
				</s:if>
            </div>
          </td>
        </tr>
        <tr>
          <td>
            <label>カナ（名）</label>
          </td>
          <td>
            <input type="text" class="text" name="lastNameKana" maxlength="10" value="<s:property value='lastNameKana'/>"><br>
            <div class="errorMessage">
	            <s:if test="lastNameKanaErrorMessage != null">
	            	<s:property value="lastNameKanaErrorMessage"/>
				</s:if>
            </div>
          </td>
        </tr>
        <tr>
          <td>
            <label>メールアドレス</label>
          </td>
          <td>
            <input type="text" class="text" name="mail" maxlength="100" value="<s:property value='mail'/>"><br>
            <div class="errorMessage">
	            <s:if test="mailErrorMessage != null">
	            	<s:property value="mailErrorMessage"/>
				</s:if>
            </div>
          </td>
        </tr>
        <tr>
          <td>
            <label>パスワード</label>
          </td>
          <td>
            <input type="password" class="text" name="password" maxlength="10" /><br>
            <div class="errorMessage">
	            <s:if test="passwordErrorMessage != null">
	            	<s:property value="passwordErrorMessage"/>
				</s:if>
            </div>
          </td>
        </tr>
        <tr>
        	<td>
        		<label>パスワードの変更の有無</label>
        	</td>
        	<td>
        		<input type="radio" name="passwordChange" value="0" checked="checked">変更しない
        		<input type="radio" name="passwordChange" value="1">変更する
        	</td>
        </tr>


        <tr>
          <td>
            <label>性別</label>
          </td>
          <td>
          	<s:if test="gender == 0">
	            <input type="radio"  name="gender" value="0" checked="checked">男性
	            <input type="radio"  name="gender" value="1">女性
          	</s:if>
          	<s:if test="gender == 1">
	            <input type="radio"  name="gender" value="0" >男性
	            <input type="radio"  name="gender" value="1" checked="checked">女性
          	</s:if>
          </td>
        </tr>
        <tr>
          <td>
            <label>郵便番号</label>
          </td>
          <td>
            <input type="text" class="text" name="postalCode" maxlength="7" value="<s:property value='postalCode'/>"><br>
            <div class="errorMessage">
	            <s:if test="postalCodeErrorMessage != null">
	            	<s:property value="postalCodeErrorMessage"/>
				</s:if>
            </div>
          </td>
        </tr>
        <tr>
          <td>
            <label>住所（都道府県）</label>
          </td>
          <td>
            <select name="prefecture" id="prefecture">




            	<%
            	UpdateAction a = new UpdateAction();
            	System.out.println("aaaaaaaaa   "+a.getPrefecture());
				String prefecture = UpdateDTO.p;
            	String[] prefectureAll = {"北海道","青森県","岩手県","宮城県","秋田県","山形県","福島県","茨城県","栃木県","群馬県","埼玉県","千葉県","東京都","神奈川県","新潟県","富山県","石川県","福井県","山梨県","長野県","岐阜県","静岡県","愛知県","三重県","滋賀県","京都府","大阪府","兵庫県","奈良県","和歌山県","鳥取県","島根県","岡山県","広島県","山口県","徳島県","香川県","愛媛県","高知県","福岡県","佐賀県","長崎県","熊本県","大分県","宮崎県","鹿児島県","沖縄県"};

            	for(int i=0; i < prefectureAll.length; i++){
            		if(prefectureAll[i].equals(prefecture)){
            			System.out.println("対象の都道府県" + prefecture);

            	%>
            		<option value="<%=prefectureAll[i] %>" selected><%=prefectureAll[i] %></option>
            	<%
            		}else{
            			System.out.println("prefecture[i] " + prefectureAll[i]);
            	%>

            		<option value="<%=prefectureAll[i] %>" ><%=prefectureAll[i] %></option>
            	<%
            		}
            	}
				%>





<!--               <option value="北海道">北海道</option>
              <option value="青森県">青森県</option>
              <option value="岩手県">岩手県</option>
              <option value="宮城県">宮城県</option>
              <option value="秋田県">秋田県</option>
              <option value="山形県">山形県</option>
              <option value="福島県">福島県</option>
              <option value="茨城県">茨城県</option>
              <option value="栃木県">栃木県</option>
              <option value="群馬県">群馬県</option>
              <option value="埼玉県">埼玉県</option>
              <option value="千葉県">千葉県</option>
              <option value="東京都">東京都</option>
              <option value="神奈川県">神奈川県</option>
              <option value="新潟県">新潟県</option>
              <option value="富山県">富山県</option>
              <option value="石川県">石川県</option>
              <option value="福井県">福井県</option>
              <option value="山梨県">山梨県</option>
              <option value="長野県">長野県</option>
              <option value="岐阜県">岐阜県</option>
              <option value="静岡県">静岡県</option>
              <option value="愛知県">愛知県</option>
              <option value="三重県">三重県</option>
              <option value="滋賀県">滋賀県</option>
              <option value="京都府">京都府</option>
              <option value="大阪府">大阪府</option>
              <option value="兵庫県">兵庫県</option>
              <option value="奈良県">奈良県</option>
              <option value="和歌山県">和歌山県</option>
              <option value="鳥取県">鳥取県</option>
              <option value="島根県">島根県</option>
              <option value="岡山県">岡山県</option>
              <option value="広島県">広島県</option>
              <option value="山口県">山口県</option>
              <option value="徳島県">徳島県</option>
              <option value="香川県">香川県</option>
              <option value="愛媛県">愛媛県</option>
              <option value="高知県">高知県</option>
              <option value="福岡県">福岡県</option>
              <option value="佐賀県">佐賀県</option>
              <option value="長崎県">長崎県</option>
              <option value="熊本県">熊本県</option>
              <option value="大分県">大分県</option>
              <option value="宮崎県">宮崎県</option>
              <option value="鹿児島県">鹿児島県</option>
              <option value="沖縄県">沖縄県</option> -->
            </select>
            ※都道府県の初期値の設定は一旦飛ばす
          </td>
        </tr>
        <tr>
          <td>
            <label>住所（市区町村）</label>
          </td>
          <td>
            <input type="text" class="text" name="address1" maxlength="10" value="<s:property value='address1'/>"/><br>
            <div class="errorMessage">
	            <s:if test="address1ErrorMessage != null">
	            	<s:property value="address1ErrorMessage"/>
				</s:if>
            </div>
          </td>
        </tr>
        <tr>
          <td>
            <label>住所（番地）</label>
          </td>
          <td>
            <input type="text" class="text" name="address2" maxlength="100" value="<s:property value='address2'/>">
            <div class="errorMessage">
	            <s:if test="address2ErrorMessage != null">
	            	<s:property value="address2ErrorMessage"/>
				</s:if>
            </div>
          </td>
        </tr>
        <tr>
          <td>
            <label>アカウント権限</label>
          </td>
          <td>
			<s:if test="authority == 0">
	            <select name="authority">
	            	<option value="0" selected>一般</option>
	            	<option value="1">管理者</option>
	            </select>
			</s:if>
			<s:if test="authority == 1">
	            <select name="authority">
	            	<option value="0" >一般</option>
	            	<option value="1" selected>管理者</option>
	            </select>
			</s:if>

          </td>
        </tr>


      </table>

		<div class="button">
			<s:submit class="b" value="確認する"/>
			<input type="hidden" name="id" value="<s:property value='id'/>">
		</div>
    </s:iterator>
    </s:form>
    </div>

    <div id="footer">
      <p>フッター</p>
    </div>

</body>
</html>