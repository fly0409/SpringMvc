<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.tl.bean.FactoryBean"%>
 <% request.setCharacterEncoding("UTF-8");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ShowTable</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/tableStyle.css">
<style>
	tbody tr:nth-child(2n){background-color:#ECFFFF	;}

</style>
</head>
<body>
<% List<FactoryBean> faclist=(ArrayList<FactoryBean>)request.getAttribute("faclist"); %>
<div align=center >
<h2 class="table">台灣觀光工廠</h2>
</div>
<div align=center class="qry" >
<form method="post" action="CitySelect">城市名搜尋:<input type="text" name="city"><input type="submit" value="查詢" ></form>
</div>
<div align=center style="clear:both">
<form method="post" action="html/addFactory.jsp" class="left buttom2"><input type="submit" value="新增" ></form>
<form method="post" action="ExportFactory" class="right buttom2" ><input type="submit" value="匯出" ></form>

</div>

<div align=center style="clear:both">



<table border="1"  class="table">
<tr class="trh"><td >序號<td>地區別<td class="nartr">縣市<td class="widtr">觀光工廠名稱<td class="widtr">地址<td >預約電話<td>網址<td>修改<td>刪除
<tbody>
<% for (FactoryBean fac:faclist){ %>
	<tr class="trb"><td><%=fac.getFacID() %>
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
</tbody>
</table>



</div>

</body>
</html>