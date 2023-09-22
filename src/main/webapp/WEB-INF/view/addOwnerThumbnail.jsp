<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="ownerMypage.jsp" method="post" enctype="multipart/form-data">
		<div class="mb-3">
			<p>サムネイル用画像</p>
			<c:choose>
				<c:when test="${imgData != null }">
					<p>現在登録されている画像：</p>
					<img style="height: 100px;" class="mb-3"
						src='data:image/jpeg;base64,<c:out value="${imgData}" />'>
				</c:when>
				<c:otherwise>
					<img class="mb-3" id="ownerThumbnail" src="img/thumbnail.jpg">
				</c:otherwise>
			</c:choose>
			<input type="file" name="upfile" value="画像をアップロードする">
		</div>
<input type="submit" class="btn btn-primary" >
</form>
<a href="ownerInformationEdit?ownerId=<c:out value="${ownerId }"/>">編集ページへ戻る</a>
</body>
</html>