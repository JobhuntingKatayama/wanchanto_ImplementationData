<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>愛犬家登録内容確認</title>

<link rel="icon" href="img/favicon.svg" type="image/svg+xml">

<jsp:include page="include/bootstrapCDN.jsp" />
<link href="css/ownerMypage.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="include/ownerMypageContainer.jsp" />
	<jsp:include page="include/ownerEntrance.jsp" />
	<h1>愛犬家登録内容確認</h1>
	<p>下記の情報で登録をしてもよろしいでしょうか？</p>

	<form action="ownerRegistrationComplete" method="post" class="mb-3">
		<p class="fw-bold">ログインID</p>
		<p
			class="d-inline-flex focus-ring py-2 px-2 text-decoration-none border rounded-2">${loginId }</p>
		<p class="fw-bold">パスワード</p>
		<p
			class="d-inline-flex focus-ring py-2 px-2 text-decoration-none border rounded-2">セキュリティのため表示されません。</p>
		<p class="fw-bold">サムネイル画像</p>

		<c:choose>
			<c:when test="${imgData != null}">
				<img class="mb-3" id="ownerThumbnail"
					src='data:image/jpeg;base64,<c:out value="${imgData}" />'>
			</c:when>
			<c:otherwise>
				<img class="mb-3" id="ownerThumbnail" src="img/thumbnail.jpg">
			</c:otherwise>
		</c:choose>

		<div class="d-flex justify-content-between pt-3">
			<div class="bd-highlight">
				<input class="btn btn-primary" type="submit" value="登録する">
			</div>
			<div class="bd-highlight">
				<button type="button" class="btn btn-outline-primary"
					onclick="location.href='ownerRegistration'">入力しなおす</button>
			</div>
		</div>

	</form>

	</div>
	</div>
</body>
</html>