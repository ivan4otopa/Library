<%@ taglib prefix="ct" uri="http://jwd.bg/tags" %>

<html>
<head>
	<title>Add User</title>
	<link href="resources/css/styles.css" rel="stylesheet">
</head>
<body>
	<ct:Header />
	<h1 id="header">Add User</h1>
	<div id="main-content">
	 	<form action="addUser" method="POST" modelAttribute="user">
	 		<input type="text" class="input-field" placeholder="Username..." name="username" required /><br />
	 		<input type="password" class="input-field" placeholder="Password..." name="password" required /><br />
	 		<input type="text" class="input-field" placeholder="Name..." name="name" required /><br />
	 		<input type="radio" id="isAdmin" name="isAdmin" value="true" /> <label for="isAdmin">Admin</label><br />
	 		<input type="submit" id="submit-btn" value="Add User" />
	 		<button type="button" id="cancel-btn" onclick="location = '/library/userRegistry'">Cancel</button>
	 	</form>
	 </div>
	 <ct:Footer />
</body>
</html>