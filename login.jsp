<%@ page language="java" contentType="text/html; charset=UTF-8/" pageEncoding="UTF-8"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title></title>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="style.css">
		<link href="https://fonts.googleapis.com/css?family=Kalam|Righteous" rel="stylesheet">
	</head>
	<body>
		<div id="container">
			<div class="form">
				<form id="loginform" method="POST" action="login">
					<h1>Welcome</h1>
					<div id="user">
						<input type="text" id="username" name="username" placeholder="Username" value="" autocomplete="off">
					</div>
					<div id="pass"><input type="password" id="password" name="password" placeholder="Password"></div>
					<div id="submitlogin"><input type="submit" id="login" value="Log In"></div>
					<div id="sid"></div>
				</form>
			</div>
		</div>
	</body>
</html>
