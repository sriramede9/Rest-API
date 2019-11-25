<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>

<%@ page isELIgnored="false"%>

<title>Welcome</title>
</head>
<body bgcolor="orange">

	<h1>Test one two theree</h1>


	<form:form modelAttribute="usertwo" action="formresponse" method="post">
		<form:input path="id" />
		<form:input path="name" />
		<form:input path="dob" />
		<input type="submit">
	</form:form>


</body>
</html>