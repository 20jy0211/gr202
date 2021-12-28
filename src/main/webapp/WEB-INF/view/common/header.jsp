<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<header class="site-header">
    <div class="logo_box">
        <a class="logo_text" href="NonMemberController?view=index">COCO薬局</a>
    </div>
    <nav>
        <ul class="menu_bar">
            <li><a href="NonMemberController?view=index">ホーム</a></li>
            <li><a href="NonMemberController?view=u02">薬歴</a></li>
            <li><a href="NonMemberController?view=u02">My QRコード</a></li>
            <li><a href="NonMemberController?view=u02">子供情報</a></li>
            <li><a href="NonMemberController?view=u02">マイページ</a></li>
        </ul>
    </nav>
    <div class="account_box">
        <input type="checkbox" id="account-btn-check">
        <label for="account-btn-check" id="account-btn-menu" class="account-btn"><span></span></label>
        <div class="account-content">
            <h2>ログインしてから利用できます。</h2>
            <ul>
                <li>
                    <a href="NonMemberController?view=u02">ログイン</a>
                </li>
                <li>
                    <a href="NonMemberController?view=u01_01">会員登録</a>
                </li>
            </ul>
        </div>
        <a href="NonMemberController?view=u02" class="login_btn">ログイン</a><br>
        <a href="NonMemberController?view=u01_01" class="singup_btn">会員登録</a>
    </div>
</header>