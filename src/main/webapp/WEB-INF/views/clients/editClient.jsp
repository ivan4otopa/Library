<%@ taglib prefix="ct" uri="http://jwd.bg/tags" %>

<html>
<head>
	<title>Edit Client</title>
	<link href="resources/css/styles.css" rel="stylesheet">
</head>
<body>
	<ct:Header />
	<h1 id="header">Edit Client</h1>
	<div id="main-content">
	 	<form action="editClient" method="POST" modelAttribute="client">
	 		<input type="text" class="input-field" placeholder="Id..." name="id" required /><br />
	 		<input type="text" class="input-field" placeholder="Name..." name="name" required /><br />
	 		<input type="text" class="input-field" placeholder="PID..." name="pid" required /><br />
			<input type="date" class="input-field" name="dateOfBirth" required /><br />
	 		<input type="submit" id="submit-btn" value="Edit Client" />
	 		<button type="button" id="cancel-btn" onclick="location = '/library/clientRegistry'">Cancel</button>
	 	</form>
	 </div>
	 <ct:Footer />
</body>
</html>