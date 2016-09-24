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
				var code=$('#code').val();
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
				if(code==""){
					alert("验证码不能为空！");
					$("#code").focus();
					return false;
				}
				$.ajax({
					type: "POST",
					url: "login.php",
					dataType: "text",
					data: {"username":email,"password":password,"code":code},
					success: function(data){
						alert(data);
						if(data=='登录成功')
						alert(11);
						window.location.href="/w1/index.php"

					}
			});
			});
		$('#reset').click(function(){
			$('input').val('');
		})


		})
