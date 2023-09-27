<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>画像削除完了</title>
<link rel="icon" href="img/favicon.svg" type="image/svg+xml">


<jsp:include page="include/bootstrapCDN.jsp" />
<link href="css/style.css" rel="stylesheet">

</head>
<body>
	<jsp:include page="include/destinationEditContainer.jsp" />
	<jsp:include page="include/destinationEdit.jsp" />

<h1>画像削除完了</h1>
<p class="mb-3">お出掛け先情報から画像を削除しました。</p>
	<div class="bd-highlight">
		<button type="button" class="btn btn-primary"
			onclick="location.href='destinationEdit?destinationId=<c:out value="${destinationId }" />'">編集画面に戻る</button>
	</div>
</div>
</div>
</body>
</html>