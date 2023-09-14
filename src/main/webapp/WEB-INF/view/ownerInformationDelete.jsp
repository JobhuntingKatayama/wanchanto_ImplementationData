<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>会員情報の削除</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">

</head>
<body>
  <jsp:include page="include/ownerMypageContainer.jsp"/>
  
		<h1>愛犬家登録情報削除画面</h1>
		<p>ご登録いただいた愛犬家情報を削除しますか？</p>
		<p>削除を進める場合は画面下部の「削除する」ボタンを押してください。
		<div class="alert alert-warning" role="alert">
			注意点：ご共有いただいているお出掛け先情報は愛犬家情報が無い状態で残りますのでご了承ください。</div>
		</p>
		<h2>ご自身の情報</h2>
		<p>ご登録いただいているこちらの情報を削除します。</p>
		<form action="" method="post" class="mb-3">

			<p>
				ログインID<span class="small">※半角英数字5～15文字</span><span class="required">*</span>
			</p>
			

			<p class="d-inline-flex focus-ring py-2 px-2 text-decoration-none border rounded-2">
				<c:out value="${owner.loginId }" />
			</p>
			
			<p>
				パスワード<span class="small">※半角英数字5～15文字</span><span class="required">*</span>
			</p>
			<p class="d-inline-flex focus-ring py-2 px-2 text-decoration-none border rounded-2">
			セキュリティのため表示されません。
			</p>

			<p>
				<button type="button" class="btn btn-outline-primary"
					onclick="location.href='ownerMypage'">削除はせずにマイページに戻る</button>
			</p>

			<input type="submit" class="btn btn-danger" value="削除する">
		</form>

		<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
		<script>
			$(document).ready(function() {
				$("form").submit(function() {
					return confirm("本当に削除しますか？");
				});
			});
		</script>
	</div>
</body>
</html>