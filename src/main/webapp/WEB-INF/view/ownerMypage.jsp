<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>愛犬家マイページ</title>

<link rel="icon" href="img/favicon.svg" type="image/svg+xml">

<jsp:include page="include/bootstrapCDN.jsp" />
<link href="css/evaluation.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<link href="css/ownerMypage.css" rel="stylesheet">

</head>
<body>
	<div class="d-flex justify-content-end mb-3 position-relative">
		<div class="p-2 bd-highlight position-absolute top-0 end-0">
			<button type="button" class="btn btn-outline-primary"
				onclick="location.href='ownerLogout'">ログアウト</button>
		</div>
	</div>
	<jsp:include page="include/ownerMypageContainer.jsp" />

	<h1>${loginId }さんのマイページ</h1>
	<div class="container">
		<div class="row">
			<div id="ownerInfo" class="col-sm-4 text-center">

				<c:choose>
					<c:when test="${owner.ownerImgData != null}">
						<img class="mb-3" id="ownerThumbnail"
							src='data:image/jpeg;base64,<c:out value="${owner.ownerImgData}" />'>
					</c:when>
					<c:otherwise>
						<img class="mb-3" id="ownerThumbnail" src="img/thumbnail.jpg">
					</c:otherwise>
				</c:choose>

				<ul class="nav flex-column">
					<li class="nav-item mb-3">
						<button type="button" class="btn btn-outline-primary"
							onclick="location.href='ownerInformationEdit?ownerId=<c:out value="${owner.ownerId}"/>'">愛犬家情報の更新</button>
					</li>
					<li class="nav-item">
						<button type="button" class="btn btn-light"
							onclick="location.href='ownerInformationDelete?ownerId=<c:out value="${owner.ownerId}"/>'">愛犬家情報の削除</button>
					</li>
				</ul>

			</div>

			<div id="destinationsList" class="col-sm-8">
				<div class="container ">
					<div class="row">
						<div class="col-8">
							<h2>お出掛け先一覧</h2>
						</div>
						<div class="col-4 right">
							<button type="button" class="btn btn-primary"
								onclick="location.href='destinationRegistration?ownerId=<c:out value="${owner.ownerId}"/>'">追加する</button>
						</div>
					</div>
				</div>


				<table class="table table-striped">
					<tr class="text-center">
						<th>イメージ</th>
						<th>名称</th>
						<th>ジャンル</th>
						<th>評価</th>
						<th>編集</th>
					</tr>
					<c:forEach items="${destinationList}" var="destination">
						<tr class="text-center">
							<td><c:choose>
									<c:when test="${destination.desImgData != null}">
										<a target="_blank"
											href="destinationDetail?destinationId=<c:out value="${destination.destinationId}" />">
											<img class="destinationThumbnail"
											src='data:image/jpeg;base64,<c:out value="${destination.desImgData}" />'>
										</a>
									</c:when>
									<c:otherwise>
										<a target="_blank"
											href="destinationDetail?destinationId=<c:out value="${destination.destinationId}" />">
											<img class="destinationThumbnail" src="img/thumbnail.jpg">
										</a>
									</c:otherwise>
								</c:choose></td>
							<td><a target="_blank"
								href="destinationDetail?destinationId=<c:out value="${destination.destinationId}" />"><c:out
										value="${destination.name}" /></a></td>
							<td>
								<c:choose>
									<c:when test="${destination.genreId == 1}">公園</c:when>
									<c:when test="${destination.genreId == 2}">ドッグラン</c:when>
									<c:when test="${destination.genreId == 3}">飲食店</c:when>
									<c:otherwise>その他の施設</c:otherwise>
								</c:choose>
								</td>
							<td><div id="evaluation"
									class="
							<c:choose>
									<c:when test='${destination.evaluation == 1}'>oneStar">1</c:when>
									<c:when test='${destination.evaluation == 2}'>twoStars">2</c:when>
									<c:when test='${destination.evaluation == 3}'>threeStars">3</c:when>
									<c:when test='${destination.evaluation == 4}'>fourStars">4</c:when>
									<c:when test='${destination.evaluation == 5}'>fiveStars">5</c:when>
							</c:choose>
								</div></td>
							<td><button type="button" class="btn btn-outline-primary"
									onclick="location.href='destinationEdit?destinationId=${destination.destinationId}'">編集する</button></td>
						</tr>
					</c:forEach>
				</table>




			</div>
		</div>
	</div>

	</div>
</body>
</html>