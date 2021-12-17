<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/common.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/index.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <title>COCO薬局</title>
</head>
<body id="body">
	<c:choose>
		<c:when test="${sessionScope.member ne null }">
			<jsp:include page="./WEB-INF/common_view/member/header.jsp"/>
			<jsp:include page="./WEB-INF/common_view/member/main.jsp"/>
		</c:when>
		<c:when test="${sessionScope.pharmacy ne null }">
			<jsp:include page="./WEB-INF/common_view/pharmacy/header.jsp"/>
			<jsp:include page="./WEB-INF/common_view/pharmacy/main.jsp"/>
		</c:when>
		<c:when test="${sessionScope.doctor ne null }">
			<jsp:include page="./WEB-INF/common_view/doctor/header.jsp"/>
			<jsp:include page="./WEB-INF/common_view/doctor/main.jsp"/>
		</c:when>
		<c:when test="${sessionScope.hospital ne null }">
			<jsp:include page="./WEB-INF/common_view/hospital/header.jsp"/>
			<jsp:include page="./WEB-INF/view/hospital/u12.jsp"/>
		</c:when>
		 <c:otherwise>
		 	<jsp:include page="./WEB-INF/common_view/header.jsp"/>
			<jsp:include page="./WEB-INF/common_view/main.jsp"/>
    	</c:otherwise>
	</c:choose>
	
	<!-- FOOTER -->
    <jsp:include page="./WEB-INF/common_view/footer.jsp"/>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/common.js"></script>
</html>

