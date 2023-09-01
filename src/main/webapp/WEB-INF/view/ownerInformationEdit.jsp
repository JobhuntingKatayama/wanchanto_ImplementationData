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
		<h2>ご自身の情報</h2>
		<table>
			<tr>
				<th>ログインID<span class="small">※半角英数字5～15文字</span><span
					class="required">*</span></th>
				<td>
				<c:if test="${not empty loginIdError }">
				<c:out value="※${loginIdError }"/>
				</c:if>
				<input required type="text" pattern="^[0-9A-Za-z]*$"
					minlength="5" maxlength="15" name="loginId" value="${loginId }" /></td>
			</tr>
			<tr>
				<th>パスワード<span class="small">※半角英数字5～15文字</span><span
					class="required">*</span></th>
				<td>
				<c:if test="${not empty loginPasswordError }">
				<c:out value="※${loginPasswordError }"/>
				</c:if>
				<input required type="password" minlength="5"
					pattern="^[0-9A-Za-z]*$" minlength="5" maxlength="15"
					name="loginPassword" value="${loginPassword }" /></td>
			</tr>
		</table>

		<input type="submit" value="登録内容を更新する">
	</form>
</body>
</html>