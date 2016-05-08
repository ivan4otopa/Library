<%@ taglib prefix="ct" uri="http://jwd.bg/tags" %>

<html>
<head>
	<title>Delete Client</title>
	<link href="resources/css/styles.css" rel="stylesheet">
</head>
<body>
	<ct:Header />
	<h1 id="header">Delete Client</h1>
	<div id="main-content">
	 	<form action="deleteClient" method="POST">
	 		<input type="text" class="input-field" placeholder="Id..." name="id" required /><br />	 		
	 		<input type="submit" id="submit-btn" value="Delete Client" />
	 		<button type="button" id="cancel-btn" onclick="location = '/library/clientRegistry'">Cancel</button>
	 	</form>
	 </div>
	 <ct:Footer />
</body>
</html>