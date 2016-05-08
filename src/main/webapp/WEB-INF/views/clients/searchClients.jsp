<%@ taglib prefix="ct" uri="http://jwd.bg/tags" %>

<html>
<head>
	<title>Search Clients</title>
	<link href="resources/css/styles.css" rel="stylesheet">
	<script src="https://code.jquery.com/jquery-1.12.3.min.js"></script>
</head>
<body>
	<ct:Header />
	<h1 id="header">Search Clients</h1>
	<div id="main-content">
		<form action="searchClients" method="POST">
			<input type="radio" class="radio-btn" id="name" name="criteria" value="name" /> <label for="name">Name</label><br />
			<input type="radio" class="radio-btn" id="pid" name="criteria" value="pid" /> <label for="pid">PID</label><br />
			<input type="radio" class="radio-btn" id="dateOfBirth" name="criteria" value="dateOfBirth" /> <label for="dateOfBirth">Date Of Birth</label><br />
			<input type="text" class="input-field" placeholder="Value..." /><br />
			<input type="date" class="input-field" /><br />
			<input type="submit" id="submit-btn" value="Search" />
			<button type="button" id="cancel-btn" onclick="location = '/library/clientRegistry'">Cancel</button>
		</form>
	</div>
	<ct:Footer />	
	<script src="resources/js/changeInputTypeEventClient.js"></script>
</body>
</html>