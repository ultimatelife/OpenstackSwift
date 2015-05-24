<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script type="text/javascript">
	function submitform() {
		document.myform.submit();
	}
</script>

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

			<div class="container" style="text-align: right;">
				<button type="button" class="btn btn-info btn-lg"
					data-toggle="modal" data-target="#myModalInsert">ADD</button>
			</div>


			<table class="table" style="border-color: aqua;">

				<thead>
					<tr style="text-align: center; color: green;">
						<th>Num</th>
						<th>Name</th>
						<th>Cell Phone</th>
						<th>Start Time</th>
						<th>End Time</th>
						<th>QR CODE</th>
						<th>Option</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach items="${list}" var="dto">
						<tr class="success">
							<td>${dto.num}</td>
							<td>${dto.name}</td>
							<td>${dto.cellphone}</td>
							<td>${dto.start_time}</td>
							<td>${dto.end_time}</td>
							<td>${dto.qr_code}</td>
							<td>
								<div class="dropdown">
									<button class="btn btn-primary dropdown-toggle" type="button"
										data-toggle="dropdown">
										OPTION <span class="caret"></span>
									</button>
									<ul class="dropdown-menu">
										
										<li>
											<button type="button" class="btn btn-info btn-lg"
												data-toggle="modal" data-target="#myModal">Alter
											</button>
										</li>
										<li>
											<form action="RegularVisitant/Delete" method="post">
												<input type="hidden" name="num" id="num" value="${dto.num}" />
												<input type="submit" class="btn btn-info btn-lg"  value="Delete">
											</form>
										</li>

									</ul>
								</div>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

			<!-- Modal -->
			<div class="modal fade" id="myModal" role="dialog"
				style="color: white-space:;">
				<div class="modal-dialog modal-lg" style="background-color: lime;">

					<!-- Modal content-->

					<form class="form-horizontal" role="form" method="post"
						action="RegularVisitant/Update">
						<div class="form-group">
							<div class="modal-body">
								<div class="form-group">
									<div class="container">
										<label class="col-sm-2 control-label">Num</label>
										<div class="col-sm-2">
											<input class="form-control" name="num" type="text" value="">
										</div>
									</div>
								</div>
							</div>

							<div class="modal-body">
								<div class="container">
									<label class="col-sm-2 control-label">Name</label>
									<div class="col-sm-2">
										<input class="form-control" name="name" type="text" value="">
									</div>
									<label class="col-sm-2 control-label">CellPhone</label>
									<div class="col-sm-2">
										<input class="form-control" name="cellphone" type="text"
											value="">
									</div>
								</div>
							</div>

							<div class="modal-body">
								<div class="container">
									<label class="col-sm-2 control-label">Start Time</label>
									<div class="col-sm-2">
										<input class="form-control" name="start_time" type="text"
											value="">
									</div>
									<label class="col-sm-2 control-label">End Time</label>
									<div class="col-sm-2">
										<input class="form-control" name="end_time" type="text"
											value="">
									</div>
								</div>
							</div>

							<div class="modal-body">
								<div class="container">
									<label class="col-sm-2 control-label">QR CODE</label>
									<div class="col-sm-2">
										<input class="form-control" name="qr_code" type="text"
											value="">
									</div>
								</div>
							</div>



							<div class="modal-footer">
								<!-- 
							<button type="button" class="btn btn-default"
								data-dismiss="modal">Close</button>
							 -->
								<input type="submit" class="btn btn-default"
									action="RegularVisitant/Update" method="post" value="Send" />
							</div>
						</div>
					</form>
				</div>

			</div>

			<div class="modal fade" id="myModalInsert" role="dialog"
				style="color: white-space:;">
				<div class="modal-dialog modal-lg" style="background-color: lime;">

					<!-- Modal content-->

					<form class="form-horizontal" role="form" method="post"
						action="RegularVisitant/Insert">
						<div class="form-group">
							<div class="modal-body">
								<div class="form-group">
									<div class="container">
										<label class="col-sm-2 control-label">Num</label>
										<div class="col-sm-2">
											<input class="form-control" name="num" type="text" value="">
										</div>
									</div>
								</div>
							</div>

							<div class="modal-body">
								<div class="container">
									<label class="col-sm-2 control-label">Name</label>
									<div class="col-sm-2">
										<input class="form-control" name="name" type="text" value="">
									</div>
									<label class="col-sm-2 control-label">CellPhone</label>
									<div class="col-sm-2">
										<input class="form-control" name="cellphone" type="text"
											value="">
									</div>
								</div>
							</div>

							<div class="modal-body">
								<div class="container">
									<label class="col-sm-2 control-label">Start Time</label>
									<div class="col-sm-2">
										<input class="form-control" name="start_time" type="text"
											value="">
									</div>
									<label class="col-sm-2 control-label">End Time</label>
									<div class="col-sm-2">
										<input class="form-control" name="end_time" type="text"
											value="">
									</div>
								</div>
							</div>

							<div class="modal-body">
								<div class="container">
									<label class="col-sm-2 control-label">QR CODE</label>
									<div class="col-sm-2">
										<input class="form-control" name="qr_code" type="text"
											value="">
									</div>
								</div>
							</div>



							<div class="modal-footer">
								<!-- 
							<button type="button" class="btn btn-default"
								data-dismiss="modal">Close</button>
							 -->
								<input type="submit" class="btn btn-default"
									action="RegularVisitant/Insert" method="post" value="Send" />
							</div>
						</div>
					</form>
				</div>

			</div>
		</div>
	</div>
</body>
</html>