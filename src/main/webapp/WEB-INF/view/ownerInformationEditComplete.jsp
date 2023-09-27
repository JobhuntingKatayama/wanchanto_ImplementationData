<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>愛犬家情報の更新完了</title>

<link rel="icon" href="img/favicon.svg" type="image/svg+xml">

<jsp:include page="include/bootstrapCDN.jsp" />
<link href="css/style.css" rel="stylesheet">

</head>
<body>
  <jsp:include page="include/ownerMypageContainer.jsp"/>
    <jsp:include page="include/ownerEntrance.jsp"/>
  
<h1>愛犬家情報の更新</h1>
<p>更新しました。</p>
		<p>
			<button type="button" class="btn btn-primary"
				onclick="location.href='ownerMypage'">マイページへ戻る</button>
		</p>

</div>
</div>
</body>
</html>