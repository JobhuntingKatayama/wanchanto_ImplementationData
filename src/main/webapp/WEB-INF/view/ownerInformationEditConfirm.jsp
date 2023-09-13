<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>愛犬家登録内容確認</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">

</head>
<body>
	<div class="container mt-5 mb-5">

<h1>愛犬家登録内容確認</h1>
<p>下記の情報で登録をしてもよろしいでしょうか？</p>

	<form action="ownerInformationEditComplete" method="post">
		<h2>ご自身の情報</h2>
		<%-- Editでpostされた情報をConfirmから取得 --%>
		<p>ログインID</p>
		<p class="d-inline-flex focus-ring py-2 px-2 text-decoration-none border rounded-2">${loginId }</p>
		<p>ログインパスワード</p>
		<p class="d-inline-flex focus-ring py-2 px-2 text-decoration-none border rounded-2">セキュリティのため表示されません</p>


			<div class="d-flex justify-content-between pt-3">
				<div class="bd-highlight">
					<input type="submit" class="btn btn-primary" value="登録内容を更新する">
				</div>
				<div class="bd-highlight">
					<button type="button" class="btn btn-outline-primary"
				onclick="location.href='ownerMypage'">更新せずにマイページへ戻る</button>
				</div>
			</div>
		
	</form>
	
	</div>
</body>
</html>