<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>愛犬家ログイン</title>
</head>
<body>
	<h1>愛犬家ログイン画面</h1>

	<c:if test="${not empty error }">
		<p>ログイン情報に間違いがあります。</p>
	</c:if>

	<p class="small right">
		「<span class="required">*</span>」がついている項目は必須項目です。
	</p>

	<form action="" method="post">
		<table>
			<tr>
				<th>ログインID<span class="small">※半角英数字5～15文字</span><span
					class="required">*</span></th>
				<td><input required type="text" pattern="^[0-9A-Za-z]*$"
					minlength="5" maxlength="15" name="loginId"></td>
			</tr>
			<tr>
				<th>パスワード<span class="small">※半角英数字5～15文字</span><span
					class="required">*</span></th>
				<td><input required type="password" minlength="5"
					pattern="^[0-9A-Za-z]*$" minlength="5" maxlength="15"
					name="loginPassword"></td>
			</tr>
		</table>
		<input type="submit" value="ログイン">
	</form>
	
	<p><a href="ownerRegistration">新規で愛犬家登録をされる場合はこちら</a></p>
</body>
</html>