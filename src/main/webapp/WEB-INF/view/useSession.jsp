<%@ page pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>セッション</title>
</head>
<body>
<h1>セッションスコープの参照</h1>
<p>${item }</p>
<p>${member.name }${member.age }</p>

<h1>リクエストスコープの参照</h1>
<p>${info1 }</p>
<p>${info2 }</p>
<p><a href="removeSession">セッションデータの破棄</a></p>
</body>
</html>