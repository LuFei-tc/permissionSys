<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<button class="btn btn-success add" onclick="showAddRoleModal('/addSysRole')">添加</button>
<table class="table table-striped">
    <tr>
    	<th>序号</th>
    	<th>角色名</th>
    	<th>描述</th>
    	<th>创建时间</th>
    	<th>操作</th>
    </tr>
	<c:forEach items="${sysRoleList}" var="sysRole" varStatus="status">
		<tr>
		    <td>${status.count}</td>
			<td>${sysRole.roleName }</td>
			<td>${sysRole.remark}</td>
			<td>${sysRole.createTime }</td>
			
			<td>
				<a href="javascript:void(0)" class="btn btn-info" onclick="showUpdateRoleData('/sysRoleInfo','/updateSysRole',${sysRole.roleId})">edit</a>
				<a href="javascript:void(0)" class="btn btn-danger" onclick="deleteData('/deleteSysRole',${sysRole.roleId})">delete</a>
			</td>
		</tr>
	</c:forEach>
	<c:if test="${fn:length(sysRoleList)==0 }">
		<h3>暂无数据</h3>
	</c:if>
</table>
<ul class="pager">
    <c:if test="${page.currentPage != 1 }">
    	<li class="previous"><a href="javascript:void(0)" onclick="getData('/sysRoleList',${page.currentPage-1})">上一页</a></li>
    </c:if>
	<c:if test="${page.currentPage != page.totalPage }">
		<li class="next"><a href="javascript:void(0)" onclick="getData('/sysRoleList',${page.currentPage+1})">下一页</a></li>
	</c:if>
</ul>

<%@ include file="rolemodal.jsp" %>
