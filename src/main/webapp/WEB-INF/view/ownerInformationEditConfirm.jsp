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

	<form action="ownerInformationEditComplete" method="post"
		enctype="multipart/form-data">

		<div class="mb-4">
			<p class="fw-bold">ログインID</p>
			<p
				class="d-inline-flex focus-ring py-2 px-2 text-decoration-none border rounded-2">${loginId }</p>
		</div>

		<div class="mb-4">
			<p class="fw-bold">ログインパスワード</p>
			<p
				class="d-inline-flex focus-ring py-2 px-2 text-decoration-none border rounded-2">セキュリティのため表示されません</p>
		</div>

		<div class="mb-3">
			<p class="fw-bold">サムネイル</p>
			<c:choose>
				<c:when test="${ownerImgData != null}">
					<img class="mb-3" id="ownerThumbnail"
						src='data:image/jpeg;base64,<c:out value="${ownerImgData}" />'>
				</c:when>
				<c:otherwise>
					<img class="mb-3" id="ownerThumbnail" src="img/thumbnail.jpg">
				</c:otherwise>
			</c:choose>
		</div>
		<div class="d-flex justify-content-between pt-3">
			<div class="bd-highlight">
				<input type="submit" class="btn btn-primary" value="登録内容を更新する">
			</div>
			<div class="bd-highlight">
				<button type="button" class="btn btn-outline-primary"
					onclick="location.href='ownerMypage'">更新せずにマイページへ戻る</button>
			</div>
		</div>

	</form>

	</div>
	</div>
</body>
</html>