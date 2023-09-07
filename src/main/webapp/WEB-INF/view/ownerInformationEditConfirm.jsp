<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>愛犬家登録内容確認</title>
</head>
<body>
<h1>愛犬家登録内容確認</h1>
<p>下記の情報で登録をしてもよろしいでしょうか？</p>

	<form action="ownerInformationEditComplete" method="post">
		<h2>ご自身の情報</h2>
		<%-- Editでpostされた情報をConfirmから取得 --%>
		<p>${loginId }</p>
		<p>${loginPassword }</p>
		
		<input type="submit" value="登録内容を更新する">
	</form>
	
	
</body>
</html>