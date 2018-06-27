<%@ page language="java" contentType="text/html; charset=UTF-8/" pageEncoding="UTF-8"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title></title>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="dashboard.css">
		<link href="https://fonts.googleapis.com/css?family=Noto+Sans|Sigmar+One" rel="stylesheet">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
		<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
		<script src="dashboard.js"></script>
	</head>
	<body>
		<%
			if(session.getAttribute("username")==null) {
				response.sendRedirect("login.jsp");
			}
		%>

		<div id="header">
			<div id="name">Residence</div>
			<div id="menubutton"><a id="menulink" href="#"><i class="fa fa-user-circle" style="font-size:24px"></i> ${username}</a></div>
			<div id="menu" class="hiddenmenu">
				<div class="menuitem"><a href="#">Profile</a></div>
				<div class="menuitem"><a href="#">Log out</a></div>
			</div>
			<div class="clear"></div>
		</div>
		<div class="sidebar">
			<p><a class="button" id="dashboard" name="dashboard" href="dashboard.jsp"><i class="w3-margin-left material-icons">home</i>Dashboard</a></p>
			<p><a class="button" id="account" name="account" href="account.jsp"><i class="fa fa-users"></i>Account</a></p>
			<p><a class="button" id="asset" name="asset" href="inventory.jsp"><i class="fa fa-folder-open"></i> Asset Inventory</a></p>
			<p><a class="button" id="logs" name="logs"><i class="fa fa-tasks"></i> Logs</a></p>
			<p><a class="button" id="report" name="report"><i class="material-icons">report</i> Report</a></p>
		</div>
		<div id="content">
		</div>
	</body>
</html>
