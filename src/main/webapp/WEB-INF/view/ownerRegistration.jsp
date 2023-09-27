<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>愛犬家登録</title>

<link rel="icon" href="img/favicon.svg" type="image/svg+xml">

<jsp:include page="include/bootstrapCDN.jsp" />
<link href="css/style.css" rel="stylesheet">

</head>
<body>
	<jsp:include page="include/ownerMypageContainer.jsp" />
	<jsp:include page="include/ownerEntrance.jsp" />
	<h1>愛犬家登録画面</h1>
	<p class="small right">
		「<span class="required">*</span>」がついている項目は必須項目です。
	</p>

<p>今後当サービスを利用するにあたり、ログインに必要になるIDとパスワードを入力して登録してください。</p>
	<form action="" method="post" class="mb-3" enctype="multipart/form-data">
		<div class="mb-4">
			<p class="fw-bold">
				ログインID<span class="small"><span class="required">*</span>※半角英数字5～15文字</span>
			</p>
			<input class="form-control" aria-describedby="basic-addon1" required
				type="text" pattern="^[0-9A-Za-z]*$" minlength="5" maxlength="15"
				name="loginId" placeholder="ログインID" value="${loginId }">
		</div>
		<div class="mb-4">
			<p class="fw-bold">
				パスワード<span class="small"><span class="required">*</span>※半角英数字5～15文字</span>
			</p>
			<input class="form-control" aria-describedby="basic-addon1" required
				type="password" minlength="5" pattern="^[0-9A-Za-z]*$" minlength="5"
				maxlength="15" name="loginPassword" placeholder="パスワード">
		</div>

		<div class="mb-3">
			<p class="fw-bold">サムネイル用画像</p>
			<input type="file" name="upfile" value="画像を選択する">
		</div>
		
		<div class="d-flex justify-content-between pt-3">
			<div class="bd-highlight">
				<input class="btn btn-primary" type="submit" value="登録内容を確認する">
			</div>
			
			<div class="bd-highlight">
				<button type="button" class="btn btn-outline-primary"
					onclick="location.href='ownerLogin'">ログイン画面に戻る</button>
			</div>
		</div>

	</form>



	</div>
	</div>
</body>
</html>