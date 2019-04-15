<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<style>

</style>

<div>
	<h1> 用户管理</h1>
	<h5> 首页 / 用户管理 / 用户管理</h5>
	<button class="btn btn-success add" onclick="showAddModal('/addSysUser')">添加用户</button>
</div>


<table class="table table-striped">
    <tr>
    	<th>序号</th>
    	<th>姓名</th>
    	<th>邮箱</th>
    	<th>电话</th>
    	<th>状态</th>
    	<th>操作</th>
    </tr>
	<c:forEach items="${sysUserList}" var="sysUser" varStatus="status">
		<tr>
		    <td>${status.count}</td>
			<td>${sysUser.username }</td>
			<td>${sysUser.email}</td>
			<td>${sysUser.mobile }</td>
			<td>${sysUser.status==1?'可用':'不可用' }</td>
			<td>
				<a href="javascript:void(0)" class="btn btn-info" onclick="showUpdateData('/sysUserInfo','/updateSysUser',${sysUser.userId})">edit</a>
				<a href="javascript:void(0)" class="btn btn-danger" onclick="deleteData('/deleteSysUser',${sysUser.userId})">delete</a>
				<a href="javascript:void(0)" class="btn btn-warning" onclick="showSendModal('${sysUser.email}')">email</a>
			</td>
		</tr>
	</c:forEach>
	<c:if test="${fn:length(sysUserList)==0}">
		<h3>暂无数据</h3>
	</c:if>
</table>
<ul class="pager">
    <c:if test="${page.currentPage != 1 }">
    	<li class="previous"><a href="javascript:void(0)" onclick="getData('/sysUserList',${page.currentPage-1})">上一页</a></li>
    </c:if>
	<c:if test="${page.currentPage != page.totalPage }">
		<li class="next"><a href="javascript:void(0)" onclick="getData('/sysUserList',${page.currentPage+1})">下一页</a></li>
	</c:if>
</ul>
<%@ include file="usermodal.jsp"%>
<%@ include file="mailmodal.jsp" %>






