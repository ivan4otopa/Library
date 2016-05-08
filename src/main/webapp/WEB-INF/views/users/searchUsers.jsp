<%@ taglib prefix="ct" uri="http://jwd.bg/tags" %>

<html>
<head>
	<title>Search Users</title>
	<link href="resources/css/styles.css" rel="stylesheet">
	<script src="https://code.jquery.com/jquery-1.12.3.min.js"></script>
</head>
<body>
	<ct:Header />
	<h1 id="header">Search Users</h1>
	<div id="main-content">
		<form action="searchUsers" method="POST">
			<input type="radio" class="radio-btn" id="username" name="criteria" value="username" /> <label for="username">Username</label><br />
			<input type="radio" class="radio-btn" id="name" name="criteria" value="name" /> <label for="name">Name</label><br />
			<input type="radio" class="radio-btn" id="type" name="criteria" value="type" /> <label for="type">Type</label><br />
			<input type="radio" class="radio-btn" id="status" name="criteria" value="status" /> <label for="status">Status</label><br />
			<input type="text" class="input-field" placeholder="Value..." /><br />
			<input type="radio" class="type-radio-btn" id="admin" value="admin"/> <label class="type-label" for="admin">Admin</label><br />
			<input type="radio" class="type-radio-btn" id="user" value="user"/> <label class="type-label" for="user">User</label><br />
			<input type="submit" id="submit-btn" value="Search" />
			<button type="button" id="cancel-btn" onclick="location = '/library/userRegistry'">Cancel</button>
		</form>		
	</div>
	<ct:Footer />
	<script src="resources/js/changeInputTypeEventUser.js"></script>
</body>
</html>