<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>ワンちゃんと${destinationId }に関する情報／ワンちゃんとのための情報サイト「ワンちゃんと」</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<link href="css/destination.css" rel="stylesheet">

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick-theme.min.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.css">

</head>
<body>

	<jsp:include page="include/loginButton.jsp" />

	<jsp:include page="include/ownerMypageContainer.jsp" />


	<h1>${name}の情報</h1>
	<p>
		お出掛け先のジャンル：
		<c:choose>
			<c:when test="${genreId == 1}">公園</c:when>
			<c:when test="${genreId == 2}">ドッグラン</c:when>
			<c:when test="${genreId == 3}">飲食店</c:when>
			<c:otherwise>その他の施設</c:otherwise>
		</c:choose>
	</p>

	<div id="destinationImgSlider">
		<ul class="slider">
			<li><img
				src="https://images.unsplash.com/photo-1597451857899-9ef64117da3d?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1170&q=80"
				alt=""></li>
			<li><img
				src="https://images.unsplash.com/photo-1585938389612-a552a28d6914?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1160&q=80"
				alt=""></li>
			<li><img
				src="https://images.unsplash.com/photo-1561283890-5d858c23b2ea?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1076&q=80"
				alt=""></li>
		</ul>
	</div>


	<h2>${name}の評価</h2>
	<p>星${evaluation}</p>
	<h3>この情報を共有した愛犬家さん</h3>
	<p>${ownerId}さん</p>
				<c:choose>
					<c:when test="${ownerImg == null}">
						<img class="mb-3" id="ownerThumbnail" src="img/thumbnail.jpg">
					</c:when>
					<c:otherwise>
						<img class="mb-3" id="ownerThumbnail"
							src='data:image/jpeg;base64,<c:out value="${ownerImg}" />'>
					</c:otherwise>
				</c:choose>
	<div class="d-flex justify-content-end mb-3">
		<div class="p-2 bd-highlight">
			<button type="button" class="btn btn-primary"
				onclick="location.href='destinationIndex'">お出掛け先一覧を見る</button>
		</div>
	</div>

	</div>


	<script
		src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>
	<script>
		$('.slider').slick({
			autoplay : true,
			dots : true,
		});
	</script>
</body>
</html>