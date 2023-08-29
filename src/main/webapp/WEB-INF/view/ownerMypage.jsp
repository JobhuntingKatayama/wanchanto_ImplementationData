<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>愛犬家マイページ</title>

<script type="text/javascript">
<!--
	function confirm() {
		window.alert('本当にログアウトしますか？');
	}
// -->
</script>

</head>
<body>
	<h1>${handleName}さんのマイページ</h1>
	<p>${handleName}さん、こんにちは！</p>
	<div id="ownerMypageContents">
		<dl>
			<dt id="ownerInfomation">
				<dl>
					<dt>
						<img id="thumbnailOwner" src="img/thumbnail.jpg">
					</dt>
					<dd>
						<h2>
							ニックネーム<span>さん</span>
						</h2>
						<input type="button"
							onclick="location.href='ownerInformationEdit.html'"
							value="愛犬家情報の編集">
					</dd>
				</dl>
			</dt>
			<dd id="destinationInformation">
				<dl>
					<dt>
						<h2>お出掛け先情報一覧</h2>
						<input type="button"
							onclick="location.href='destinationInformationRegistration'"
							value="お出掛け先情報の新規追加">
					</dt>
					<dd>
						<table>
							<tr>
								<th>ジャンル</th>
								<th>名称</th>
								<th>評価</th>
							</tr>
							<c:forEach items="${destinationList}" var="destination">
							<tr>
								<td><c:out value="${destination.genreId}" /></td>
								<td><c:out value="${destination.name}" /></td>
								<td><c:out value="${destination.evaluation}" /></td>
							</tr>
							</c:forEach>
						</table>

					</dd>
				</dl>
			</dd>
		</dl>
	</div>

	<input type="button" onclick="location.href='ownerLogout'"
		value="ログアウトする">

</body>
</html>