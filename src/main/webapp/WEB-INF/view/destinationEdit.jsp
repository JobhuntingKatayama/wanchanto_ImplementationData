<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>お出掛け先情報登録画面</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">

</head>
<body>
	<div class="container mt-5 mb-5">
		<h1>お出掛け先情報登録画面</h1>
		<p class="small right">
			「<span class="required">*</span>」がついている項目は必須項目です。
		</p>

		<form action="" method="post" class="mb-3">

			<div class="mb-3">
				<p>
					お出掛け先のジャンル<span class="required">*</span><br />
					現在登録されているジャンルは「${preGenreId }」です。
				</p>
				<select class="form-select" name="newGenreId" size="1" required>
					<option label="１つ選んでください" selected disabled></option>
					<option value="1" label="公園">1</option>
					<option value="2" label="ドッグラン">2</option>
					<option value="3" label="飲食店">3</option>
					<option value="99" label="その他の施設">99</option>
				</select>
			</div>

			<div class="mb-3">
				<p>
					お出掛け先の名称<span class="required">*</span>
				</p>
				<input class="form-control" aria-describedby="basic-addon1" required
					type="text" name="newName" value="${preName }">
			</div>

			<div class="mb-3">
				<p>
					総合評価<span class="required">*</span><br /> 現在の評価は「${preEvaluation }」です。
				</p>
				<div class="form-check">
					<input type="radio" id="flexRadioDefault1" required name="newEvaluation" value="1" class="form-check-input" />
					<label for="flexRadioDefault1" class="form-check-label">1</label><br>	
					<input type="radio" id="flexRadioDefault2" name="newEvaluation" value="2" class="form-check-input" /> 
					<label for="flexRadioDefault2" class="form-check-label">2</label><br> 
					<input class="form-check-input" id="flexRadioDefault3" type="radio" name="newEvaluation" value="3" /> 
					<label class="form-check-label" for="flexRadioDefault3">3</label> <br>
					<input class="form-check-input" id="flexRadioDefault4" type="radio" name="newEvaluation" value="4" /> 
					<label class="form-check-label" for="flexRadioDefault4">4</label> <br>
					<input class="form-check-input" id="flexRadioDefault5" type="radio" name="newEvaluation" value="5" /> 
					<label class="form-check-label" for="flexRadioDefault5">5</label><br>
				</div>
			</div>

			<input class="btn btn-primary" type="submit" value="上記の内容で登録する">

		</form>
		<p>
			<button type="button" class="btn btn-outline-primary"
				onclick="location.href='ownerMypage'">マイページへ戻る</button>
		</p>
	</div>
</body>
</html>