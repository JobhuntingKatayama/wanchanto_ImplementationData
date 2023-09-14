<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>ワンちゃんとのお出掛け先一覧</title>
</head>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">

<body>
  <jsp:include page="include/loginButton.jsp"/>

	<jsp:include page="include/destinationIndex.jsp"/>
	
	<h1>ワンちゃんとのお出掛け先一覧</h1>
		<table class="table table-striped">
		<tr>
			<th>お出掛け先名称</th>
			<th>お出掛け先ジャンル</th>
			<th>評価</th>
			<th>登録日</th>
		</tr>
		<c:forEach items="${destinationList }" var="destination">
			<tr>
				<td><a target="_blank" href="destinationDetail?destinationId=${destination.destinationId }">${destination.name }</a></td>
				<td><c:choose>
						<c:when test="${destination.genreId == 1}">
公園
</c:when>
						<c:when test="${destination.genreId == 2}">
ドッグラン
</c:when>
						<c:when test="${destination.genreId == 3}">
飲食店
</c:when>
						<c:otherwise>
その他の施設
</c:otherwise>
					</c:choose></td>
				<td>${destination.evaluation }</td>
				<td>${destination.addedDate }</td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>