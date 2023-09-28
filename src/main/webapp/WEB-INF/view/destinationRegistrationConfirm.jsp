<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>お出掛け先情報登録内容確認</title>

<link rel="icon" href="img/favicon.svg" type="image/svg+xml">

<jsp:include page="include/bootstrapCDN.jsp" />
<link href="css/evaluation.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">

</head>
<body>
	<jsp:include page="include/destinationEditContainer.jsp" />
	<jsp:include page="include/destinationEdit.jsp" />
	<h1>お出掛け先情報登録内容確認</h1>
	<p>下記の情報でお出掛け先を登録してもよろしいですか？</p>

	<form action="destinationRegistrationComplete" method="post"
		class="mb-4">
		<input type="hidden" name="ownerId" value="${ownerId}">
		<p class="fw-bold">お出掛け先のジャンル</p>
		<p
			class="d-inline-flex focus-ring py-2 px-2 text-decoration-none border rounded-2">
			<c:choose>
				<c:when test="${genreId == 1}">
公園
</c:when>
				<c:when test="${genreId == 2}">
ドッグラン
</c:when>
				<c:when test="${genreId == 3}">
飲食店
</c:when>
				<c:otherwise>
その他の施設
</c:otherwise>
			</c:choose>
		</p>
<div class="mb-4">
		<p class="fw-bold">お出掛け先の名称</p>
		<p
			class="d-inline-flex focus-ring py-2 px-2 text-decoration-none border rounded-2">
			${name}</p>
</div>

<div class="mb-4">
		<p class="fw-bold">お出掛け先のイメージ</p>
		<c:choose>
			<c:when test="${imageData != null}">
				<img class="mb-3" style="width:100%;"
					src='data:image/jpeg;base64,<c:out value="${imageData}" />'>
			</c:when>
			<c:otherwise>
				<p>イメージ画像のご登録はありません。</p>
			</c:otherwise>
		</c:choose>
</div>
<div class="mb-4">
		<p class="fw-bold">評価</p>
		<p id="evaluation"
			class="
			<c:choose>
			<c:when test="${evaluation == 1}">oneStar</c:when>
			<c:when test="${evaluation == 2}">twoStars</c:when>
			<c:when test="${evaluation == 3}">threeStars</c:when>
			<c:when test="${evaluation == 4}">fourStars</c:when>
			<c:when test="${evaluation == 5}">fiveStars</c:when>
			</c:choose> ">
			${evaluation}</p>

</div>
		<div class="d-flex justify-content-between pt-3">
			<div class="bd-highlight">
				<input class="btn btn-primary" type="submit" value="登録する">
			</div>
			<div class="bd-highlight">
				<button type="button" class="btn btn-outline-primary"
					onclick="location.href='ownerMypage'">登録せずにマイページへ戻る</button>
			</div>
		</div>

	</form>


	</div>
	</div>

</body>
</html>