<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<header class="site-header">
    <div class="logo_box">
        <a class="logo_text" href="${pageContext.request.contextPath}/index.jsp">COCO薬局</a>
    </div>
    <nav>
        <ul class="menu_bar">
            <li><a href="${pageContext.request.contextPath}/index.jsp" >ホーム</a></li>
            <li><a href="./u10_01_doctor.jsp">会員検索</a></li>
            <li><a href="./u06_01_doctor.jsp">マイページ</a></li>
        </ul>
    </nav>
    <div class="account_box">
        <input type="checkbox" id="account-btn-check">
        <label for="account-btn-check" id="account-btn-menu" class="account-btn"><span></span></label>
        <div class="account-content">
            <h2>ログインしてから利用できます。</h2>
            <ul>
                <li><a href="${pageContext.request.contextPath}/index.jsp" >ホーム</a></li>
	            <li><a href="./u10_01_doctor.jsp">会員検索</a></li>
	            <li><a href="./u06_01_doctor.jsp">マイページ</a></li>
                <li><a href="../member/u02_01.jsp">ログアウト</a></li>
            </ul>
        </div>
        <a href="../member/u04.jsp" class="logout_btn">ログアウト</a><br>
    </div>
</header>