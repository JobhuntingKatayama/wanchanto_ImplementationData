<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>お出掛け先情報確認画面</title>

<link rel="icon" href="img/favicon.svg" type="image/svg+xml">

<jsp:include page="include/bootstrapCDN.jsp" />
<link href="css/evaluation.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">

</head>
<body>
	<jsp:include page="include/destinationEditContainer.jsp" />
	<jsp:include page="include/destinationEdit.jsp" />

	<div class="container mt-5 mb-3">
		<h1>お出掛け先情報確認画面</h1>
		<p class="mb-4">こちらの内容でお出掛け先を更新します。</p>
		<form action="destinationEditComplete" enctype="multipart/form-data"
			method="post" class="mb-3">
			
			<div class="mb-3">
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
			</div>
			
						<div class="mb-3">
			
			<p class="fw-bold">お出掛け先の名称</p>
			<p
				class="d-inline-flex focus-ring py-2 px-2 text-decoration-none border rounded-2">${name}</p>
			</div>
		
								<div class="mb-3">
			
			<p class="fw-bold">お出掛け先の評価</p>
			<p
				id="evaluation" class="
				<c:choose>
				<c:when test="${evaluation==1}">oneStar</c:when>
				<c:when test="${evaluation==2}">twoStars</c:when>
				<c:when test="${evaluation==3}">threeStars</c:when>
				<c:when test="${evaluation==4}">fourStars</c:when>
				<c:when test="${evaluation==5}">fiveStars</c:when>
				</c:choose>">${evaluation}</p>
			</div>

								<div class="mb-4">

			<c:if test="${fileName != null }">
				<p class="fw-bold">追加する画像</p>
				<table class="table table-striped border">
					<tr>
						<th>画像</th>
<!--  						<th>画像ファイル名</th>-->
						<th>種類</th>
						<th>コメント</th>
					</tr>
					<tr>
						<td><img style="height: 100px;" class="mb-3"
							src='data:image/jpeg;base64,<c:out value="${strBytes}" />'></td>
						<!-- <td><c:out value="${fileName }" /></td> -->
						<td>
						<c:choose>
						<c:when test="${imgCategory ==0 }">特に指定なし</c:when>
						<c:when test="${imgCategory ==1 }">内観</c:when>
						<c:when test="${imgCategory ==2 }">外観</c:when>
						<c:when test="${imgCategory ==3 }">情報</c:when>
						<c:when test="${imgCategory ==4 }">料理</c:when>
						<c:when test="${imgCategory ==5 }">注意事項</c:when>
						</c:choose>
						</td>
						<td><c:out value="${comment }" /></td>
					</tr>
				</table>
			</c:if>
</div>

					<input class="btn btn-primary mb-3" type="submit" value="上記の内容で登録する">
			<div class="d-flex justify-content-between pt-3">
								<div class="bd-highlight">
					<button type="button" class="btn btn-outline-primary"
						onclick="location.href='destinationEdit?destinationId=<c:out value="${destinationId }"/>'">編集ページへ戻る</button>
				</div>
				<div class="bd-highlight">
					<button type="button" class="btn btn-outline-primary"
						onclick="location.href='ownerMypage'">マイページへ戻る</button>
				</div>
			</div>

		</form>

	</div>
	</div>
</body>
</html>