<%@ page pageEncoding="UTF-8"%>

<%
Cookie[] cs = request.getCookies();
String color = null;
if (cs != null) {
	for (Cookie c : cs) {
		if (c.getName().equals("color")) {
	color = c.getValue();
		}
	}
}
%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>I色の設定</title>
</head>
<body>
	<p>
		保存された色は<%=color%>です。
	</p>
</body>
</html>