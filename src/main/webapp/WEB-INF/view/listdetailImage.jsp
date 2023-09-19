<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>詳細画像一覧</title>
</head>
<body>
	<table>
		<tr>
			<th>お出掛け先ID</th>
			<th>画像</th>
			<th>画像ファイル名</th>
			<th>画像の種類</th>
			<th>コメント</th>
		</tr>
		<c:forEach items="${detailImageList }" var="detailImage">
			<tr>
				<td><c:out value="${detailImage.destinationId }" /></td>
				<td><img style="height:100px;" class="mb-3"
					src='data:image/jpeg;base64,<c:out value="${detailImage.imgData}" />'></td>
				<td><c:out value="${detailImage.fileName }" /></td>
				<td><c:out value="${detailImage.imgCategory }" /></td>
				<td><c:out value="${detailImage.comment }" /></td>
			</tr>
		</c:forEach>
	</table>
	
	<a href="addDetailImage">画像の追加</a>
</body>
</html>