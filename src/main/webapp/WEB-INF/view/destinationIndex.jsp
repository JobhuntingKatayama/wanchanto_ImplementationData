<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>ワンちゃんとのお出掛け先一覧</title>

<link rel="icon" href="img/favicon.svg" type="image/svg+xml">


<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/bootstrapChangeColor.css" rel="stylesheet">
<link href="css/destinationIndex.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">

<%--リストのソート用 --%>
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.13.6/css/jquery.dataTables.css" />

</head>



<body>
	<jsp:include page="include/loginButton.jsp" />
	<jsp:include page="include/destinationIndex.jsp" />

	<h1>ワンちゃんとのお出掛け先一覧</h1>
	<table id="myTable" class="table table-striped display text-center">
		<thead>
			<tr>
				<th class="text-center">名称</th>
				<th class="text-center">ジャンル</th>
				<th class="text-center">評価</th>
				<th class="text-center">愛犬家</th>
				<th class="text-center">登録日</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${destinationList }" var="destination">
				<tr>
					<td><a 
						href="destinationDetail?destinationId=${destination.destinationId }">${destination.name }</a></td>
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
					<td><span id="evaluation"
						class="<c:choose>
					<c:when test="${destination.evaluation ==1}">oneStar</c:when>
					<c:when test="${destination.evaluation ==2}">twoStars</c:when>
					<c:when test="${destination.evaluation ==3}">threeStars</c:when>
					<c:when test="${destination.evaluation ==4}">fourStars</c:when>
					<c:otherwise>fiveStars</c:otherwise>
					</c:choose>"></span><span
						class="score">${destination.evaluation}</span></td>
					<td><c:choose>
							<c:when test="${destination.ownerImgData != null}">
								<img id="ownerThumbnail"
									src='data:image/jpeg;base64,<c:out value="${destination.ownerImgData}" />'>
							</c:when>
							<c:otherwise>
								<img id="ownerThumbnail" src="img/thumbnail.jpg">
							</c:otherwise>
						</c:choose></td>
					<td>${destination.formattedDate }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>

	<%-- JQuery --%>
	<script src="https://code.jquery.com/jquery-3.7.1.min.js"
		integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
		crossorigin="anonymous"></script>
	<script src="https://cdn.datatables.net/1.13.6/js/jquery.dataTables.js"></script>
	<%--テーブルソート用 --%>
	<script>
		$(document).ready(function() {
			$("#myTable").DataTable({
				"columnDefs" : [ {
					"targets" : [],
					"orderable" : false
				} ]
			});
		});
	</script>
</body>
</html>