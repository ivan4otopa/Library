<%@ taglib prefix="ct" uri="http://jwd.bg/tags" %>

<html>
<head>
	<title>Deactivate User</title>
	<link href="resources/css/styles.css" rel="stylesheet">
</head>
<body>
	<ct:Header />
	<h1 id="header">Deactivate User</h1>
	<div id="main-content">
	 	<form action="deactivateUser" method="POST">
	 		<input type="text" class="input-field" placeholder="Id..." name="id" required /><br />
	 		<input type="submit" id="submit-btn" value="Deactivate User" />
	 		<button type="button" id="cancel-btn" onclick="location = '/library/userRegistry'">Cancel</button>
	 	</form>
	 </div>
	 <ct:Footer />
</body>
</html>