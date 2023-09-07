<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>お出掛け先情報確認画面</title>
</head>
<body>
	<div id="destinationInformationEdit">
		<h1>お出掛け先情報確認画面</h1>
		<p class="small right">
		こちらの内容でお出掛け先を更新します。
		</p>
		<form action="" method="post">
<p>${genreId }、
${name }、
${evaluation }</p>



			<input type="submit" value="上記の内容で登録する">
		</form>
	</div>
</body>
</html>