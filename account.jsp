<%@ page language="java" contentType="text/html; charset=UTF-8/" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="src.*"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
		<title></title>
		<meta charset="UTF-8"/>
		<link rel="stylesheet" href="dashboard.css"/>
		<link href="https://fonts.googleapis.com/css?family=Kalam|Righteous" rel="stylesheet"/>
		<link href="https://fonts.googleapis.com/css?family=Noto+Sans|Sigmar+One" rel="stylesheet"/>
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"/>
		<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css"/>
		<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons"/>
		<link rel="stylesheet" href="account.css"/>
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
		<h2><font><strong>Accounts List</strong></font></h2>
		<div class="box">
			<a class="button" href="#popup1"><i class="fa fa-user-plus" style="font-size:24px"></i> Create Account</a>
		</div>
		<div id="popup1" class="overlay">
			<div class="popup">
				<form id="signupform" method="POST" action="adduser">
				<h1>Add user</h1>
				<div id="user"><input type="text" id="username" name="username" placeholder="Username" autocomplete="off" required /></div>
				<div id="email"><input type="text" id="emailadd" name="email" placeholder="Email" required /></div>
				<div id="role_field"><input type="text" id="role" name="role" placeholder="Role" required /></div>
				<div id="status_field"><input type="text" id="status" name="status" placeholder="Status" required /></div>
				<div id="pass"><input type="password" id="password" name="password" placeholder="Password" required /></div>
				<div id="repass"><input type="password" id="repassword" name="repassword" placeholder="Re-enter Password" required /></div>
				<div id="date_field"><input type="text" id="date" name="date" placeholder="Date" required /></div>
				<div id="submitlogin"><input type="submit" id="addUser" value="Add user" /></div>
				<div id="canceladd"><input type="submit" id="cancelAdd" value="Cancel" formnovalidate /></div>
				</form>
			</div>
		</div>
		<div class="table">
			<div class="table-row" id="header">
				<div class="table-cell">Id</div>
				<div class="table-cell">Username</div>
				<div class="table-cell">Email</div>
				<div class="table-cell">Role</div>
				<div class="table-cell">Status</div>
				<div class="table-cell">Date</div>
				<div class="table-cell">Options</div>
			</div>
			<%
				AccountsListDatabase ald = new AccountsListDatabase();
				AccountCollection ac = ald.getAccountCollection();
				ArrayList<Account> account = ac.getAllAccounts();
				for(Account a : account) {
			%>
			<div id="popup2" class="overlay1">
				<div class="popup1">
					<form id="deleteUser" method="GET" action="deleteuser">
						<p>Delete user?</p>
						<input type="hidden" value="<%= a.getId() %>" name="userid">
						<div id="yes_field"><input type="submit" id="okay" value="Ok"/></div>
						<div id="cancel_field"><input type="submit" id="cancel" value="Cancel"/></div>
					</form>
				</div>
			</div>
			<div class="table-row">
				<div class="table-cell"><%= a.getId() %></div>
				<div class="table-cell"><%= a.getUsername() %></div>
				<div class="table-cell"><%= a.getEmail() %></div>
				<div class="table-cell"><%= a.getRole() %></div>
				<div class="table-cell"><%= a.getStatus() %></div>
				<div class="table-cell"><%= a.getDate() %></div>
				<div class="table-cell" id="box1">
				<a class="button" href="#popup2">
				<i class="fa fa-user-times" style="font-size:24px"></i>
				</a>
				<a class="button" id="edit" href="#">
				<i class="material-icons">edit</i>
				</a>
				</div>
			</div>
			<%}%>
		</div>
	</div>
	</body>
</html>
