<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="ct" uri="http://jwd.bg/tags" %>

<html>
<head>
	<title>Client Registry</title>
	<link href="resources/css/styles.css" rel="stylesheet">
</head>
<body>
	<ct:Header />
	<h1 id="header">Client Registry</h1>
	<div id="operations-menu">
		<button class="operation-btn" onclick="location = '/library/addClient'">Add Client</button>
		<button class="operation-btn" onclick="location = '/library/editClient'">Edit Client</button>
		<button class="operation-btn" onclick="location = '/library/deleteClient'">Delete Client</button>
		<button class="operation-btn" onclick="location = '/library/searchClients'">Search Clients</button>
	</div>
	<div id="main-content">
		<c:choose>
			<c:when test='${ not empty clients }'>
				<c:forEach var="client" items="${ clients }">
					<div class="bubble-box">
						Id: ${ client.id }<br />
						Name: ${ client.name }<br />
						PID: ${ client.pid }<br />
						Date Of Birth: ${ client.dateOfBirth }
					</div>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<h1>No Clients Registered</h1>
			</c:otherwise>
		</c:choose>
	</div>	
	<ct:Footer />
</body>
</html>