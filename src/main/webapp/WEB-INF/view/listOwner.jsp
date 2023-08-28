<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>愛犬家管理</title>
</head>
<body>
<h1>愛犬家一覧</h1>
<table border="1">
<tr>
	<th>愛犬家ログインID</th>
	<th>愛犬家ログインパスワード</th>
</tr>
<c:forEach items="${ownerList }" var="owner">
<tr>
	<td><c:out value="${owner.loginId }" /></td>
	<td><c:out value="${owner.loginPassword }" /></td>
</tr>
</c:forEach>
</table>

<p><a href="ownerRegistration">新規の愛犬家登録はこちら</a></p>
</body>
</html>