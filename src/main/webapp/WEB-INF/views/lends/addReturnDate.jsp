<%@ taglib prefix="ct" uri="http://jwd.bg/tags" %>

<html>
<head>
	<title>Add Return Date</title>
	<link href="resources/css/styles.css" rel="stylesheet">
</head>
<body>
	<ct:Header />
	<h1 id="header">Add Return Date</h1>
	<div id="main-content">
		<form action="addReturnDate" method="POST">
			<input type="text" class="input-field" name="id" placeholder="Id..." /><br />
			<input type="date" class="input-field" name="returnDate" /><br />
			<input type="submit" id="submit-btn" value="Add Return Date" />
			<button type="button" id="cancel-btn" onclick="location = '/library/lendRegistry'">Cancel</button>
		</form>
	</div>
	<ct:Footer />
</body>
</html>