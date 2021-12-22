<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/common.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/member/u01.css">
    <title>入力内容確認画面</title>
</head>
<body>
	<jsp:include page="../common/header.jsp"/>
    <main>
        <div class="contents">
            <p>入力内容をご確認いただき、お間違いなければ「確定」をクリックしてください。</p>
            <form class="form" action="./u01_03.html" method="POST">
                <h3 class="registTitle">入力内容確認</h3>
                <table class="registTable" border="1">
	                <tr>
	                    <th><label>メールアドレス</label></th>
	                    <td>
	                    	<input name="email" type="email" disabled>
	                    </td>
	                </tr>
	                <tr>
	                    <th><label>名前</label></th>
	                    <td>
	                        <input name="frist_name" type="text" disabled>
	                    </td>
	                </tr>
	                <tr>
	                    <th><label>名前(ふりがな)</label></th>
	                    <td>
	                        <input name="frist_kana" type="text" disabled>
	                    </td>
	                </tr>
	                <tr>
	                    <th><label>性別</label></th>
	                    <td>
	                    	<!-- 性別 gender -->
	                    </td>
	                </tr>
	                <tr class="birthday">
	                    <th><label>生年月日</label></th>
	                    <td>
	                        <input type="number" name="brith" disabled>
	                    </td>
	                </tr>
	                <tr>
	                    <th><label>電話番号</label></th>
	                    <td>
	                        <input name="tel" type="number" value="090" disabled>
	                    </td>
	                </tr>
	                <tr class="postnum">
	                    <th><label>郵便番号</label></th>
	                    <td>
	                        <input name="zip_code" type="number" disabled>
	                    </td>
	                </tr>
	                </tr>
	                <tr>
	                    <th><label>住所</label></th>
	                    <td>
	                        <input type="text" name="address" disabled>
	                    </td>
	                </tr>
	                <tr>
	                    <th>
	                        <label>保険証記号</label>
	                    </th>
	                    <td>
	                        <input type="text" name="insurance_mark" disabled>
	                    </td>
	                </tr>
	                <tr>
	                    <th>
	                        <label>保険証番号</label>
	                    </th>
	                    <td>
	                        <input name="insurance_num" type="number" value="" disabled>
	                    </td>
	                </tr>
	                <tr>
	                    <th>
	                        <label>保険証有効期限</label>
	                    </th>
	                    <td class="hoken_td">
	                        <input name="insurance_expiry_date" type="number" disabled>
	                    </td>
	                </tr>
	            </table>
	            <div class="question-wrap">
               	<h3 class="questionTitle">問診表</h3>
                <table class="questionTable" border="1">
                    <tr>
                        <th>
                            <label class="itemTitle">血液型</label>
                        </th>
                        <td>
                        	<!-- 下のは消す -->
                            <select name="blood_type" disabled>
                                <option value="0" selected>分からない</option>
                                <option value="A">A</option>
                                <option value="AB">AB</option>
                                <option value="B">B</option>
                                <option value="O">O</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th>
                            <label class="itemTitle">今までにかかった病気</label>
                        </th>
                        <td>
                            <textarea name="medical_history" rows="3" cols="40"
                                style="width: 100%; max-width: 20em; height: 4.8em"></textarea disabled><br>
                            <span>今までにかかったことがある病気をかいてください。</span>
                        </td>
                    </tr>
                    <tr>
                        <th>
                            <label class="itemTitle">服用中のお薬</label>
                        </th>
                        <td>
                            <input type="text" name="sick_diray" size="30" style="width: 100%; max-width: 15em" autocomplete="off" disabled/>
                        </td>
                    </tr>
                    <tr>
                        <th>
                            <label class="itemTitle">飲酒</label>
                        </th>
                        <td>
                            <label><input type="radio" value="1" name="drink" disabled>あり</label>
                            <label><input type="radio" value="0" name="drink" checked>なし</label>
                        </td>
                    </tr>
                    <tr>
                        <th>
                            <label class="itemTitle">喫煙</label>
                        </th>
                        <td>
                            <label><input type="radio" value="1" name="smoke" disabled>あり</label>
                            <label><input type="radio" value="0" name="smoke" checked>なし</label>
                        </td>
                    </tr>
                    <tr>
                        <th>
                            <label class="itemTitle">妊娠</label>
                        </th>
                        <td>
                            <label><input type="radio" value="" name="pregnant" disabled>あり</label>
                            <label><input type="radio" value="" name="pregnant" checked>なし</label><br>
                            <span>男性の方は「なし」を選択してください</span>
                        </td>
                    </tr>
                    <tr>
                        <th>
                            <label class="itemTitle">アレルギー情報</label>
                        </th>
                        <td>
                            <textarea name="allergy" rows="3" cols="40"
                                style="width: 100%; max-width: 20em; height: 4.8em" disabled></textarea>
                        </td>
                    </tr>
                </table>
                </div>
                <section class="twobtns">
                    <input type="button" onclick="location.href='history.back();'" value="戻る">
                    <input type="button" onclick="isSubmit(form);" value="確定">
                </section>
            </form>
        </div>
    </main>
    <jsp:include page="../common/footer.jsp"/>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/member/u01_02.js"></script>
</html>