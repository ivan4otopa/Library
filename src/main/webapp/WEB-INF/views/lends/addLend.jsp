<%@ taglib prefix="ct" uri="http://jwd.bg/tags" %>

<html>
<head>
	<title>Add Lend</title>
	<link href="resources/css/styles.css" rel="stylesheet">
</head>
<body>
	<ct:Header />
	<h1 id="header">Add Lend</h1>
	<div id="main-content">
	 	<form action="addLend" method="POST" modelAttribute="lend">
	 		<input type="text" class="input-field" placeholder="Book Id..." name="bookId" required /><br />
	 		<input type="text" class="input-field" placeholder="Client Id..." name="clientId" required /><br />
			<input type="text" class="input-field" placeholder="Period..." name="period" required /><br />
			<input type="date" class="input-field" name="dateOfLending" required /><br />
	 		<input type="submit" id="submit-btn" value="Add Lend" />
	 		<button type="button" id="cancel-btn" onclick="location = '/library/lendRegistry'">Cancel</button>
	 	</form>
	 </div>
	 <ct:Footer />
</body>
</html>