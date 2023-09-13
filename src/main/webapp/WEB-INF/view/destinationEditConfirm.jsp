<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>お出掛け先情報確認画面</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">

</head>
<body>
	<div class="container mt-5 mb-3">
		<h1>お出掛け先情報確認画面</h1>
		<p class="small right">こちらの内容でお出掛け先を更新します。</p>
		<form action="destinationEditComplete" method="post" class="mb-3">
			<p>お出掛け先のジャンル</p>
			<p class="d-inline-flex focus-ring py-2 px-2 text-decoration-none border rounded-2">
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
			<p>お出掛け先の名称</p>
			<p class="d-inline-flex focus-ring py-2 px-2 text-decoration-none border rounded-2">${name}</p>
			<p>お出掛け先の評価</p>
			<p class="d-inline-flex focus-ring py-2 px-2 text-decoration-none border rounded-2">${evaluation}</p>
</br>
			
			
			<div class="d-flex justify-content-between pt-3">
				<div class="bd-highlight">
					<input class="btn btn-primary" type="submit" value="上記の内容で登録する">
				</div>
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
</body>
</html>