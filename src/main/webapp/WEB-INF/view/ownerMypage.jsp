<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>愛犬家マイページ</title>

  <script type="text/javascript">
        <!--      
        function confirm(){
            window.alert('本当にログアウトしますか？');
        }
        // -->
        </script>

</head>
<body>
   <h1>マイページ</h1>
    <div id="ownerMypageContents">
    <dl>
        <dt id="ownerInfomation">
            <dl>
                <dt><img id="thumbnailOwner" src="img/thumbnail.jpg"></dt>
                <dd>
                    <h2>ニックネーム<span>さん</span></h2>
                    <input type="button" onclick="location.href='ownerInformationEdit.html'" value="愛犬家情報の編集">
                </dd>
            </dl>
        </dt>
        <dd id="destinationInformation">
            <dl>
                <dt><h2>お出掛け先情報一覧</h2>
                <input type="button" onclick="location.href='destinationInformationRegistration.html'" value="お出掛け先情報の新規追加">
            </dt>
                <dd>
                <table>
                    <tr>
                        <th>サムネイル</th>
                        <th>名称</th>
                        <th>登録日</th>
                        <th>操作</th>
                    </tr>
                    <tr>
                        <td><label for="edit001"><img class="thumbnailDestination" src="img/park230823hwc72001.jpg"></label></td>
                        <td>○○県立○○公園</td>
                        <td>20XX年XX月XX日</td>
                        <td>
                            <input type="button" onclick="location.href='destinationInformationEdit.html'" value="編集する" id="edit001">
                        </td>
                    </tr>
                    <tr>
                        <td><label for="edit001"><img class="thumbnailDestination" src="img/park230823hwc72001.jpg"></label></td>
                        <td>○○レストラン</td>
                        <td>20XX年XX月XX日</td>
                        <td>
                            <input type="button" onclick="location.href='destinationInformationEdit.html'" value="編集する">
                        </td>
                    </tr>
                    <tr>
                        <td><label for="edit001"><img class="thumbnailDestination" src="img/park230823hwc72001.jpg"></label></td>
                        <td>○○スポーツガーデン</td>
                        <td>20XX年XX月XX日</td>
                        <td>
                            <input type="button" onclick="location.href='destinationInformationEdit.html'" value="編集する">
                        </td>
                    </tr>
                    <tr>
                        <td><label for="edit001"><img class="thumbnailDestination" src="img/park230823hwc72001.jpg"></label></td>
                        <td>○○○○○○カフェ</td>
                        <td>20XX年XX月XX日</td>
                        <td>
                            <input type="button" onclick="location.href='destinationInformationEdit.html'" value="編集する">
                        </td>
                    </tr>
                    <tr>
                        <td><label for="edit001"><img class="thumbnailDestination" src="img/park230823hwc72001.jpg"></label></td>
                        <td>○○○○○○公園</td>
                        <td>20XX年XX月XX日</td>
                        <td>
                            <input type="button" onclick="location.href='destinationInformationEdit.html'" value="編集する">
                        </td>
                    </tr>
                    <tr>
                        <td><label for="edit001"><img class="thumbnailDestination" src="img/park230823hwc72001.jpg"></label></td>
                        <td>○○○○○○カフェ</td>
                        <td>20XX年XX月XX日</td>
                        <td>
                            <input type="button" onclick="location.href='destinationInformationEdit.html'" value="編集する">
                        </td>
                    </tr>

                </table>
                
            </dd>
        </dl>
    </dd>
    </dl>
</div>
        
<input type="button" onclick="location.href='ownerLogout.html',confirm()" value="ログアウトする">
    
</body>
</html>