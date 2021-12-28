<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/common.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/member/u03.css">
    <title>パスワードを忘れた</title>
</head>
<body>
    <jsp:include page="../common/header.jsp"/>
    <main>
        <div class="main_con">
            <div class="subtitle">
                <h2>パスワードを忘れた</h2>
            </div>
            <p>パスワードを忘れた方は
            現在ご登録いただいているメールアドレスを入力してください。</p>
            <form method="POST" action="NonMemberController?action=u03_02">
            <div class="items">
                <label>
                    <div class="items_title">
                    	<span>メールアドレス</span>
                    </div>
                    <input type="email" name="mail" value="">
                </label>
            </div>
                <hr>
                <button type="button" onclick="location.href='NonMemberController?view=u02'">ログイン画面に戻る</button>
                <button type="submit">確定</button>
            </form>
        </div>
    </main>
	<jsp:include page="../common/footer.jsp"/>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/common.js"></script>

</html>