<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>画像削除完了</title>
</head>
<body>
<p>削除しました。</p>
<a href="destinationEdit?destinationId=<c:out value="${destinationId }"/>">お出掛け先情報の編集ページへ戻る</a>
</html>