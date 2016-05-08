<%@ taglib prefix="ct" uri="http://jwd.bg/tags" %>

<html>
<head>
	<title>Delete Lend</title>
	<link href="resources/css/styles.css" rel="stylesheet">
</head>
<body>
	<ct:Header />
	<h1 id="header">Delete Lend</h1>
	<div id="main-content">
	 	<form action="deleteLend" method="POST">
	 		<input type="text" class="input-field" placeholder="Id..." name="id" required /><br />	 		
	 		<input type="submit" id="submit-btn" value="Delete Lend" />
	 		<button type="button" id="cancel-btn" onclick="location = '/library/lendRegistry'">Cancel</button>
	 	</form>
	 </div>
	 <ct:Footer />
</body>
</html>