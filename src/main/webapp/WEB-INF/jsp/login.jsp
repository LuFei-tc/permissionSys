<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>商品信息管理系统</title>
<link rel="icon" href="/images/box.ico"/>
<link rel="stylesheet"  href="webjars/bootstrap/3.3.5/css/bootstrap.min.css"/>
<style>
	body{
		background-image:url("/images/bg.jpg");
	}
	 button{
	margin-left:80px;
	width:100px;
	}
	
		
	
	form{
		background-color:rgba(250,250,250,0.8);
		padding:20px;
		margin-top:200px;
		margin-left:-100px;
		border-radius:5px;
		width:500px;
		heigth:600px;
	}
</style>
</head>
<body>
<div class="container-fluid">
	<div class="col-md-2 col-md-offset-5">
		<form action="/login" method="post">
			<div class="form-group">
				<label>用户名</label>
				<input class="form-control" placeholder="please input your username" name="username">
			</div>
			<div class="form-group">
				<label>密码</label>
				<input class="form-control" placeholder="please input your passowrd" name="password" type="password">
			</div>
			<button type="submit" class="btn btn-primary">登录</button>
			<button type="reset" class="btn btn-success"> 重置</button>
		</form>
	</div>
</div>

</body>
</html>