<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<style>
	table{
		width:500px;
		border:1px solid black;
		border-collapse: collapse;
	}
	td{
		border:1px solid black;
		border-collapse: collapse;
		padding:5px;
	}
	
</style>
<script>
	$(function(){
		$("#delete").click(function(){
			var check = confirm("정말로 삭제하시겠습니까?");
			if(!check){
				return false;
			}
		})
	})
</script>
</head>
<body>
	<jsp:include page="/WEB-INF/view/header.jsp"/>
	<table>
		<tr>
			<td>프로젝트 이름</td>
			<td>${project.projectName }</td>
		</tr>
		<tr>
			<td>프로젝트 내용</td>
			<td>${project.projectContent }</td>
		</tr>
		<tr>
			<td>시작 날짜</td>
			<td><fmt:formatDate value="${project.startDate}" pattern="yyyy-MM-dd"/></td>
			
		</tr>
		<tr>
			<td>종료 날짜</td>
			<td><fmt:formatDate value="${project.endDate}" pattern="yyyy-MM-dd"/></td>
		</tr>
		<tr>
			<td>상태</td>
			<td>${project.processStatus }</td>
		</tr>
	</table>
	
	<p>
		<a href="update.do?serialNo=${project.serialNo}">[수정]</a>
		<a id="delete" href="delete.do?serialNo=${project.serialNo}">[삭제]</a>
		<a href="list.do">[돌아가기]</a>
	</p>
	
	<jsp:include page="/WEB-INF/view/footer.jsp"/>

</body>
</html>