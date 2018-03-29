<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#container{
		width:700px;
		margin:0 auto;
	}
	#container p{
		text-align: right;
	}
	table{
		width:700px;
		border:1px solid black;
		border-collapse: collapse;
	}
	td, th{
		padding:5px;
		border:1px solid black;
		border-collapse: collapse;
		text-align: center;
	}
	.title{
		width:300px;
		text-align: left;
	}
</style>
</head>
<body>
	<jsp:include page="/WEB-INF/view/header.jsp"/>

	<div id="container">
		<p>
			<a href="write.do">[새 프로젝트 등록]</a>
		</p>
		
		<table>
		<tr>
			<th>프로젝트 이름</th>
			<th>시작 날짜</th>
			<th>종료 날짜</th>
			<th>상태</th>
		</tr>
		<c:forEach var="item" items="${list }" >
			<tr>
				<td class="title"><a href="read.do?serialNo=${item.serialNo}">${item.projectName }</a></td>
				<td><fmt:formatDate value="${item.startDate }" pattern="yyyy.MM.dd" /></td>
				<td><fmt:formatDate value="${item.endDate }" pattern="yyyy.MM.dd" /></td>
				<td>${item.processStatus }</td>
			</tr>
		</c:forEach>
		</table>
	</div>
	
	<jsp:include page="/WEB-INF/view/footer.jsp"/>
	


</body>
</html>





