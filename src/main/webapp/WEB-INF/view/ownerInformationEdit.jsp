<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>愛犬家登録情報の更新</title>
</head>
<body>
	<p class="small right">
		「<span class="required">*</span>」がついている項目は必須項目です。
	</p>
	
	<form action="" method="post">
	<input type="text" name="loginId" value="${loginId }"><%-- リクエストスコープから取得 --%>
	<input type="text" name="loginPassword" value="${loginPassword }"><%-- リクエストスコープから取得 --%>

		<input type="submit" value="登録内容を更新する">
	</form>
</body>
</html>