<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>愛犬家登録完了</title>
</head>
<body>
<h1>愛犬家登録完了</h1>
<p>登録が完了しました。</p>
<h2>ご自身の情報</h2>
<table>
<tr>
    <th>ログインID<span class="small">※半角英数字5～15文字</span><span class="required">*</span></th>
    <td><c:out value="${owner.loginId }" /></td>
</tr>
<tr>
    <th>パスワード<span class="small">※半角英数字5～15文字</span><span class="required">*</span></th>
    <td>セキュリティのため表示されません。</td>
</tr>
</table>
<p><a href="ownerMypage">マイページへ進む</a></p>
</body>
</html>