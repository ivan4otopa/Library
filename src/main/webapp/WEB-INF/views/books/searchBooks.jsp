<%@ taglib prefix="ct" uri="http://jwd.bg/tags" %>

<html>
<head>
	<title>Search Books</title>
	<link href="resources/css/styles.css" rel="stylesheet">
</head>
<body>
	<ct:Header />
	<h1 id="header">Search Books</h1>
	<div id="main-content">
		<form action="searchBooks" method="POST">
			<input type="radio" id="name" name="criteria" value="name" /> <label for="name">Name</label><br />
			<input type="radio" id="author" name="criteria" value="author" /> <label for="author">Author</label><br />
			<input type="radio" id="yearOfPublishing" name="criteria" value="yearOfPublishing" /> <label for="yearOfPublishing">Year Of Publishing</label><br />
			<input type="text" class="input-field" name="value" placeholder="Value..." required /><br />
			<input type="submit" id="submit-btn" value="Search" />
			<button type="button" id="cancel-btn" onclick="location = '/library/bookRegistry'">Cancel</button>
		</form>
	</div>
	<ct:Footer />
</body>
</html>