<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>お出掛け先画像の変更</title>
</head>
<body>
<form action="" method="post" enctype="multipart/form-data">
現在登録されている画像：
<img style="height: 100px;" class="mb-3"
		src='data:image/jpeg;base64,<c:out value="${detailImage.imgData}" />'>
<input type="file" name="upfile" value="<c:out value="${detailImage.imgData }"/>">
			<p>画像の種類：<input type="text" name="imgCategory"/></p>
			<p>コメント：<textarea name="comment" rows="4" cols="40"></textarea></p>
			<input type="submit" value="送信">

</form>
</body>
</html>