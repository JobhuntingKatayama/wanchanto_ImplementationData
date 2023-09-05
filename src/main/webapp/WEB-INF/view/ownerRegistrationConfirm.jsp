<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>愛犬家登録内容確認</title>
</head>
<body>
<h1>愛犬家登録内容確認</h1>
<p>下記の情報で登録をしてもよろしいでしょうか？</p>
<table>
<tr>
    <th>ログインID</th>
    <td>${loginId }</td>
</tr>
<tr>
    <th>パスワード</th>
    <td>セキュリティのため表示されません。</td>
</tr>
</table>
<p><a href="ownerMypage">登録をしてマイページへ進む</a></p>
<p><a href="ownerInformationEdit?ownerId=Id=<c:out value="${ownerId}"/>">編集しなおす</a></p>
</body>
</html>