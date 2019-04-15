<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<button class="btn btn-success add" onclick="showAddPermModal('/addSysPerm')">添加</button>
<table class="table table-striped">
    <tr>
    	<th>序号</th>
    	<th>权限名</th>
    	<th>url</th>
    	<th>权限符</th>
    	<th>类型</th>
    	<th>排序号</th>
    	<th>操作</th>
    </tr>
	<c:forEach items="${sysPermList}" var="sysPerm" varStatus="status">
		<tr>
		    <td>${status.count}</td>
			<td>${sysPerm.name }</td>
			<td>${sysPerm.url}</td>
			<td>${sysPerm.perms }</td>
			<td>${sysPerm.type }</td>
			<td>${sysPerm.orderNum }</td>
			<td>
				<a href="javascript:void(0)" class="btn btn-info" onclick="showUpdatePermData('/sysPermInfo','/updateSysPerm',${sysPerm.permId})">edit</a>
				<a href="javascript:void(0)" class="btn btn-danger" onclick="deleteData('/deleteSysPerm',${sysPerm.permId})">delete</a>
			</td>
		</tr>
	</c:forEach>
	<c:if test="${fn:length(sysPermList)==0 }">
		<h3>暂无数据</h3>
	</c:if>
</table>
<ul class="pager">
    <c:if test="${page.currentPage != 1 }">
    	<li class="previous"><a href="javascript:void(0)" onclick="getData('/sysPermList',${page.currentPage-1})">上一页</a></li>
    </c:if>
	<c:if test="${page.currentPage != page.totalPage }">
		<li class="next"><a href="javascript:void(0)" onclick="getData('/sysPermList',${page.currentPage+1})">下一页</a></li>
	</c:if>
</ul>

<%@ include file="permmodal.jsp" %>
