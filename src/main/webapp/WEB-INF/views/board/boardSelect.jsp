<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/bootStrap.jsp"></c:import>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
<div class="container">
  <h3>${board} Select Page</h3>
  <h3 id="num">${one.num}</h3>
  <h3>Title : ${one.title}</h3>
  <h3>Writer : ${one.writer}</h3>
  <h3>Contents : ${one.contents}</h3>
  <input type="button" title="${one.num}" value="Delete" class="btn btn-warning" id="del">
  <input type="button" class="btn btn-primary" value="Update" id="update">
</div>

<script type="text/javascript">
	//$("css선택자").action();
	$("#update").click(function() {
		location.href="./noticeUpdate?num=${dto.num}";
	});
	
	$("#del").click(function() {
		//var num = $("#num").html();
		var num = $(this).attr("title");
		alert(num);
		location.href="./noticeDelete?num="+num;
	});

</script>


</body>
</html>