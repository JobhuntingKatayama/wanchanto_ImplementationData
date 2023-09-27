<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>お出掛け先情報登録完了</title>

<link rel="icon" href="img/favicon.svg" type="image/svg+xml">


<jsp:include page="include/bootstrapCDN.jsp" />
<link href="css/style.css" rel="stylesheet">

</head>
<body>
	<jsp:include page="include/destinationEditContainer.jsp" />
	<jsp:include page="include/destinationEdit.jsp" />
		<h1>お出掛け先情報登録完了</h1>
		<p>下記の情報でお出掛け先を登録しました。</p>
		<p>マイページの「編集する」ボタンからお出掛け先の画像登録をお願いします。</p>

			<div class="d-flex justify-content-between pt-3">
			<%-- 				<div class="bd-highlight">
					<button type="button" class="btn btn-primary"
				onclick="window.open('destinationDetail?destinationId=${destinationId}')">登録した内容を確認する</button>
				</div>
 --%>
			<div class="bd-highlight">
					<button type="button" class="btn btn-primary"
					onclick="location.href='ownerMypage'">マイページへ戻る</button>
				</div>
			</div>

	</div>
	</div>

</body>
</html>