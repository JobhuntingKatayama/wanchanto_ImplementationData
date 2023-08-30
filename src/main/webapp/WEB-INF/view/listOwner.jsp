<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
			<th>愛犬家ID</th>
			<th>サムネイル</th>
			<th>ログインID</th>
			<th>ログインパスワード</th>
			<th>ステータスID</th>
			<th>登録日</th>
		</tr>
		<c:forEach items="${ownerList}" var="owner">
			<tr>
				<td><c:out value="${owner.ownerId }" /></td>
				<td><c:out value="${owner.thumbnail }" /></td>
				<td><c:out value="${owner.loginId }" /></td>
				<td><c:out value="${owner.loginPassword }" /></td>
				<td><c:out value="${owner.statusId }" /></td>
				<td><c:out value="${owner.registrationDate }" /></td>
			</tr>
		</c:forEach>
	</table>

	<p>
		<a href="ownerRegistration">新規の愛犬家登録はこちら</a>
	</p>
</body>
</html>