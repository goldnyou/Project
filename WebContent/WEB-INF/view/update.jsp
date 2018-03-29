<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	form{
		width:500px;
	}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> 
<script src="../js/common.js"></script>
<script>

$(function(){
	$("form[name='f2']").submit(function(){
					
		if( checkInputEmpty( $(this).find("input[name]")  ) == false){
			return false;
		}		
	});
})
</script>
</head>
<body>
	<jsp:include page="/WEB-INF/view/header.jsp"/>
	<form name="f2" action="update.do?serialNo=${project.serialNo}" method="post">
		<p>
			<label>프로젝트 이름</label>
			<input type="text" name="projectName" value="${project.projectName}">
		</p>
		<p>
			<label>프로젝트 내용</label>
			<textarea rows="10" cols="50" name="projectContent">${project.projectContent}</textarea>
		</p>
		<p>
			<label>시작 날짜</label>
			<input type="date" name="startDate" value="<fmt:formatDate value="${project.startDate}" pattern="yyyy-MM-dd"/>">
		</p>
		<p>
			<label>마감 날짜</label>
			<input type="date" name="endDate" value="<fmt:formatDate value="${project.endDate}" pattern="yyyy-MM-dd"/>">
		</p>
		<p>
			<label>상태</label>
			<select name="processStatus">
				<c:if test="${project.processStatus == '준비'}">
				   <option selected>준비</option>
				   <option>진행 중</option>
	               <option>종료</option>
	               <option>보류</option>
				</c:if>
				<c:if test="${project.processStatus == '진행 중'}">
				   <option>준비</option>
				   <option selected>진행 중</option>
	               <option>종료</option>
	               <option>보류</option>
				</c:if>
				<c:if test="${project.processStatus == '종료'}">
				   <option>준비</option>
				   <option>진행 중</option>
	               <option selected>종료</option>
	               <option>보류</option>
             	</c:if>  
				<c:if test="${project.processStatus == '보류'}">
				   <option>준비</option>
				   <option>진행 중</option>
	               <option>종료</option>
	               <option  selected>보류</option>
               </c:if>
               
			</select>			
		</p>
		<p>
			<input type="submit" value="수정">
			<a href="list.do"><input type="button" value="취소"></a>
		</p>
	</form>
	<jsp:include page="/WEB-INF/view/footer.jsp"/>

</body>
</html>










