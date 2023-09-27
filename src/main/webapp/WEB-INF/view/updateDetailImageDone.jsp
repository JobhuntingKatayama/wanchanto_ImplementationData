<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">

<title>お出掛け先画像の編集完了</title>

<link rel="icon" href="img/favicon.svg" type="image/svg+xml">

<jsp:include page="include/bootstrapCDN.jsp" />
<link href="css/style.css" rel="stylesheet">

</head>
<body>
	<jsp:include page="include/ownerMypageContainer.jsp" />

<h1>お出掛け先画像の更新完了</h1>
<p class="mb-3">お出掛け先画像の情報を更新しました。</p>
	<div class="bd-highlight">
		<button type="button" class="btn btn-primary"
			onclick="location.href='destinationEdit?destinationId=<c:out value="${destinationId }" />'">編集画面に戻る</button>
	</div>
</div>
</body>
</html>