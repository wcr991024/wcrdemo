$(".code1").on("click", function() {
	var img = document.getElementsByClassName("code1")[0];
	var time = new Date().getTime();
	img.src = "images?t=" + time;
})

// 自运行
$(function() {
	var img = document.getElementsByClassName("code1")[0];
	var time = new Date().getTime();
	img.src = "images?t=" + time;
})


$(".login-btn").on("click", function(){
	var phone = $(".phone").val();
	var imgcode = $(".code").val();
	var password = $(".password").val();
	var password1 = $(".password1").val();
	if(phone =='' || phone == null ){
		//window.alert("手机号不能为空");
		$("#msg").css("display", "block");
        $("#msg").text("手机号不能为空!!!");
	}else if(password=="" || password == null){
		//window.alert("密码不能为空");
		$("#msg").css("display", "block");
        $("#msg").text("密码不能为空!!!");
	}else if(password1=="" || password1 == null){
		//window.alert("密码不能为空");
		$("#msg").css("display", "block");
        $("#msg").text("密码不能为空!!!");
	}else if(imgcode =="" || imgcode==null ){
		//window.alert("?
		$("#msg").css("display", "block");
        $("#msg").text("验证码不能为空!!!");
	}else if(password1!=password){
		$("#msg").css("display", "block");
        $("#msg").text("两次密码输入不一致!!!");
        }else{
	$.ajax({
		//请求类型
		type:"post",
		//请求路径
		url:"/repassword",
		//请求参数
		data:{
			phone: phone,
			password: password,
			imgcode: imgcode,
			password1: password1,
		},
		//返回数据类型
		//请求成功后调用函数
		success: function(data){
			console.log("成功后返回数据",data);
			if(data.code == 1){
				location.href = "operator_login.html"
			}else if(data.code == 2){
				alert("手机号格式错误")
				location.href="operator_findpassword.html"
			}else if(data.code == 3){
				alert("没有该用户")
				location.href="operator_findpassword.html"
			} 
			
			else{
				alert("密码修改失败!");
				location.href = "operator_findpassword.html"
			}
			
		},
		//请求失败后调用函数
		error: function(data){
			console.log("失败后返回数据",data);
			//location.href = "re?page=operator_findpassword"
		}
	})
        }
})
/***************************/
$("input").focus(function(){
    $(this).css("background-color","#FFFFCC");
});
$("input").blur(function(){
    $(this).css("background-color","#ffffff");
    $("#msg").text("");
});
function keyLogin(){
	if (event.keyCode==13)  
		   $(".login-btn").click();
}