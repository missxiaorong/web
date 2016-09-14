<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
<link rel="stylesheet" href="./resources/bootstrap/css/bootstrap.min.css" type="text/css">
<link rel="stylesheet" href="./resources/bootstrap/css/bootstrap-theme.min.css" type="text/css">
<link rel="stylesheet" href="./resources/css/home.css" type="text/css">
<script src="./resources/js/jquery-1.8.3.min.js"></script>

</head>
<body>


	<div class="block login-block" id="login-form">
	<div class="title"><b>登陆</b></div>
		<form action="login.home" method="post" class="form-horizontal" role="form">
			<div class="form-group">
				<label class="col-sm-3 control-label">Nick Name:</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" placeholder="Your Nick Name" name="login" id="login_login_input">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">PW:</label>
				<div class="col-sm-8">
					<input type="password" class="form-control" placeholder="Your Password" name="pw">
				</div>
			</div>
			<div class="form-group">
    			<div class="col-sm-offset-3 col-sm-8">
      				<button type="submit" class="btn btn-default">登陆</button>
      				<button type="button" class="btn btn-default col-sm-offset-4" id="register">注册</button>
    			</div>
  			</div>
		</form>
	</div>
	
	<div class="block login-block" id="register-form">
	<div class="title"><b>注册</b></div>
		<form action="register.home" method="post" class="form-horizontal" role="form">
			<div class="form-group">
				<label class="col-sm-3 control-label">Nick Name:</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" placeholder="Your Nick Name" name="login" id="register_login_input">
					<span id="errorHint"></span>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">True Name:</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" placeholder="Your True Name" name="name">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">PW:</label>
				<div class="col-sm-8">
					<input type="password" class="form-control" placeholder="Your Password" name="pw">
				</div>
			</div>
			<div class="form-group">
    			<div class="col-sm-offset-3 col-sm-8">
      				<button type="submit" class="btn btn-default" id="register_submit_button">注册</button>
      				<button type="button" class="btn btn-default col-sm-offset-4" id="cancel-register">取消</button>
    			</div>
  			</div>
		</form>
	</div>
	<script src="./resources/js/home.js"></script>
	<script>
		$("#register_login_input").blur(function(){
			$.ajax({
				data:"userRegister="+$("#register_login_input").val(),
				type:"POST",
				dataType:"json",
				url:"registerCheckAjax.do",
				error:function(data){
					
				},
				success:function(data){
					if(data.msg!="1"){//如果已经被注册过
						$("#register_login_input").css("color","red");
						$("#register_submit_button").addClass("disabled");
						$("#errorHint").text("该用户名已经被注册");
					}
					else{
						$("#register_login_input").css("color","green");
						$("#register_submit_button").removeClass("disabled");
						$("#errorHint").text("");
					}
				}
			});
		});
	</script>
</body>
</html>
