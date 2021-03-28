<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add accountMember</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/fontawesome/css/all.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/bootstrap4.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script src="bootstrap4.6/js/bootstrap.bundle.min.js"></script>
</head>

<body>
<div class="container d-flex justify-content-center align-items-center mt-5">
	<div>
	<form method="post" action="accountMemberAdder" enctype="multipart/form-data">
	<fieldset><h2>新增會員</h2></fieldset>
		<table border="1">
			<tr>
			<td><label for="accountInput">account:</label>
			<td><input id="accountInput" type="text" name="account" />
			</tr>
			<tr>
			<td><label for="passwordInput">password:</label>
			<td><input id="passwordInput" type="text" name="password" />
			</tr>
			<tr>
			<td><label for="realNameInput">realName:</label>
			<td><input id="realNameInput" type="text" name="realName" />
			</tr>
			<tr>
			<td><label for="nickNameInput">nickName:</label>
			<td><input id="nickNameInput" type="text" name="nickName" />
			</tr>
			<tr>
			<td><label for="phoneNumerInput">phoneNumer:</label>
			<td><input id="phoneNumerInput" type="text" name="phoneNumer" />
			</tr>
			<tr>
			<td><label for="birthdayInput">birthday:</label>
			<td><input id="birthdayInput" type="text" name="birthday" />
			</tr>
			<tr>
			<td><label for="userProtraitInput">userProtrait:</label>
			<td><input id="userProtraitInput" type="file" name="userProtrait" />
			</tr>
			<tr>
			<td><label for="sexInput">sex:</label>
			<td><input id="sexInput" type="text" name="sex" />
			</tr>
			<tr>
			<td><label for="distinctInput">distinct:</label>
			<td><input id="distinctInput" type="text" name="distinct" />
			</tr>
			<tr>
			<td><label for="YummyPointInput">YummyPoint:</label>
			<td><input id="YummyPointInput" type="text" name="yummyPoint" />
			</tr>
			<tr>
			<td>確定送出
			<td><input type="submit" value="upload"/>
		</table>
	</form>


<%-- 	<form:form method="post" action="accountMemberAdder" modelAttribute="accountMember" enctype="multipart/form-data"> --%>
<%-- 		<form:label for="userAcoountInput" path="accountID">accountID:</form:label> --%>
<%-- 		<form:input id="userAcoountInput" type="text" path="accountID" /><br> --%>
<%-- 		<form:label for="accountInput" path="account">account:</form:label> --%>
<%-- 		<form:input id="accountInput" type="text" path="account" /><br> --%>
<%-- 		<form:label for="passwordInput" path="password">password:</form:label> --%>
<%-- 		<form:input id="passwordInput" type="text" path="password" /><br> --%>
<%-- 		<form:label for="realNameInput" path="realName">realName:</form:label> --%>
<%-- 		<form:input id="realNameInput" type="text" path="realName" /><br> --%>
<%-- 		<form:label for="nickNameInput" path="nickName">nickName:</form:label> --%>
<%-- 		<form:input id="nickNameInput" type="text" path="nickName" /><br> --%>
<%-- 		<form:label for="phoneNumerInput" path="phoneNumer">phoneNumer:</form:label> --%>
<%-- 		<form:input id="phoneNumerInput" type="text" path="phoneNumer" /><br> --%>
<%-- 		<form:label for="birthdayInput" path="birthday">birthday:</form:label> --%>
<%-- 		<form:input id="birthdayInput" type="text" path="birthday" /><br> --%>
<%-- 		<form:label for="protraitNameInput" path="protraitName">protraitName:</form:label> --%>
<%-- 		<form:input id="protraitNameInput" type="text" path="protraitName" /><br> --%>
<%-- 		<form:label for="userProtraitInput" path="userProtrait">userProtrait:</form:label> --%>
<%-- 		<form:input id="userProtraitInput" type="file" path="userProtrait" /><br> --%>
<%-- 		<form:label for="sexInput" path="sex">sex:</form:label> --%>
<%-- 		<form:input id="sexInput" type="text" path="sex" /><br> --%>
<%-- 		<form:label for="distinctInput" path="distinct">distinct:</form:label> --%>
<%-- 		<form:input id="distinctInput" type="text" path="distinct" /><br> --%>
<%-- 		<form:label for="YummyPointInput" path="YummyPoint">YummyPoint:</form:label> --%>
<%-- 		<form:input id="YummyPointInput" type="text" path="YummyPoint" /><br> --%>
<!-- 		 <input type="file" name="myFiles"/> -->

<%-- 		<form:button value="send">登入</form:button> --%>
<%-- 	</form:form> --%>

<button class="d-flex justify-content-center" id="quickenter">偷懶的按鈕</button>
</div>
</div>	
	

	<script>
		document.getElementById("quickenter").addEventListener("click",function(){
			document.getElementById("accountInput").value="A1234";
			document.getElementById("passwordInput").value="test123";
			document.getElementById("realNameInput").value="linMary";
			document.getElementById("nickNameInput").value="mary";
			document.getElementById("phoneNumerInput").value="0912345678";
			document.getElementById("birthdayInput").value="1991-01-20";
// 			document.getElementById("protraitNameInput").value="";
			document.getElementById("sexInput").value="female";
			document.getElementById("distinctInput").value="taipei";
			document.getElementById("YummyPointInput").value="1500";
		})
	</script>
</body>
</html>