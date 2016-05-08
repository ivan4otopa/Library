<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ct" uri="http://jwd.bg/tags" %>

<html>
<head>
	<title>Login</title>
	<link href="resources/css/styles.css" rel="stylesheet">
</head>
<body>
	<h1 id="header">Login</h1>
	<div id="main-content">
		<form method="POST">
			<input type="text" class="input-field" placeholder="Username..." name="username" /><br />
			<input type="password" class="input-field" placeholder="Password..." name="password" /><br />
			<input type="submit" id="submit-btn" value="Login" />
		</form>	
	</div>
	<ct:Footer />
</body>
</html>