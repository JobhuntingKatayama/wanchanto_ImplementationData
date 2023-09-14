<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>お出掛け先情報登録完了</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">

</head>
<body>
  <jsp:include page="include/ownerMypageContainer.jsp"/>
		<h1>お出掛け先情報更新完了</h1>
<p>更新しました。</p>

		<p>
			<button class="btn btn-primary" type="button" class="btn btn-outline-primary"
				onclick="location.href='ownerMypage'">マイページへ戻る</button>
		</p>

	</div>
</body>
</html>