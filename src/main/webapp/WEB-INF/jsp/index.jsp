<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>商品信息管理系统</title>
<link rel="icon" href="/images/box.ico"/>
<link rel="stylesheet"  href="webjars/bootstrap/3.3.5/css/bootstrap.min.css"/>
<link rel="stylesheet" href="/plugin/alert/BeAlert.css">
<script src="webjars/jquery/3.1.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script src="/plugin/alert/BeAlert.js"></script>
<script src="/js/send.js"></script>


<style>
    .col-md-2,.list-group,.dropdown-menu{
    	padding:0;
    }
   
	.navbar{
		margin-bottom:0;
	}

	.navbar-right{
		margin-right:0;
	}
	.col-md-2{
		
		height:calc( 100vh - 52px );
		background:#EDECD9;
	} 
	.list-group{
	  margin-top:-52px;
	}
	.list-group li{
	   background:#EDECD9;
	   height:52px;
	   padding-left:20px;
	   font-size:16px;
	  
	}
	.navbar-brand{
		padding-left:500px;
	}
	.add{
		margin:20px 0;
	}
	#menu1{
	padding-left:40px;
	color:#838374;
	}

</style>
</head>
<body>
<div class="container-fluid">
    <div class="row">
    	<div class="navbar navbar-default">
			<div class="navbar-header">
				<a href="javascript:void(0)" class="navbar-brand">Welcome Commodity Information Management System</a> 
			</div>
			
			<ul class="nav navbar-nav navbar-right">
				<li><a href="javascript:void(0)"><s:principal property="username"></s:principal> 用户 </a></li>
				<li><a href="/logout">登出</a></li>
			</ul>
		</div>
    </div>
    <div class="row">
	    <div class="col-md-2">
			<ul class="list-group">
			  <li class="list-group-item">
			  	  <a href="javascript:void(0)" data-toggle="dropdown" id="menu1">用户管理</a>
			  	  <ul class="dropdown-menu">
					  <li><a href="javascript:void(0)" onclick="getData('/sysUserList',1)">管理员</a></li>
					  <li><a href="javascript:void(0)" onclick="getData('/sysRoleList',1)">角色管理</a></li>
					  <li><a href="javascript:void(0)" onclick="getData('/sysPermList',1)">权限管理</a></li>
				  </ul>
			  </li>
			  <li class="list-group-item">
			  	 <a href="javascript:void(0)" onclick="getData('/sysGoodList',1)" id="menu1">商品管理</a>
			  </li>
			  <li class="list-group-item"><a href="javascript:void(0)" onclick="getDataByUrl('/sysOrderList')"  id="menu1">订单管理</a></li>
			</ul>
		</div>
		<div class="col-md-10" id="content">
		  
		     
		</div>
    </div>
</div>

</body>
</html>