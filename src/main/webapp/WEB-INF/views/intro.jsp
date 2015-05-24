<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
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

  
    <div class="progress">
    <div class="progress-bar" role="progressbar" aria-valuenow="100" aria-valuemin="100" aria-valuemax="100" style="width:100%">
      <span class="sr-only">70% Complete</span>
    </div>
  </div>
  
  <div class="list-group">
  	
  	<!-- <td><a href="delete?mId=${dto.mId}">X</a></td> -->
  	
    <a href="OpenClosedDate" class="list-group-item " >
      <h4 class="list-group-item-heading" style="text-align: center;">OPEN AND CLOSED TIME</h4>
    </a>
    
	<a class="list-group-item " >
      <h4 class="list-group-item-heading"></h4>
    </a>
    
      <div class="progress">
    <div class="progress-bar" role="progressbar" aria-valuenow="100" aria-valuemin="100" aria-valuemax="100" style="width:100%">
      <span class="sr-only">70% Complete</span>
    </div>
  </div>
    
    <a href="RegularVisitant" class="list-group-item ">
      <h4 class="list-group-item-heading" style="text-align: center;">Management Regular Visitant</h4>
    </a>
  </div>
</div>

</body>
</html>
