<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="destinationInformationRegistrationComplete">
    <h1>お出掛け先情報登録完了</h1>
<p>下記の情報でお出掛け先を登録しました。</p>

<input type="button" onclick="window.open('park230823hwc72.html')" value="登録した内容を確認する">

<table>
    <tr>
        <th>お出掛け先のジャンル</th>
        <td><c:out value="${genreId}" />
        </td>
    </tr>
    <tr>
        <th>お出掛け先の名称</th>
        <td><c:out value="${name}" /></td>
    </tr>
    <!-- <tr>
        <th>写真</th>
        <td>
            <ul>
                <li><img class="thumbnailDestination" src="img/park230823hwc72001.jpg"></li>
                <li><img class="thumbnailDestination" src="img/park230823hwc72002.jpg"></li>
                <li><img class="thumbnailDestination" src="img/park230823hwc72003.jpg"></li>
            </ul>
        </td>
    </tr> -->
    <tr>
        <th>評価</th>
        <td><c:out value="${evaluation}" /></td>
    </tr>
</table>

        <!-- <input type="button" onclick="location.href='destinationInformationEdit.html'" value="登録した内容を編集する"> -->
        <input type="button" onclick="location.href='ownerMypage'" value="マイページへ戻る">
    </div>
</body>
</html>