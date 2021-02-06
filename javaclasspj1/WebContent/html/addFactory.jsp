<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<jsp:useBean id="fac" scope="request" class="com.tl.bean.FactoryBean"/>
<form method="post" action="../AddFactory">
<table>
<tr>
<td>序號<td><input type="text" name="facID">
<tr>
<td>地區別<td><input type="text" name="facLocation">
<tr>
<td>縣市<td><input type="text" name="facCountry">
<tr>
<td>觀光工廠名稱<td><input type="text" name="facName">
<tr>
<td>地址<td><input type="text" name="facAddress">
<tr>
<td>工廠電話<td><input type="text" name="facPhone">
<tr>
<td>網址<td><input type="text" name="facUrl">
</table>
<input type="submit" value="新增">
</form>




</div>
</body>
</html>