<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>愛犬家ログイン</title>

<link rel="icon" href="img/favicon.svg" type="image/svg+xml">

<jsp:include page="include/bootstrapCDN.jsp" />
<link href="css/style.css" rel="stylesheet">

</head>
<body>
  <jsp:include page="include/ownerMypageContainer.jsp"/>
	<jsp:include page="include/ownerEntrance.jsp" />
 
		<h1>愛犬家ログイン画面</h1>

		<c:if test="${not empty error }">
			<p>ログイン情報に間違いがあります。</p>
		</c:if>

		<p class="small right">
			「<span class="required">*</span>」がついている項目は必須項目です。
		</p>

		<form action="" method="post" class="mb-3">
			<div class="mb-4">

				<p class="fw-bold">
					ログインID<span class="small"><span class="required">*</span>※半角英数字5～15文字</span></p>
					<input class="form-control" aria-describedby="basic-addon1" required type="text"
						pattern="^[0-9A-Za-z]*$" minlength="5" maxlength="15"
						name="loginId" placeholder="ログインID">
			</div>
			<div class="mb-3">

				<p class="fw-bold">
					パスワード<span class="small"><span class="required">*</span>※半角英数字5～15文字</span>
				</p>
				<input class="form-control" aria-describedby="basic-addon1" required type="password"
					minlength="5" pattern="^[0-9A-Za-z]*$" minlength="5" maxlength="15"
					name="loginPassword" placeholder="パスワード">
			</div>

	<div class="d-flex justify-content-between pt-3">
    <div class="bd-highlight"><input class="btn btn-primary" type="submit" value="ログイン"></div>
    <div class="bd-highlight"><button type="button" class="btn btn-outline-primary" onclick="location.href='ownerRegistration'">新規で愛犬家登録をされる場合はこちら</button></div>
	</div>
		
		</form>
	</div>
</div>
</body>
</html>