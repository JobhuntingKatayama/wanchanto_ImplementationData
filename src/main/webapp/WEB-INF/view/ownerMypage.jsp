<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>愛犬家マイページ</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">

</head>
<body>
	<div class="container mt-5 mb-5">

		<h1>${loginId }さんのマイページ</h1>
			<dl>
				<dt>
					<dl>
						<dt>
							<img id="thumbnailOwner" src="img/thumbnail.jpg">
						</dt>
						<dd>
							<p>
								<button type="button" class="btn btn-outline-primary"
									onclick="location.href='ownerInformationEdit?ownerId=<c:out value="${ownerId}"/>'">愛犬家情報の更新</button>
							</p>
							<p>
								<button type="button" class="btn btn-light"
									onclick="location.href='ownerInformationDelete?ownerId=<c:out value="${ownerId}"/>'">愛犬家情報の削除</button>
							</p>

						</dd>
					</dl>
				</dt>
				<dd>
					<dl>
						<dt>
							<h2>お出掛け先情報一覧</h2>
							<p>
								<button type="button" class="btn btn-primary"
									onclick="location.href='destinationRegistration?ownerId=<c:out value="${ownerId}"/>'">お出掛け先情報の新規追加</button>
							</p>
						</dt>
						<dd>
							<table class="table table-striped">
								<tr>
									<th>ジャンル</th>
									<th>名称</th>
									<th>評価</th>
									<th>編集</th>
								</tr>
								<c:forEach items="${destinationList}" var="destination">
									<tr>
										<td><c:out value="${destination.genreId}" /></td>
										<td><a
											href="destinationDetail?destinationId=<c:out value="${destination.destinationId }" />"><c:out
													value="${destination.name}" /></a></td>
										<td><c:out value="${destination.evaluation}" /></td>
										<td><button type="button" class="btn btn-outline-primary"
												onclick="location.href='destinationEdit?ownerId=${destination.ownerId}&destinationId=${destination.destinationId}'">編集する</button></td>
									</tr>
								</c:forEach>
							</table>

						</dd>
					</dl>
				</dd>
			</dl>
		<p>
			<button type="button" class="btn btn-outline-primary"
				onclick="location.href='ownerLogout'">ログアウトする</button>
		</p>
	</div>
</body>
</html>