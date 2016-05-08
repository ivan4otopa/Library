<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="ct" uri="http://jwd.bg/tags" %>

<html>
<head>
	<title>Home</title>
	<link href="resources/css/styles.css" rel="stylesheet">
</head>
<body>
	<ct:Header />
	<h1 id="header">Home</h1>
	<div id="main-content">
		<h1>Welcome to Library, ${username}!</h1>
		<h3>Here you can view, edit, delete or search for books in the Books menu.</h3>	
		<h3>View, edit, delete, search clients in the Clients menu.</h3>
		<h3>Make and search for lends in the Lends menu.</h3>
	</div>
	<ct:Footer />
</body>
</html>