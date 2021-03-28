<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UpdatePage</title>
</head>
<script>
document.addEventListener("DOMContentLoaded",function(){
	console.log("ok"); 
	
	let input = document.getElementsByName("userProtrait")
	
	input[0].addEventListener("change",function(thisimg){
		var file = thisimg.target.files[0];
		
		if(window.FileReader) {
			var fr = new FileReader();
			
			var showimg = document.getElementById('previewImg');
			console.log(showimg);
			fr.onloadend = function(e) {
			showimg.src = e.target.result;
		};
		fr.readAsDataURL(file);
		showimg.style.display = 'block';
		}
	})

});
</script>
<body>
<div align="center">
	<form method="post" action="accountMemberUpdater" enctype="multipart/form-data">
		<fieldset><h2>修改會員</h2></fieldset>
		<table border="1">
		<tr>
		<td><label for="userAcoountInput">accountID:</label>
		<td><input id="userAcoountInput" type="text" name="accountID" value="${accountMember.accountID}" />
		</tr>
		<tr>
		<td><label for="accountInput">account:</label>
		<td><input id="accountInput" type="text" name="account" value="${accountMember.account}" />
		</tr>
		<tr>
		<td><label for="passwordInput">password:</label>
		<td><input id="passwordInput" type="text" name="password" value="${accountMember.password}" />
		</tr>
		<tr>
		<td><label for="realNameInput">realName:</label>
		<td><input id="realNameInput" type="text" name="realName" value="${accountMember.realName}"/>
		</tr>
		<tr>
		<td><label for="nickNameInput">nickName:</label>
		<td><input id="nickNameInput" type="text" name="nickName" value="${accountMember.nickName}"/>
		</tr>
		<tr>
		<td><label for="phoneNumerInput">phoneNumer:</label>
		<td><input id="phoneNumerInput" type="text" name="phoneNumer" value="${accountMember.phoneNumer}"/>
		</tr>
		<tr>
		<td><label for="birthdayInput">birthday:</label>
		<td><input id="birthdayInput" type="text" name="birthday" value="${accountMember.birthday}"/>
		</tr>
		<tr>
		<td><label for="userProtraitInput">userProtrait:</label>
		<td><input id="userProtraitInput" id="updateFile" type="file" name="userProtrait" />
		</tr>
		<tr>
		<td>預覽圖
		<td> <img id ="previewImg" style="height:100px" src="<c:url value='/accountMember.pic'/>?accountId=${accountMember.accountID}"/> 
		</tr>
		<tr>
		<td><label for="sexInput">sex:</label>
		<td><input id="sexInput" type="text" name="sex" value="${accountMember.sex}"/>
		</tr>
		<tr>
		<td><label for="distinctInput">distinct:</label>
		<td><input id="distinctInput" type="text" name="distinct" value="${accountMember.distinct}"/>
		</tr>
		<tr>
		<td><label for="YummyPointInput">YummyPoint:</label>
		<td><input id="YummyPointInput" type="text" name="yummyPoint" value="${accountMember.yummyPoint}"/>
		</tr>
		<tr>
		<td>
		<td><input type="submit" value="update"/>
		</tr>
		
		</table>
	</form>
</div>


</body>
</html>