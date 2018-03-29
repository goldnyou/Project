<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/common.css">
<style>
	form{
		width:500px;
	}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> 
<script src="../js/common.js"></script>
<script>

$(function(){
	$("form[name='f1']").submit(function(){
		if( checkInputEmpty( $(this).find("input[name]")  ) == false){
			return false;
		}		
	});
})
</script>
</head>
<body>
	<jsp:include page="/WEB-INF/view/header.jsp"/>
	<form name="f1" action="write.do" method="post">
		<p>
			<label>프로젝트 이름</label>
			<input type="text" name="projectName">
		</p>
		<p>
			<label>프로젝트 내용</label>
			<textarea rows="10" cols="50" name="projectContent"></textarea>
		</p>
		<p>
			<label>시작 날짜</label>
			<input type="date" name="startDate">
		</p>
		<p>
			<label>마감 날짜</label>
			<input type="date" name="endDate">
		</p>
		<p>
			<label>상태</label>
			<select name="processStatus">
               <option value="준비" selected="selected">준비</option>
               <option value="진행 중">진행 중</option>
               <option value="종료">종료</option>
               <option value="보류">보류</option>
			</select>			
		</p>
		<p>
			<input type="submit" value="저장">
			<a href="list.do"><input type="button" value="취소"></a>
		</p>
	</form>
	
	<jsp:include page="/WEB-INF/view/footer.jsp"/>

</body>
</html>










