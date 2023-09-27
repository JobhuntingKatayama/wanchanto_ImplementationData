<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>お出掛け先画像の変更</title>

<link rel="icon" href="img/favicon.svg" type="image/svg+xml">

<jsp:include page="include/bootstrapCDN.jsp" />
<link href="css/style.css" rel="stylesheet">

</head>
<body>
	<jsp:include page="include/destinationEditContainer.jsp" />
	<jsp:include page="include/destinationEdit.jsp" />

	<h1>お出掛け先画像の更新</h1>
	<form action="" method="post" enctype="multipart/form-data"
		class="mb-3">
		<div class="mb-3">
		<p class="fw-bold">現在登録されている画像：</p>
		<c:choose>
			<c:when test="${imgData != null }">
				<img style="width:100%" class="mb-3"
					src='data:image/jpeg;base64,<c:out value="${imgData}" />'>
			</c:when>
			<c:otherwise>
				<p>画像がありません</p>
			</c:otherwise>
		</c:choose>
		</div>
		<div class="mb-3">
		<p class="fw-bold">新しい画像のアップロード：</p>
		<p><input type="file" name="upfile"></p>
		<p>画像の種類：</p>
		<select class="form-select mb-3" name="imgCategory">
				<option value="" label="画像の種類をお選びください"
					<c:if test="${imgCategory == null }">selected</c:if> disable>
				<option value="0" label="特に指定なし"
					<c:if test="${imgCategory == 0 }">selected</c:if>>
				<option value="1" label="内観"
					<c:if test="${imgCategory == 1 }">selected</c:if>>
				<option value="2" label="外観"
					<c:if test="${imgCategory == 2 }">selected</c:if>>
				<option value="3" label="情報"
					<c:if test="${imgCategory == 3 }">selected</c:if>>
				<option value="4" label="料理"
					<c:if test="${imgCategory == 5 }">selected</c:if>>
				<option value="5" label="注意事項"
					<c:if test="${imgCategory == 5 }">selected</c:if>>
			</select>
		<p>コメント：</p>
			<textarea name="comment" rows="4" cols="40"><c:out
					value="${comment }" /></textarea>
		</div>
		
		<input class="btn btn-primary" type="submit" value="この内容で更新する">

	</form>

	<div class="bd-highlight">
		<button type="button" class="btn btn-outline-primary"
			onclick="location.href='destinationEdit?destinationId=<c:out value="${destinationId }" />'">更新せず編集画面に戻る</button>
	</div>

	</div>
</body>
</html>