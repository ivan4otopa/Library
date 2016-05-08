<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="ct" uri="http://jwd.bg/tags" %>

<html>
<head>
	<title>Book Registry</title>
	<link href="resources/css/styles.css" rel="stylesheet">
</head>
<body>
	<ct:Header />
	<h1 id="header">Book Registry</h1>
	<div id="operations-menu">
		<button class="operation-btn" onclick="location = '/library/addBook'">Add Book</button>
		<button class="operation-btn" onclick="location = '/library/editBook'">Edit Book</button>
		<button class="operation-btn" onclick="location = '/library/deleteBook'">Delete Book</button>
		<button class="operation-btn" onclick="location = '/library/searchBooks'">Search Books</button>
	</div>
	<div id="main-content">
		<c:choose>
			<c:when test='${ not empty books }'>
				<c:forEach var="book" items="${ books }">
					<div class="bubble-box">
						Id: ${ book.id }<br />
						Name: ${ book.name }<br />
						Author: ${ book.author }<br />
						Year Of Publishing: ${ book.yearOfPublishing }
					</div>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<h1>No Books Registered</h1>
			</c:otherwise>
		</c:choose>
	</div>	
	<ct:Footer />
</body>
</html>