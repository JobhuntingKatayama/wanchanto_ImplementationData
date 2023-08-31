<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>会員情報の削除</title>
</head>
<body>
	<h1>愛犬家登録情報削除画面</h1>
	<p>ご登録いただいた愛犬家情報を削除しますか？</p>
	<p>削除を進める場合は画面下部の「削除する」ボタンを押してください。</p>
	<p>注意点：ご共有いただいているお出掛け先情報は愛犬家情報が無い状態で残りますのでご了承ください。</p>
	<h2>ご自身の情報</h2>
	<p>▼こちらの情報を削除します。</p>
	<form action="" method="post">
		<table>
			<tr>
				<th>ログインID<span class="small">※半角英数字5～15文字</span><span
					class="required">*</span></th>
				<td><c:out value="${owner.loginId }" /></td>
			</tr>
			<tr>
				<th>パスワード<span class="small">※半角英数字5～15文字</span><span
					class="required">*</span></th>
				<td>セキュリティのため表示されません。</td>
			</tr>
		</table>
		<input type="submit" value="削除">
	</form>

	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script>
		$(document).ready(function() {
			$("form").submit(function() {
				return confirm("本当に削除しますか？");
			});
		});
	</script>
</body>
</html>