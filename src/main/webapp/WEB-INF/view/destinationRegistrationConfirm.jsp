<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>お出掛け先情報登録内容確認</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">

</head>
<body>
	<div class="container mt-5 mb-5">
		<h1>お出掛け先情報登録内容確認</h1>
		<p>下記の情報でお出掛け先を登録してもよろしいですか？</p>

		<form action="destinationRegistrationComplete" method="post"
			class="mb-3">
			<input type="hidden" name="ownerId" value="${ownerId}">
			<p>お出掛け先のジャンル</p>
			<p
				class="d-inline-flex focus-ring py-2 px-2 text-decoration-none border rounded-2">
				${genreId}</p>

			<p>お出掛け先の名称</p>
			<p
				class="d-inline-flex focus-ring py-2 px-2 text-decoration-none border rounded-2">
				${name}</p>

			<p>評価</p>
			<p
				class="d-inline-flex focus-ring py-2 px-2 text-decoration-none border rounded-2">
				${evaluation}
				</p>
			<input type="submit" value="登録する">
		</form>
		<p>
			<button type="button" class="btn btn-primary"
				onclick="location.href='ownerMypage'">マイページに戻る</button>
		</p>
	</div>

</body>
</html>