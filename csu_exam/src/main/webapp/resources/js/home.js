$(document).ready(function(){
	$("#register-form").hide();
	$("#register-form").css("opacity","1");
});

$("#register").click(function(){
	$("#login-form").hide(300);
	$("#register-form").show(300);
});

$("#cancel-register").click(function(){
	$("#register-form").hide(300);
	$("#login-form").show(300);
});