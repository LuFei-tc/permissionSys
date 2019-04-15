<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>

<style>
	

</style>
</head>
<body>
<div>

	<h1> 订单管理</h1>
	<h5> 首页 / 订单管理 / 订单管理</h5>
	添加订单:<a href="javascript:void(0)" class="" onclick="showAddOrderModal('/addSysOrder')">
		<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
	</a>
	<br>
</div>
 
<div>
	根据买家昵称查询订单:
	<form id="#myForm">
		<input type="text" class="form-control" id="uname" name="uname">
		<input type="button" value="Submit"  onclick="searchOrder('/searchSysOrder')"/>
	</form>
</div>
<table class="table table-striped" id="mytable">
	<tr>
		<th>订单序号</th>
		<th>买家昵称</th>
		<th>商品名称</th>
		<th>单价</th>
		<th>购物数量</th>
		<th>订单总额</th>
		<th>状态</th>
		<th>创建时间</th>
		<th>操作</th>
	</tr>
	<c:forEach items="${sysOrderList}" var="sysOrder" varStatus="status">
		<tr class="detail">
		    <td>${sysOrder.oid}</td>
			<td>${sysOrder.uname }</td>
			<td>${sysOrder.gname}</td>
			<td>${sysOrder.price}</td>
			<td>${sysOrder.num }</td>
			<td>${sysOrder.totalPrice }</td>
			<td>${sysOrder.status }</td>
			<td><fmt:formatDate value="${sysOrder.created }" pattern="yyyy-MM-dd"/></td>	
			<td>
				<a href="javascript:void(0)"  class="" onclick="showOrderData('/findSysOrderById',${ sysOrder.oid})">
  					<span class="glyphicon glyphicon-th-large" aria-hidden="true"></span>
				</a>
				<a href="javascript:void(0)"  class="" onclick="deleteData('/deleteSysOrder',${ sysOrder.oid})">
					<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
				</a>
				
			</td>
		</tr>
	</c:forEach>
	
	<c:if test="${fn:length(sysOrderList)==0}">
		<h3>暂无数据</h3>
	</c:if>
	
</table>



</body>
</html>
<%@ include file="ordermodal.jsp"%>