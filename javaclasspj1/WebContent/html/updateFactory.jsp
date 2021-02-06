<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Factory</title>
<style>
fieldset{
	margin:50px;
	width:500px;
	border:1px solid #ACD6FF;
	border-radius:20px;
}
</style>
</head>
<body>
<div align="center">
<h1>修改頁面</h1>
<jsp:useBean id="fac" scope="request" class="com.tl.bean.FactoryBean"/>
<form method="post" action="UpdateFactory">
<fieldset>
<legend><i>填寫欲修改資料</i></legend>
<table>
<tr>
<td>序號<td><input type="text" readonly value="<%=fac.getFacID()%>" name="facID">
<tr>
<td>地區別<td><input type="text" value="<%=fac.getFacLocation()%>" name="facLocation">
<tr>
<td>縣市<td><input type="text" value="<%=fac.getFacCountry()%>" name="facCountry">
<tr>
<td>觀光工廠名稱<td><input type="text" value="<%=fac.getFacName()%>" name="facName">
<tr>
<td>地址<td><input type="text" value="<%=fac.getFacAddress()%>" name="facAddress">
<tr>
<td>工廠電話<td><input type="text" value="<%=fac.getFacPhone()%>" name="facPhone">
<tr>
<td>網址<td><input type="text" value="<%=fac.getFacUrl()%>" name="facUrl">
</table>
<input type="submit" value="送出修改">
</fieldset>
</form>




</div>

</body>
</html>