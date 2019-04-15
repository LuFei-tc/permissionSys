<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 
    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="com.ycsf.persys.modalur.sys.entity.SysGood" %>
<link rel="icon" href="/images/box.ico"/>
<link rel="stylesheet"  href="webjars/bootstrap/3.3.5/css/bootstrap.min.css"/>
<link rel="stylesheet" href="/plugin/alert/BeAlert.css">
<script src="webjars/jquery/3.1.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script src="/plugin/alert/BeAlert.js"></script>   


<% SysGood sysGood = (SysGood)session.getAttribute("sysGood"); %>

<h2>商品:<%= sysGood.getGoodTitle() %> <br></h2>
  ${ sysGood.image} 
<table class="table table-striped">
	<tr>
		<th>序号</th>  <td>${ sysGood.goodId}</td>
	</tr>
	<tr>
		<th>名称</th>  <td>${sysGood.goodTitle }</td>
	</tr>
	<tr>
		<th>价格</th> 	<td>${sysGood.goodPrice}</td>
	</tr>
	<tr>
		<th>商品卖点</th>  <td>${sysGood.sellPoint}</td>
	</tr>
	<tr>
		<th>库存数量</th>  <td>${sysGood.num}</td>
	</tr>
	<tr>
		<th>所属类目</th>  <td>${sysGood.cid }</td>
	</tr>
	<tr>
		<th>状态</th>     <td>${sysGood.status==1?'有货':'无货' }</td>
	</tr>
	<tr>
		<th>创建时间</th>  <td><fmt:formatDate value="${sysGood.created }" pattern="yyyy-MM-dd"/></td>	
	</tr>
	<tr>
		<th>更新时间</th>  <td><fmt:formatDate value="${ sysGood.updated}" pattern="yyyy-MM-dd"/></td>	
	</tr>	
</table>



