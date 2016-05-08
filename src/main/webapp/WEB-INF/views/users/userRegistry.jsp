<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="ct" uri="http://jwd.bg/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
	<title>User Registry</title>
	<link href="resources/css/styles.css" rel="stylesheet">
</head>
<body>
	<ct:Header />
	<h1 id="header">User Registry</h1>
	<div id="operations-menu">
		<sec:authorize access="hasRole('ROLE_ADMIN')">
			<button class="operation-btn" onclick="location = '/library/addUser'">Add User</button>
		</sec:authorize>
		<button class="operation-btn" onclick="location = '/library/editUser'">Edit User</button>
		<sec:authorize access="hasRole('ROLE_ADMIN')">
			<button class="operation-btn" onclick="location = '/library/deactivateUser'">Deactivate User</button>
		</sec:authorize>
		<sec:authorize access="hasRole('ROLE_ADMIN')">
			<button class="operation-btn" onclick="location = '/library/searchUsers'">Search Users</button>
		</sec:authorize>
	</div>
	<div id="main-content">
		<c:choose>
			<c:when test='${ not empty users }'>
				<c:forEach var="user" items="${ users }">
					<div class="bubble-box">
						Id: ${ user.id }<br />
						Username: ${ user.username }<br />
						Name: ${ user.name }<br />
						Types: <c:forEach var="authority" items="${ user.applicationAuthorities }" varStatus="loop">							
							${ fn:substring(authority.name, 5, fn:length(authority.name)) }${ not loop.last ? ',' : '' }
						</c:forEach><br />
						Status: ${ user.status }
					</div>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<h1>No Users Registered</h1>
			</c:otherwise>
		</c:choose>
	</div>	
	<ct:Footer />
</body>
</html>