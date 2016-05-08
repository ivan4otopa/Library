<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="ct" uri="http://jwd.bg/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
	<title>Lend Registry</title>
	<link href="resources/css/styles.css" rel="stylesheet">
</head>
<body>
	<ct:Header />
	<h1 id="header">Lend Registry</h1>
	<div id="operations-menu">
		<button class="operation-btn" onclick="location = '/library/addLend'">Add Lend</button>
		<sec:authorize access="hasRole('ROLE_ADMIN')">
			<button class="operation-btn" onclick="location = '/library/editLend'">Edit Lend</button>
		</sec:authorize>
		<button class="operation-btn" onclick="location = '/library/deleteLend'">Delete Lend</button>
		<button class="operation-btn" onclick="location = '/library/searchLends'">Search Lends</button>
		<button class="operation-btn" onclick="location = '/library/addReturnDate'">Add Return Date</button>
	</div>
	<div id="main-content">
		<c:choose>
			<c:when test='${ not empty lends }'>
				<c:forEach var="lend" items="${ lends }">
					<div class="bubble-box">
						Id: ${ lend.id }<br />
						Book Id: ${ lend.bookId }<br />
						Client Id: ${ lend.clientId }<br />
						Period: ${ lend.period }<br />
						Date Of Lending: ${ lend.dateOfLending }<br />
						<c:choose>
							<c:when test="${ not empty lend.dateOfReturn }">
								Date Of Return: ${ lend.dateOfReturn }
							</c:when>
							<c:otherwise>
								Date Of Return: Not returned
							</c:otherwise>
						</c:choose>
					</div>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<h1>No Lends Registered</h1>
			</c:otherwise>
		</c:choose>
	</div>	
	<ct:Footer />
</body>
</html>