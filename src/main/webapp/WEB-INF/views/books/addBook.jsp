<%@ taglib prefix="ct" uri="http://jwd.bg/tags" %>

<html>
<head>
	<title>Add Book</title>
	<link href="resources/css/styles.css" rel="stylesheet">
</head>
<body>
	<ct:Header />
	<h1 id="header">Add Book</h1>
	<div id="main-content">
	 	<form action="addBook" method="POST" modelAttribute="book">
	 		<input type="text" class="input-field" placeholder="Name..." name="name" required /><br />
	 		<input type="text" class="input-field" placeholder="Author..." name="author" required /><br />
			<input type="text" class="input-field" placeholder="Year Of Publishing..." name="yearOfPublishing" required /><br />
	 		<input type="submit" id="submit-btn" value="Add Book" />
	 		<button type="button" id="cancel-btn" onclick="location = '/library/bookRegistry'">Cancel</button>
	 	</form>
	 </div>
	 <ct:Footer />
</body>
</html>