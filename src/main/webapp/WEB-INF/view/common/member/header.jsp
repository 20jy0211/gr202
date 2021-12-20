<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<header class="site-header">
    <div class="logo_box">
        <a class="logo_text" href="MemberController?view=index">COCO薬局</a>
    </div>
    <nav>
        <ul class="menu_bar">
            <li><a href="MemberController?view=index">ホーム</a></li>
            <li><a href="MemberController?view=u08_01">薬歴</a></li>
            <li><a href="MemberController?view=u09_01">会員QRコード</a></li>
            <li><a href="MemberController?view=u07_01">子供情報</a></li>
            <li><a href="MemberController?view=u06_01">マイページ</a></li>
        </ul>
    </nav>
    <div class="account_box">
        <input type="checkbox" id="account-btn-check">
        <label for="account-btn-check" id="account-btn-menu" class="account-btn"><span></span></label>
        <div class="account-content">
            <h2>ログインしてから利用できます。</h2>
            <ul>
                <li>
                    <a href="MemberController?view=u04.jsp">ログアウト</a>
                </li>
                <li><a href="MemberController?view=index">ホーム</a></li>
	            <li><a href="MemberController?view=u08_01">薬歴</a></li>
	            <li><a href="MemberController?view=u09_01">会員QRコード</a></li>
	            <li><a href="MemberController?view=u07_01">子供情報</a></li>
	            <li><a href="MemberController?view=u06_01">マイページ</a></li>
            </ul>
        </div>
        <a href="../member/u04.jsp" class="logout_btn">ログアウト</a><br>
    </div>
</header>