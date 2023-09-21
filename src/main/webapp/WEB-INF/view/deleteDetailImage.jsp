<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>画像削除確認画面</title>
</head>
<body>
	<form action="" method="post" enctype="multipart/form-data">
	<input type="hidden" name="destinationId" value="<c:out value='${destinationId }'/>">
	<p>こちらの画像を削除しますか？</p>
	<img style="height: 100px;" class="mb-3"
		src='data:image/jpeg;base64,<c:out value="${detailImage.imgData}" />'>、
	${detailImage.fileName}、
	<input type="submit" value="お出掛け先編集ページに戻る">
	</form>
</body>
</html>