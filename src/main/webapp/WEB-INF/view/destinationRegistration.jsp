<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>お出掛け先新規登録</title>

<link rel="icon" href="img/favicon.svg" type="image/svg+xml">


<jsp:include page="include/bootstrapCDN.jsp" />
<link href="css/style.css" rel="stylesheet">
<link href="css/evaluation.css" rel="stylesheet">

</head>
<body>
	<jsp:include page="include/destinationEditContainer.jsp" />
	<jsp:include page="include/destinationEdit.jsp" />
	<h1>お出掛け先情報登録画面</h1>
	<p class="small right">
		「<span class="required">*</span>」がついている項目は必須項目です。
	</p>
	<p>お出掛け先のイメージ画像は、情報登録完了後にマイページの「編集する」ボタンから登録をお願いします。</p>
	<form class="mb-3" action="" method="post" enctype="multipart/form-data">
		<div class="mb-4">
			<p class="fw-bold">
				お出掛け先のジャンル<span class="required">*</span>
			</p>
			<select class="form-select" name="genreId" required size="1">
				<option value="0" label="１つ選んでください" selected disabled>0</option>
				<option value="1" label="公園">1</option>
				<option value="2" label="ドッグラン">2</option>
				<option value="3" label="飲食店">3</option>
				<option value="99" label="その他の施設">99</option>
			</select>
		</div>
		<div class="mb-4">
			<p class="fw-bold">
				お出掛け先の名称<span class="required">*</span>
			</p>
			<input class="form-control" aria-describedby="basic-addon1" required
				type="text" name="name" placeholder="お出掛け先の名称">
		</div>

		<div class="mb-4">
			<p class="fw-bold">
				お出掛け先のイメージ画像
			</p>
			<input type="file" name="upfile">
		</div>

		<div class="mb-3">
			<p class="fw-bold">
				評価<span class="required">*</span>
			</p>

			<div class="form-check">
				<input type="radio" id="flexRadioDefault1" required
					name="evaluation" value="1" class="form-check-input" /> <label
					id="evaluation" for="flexRadioDefault1"
					class="form-check-label oneStar">1</label><br> <input
					type="radio" id="flexRadioDefault2" name="evaluation" value="2"
					class="form-check-input" /> <label id="evaluation"
					for="flexRadioDefault2" class="form-check-label twoStars">2</label><br>
				<input class="form-check-input" id="flexRadioDefault3" type="radio"
					name="evaluation" value="3" /> <label id="evaluation"
					class="form-check-label threeStars" for="flexRadioDefault3">3</label>
				<br> <input class="form-check-input" id="flexRadioDefault4"
					type="radio" name="evaluation" value="4" /> <label id="evaluation"
					class="form-check-label fourStars" for="flexRadioDefault4">4</label>
				<br> <input class="form-check-input" id="flexRadioDefault5"
					type="radio" name="evaluation" value="5" /> <label id="evaluation"
					class="form-check-label fiveStars" for="flexRadioDefault5">5</label><br>
			</div>

		</div>


		<div class="d-flex justify-content-between pt-3">
			<div class="bd-highlight">
				<input type="submit" class="btn btn-primary" value="上記の内容で登録する">
			</div>
			<div class="bd-highlight">
				<button type="button" class="btn btn-outline-primary"
					onclick="location.href='ownerMypage'">登録せずにマイページへ戻る</button>
			</div>
		</div>

	</form>
	</div>
	</div>

</body>
</html>