<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BackStage</title>
<style>
img{
	height:150px;
}
.imgtr{
	height:150px;
}

</style>

</head>
<body>
Hello,${loginUser}<br>
<form method="get" action="logout.controller">
<input type="submit" value="logout">
</form>
<br><br>
<table border="1"><tr><th>AccountID<th>Account<th>pwd<th>realname<th>birthday<th>sex<th>userPortrait</tr>
<c:forEach items="${allmember}" var="accMember">
	<tr class="imgtr">
	<td>${accMember.accountID}
	<td>${accMember.account}
	<td>${accMember.password}
	<td>${accMember.realName}
	<td>${accMember.birthday}
	<td>${accMember.sex}
	<td><img src="<c:url value='/accountMember.pic'/>?accountId=${accMember.accountID}">
	<td>
	<form action="update.controller" method="get">
	<input id="update" type="hidden" value="${accMember.accountID}">
	<button type="submit">修改</button>
	</form>
	
	</tr>
</c:forEach>

</table>



<button id="btn01">test</button>
<div id="img">
	
</div>

<script>
document.addEventListener("DOMContentLoaded",function(){
	
	document.getElementById("btn01").addEventListener("click",function(){
		let divImg = document.getElementById("img");
		let url="<c:url value='/accountMember.pic'/>";
		console.log(url);
		divImg.innerHTML="<img src='"+url+"?accountId=1001"+"'>";
	});
	
	
	
	
})

</script>
</body>
</html>