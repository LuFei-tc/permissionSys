<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table class="table table-striped">
	<tr>
		<th>序号</th>
		<th>名称</th>
		<th>价格</th>
		<!-- <th>卖点</th> -->
		<th>库存数量</th>
		<th>所属类目</th>
		<th>状态</th>
		<th>创建时间</th>
		<th>更新时间</th>
	</tr>
	<c:forEach items="${sysGoodList}" var="sysGood" varStatus="status">
		<tr>
		    <td>${status.count}</td>
			<td>${sysGood.goodTitle }</td>
			<td>${sysGood.goodPrice}</td>
			<%-- <td>${sysGood.sellPoint}</td> --%>
			<td>${sysGood.num}</td>
			<td>${sysGood.cid }</td>
			<td>${sysGood.status==1?'可用':'不可用' }</td>
			
			<td>${sysGood.created }</td>
			<td>${sysGood.updated }</td>
			
			
			
		</tr>
	</c:forEach>
	
	<c:if test="${fn:length(sysGoodList)==0}">
		<h3>暂无数据</h3>
	</c:if>
	
</table>
</body>
</html>