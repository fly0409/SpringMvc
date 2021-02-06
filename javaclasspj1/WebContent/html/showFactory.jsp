<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.tl.bean.FactoryBean"%>
 <% request.setCharacterEncoding("UTF-8");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ShowTable</title>
</head>
<body>

<div align=center>
<h2>工廠</h2>
<form method="post" action="html/addFactory.jsp"><input type="submit" value="新增" ></form>
<% List<FactoryBean> faclist=(ArrayList<FactoryBean>)request.getAttribute("faclist"); %>

<form method="post" action="ExportFactory"><input type="submit" value="匯出" ></form>
<form method="post" action="CitySelect">地名查詢<input type="text" name="city"><input type="submit" value="查詢" ></form>

<table border="1">
<tr><td>序號<td>地區別<td>縣市<td>觀光工廠名稱<td>地址<td>預約電話<td>網址<td>修改<td>刪除
<% for (FactoryBean fac:faclist){ %>
	<tr><td><%=fac.getFacID() %>
	<td><%=fac.getFacLocation() %>
	<td><%=fac.getFacCountry() %>
	<td><%=fac.getFacName() %>
	<td><%=fac.getFacAddress() %>
	<td><%=fac.getFacPhone() %>
	<td><%=fac.getFacUrl() %>
	<td><form method="post" action="GetUpdateFactory">
		<input type="hidden"  value="<%=fac.getFacID() %>" name="facID">
		<input type="submit" value="更新"></form>
	<td><form method="post" action="DeleteFactory">
		<input type="hidden"  value="<%=fac.getFacID() %>" name="dfacID">
		<input type="submit" value="刪除"></form>	
	<% } %>
</table>



</div>

</body>
</html>