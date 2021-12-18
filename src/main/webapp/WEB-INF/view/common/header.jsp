<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<header class="site-header">
    <div class="logo_box">
        <a class="logo_text" href="${pageContext.request.contextPath}/index.jsp">COCO薬局</a>
    </div>
    <nav>
        <ul class="menu_bar">
            <li><a href="${pageContext.request.contextPath}/index.jsp">ホーム</a></li>
            <li><a href="MemberController?view=u02_01">薬歴</a></li>
            <li><a href="MemberController?view=u02_01">会員QRコード</a></li>
            <li><a href="MemberController?view=u02_01">子供情報</a></li>
            <li><a href="MemberController?view=u02_01">マイページ</a></li>
        </ul>
    </nav>
    <div class="account_box">
        <input type="checkbox" id="account-btn-check">
        <label for="account-btn-check" id="account-btn-menu" class="account-btn"><span></span></label>
        <div class="account-content">
            <h2>ログインしてから利用できます。</h2>
            <ul>
                <li>
                    <a href="MemberController?view=u02_01">ログイン</a>
                </li>
                <li>
                    <a href="MemberController?view=u01_01">会員登録</a>
                </li>
            </ul>
        </div>
        <a href="MemberController?view=u02_01" class="login_btn">ログイン</a><br>
        <a href="MemberController?view=u01_01" class="singup_btn">会員登録</a>
    </div>
</header>