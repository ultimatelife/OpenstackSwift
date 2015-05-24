<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	SimpleDateFormat simple = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
	<div class="container" style="text-align: center;">
		<h1>Smart Door By SUDO</h1>
</div>

<div class="container">
	<div class="container" style="text-align: center;">
		<h2>Opend nad Closed Time</h2>
	</div>
		
	<table class="table" style="border-color: aqua;">

	    <thead>
	      <tr style="text-align: center; color: green;">
	        <th>Num</th>
	        <th>Open Time</th>
	        <th>Closed Time</th>
	        <th>Visit Type</th>
	      </tr>
	    </thead>
	     
	    <tbody>
		    <c:forEach items="${list}" var="dto">
		    	<tr class="success">
		        <td>${dto.num}</td>
		        <td>${dto.open_time}</td>
		        <td>${dto.closed_time}</td>
		        <td>${dto.visit_type}</td>
		      </tr>
		    </c:forEach>
	    </tbody>
    
  </table>
	
</div>

</body>
</html>