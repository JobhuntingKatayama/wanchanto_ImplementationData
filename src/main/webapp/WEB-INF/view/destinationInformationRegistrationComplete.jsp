<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>お出掛け先情報登録完了</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">

</head>
<body>
	<div class="container mt-5 mb-5">
		<h1>お出掛け先情報登録完了</h1>
		<p>下記の情報でお出掛け先を登録しました。</p>

		<p>
			<button type="button" class="btn btn-primary"
				onclick="location.href='destinationDetail'">登録した内容を確認する</button>
		</p>

		<p>お出掛け先のジャンル</p>
		<p
			class="d-inline-flex focus-ring py-2 px-2 text-decoration-none border rounded-2">
			<c:out value="${genreId}" />
		</p>

		<p>お出掛け先の名称</p>
		<p
			class="d-inline-flex focus-ring py-2 px-2 text-decoration-none border rounded-2">
			<c:out value="${name}" />
		</p>

		<p>評価</p>
		<p
			class="d-inline-flex focus-ring py-2 px-2 text-decoration-none border rounded-2">
			<c:out value="${evaluation}" />
		</p>

		<p>
			<button type="button" class="btn btn-primary"
				onclick="location.href='ownerMypage'">マイページに戻る</button>
		</p>
	</div>

</body>
</html>