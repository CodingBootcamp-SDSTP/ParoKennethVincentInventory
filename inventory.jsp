<%@page import="java.sql.DriverManager"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="src.*"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title></title>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="dashboard.css">
		<link href="https://fonts.googleapis.com/css?family=Kalam|Righteous" rel="stylesheet">
		<link href="https://fonts.googleapis.com/css?family=Noto+Sans|Sigmar+One" rel="stylesheet">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
		<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
		<link rel="stylesheet" href="inventory.css">
		<script src='dashboard.js'></script>
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
		<div id="container">
		<h2 align="center"><font><strong>Residence Lots Inventory</strong></font></h2>
		<form id="accountTable" method="GET" action="inventorylist">
		<p><button class="button" id="
		accountbutton"><i class="fa fa-folder-open"></i> Asset Inventory</button></p>
		</form>
		<div class="table">
			<div class="table-row" id="header">
				<div class="table-cell">List Price</div>
				<div class="table-cell">Sale Price</div>
				<div class="table-cell">House Type</div>
				<div class="table-cell">Lot Area</div>
				<div class="table-cell">Bedroom</div>
				<div class="table-cell">Toilet</div>
				<div class="table-cell">Carport</div>
				<div class="table-cell">Balcony</div>
				<div class="table-cell">Available Lots</div>
			</div>
		<%
			AccountsListDatabase ald = new AccountsListDatabase();
			InventoryCollection ic = ald.getInventoryCollection();
			ArrayList<Inventory> inventory = ic.getAllInventory();
			for(Inventory i : inventory) {
		%>
		<div class="table-row">
			<div class="table-cell"><%= i.getListPrice() %></div>
			<div class="table-cell"><%= i.getSaleprice() %></div>
			<div class="table-cell"><%= i.getHouseType() %></div>
			<div class="table-cell"><%= i.getLotArea() %></div>
			<div class="table-cell"><%= i.getBedroom() %></div>
			<div class="table-cell"><%= i.getToilet() %></div>
			<div class="table-cell"><%= i.getCarport() %></div>
			<div class="table-cell"><%= i.getBalcony() %></div>
			<div class="table-cell"><%= i.getAvailable() %></div>
		</div>
		<%}%>
		</div>
	</body>
</html>
