<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>愛犬家削除完了画面</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">

</head>
<body>
  <jsp:include page="include/ownerMypageContainer.jsp"/>
	<h1>愛犬家削除完了画面</h1>
	<p>愛犬家情報を削除しました。</p>

		<div class="d-flex justify-content-end mb-3">
			<div class="p-2 bd-highlight">
				<button type="button" class="btn btn-primary"
					onclick="location.href='destinationIndex'">お出掛け先一覧を見る</button>
			</div>
		</div>

	</div>
</body>
</html>