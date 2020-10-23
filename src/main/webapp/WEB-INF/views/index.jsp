<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
	<!-- bootstrap.jsp 불러오기 -->
	<c:import url="./template/bootStrap.jsp"></c:import>
</head>
<body>
<!-- index.jsp 불러오기 -->

<c:import url="./template/header.jsp"></c:import>

<div class="container">
  <h3>Right Aligned Navbar</h3>
  	<div>
  		<c:if test="${not empty member}" >
  			<h1>Login Success</h1>
  		</c:if>
  		
		<c:if test="${empty member}">
			<h1>Login Fail</h1>
		</c:if>
		<img alt="image" src="./resources/images/common/mnzzy2.jpg" width="500px">
	</div>
  
</div>
</body>
</html>
