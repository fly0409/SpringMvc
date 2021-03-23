<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>

<h2>Form Form form</h2>
<form:form method="post" action="login.controller" modelAttribute="account">
	<table border="1">
		<tr>
			<td><form:label path="username">Account: </form:label>
			<td><form:input path="username"/>
		</tr>
		<tr>
			<td><form:label path="userpwd">password: </form:label>
			<td><form:input path="userpwd" type="password"/>
		</tr>
		<tr>
			<td><td><form:button value="send">submit</form:button>
		</tr>	
	</table>
</form:form>

</body>
</html>