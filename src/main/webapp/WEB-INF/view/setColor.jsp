<%@ page pageEncoding="UTF-8"%>

<%
Cookie c = new Cookie("color", "Blue");
c.setMaxAge(60 * 60 * 24);
response.addCookie(c);
%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>色の設定</title>
</head>
<body>
<p>色の設定を保存しました</p>
</body>
</html>