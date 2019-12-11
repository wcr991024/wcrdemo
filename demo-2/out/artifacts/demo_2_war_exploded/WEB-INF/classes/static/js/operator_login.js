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



$(".login-btn").on("click", function() {
	var phone = $(".ope_phone").val();
	var password = $(".ope_password").val();
	var imgcode = $(".code").val();
	if(phone =='' || phone == null ){
		//window.alert("手机号不能为空");
		$("#msg").css("display", "block");
        $("#msg").text("手机号不能为空!!!");
	}else if(password=="" || password == null){
		//window.alert("密码不能为空");
		$("#msg").css("display", "block");
        $("#msg").text("密码不能为空!!!");
	}else if(imgcode =="" || imgcode==null ){
		//window.alert("?
		$("#msg").css("display", "block");
        $("#msg").text("验证码不能为空!!!");
	}else{
	$.ajax({
		// 请求类型
		type : "post",
		// 请求路径
		url : "/login",
		
		// 请求参数
		data : {
			phone : phone,
			password : password,
			imgcode : imgcode,
		},
		// 返回数据类型
		// 请求成功后调用函数
		success : function(data) {
			console.log("成功后返回数据", data);
			//alert("code=:"+data.code);
			if (data.code == 1) {
				location.href = "/dingdan"
			}else if(data.code == 3){
				alert("没有该用户")
				location.href="operator_login.html"
			} 
			else if(data.code == 2){
				alert("手机号格式错误")
				location.href="operator_login.html"
			}
			else {
				alert("信息输入错误!");
				location.href = "operator_login.html"
			}
		},
		// 请求失败后调用函数
		error : function(data) {
			console.log("失败后返回数据", data);
		}
	})
	}
})