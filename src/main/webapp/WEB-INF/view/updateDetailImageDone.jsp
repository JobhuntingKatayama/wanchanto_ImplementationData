<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>お出掛け先画像編集完了</title>
</head>
<body>
<p>更新しました。</p>
<a href="destinationEdit?destinationId=<c:out value="${destinationId }"/>">お出掛け先情報の編集ページへ戻る</a>
</body>
</html>