<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>画像削除確認画面</title>
<link rel="icon" href="img/favicon.svg" type="image/svg+xml">


<jsp:include page="include/bootstrapCDN.jsp" />
<link href="css/style.css" rel="stylesheet">

</head>
<body>
	<jsp:include page="include/destinationEditContainer.jsp" />
	<jsp:include page="include/destinationEdit.jsp" />

<h1>登録画像削除の確認</h1>

	<form action="" method="post" enctype="multipart/form-data" class="mb-3">
	<input type="hidden" name="destinationId" value="<c:out value='${destinationId }'/>">
	<p>こちらの画像を削除しますか？</p>
	<img style="width:100%;" class="mb-3"
		src='data:image/jpeg;base64,<c:out value="${detailImage.imgData}" />'></p>
	<div class="d-flex justify-content-between pt-3">
		<div class="bd-highlight">
			<input type="submit" class="btn btn-primary" value="画像を削除する">
		</div>
		<div class="bd-highlight">
			<button type="button" class="btn btn-outline-primary"
				onclick="location.href='destinationEdit?destinationId=<c:out value="${destinationId }" />'">削除せず編集画面に戻る</button>
		</div>
	</div>
	</form>



	
	</div>
</div>
</body>
</html>