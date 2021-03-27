<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
    <style>
        .header {
            height: 100vh;
            background-image: url("https://images.unsplash.com/photo-1505935428862-770b6f24f629?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1347&q=80");
            background-size: cover;
            background-position: center center;
            background-attachment: fixed;
        }
    </style>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/fontawesome/css/all.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap4.6/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
    <script src="bootstrap4.6/js/bootstrap.bundle.min.js"></script>
    <script>
        document.addEventListener("DOMContentLoaded", function () {
            document.getElementById("userAcoountInput").focus();
        })
    </script>
</head>
<body>
    <header class="header d-flex justify-content-center align-items-center">
        <div class="text-center">
            <figure class="d-flex justify-content-center">
                <img style="width: 150px;"
                    src="https://www.flaticon.com/svg/vstatic/svg/637/637252.svg?token=exp=1616768729~hmac=7d5a99f618e728c007e634812e97c1a8">
            </figure>
            <h1 class="">歡迎來到後台系統</h1>
            <h3 class="">輸入帳號密碼登入</h3>
            <div class="mt-5">
                <form:form method="post" action="login.controller" modelAttribute="account">
                    <div class="form-group row">
                        <div class="col-sm-3">
                            <form:label for="userAcoountInput" path="username">帳號:</form:label>
                        </div>
                        <div class="col-sm-9">
                            <form:input type="text" path="username" class="form-control" id="userAcoountInput" aria-describedby="account"
                                placeholder="Enter Account"/>
                        </div>
                    </div>
                    <div class="form-group row">
                        <div class="col-sm-3">
                            <form:label path="userpwd" for="exampleInputPassword1">密碼:</form:label>
                        </div>
                        <div class="col-sm-9">
                            <form:input path="userpwd" type="password" class="form-control" id="exampleInputPassword1"
                                placeholder="Password"/>
                        </div>
                        
                    </div>


                    <form:button value="send" class="btn btn-primary">登入</form:button>
                </form:form>
                	${errors.result}<br>
            </div>

        </div>


    </header>



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

    ${loginUser}<br>

</body>
</html>