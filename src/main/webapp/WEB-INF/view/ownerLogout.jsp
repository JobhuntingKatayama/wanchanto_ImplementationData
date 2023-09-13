<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>ログアウト</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">

</head>
<body>
	<div class="container mt-5 mb-5">

    <h1>ログアウト完了</h1>

    <p>ログアウトしました。</p>
	  		<div class="d-flex justify-content-between pt-3">
				<div class="bd-highlight">
					<button type="button" class="btn btn-outline-primary"
				onclick="location.href='ownerLogin'">ログインページを開く</button>
				</div>
				<div class="bd-highlight">
					<button type="button" class="btn btn-primary"
				onclick="location.href='destinationIndex'">お出掛け先一覧を開く</button>
				</div>
			</div>
    
</div>
</body>
</html>