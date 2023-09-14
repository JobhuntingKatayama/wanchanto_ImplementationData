<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>愛犬家登録内容確認</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">

</head>
<body>
  <jsp:include page="include/ownerMypageContainer.jsp"/>
  	<h1>愛犬家登録内容確認</h1>
	<p>下記の情報で登録をしてもよろしいでしょうか？</p>

	<form action="ownerRegistrationComplete" method="post" class="mb-3">
<p>ログインID</p>
<p class="d-inline-flex focus-ring py-2 px-2 text-decoration-none border rounded-2">${loginId }</p>
<p>パスワード</p>
<p class="d-inline-flex focus-ring py-2 px-2 text-decoration-none border rounded-2">セキュリティのため表示されません。</p>
<br/>
<p class="d-inline-flex focus-ring py-2 px-2 text-decoration-none border rounded-2">${thumbnail }</p>
<p class="d-inline-flex focus-ring py-2 px-2 text-decoration-none border rounded-2">${bytes }</p>


			<div class="d-flex justify-content-between pt-3">
				<div class="bd-highlight">
					<input class="btn btn-primary" type="submit" value="登録する">
				</div>
				<div class="bd-highlight">
					<button type="button" class="btn btn-outline-primary"
						onclick="location.href='ownerRegistration'">入力しなおす</button>
				</div>
			</div>

		</form>
			<p>
			
		</p>
	
</div>
</body>
</html>