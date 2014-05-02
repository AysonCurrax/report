<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Issue Tracking</title>
</head>
<body>
<form:form method="post" action="issue/submit">
	<h4>Please enter bug or
	<br>
	feature suggestion information:
	</h4>
		<div>
		<form:label path="author">username:</form:label>
		<br>
		<form:input path="author" value="${steamId}" readonly="true" size="25"/>
		<br>
		<form:label path="title">title:</form:label>
		<br>
		<form:input path="title" size="25" required="true" maxlength="100"/>
		<br>
		<form:label path="description">description:</form:label>
		<br>
		<form:textarea path="description" rows="5" maxlength="500" required="true"/>
		<br>
		<form:label path="type">type:</form:label>
		<form:select path="type">
			<c:forEach var="type" items="${types}">
			<form:option value="${type.id}">${type.name}</form:option>
			</c:forEach>
		</form:select>
		<br>
		<input type="submit" value="send report"/>
		</div>
</form:form>
</body>
</html>