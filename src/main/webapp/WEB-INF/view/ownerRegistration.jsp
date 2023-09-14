<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>愛犬家登録</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">

</head>
<body>
  <jsp:include page="include/ownerMypageContainer.jsp"/>
  
  	<h1>愛犬家登録画面</h1>
	<p class="small right">
		「<span class="required">*</span>」がついている項目は必須項目です。
	</p>

	<h2>ご自身の情報</h2>
	<form action="" method="post" class="mb-3" enctype="multipart/form-data">
<div class="mb-3">
				<p>ログインID<span class="small">※半角英数字5～15文字</span><span
					class="required">*</span></p>
				<input class="form-control" aria-describedby="basic-addon1" required type="text" pattern="^[0-9A-Za-z]*$"
					minlength="5" maxlength="15" name="loginId" placeholder="ログインID" value="${loginId }">
</div>
<div class="mb-3">
				<p>パスワード<span class="small">※半角英数字5～15文字</span><span
					class="required">*</span></p>
				<input class="form-control" aria-describedby="basic-addon1" required type="password" minlength="5"
					pattern="^[0-9A-Za-z]*$" minlength="5" maxlength="15"
					name="loginPassword" placeholder="パスワード">
</div>

							<input type="file" name="upfile" id="file_photo">

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

			
		</p>
	
</div></body>
</html>