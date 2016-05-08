<%@ taglib prefix="ct" uri="http://jwd.bg/tags" %>

<html>
<head>
	<title>Edit User</title>
	<link href="resources/css/styles.css" rel="stylesheet">
</head>
<body>
	<ct:Header />
	<h1 id="header">Edit User</h1>
	<div id="main-content">
	 	<form action="editUser" method="POST" modelAttribute="user">
	 		<input type="text" class="input-field" placeholder="Name..." name="name" required /><br />
	 		<input type="text" class="input-field" placeholder="Username..." name="username" required /><br />
	 		<input type="password" class="input-field" placeholder="password..." name="password" required /><br />
	 		<input type="hidden" name="hiddenUsername" value="${ hiddenUsername }" />	 
	 		<input type="submit" id="submit-btn" value="Edit User" />
	 		<button type="button" id="cancel-btn" onclick="location = '/library/userRegistry'">Cancel</button>
	 	</form>
	 </div>
	 <ct:Footer />
</body>
</html>