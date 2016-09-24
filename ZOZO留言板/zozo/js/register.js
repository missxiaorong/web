// JavaScript Document
//支持Enter键登录
		document.onkeydown = function(e){
			if($(".bac").length==0)
			{
				if(!e) e = window.event;
				if((e.keyCode || e.which) == 13){
					var obtnLogin=document.getElementById("submit_btn")
					obtnLogin.focus();
				}
			}
		}

    	$(function(){
			//提交表单
			$('#submit_btn').click(function(){

				var email = $("#email").val();
				var password = $("#password").val();
				var re_password=$('#re_password').val();
				if(email==""){
					alert("邮箱不能为空！")
					$("#email").focus();
					return false;
				}
				if(password==""){
					alert("密码不能为空！");
					$("#password").focus();
					return false;
				}
				if(re_password==""){
					alert("验证码不能为空！");
					$("#re_password").focus();
					return false;
				}
				if(re_password!=password){
					alert("密码输入不一致！");
					$("#re_password").focus();
					return false;
				}
				$.ajax({
					type: "POST",
					url: "register.php",
					dataType: "text",
					data: {"username":email,"password":password,"re_password":re_password},
					success: function(data){
						alert(data);

					}
			});
			});
		$('#reset').click(function(){
			$('input').val('');
		})


		})
