<%@ taglib prefix="ct" uri="http://jwd.bg/tags" %>

<html>
<head>
	<title>Edit Book</title>
	<link href="resources/css/styles.css" rel="stylesheet">
</head>
<body>
	<ct:Header />
	<h1 id="header">Edit Book</h1>
	<div id="main-content">
	 	<form action="editBook" method="POST" modelAttribute="book">
	 		<input type="text" class="input-field" placeholder="Id..." name="id" required /><br />
	 		<input type="text" class="input-field" placeholder="Name..." name="name" required /><br />
	 		<input type="text" class="input-field" placeholder="Author..." name="author" required /><br />
			<input type="text" class="input-field" placeholder="Year Of Publishing..." name="yearOfPublishing" required /><br />
	 		<input type="submit" id="submit-btn" value="Edit Book" />
	 		<button type="button" id="cancel-btn" onclick="location = '/library/bookRegistry'">Cancel</button>
	 	</form>
	 </div>
	 <ct:Footer />
</body>
</html>