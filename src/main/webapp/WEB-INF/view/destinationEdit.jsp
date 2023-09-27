<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>お出掛け先情報編集画面</title>

<link rel="icon" href="img/favicon.svg" type="image/svg+xml">


<jsp:include page="include/bootstrapCDN.jsp" />
<link href="css/evaluation.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">

</head>
<body>
	<jsp:include page="include/destinationEditContainer.jsp" />
	<jsp:include page="include/destinationEdit.jsp" />

	<h1>お出掛け先情報編集画面</h1>
	<p class="small right">
		「<span class="required">*</span>」がついている項目は必須項目です。
	</p>

	<form action="" method="post" class="mb-3"
		enctype="multipart/form-data">
		<input type="hidden" name="${destinationId }"
			value="${destinationId }">

		<div class="mb-4">
			
				<p class="fw-bold">お出掛け先のジャンル<span class="required">*</span></p>
				<p>現在登録されているジャンルは「
				<c:choose>
					<c:when test="${genreId == 1}">
					公園
					</c:when>
					<c:when test="${genreId == 2}">
					ドッグラン
					</c:when>
					<c:when test="${genreId == 3}">
					飲食店
					</c:when>
					<c:otherwise>
					その他の施設
					</c:otherwise>
				</c:choose>
				」です。
			</p>
			<select class="form-select" name="genreId" size="1" required>
				<option label="１つ選んでください" disabled></option>
				<option value="1" label="公園"
					<c:if test="${genreId == 1 }">selected</c:if>>1</option>
				<option value="2" label="ドッグラン"
					<c:if test="${genreId == 2 }">selected</c:if>>2</option>
				<option value="3" label="飲食店"
					<c:if test="${genreId == 3 }">selected</c:if>>3</option>
				<option value="99" label="その他の施設"
					<c:if test="${genreId == 99 }">selected</c:if>>99</option>
			</select>
		</div>

		<div class="mb-4">
			
				<p class="fw-bold">お出掛け先の名称<span class="required">*</span></p>
			<input class="form-control" aria-describedby="basic-addon1" required
				type="text" name="name" value="${name }">
		</div>

		<div class="mb-4">
			<p class="fw-bold">評価<span class="required">*</span></p>
			<p>現在の評価は「${evaluation }」です。</p>
			<div class="form-check">
				<input type="radio" id="flexRadioDefault1" required
					name="evaluation" value="1" class="form-check-input"
					<c:if test="${evaluation == 1 }">checked</c:if> /> <label id="evaluation" 
					for="flexRadioDefault1" class="form-check-label oneStar">1</label><br>
				<input type="radio" id="flexRadioDefault2" name="evaluation"
					value="2" class="form-check-input"
					<c:if test="${evaluation == 2 }">checked</c:if> /> <label id="evaluation" 
					for="flexRadioDefault2" class="form-check-label twoStars">2</label><br>
				<input class="form-check-input" id="flexRadioDefault3" type="radio"
					name="evaluation" value="3"
					<c:if test="${evaluation == 3 }">checked</c:if> /> <label id="evaluation" 
					class="form-check-label threeStars" for="flexRadioDefault3">3</label> <br>
				<input class="form-check-input" id="flexRadioDefault4" type="radio"
					name="evaluation" value="4"
					<c:if test="${evaluation == 4 }">checked</c:if> /> <label id="evaluation" 
					class="form-check-label fourStars" for="flexRadioDefault4">4</label> <br>
				<input class="form-check-input" id="flexRadioDefault5" type="radio"
					name="evaluation" value="5"
					<c:if test="${evaluation == 5 }">checked</c:if> /> <label id="evaluation" 
					class="form-check-label fiveStars" for="flexRadioDefault5">5</label><br>
			</div>
		</div>




 		<div class="mb-4">
			<p class="fw-bold">画像の追加・削除</p>

			<p>現在登録されている画像</p>
			<table class="table table-striped border">
				<thead>
					<tr>
						<th>画像</th>
						<!--  <th>画像ファイル名</th>-->
						<th>種類</th>
						<th>コメント</th>
						<th colspan="2">更新／削除</th>
					</tr>
				</thead>
				<tbody>
					<c:if
						test="${detailImageList != null and detailImageList.size() > 0}">
						<c:forEach items="${detailImageList }" var="detailImage">
							<tr>

								<td><input type="hidden" name="imgId"
									value="<c:out value="${detailImage.imgId }" />">
								<img style="height: 100px;" class="mb-3"
									src='data:image/jpeg;base64,<c:out value="${detailImage.imgData}" />'></td>
<%-- 								<td><c:out value="${detailImage.fileName }" /></td>
 --%>								<td><c:choose>
						<c:when test="${detailImage.imgCategory ==0 }">特に指定なし</c:when>
						<c:when test="${detailImage.imgCategory ==1 }">内観</c:when>
						<c:when test="${detailImage.imgCategory ==2 }">外観</c:when>
						<c:when test="${detailImage.imgCategory ==3 }">情報</c:when>
						<c:when test="${detailImage.imgCategory ==4 }">料理</c:when>
						<c:when test="${detailImage.imgCategory ==5 }">注意事項</c:when>
						</c:choose></td>
								<td><c:out value="${detailImage.comment }" /></td>
								<td><a target="_blank" href="updateDetailImage?imgId=<c:out value="${detailImage.imgId }"/>">更新</a>
								<td><a href="deleteDetailImage?imgId=<c:out value="${detailImage.imgId }"/>">削除</a>
							</tr>
						</c:forEach>
					</c:if>
					<c:if
						test="${detailImageList == null or detailImageList.size() == 0}">
						<tr>
							<td colspan=5>登録されている画像はありません。</td>
						</tr>
					</c:if>
				</tbody>
			</table>

			<p>画像の追加はこちらから</p>
			<p><input type="file" name="upfile"></p>
			<div class="mb-3">
			<p>画像の種類：</p>
			<select class="form-select" name="imgCategory">
					<option value="" label="画像の種類をお選びください" selected>
					<option value="0" label="特に指定なし">
					<option value="1" label="内観">
					<option value="2" label="外観">
					<option value="3" label="情報">
					<option value="4" label="料理">
					<option value="5" label="注意事項">
				</select>
			</div>
			<p>コメント：</p>
				<textarea name="comment" rows="4" style="width:100%;"></textarea>
		</div>




		<div class="d-flex justify-content-between pt-3">
			<div class="bd-highlight">
				<input class="btn btn-primary" type="submit" value="上記の内容で登録する">
			</div>
			<div class="bd-highlight">
				<button type="button" class="btn btn-outline-primary"
					onclick="location.href='ownerMypage'">編集せずにマイページへ戻る</button>
			</div>
		</div>

	</form>

	</div>
	</div>
	
</body>
</html>