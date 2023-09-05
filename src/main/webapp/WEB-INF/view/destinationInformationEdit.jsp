<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>お出掛け先情報登録画面</title>
</head>
<body>
	<div id="destinationInformationEdit">
		<h1>お出掛け先情報登録画面</h1>
		<p class="small right">
			「<span class="required">*</span>」がついている項目は必須項目です。
		</p>
		<form action="" method="post">
			<table>
				<tr>
					<td>お出掛け先のジャンル<span class="required">*</span><br>
					現在登録されているジャンルは「${genreId }」です。</td>
					<td><select name="genreId" size="1" required>
							<option value="0" label="１つ選んでください" selected disabled>0</option>
							<option value="1" label="公園">1</option>
							<option value="2" label="ドッグラン">2</option>
							<option value="3" label="飲食店">3</option>
							<option value="99" label="その他の施設">99</option>
					</select></td>
				</tr>
				<tr>
					<td>お出掛け先の名称<span class="required">*</span></td>
					<td><input required type="text" name="name"
						value="${name }"></td>
				</tr>
				<!-- <tr>
            <td>写真</td>
            <td><input type="file" name="image"></td>
        </tr> -->
				<tr>
					<td>総合評価<span class="required">*</span><br>
					現在の評価は「${evaluation }」です。</td>
					<td><label><input required type="radio"
							name="evaluation" value="1">１</label> <label><input
							type="radio" name="evaluation" value="2">２</label> <label><input
							type="radio" name="evaluation" value="3" checked>３</label> <label><input
							type="radio" name="evaluation" value="4">４</label> <label><input
							type="radio" name="evaluation" value="5">５</label></td>
				</tr>
			</table>
			<input type="submit" value="上記の内容で登録する">
		</form>
	</div>
</body>
</html>