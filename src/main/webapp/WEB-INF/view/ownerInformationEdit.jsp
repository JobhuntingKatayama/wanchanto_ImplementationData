<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>愛犬家登録情報の更新</title>

<link rel="icon" href="img/favicon.svg" type="image/svg+xml">

<jsp:include page="include/bootstrapCDN.jsp" />
<link href="css/ownerMypage.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">

</head>
<body>
	<jsp:include page="include/ownerMypageContainer.jsp" />
	<jsp:include page="include/ownerEntrance.jsp" />

	<h1>愛犬家登録情報の更新</h1>
	<p class="small right">
		「<span class="required">*</span>」がついている項目は必須項目です。
	</p>

	<form action="" method="post" class="mb-3"
		enctype="multipart/form-data">
		<div class="mb-4">
			<p class="fw-bold">
				ログインID<span class="small"><span class="required">*</span>※半角英数字5～15文字</span>
			</p>
			<input class="form-control" aria-describedby="basic-addon1" required
				type="text" pattern="^[0-9A-Za-z]*$" minlength="5" maxlength="15"
				name="loginId" placeholder="${loginId}" value="${loginId}">
		</div>

		<div class="mb-4">
			<p class="fw-bold">
				パスワード<span class="small"><span class="required">*</span>※半角英数字5～15文字</span>
			</p>
			<input class="form-control" aria-describedby="basic-addon1" required
				type="password" pattern="^[0-9A-Za-z]*$" minlength="5"
				maxlength="15" name="loginPassword" placeholder="セキュリティのため表示されません">
		</div>
		<div class="mb-3">
			<p class="fw-bold">サムネイル用画像</p>
			<c:choose>
				<c:when test="${ownerImgData != null }">
					<p>現在登録されている画像：</p>
					<p>
						<img id="ownerThumbnail"
							src='data:image/jpeg;base64,<c:out value="${ownerImgData}" />'>
					</p>
				</c:when>
				<c:otherwise>
					<p>
						<img class="mb-3" id="ownerThumbnail" src="img/thumbnail.jpg">
					</p>
				</c:otherwise>
			</c:choose>
			<p>画像の変更：</p>

			<p>
				<input type="file" name="ownerImg" value="画像をアップロードする">
			</p>
		</div>

		<div class="d-flex justify-content-between pt-3">
			<div class="bd-highlight">
				<input type="submit" class="btn btn-primary" value="登録内容を更新する">
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