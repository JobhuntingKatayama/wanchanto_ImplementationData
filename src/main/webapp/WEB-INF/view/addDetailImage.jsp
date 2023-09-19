<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>詳細画像追加</title>
</head>
<body>
	<form action="" method="post" enctype="multipart/form-data">
<!-- 		<p>
			お出掛け先ID:<select name="destinationId">
			<option value="1">1</option>
			</select></p> -->
			<p>画像：<input type="file" name="upfile"></p>
			<p>画像の種類：<input type="text" name="imgCategory"/></p>
			<p>コメント：<textarea name="comment" rows="4" cols="40"></textarea></p>
			
			<input type="submit" value="送信">


	</form>
</body>
</html>