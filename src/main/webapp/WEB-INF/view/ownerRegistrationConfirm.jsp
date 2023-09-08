<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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

	<form action="ownerRegistrationComplete" method="post" class="mb-3">
<p>ログインID</p>
<p>${loginId }</p>
<p>パスワード</p>
<p>セキュリティのため表示されません。</p>
		<input class="btn btn-primary" type="submit" value="登録する">
	</form>
			<p>
			<button type="button" class="btn btn-outline-primary"
				onclick="location.href='ownerRegistration'">入力しなおす</button>
		</p>
	
</div>
</body>
</html>