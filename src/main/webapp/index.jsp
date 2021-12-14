<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./css/common.css">
    <link rel="stylesheet" href="./css/index.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <title>COCO薬局</title>
</head>
<body id="body">
    <header class="site-header">
        <div class="logo_box">
            <a class="logo_text" href="./index.html">COCO薬局</a>
        </div>
        <nav>
            <ul class="menu_bar">
                <li class="menu_li_active">
                    <a href="./index.html" class="menu_a_active">ホーム</a>
                </li>
                <li><a href="./member/u08_01.html" >薬歴</a></li>
                <li><a href="./member/u09_01.html">会員QRコード</a></li>
                <li><a href="./member/u07_01.html" >子供情報</a></li>
                <li><a href="./member/u06_01.html" >マイページ</a></li>
            </ul>
        </nav>
        <div class="account_box">
            <input type="checkbox" id="account-btn-check">
            <label for="account-btn-check" id="account-btn-menu" class="account-btn"><span></span></label>
            <div class="account-content">
                <h2>ログインしてから利用できます。</h2>
                <ul>
                    <li>
                        <a href="./member/u02_01.html">ログイン</a>
                    </li>
                    <li>
                        <a href="./member/u01_01.html">会員登録</a>
                    </li>
                    <li class="menu_li_active">
                        <a href="./index.html" class="menu_a_active">ホーム</a>
                    </li>
                    <li><a href="./member/u08_01.html" >薬歴</a></li>
                    <li><a href="./member/u09_01.html">会員QRコード</a></li>
                    <li><a href="./member/u07_01.html" >子供情報</a></li>
                    <li><a href="./member/u06_01.html" >マイページ</a></li>
                </ul>
            </div>
            <a href="./member/u02_01.html" class="login_btn">ログイン</a><br>
            <a href="./member/u01_01.html" class="singup_btn">会員登録</a>
        </div>
    </header>
    <main>
        <div class="notice_con">
            <span>お知らせ</span>
            <a href="">暗証番号紛失に注意</a>
            <a href="">パスワードを忘れた場合</a>
            <a href="">コロナウィルス感染対策</a>
            <a href="">4</a>
            <a href="">5</a>
        </div>
        <div class="main_box">
            <article class="wrap_info_con">
                <div class="info_con">
                    <div class="subtitle">
                        <h2>初めての方</h2>
                    </div>
                    <div class="info_text">
                        <p>
                            電子お薬手帳は<a href="">会員登録</a>(無料)してから利用できます。<br>
                            <a href="">会員情報QRコード画面</a>にアクセスし<br>
                            自分のQRコードを見せることができます。<br>
                            <strong>問い合わせ</strong>は<a href="">こちら</a>を参照してください。
                        </p>
                    </div>
                    <div class="item_box">
                        <div class="subtitle">
                            <h2>電子薬手帳の使用方法</h2>
                        </div>
                        <div class="manual_box">
                            <div class="manual_title">
                                <span>メールアドレスで利用する</span>
                            </div>
                            <div class="manual_text">
                                <span>1.会員QRコード画面へ</span><br>
                                <span>2.QRコードを送信ボタンを押す</span><br>
                                <span>3.登録したメールにQRコード画像を見せる</span><br>
                            </div>
                        </div>
                        <div class="manual_box">
                            <div class="manual_title">
                                <span>ホームページにて利用する</span>
                            </div>
                            <div class="manual_text">
                                <span>1.会員QRコード画面へ</span><br>
                                <span>2.画面上のQRコードの画像を見せる</span>
                            </div>    
                        </div>
                        <div class="manual_box">
                            <div class="manual_title">
                                <span>携帯に保存した写真で利用する</span>
                            </div>
                            <div class="manual_text">
                                <span>1.携帯の写真のアプリを開く</span><br>
                                <span>2.保存されているQRコードを見せる</span>
                            </div> 
                        </div>
                    </div>
                </div>
            </article>
            <section class="menu_con">
                <div class="subtitle">
                    <h2>MENU一覧</h2>
                </div>
                <div class="menu_items">
                    <div class="menu_item_box">
                        <span class="item_title">会員QRコード</span><br>
                        <a href="./member/u09_01.html">メールにQRコードを送信する</a><br>
                    </div>
                    <div class="menu_item_box">
                        <span class="item_title">マイページ</span><br>
                        <a href="">個人情報確認</a><br>
                        <a href="">個人情報変更</a><br>
                        <a href="">退会</a>
                    </div>
                </div>
                <div class="menu_items">
                    <div class="menu_item_box">
                        <span class="item_title">子供情報</span><br>
                        <a href="">子供情報</a><br>
                        <a href="">子供情報登録</a><br>
                        <a href="">子供情報変更</a><br>
                    </div>
                    <div class="menu_item_box">
                        <span class="item_title">薬歴</span><br>
                        <a href="">過去の薬歴</a>
                    </div>
                </div>
                <div class="menu_items">
                    <div class="menu_item_box">
                        <span class="item_title">お知らせ</span><br>
                        <a href="">お知らせ</a>
                    </div>
                    <div class="menu_item_box">
                        <span class="item_title">問い合わせ</span><br>
                        <a href="">問い合わせ</a><br>
                        <a href="">よくあるQ&A</a>
                    </div>
                </div>
            </section>
        </div>
    </main>
    <footer>
        <div class="footer_link">
            <span><a href="../index.jsp">ホーム</a></span>
            <span><a href="">個人情報の取り扱いについて</a></span>
            <span><a href="">問い合わせ</a></span>
            <span><a href="">お知らせ</a></span>
            <span><a href="">会社情報</a></span>
        </div>
        <div class="footer_bottom">
            <span> Copyright &copy; 株式会社COCO薬局 All Rights Reserved.</span>
        </div>
        <div class="top_btn_con" id="top_btn_con">
            <button class="top_btn_text">⇧</button>
        </div>
    </footer>
</body>
<script type="text/javascript" src="./js/common.js"></script>
</html>

