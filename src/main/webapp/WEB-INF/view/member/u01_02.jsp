<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <form class="form" action="MemberController" method="POST">
            	<input type="hidden" name="action" value="u01_02">
                <h3 class="registTitle">入力内容確認</h3>
                <table class="registTable" border="1">
	                <tr>
	                    <th><label>メールアドレス</label></th>
	                    <td>
	                    	<c:out value="${member.m_email }"></c:out>
	                    </td>
	                </tr>
	                <tr>
	                    <th><label>名前</label></th>
	                    <td>
	                    	<c:out value="${member.m_name }"></c:out>
	                    </td>
	                </tr>
	                <tr>
	                    <th><label>名前(ふりがな)</label></th>
	                    <td>
	                    	<c:out value="${member.m_kana }"></c:out>
	                    </td>
	                </tr>
	                <tr>
	                    <th><label>性別</label></th>
	                    <td>
	                    	${member.m_gender }
	                    </td>
	                </tr>
	                <tr class="birthday">
	                    <th><label>生年月日</label></th>
	                    <td>
	                    	<c:out value="${member.m_brith }"></c:out>
	                    </td>
	                </tr>
	                <tr>
	                    <th><label>電話番号</label></th>
	                    <td>
	                    	<c:out value="${member.m_tel }"></c:out>
	                    </td>
	                </tr>
	                <tr class="postnum">
	                    <th><label>郵便番号</label></th>
	                    <td>
	                    	<c:out value="${member.m_zip_code }"></c:out>
	                    </td>
	                </tr>
	                <tr>
	                    <th><label>住所</label></th>
	                    <td>
	                    	<c:out value="${member.m_address }"></c:out>
	                    </td>
	                </tr>
	                <tr>
	                    <th>
	                        <label>保険証記号</label>
	                    </th>
	                    <td>
	                    	<c:out value="${member.m_i_mark }"></c:out>
	                    </td>
	                </tr>
	                <tr>
	                    <th>
	                        <label>保険証番号</label>
	                    </th>
	                    <td>
	                    	<c:out value="${member.m_i_num }"></c:out>
	                    </td>
	                </tr>
	                <tr>
	                    <th>
	                        <label>保険証有効期限</label>
	                    </th>
	                    <td class="hoken_td">
	                    	<c:out value="${member.m_i_expiry_date }"></c:out>
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
                        	<c:out value="${questionnaire.q_blood_type }"></c:out>
                        </td>
                    </tr>
                    <tr>
                        <th>
                            <label class="itemTitle">今までにかかった病気</label>
                        </th>
                        <td>
                       	    <c:out value="${questionnaire.q_medical_history}"></c:out>
                        </td>
                    </tr>
                    <tr>
                        <th>
                            <label class="itemTitle">服用中のお薬</label>
                        </th>
                        <td>
                        	<c:out value="${questionnaire.q_sick_diray }" />
                        </td>
                    </tr>
                    <tr>
                        <th>
                            <label class="itemTitle">飲酒</label>
                        </th>
                        <td>
	                        <c:if test="${questionnaire.q_drink eq true}">
	                            <c:out value="あり"></c:out>
	                        </c:if>
	                        <c:if test="${questionnaire.q_drink eq false}">
	                            <c:out value="なし"></c:out>
	                        </c:if>
                        </td>
                    </tr>
                    <tr>
                        <th>
                            <label class="itemTitle">喫煙</label>
                        </th>
                        <td>
                            <c:if test="${questionnaire.q_smoke eq true}">
                            	<c:out value="あり"></c:out>
                        	</c:if>
                        	<c:if test="${questionnaire.q_smoke eq false}">
                            	<c:out value="なし"></c:out>
                        	</c:if>
                        </td>
                    </tr>
                    <tr>
                        <th>
                            <label class="itemTitle">妊娠</label>
                        </th>
                        <td>
                            <c:if test="${questionnaire.q_pregnancy eq true}">
                            	<c:out value="あり"></c:out>
                        	</c:if>
                        	<c:if test="${questionnaire.q_pregnancy eq false}">
                            	<c:out value="なし"></c:out>
                        	</c:if>
                        </td>
                    </tr>
                    <tr>
                        <th>
                            <label class="itemTitle">アレルギー情報</label>
                        </th>
                        <td>
                           	<c:out value="${questionnaire.q_allergy }" />
                        </td>
                    </tr>
                </table>
                </div>
                <section class="twobtns">
                    <input type="button" onclick="location.href='MemberController?view=u01_01'" value="戻る">
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