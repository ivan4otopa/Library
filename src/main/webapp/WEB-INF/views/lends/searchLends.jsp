<%@ taglib prefix="ct" uri="http://jwd.bg/tags" %>

<html>
<head>
	<title>Search Lends</title>
	<link href="resources/css/styles.css" rel="stylesheet">
	<script src="https://code.jquery.com/jquery-1.12.3.min.js"></script>
</head>
<body>
	<ct:Header />
	<h1 id="header">Search Lends</h1>
	<div id="main-content">
		<form action="searchLends" method="POST">
			<input type="radio" class="radio-btn" id="bookId" name="criteria" value="bookId" /> <label for="bookId">Book Id</label><br />
			<input type="radio" class="radio-btn" id="clientName" name="criteria" value="clientName" /> <label for="clientName">Client Name</label><br />
			<input type="radio" class="radio-btn" id="dateOfLending" name="criteria" value="dateOfLending" /> <label for="dateOfLending">Date Of Lending</label><br />
			<input type="radio" class="radio-btn" id="dateOfReturn" name="criteria" value="dateOfReturn" /> <label for="dateOfReturn">Date Of Return</label><br />
			<input type="text" class="input-field" placeholder="Value..." /><br />
			<input type="date" class="input-field" /><br />
			<input type="submit" id="submit-btn" value="Search" />
			<button type="button" id="cancel-btn" onclick="location = '/library/lendRegistry'">Cancel</button>
		</form>		
	</div>
	<ct:Footer />
	<script src="resources/js/changeInputTypeEventLend.js"></script>
</body>
</html>