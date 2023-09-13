<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>ワンちゃんと${destinationId }に関する情報／ワンちゃんとのための情報サイト「ワンちゃんと」</title>

<link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css"/>

<style type="text/css">
.container {
	margin: 30px auto 0;
	max-width: 300px;
	width: 100%;
}

img {
	height: auto;
	width: 100%;
}
</style>

<script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>
<script type="text/javascript" src="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>
	
	<script type="text/javascript">
	$(function () {
		  $(".slider").slick({
		    autoplay: true,
		    arrows: false,
		    asNavFor: ".thumbnail",
		  });
		  $(".thumbnail").slick({
		    slidesToShow: 3,
		    asNavFor: ".slider",
		    focusOnSelect: true,
		  });
		});
	</script>
</head>
<body>
	<h1>${name}の情報</h1>
	<p>お出掛け先のジャンル：
		<c:choose>
			<c:when test="${genreId == 1}">公園</c:when>
			<c:when test="${genreId == 2}">ドッグラン</c:when>
			<c:when test="${genreId == 3}">飲食店</c:when>
			<c:otherwise>その他の施設</c:otherwise>
		</c:choose></p>

	<div class="container">
		<div class="slider">
			<div class="slick-img">
				<img src="https://images.unsplash.com/photo-1597451857899-9ef64117da3d?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1170&q=80"
					alt="" />
			</div>
			<div class="slick-img">
				<img src="https://images.unsplash.com/photo-1585938389612-a552a28d6914?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1160&q=80"
					alt="" />
			</div>
			<div class="slick-img">
				<img src="https://images.unsplash.com/photo-1561283890-5d858c23b2ea?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1076&q=80"
					alt="" />
			</div>
		</div>
		<div class="thumbnail">
			<div class="thumbnail-img">
				<img src="https://images.unsplash.com/photo-1597451857899-9ef64117da3d?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1170&q=80"
					alt="" />
			</div>
			<div class="thumbnail-img">
				<img src="https://images.unsplash.com/photo-1585938389612-a552a28d6914?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1160&q=80"
					alt="" />
			</div>
			<div class="thumbnail-img">
				<img src="https://images.unsplash.com/photo-1561283890-5d858c23b2ea?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1076&q=80"
					alt="" />
			</div>
		</div>
	</div>

	<h2>${name}の評価</h2>
	<p>星${evaluation}</p>
	<h3>この情報を共有した愛犬家さん</h3>
	<p>${ownerId}さん</p>

<p><a href="destinationIndex">お出掛け先一覧を見る</a></p>

</body>
</html>