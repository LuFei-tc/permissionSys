<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<style>
	.panel-title a:{
		text-decoration:none;
	}
	
	.input-group{
		width:300px;
		float:left;
	}
	.panel-body button{
	    width:100px;
		margin-right:20px;
	}
	
	
</style>
<div>

	<h1> 商品管理</h1>
	<h5> 首页 / 商品管理 / 商品管理</h5>
	<button type="button" class="btn btn-info"   onclick="showAddGoodModal('/addSysGood')">新增商品</button> 
</div>
<!-- <a href="javascript:void(0)" class="btn btn-info" onclick="showAddGoodModal('/addSysGood')">新增商品</a> -->

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
		<th>操作</th>
		<!-- <th>更新时间</th> -->
	</tr>
	<c:forEach items="${sysGoodList}" var="sysGood" varStatus="status">
		<tr>
		    <td>${status.count}</td>
			<td>${sysGood.goodTitle }</td>
			<td>${sysGood.goodPrice}</td>
			<td>${sysGood.num}</td>
			<td>${sysGood.cid }</td>
			<td><font color="blue"><c:if test="${sysGood.num > 0}">
			${sysGood.status==1?'有货':'num有错' } 
			</c:if></font>
			
			<font color="red"><c:if test="${sysGood.num == 0}">
			${sysGood.status==0?'库存不足':'status有错' } 
			</c:if></font>
			</td> 
			<td><fmt:formatDate value="${sysGood.created }" pattern="yyyy-MM-dd"/></td>	
			<td>
				<a href="javascript:void(0)" class="btn btn-info" onclick="showUpdateGoodData('/sysGoodInfo','/updateSysGood',${sysGood.goodId})">修改</a>
				<a href="javascript:void(0)" class="btn btn-danger" onclick="deleteData('/deleteSysGood',${sysGood.goodId})">删除</a>
				<a href="sysGoodAllInfo?id=${sysGood.goodId} " class="btn btn-warning" onclick="showGoodById('/sysGoodAllInfo',${sysGood.goodId})">查看详情</a>
			</td>
		</tr>
	</c:forEach>
	
	<c:if test="${fn:length(sysGoodList)==0}">
		<h3>暂无数据</h3>
	</c:if>
	
</table>
<ul class="pager">
    <c:if test="${page.currentPage != 1 }">
    	<li class="previous"><a href="javascript:void(0)" onclick="getData('/sysGoodList',${page.currentPage-1})">上一页</a></li>
    </c:if>
	<c:if test="${page.currentPage != page.totalPage }">
		<li class="next"><a href="javascript:void(0)" onclick="getData('/sysGoodList',${page.currentPage+1})">下一页</a></li>
	</c:if>
</ul>


<%@ include file="goodmodal.jsp"%>

