$(".code1").on("click", function() {
	var img = document.getElementsByClassName("code1")[0];
	var time = new Date().getTime();
	img.src = "images?t=" + time;
})
$(function(){
	var img = document.getElementsByClassName("code1")[0];
	var time = new Date().getTime();
	img.src = "images?t=" + time;
	$("#province").change(function(){
		
		var pr_name=$("#province").val();
		$('#city').html('<option value="">请选择城市</option>');
		$.ajax({
			url:"/findcity1?pr_name="+pr_name,
			type:"GET",
			dataType:"json",
		success:function(data){
			
			if(data!=null){
				$(data).each(function(index){
					//alert("0000000");
					$("#city").append('<option value="'+data[index].ci_name + '">'+data[index].ci_name+'</option>');
				
				});
			}
		}
		});
	});
	
	$("#city").change(function(){
		//alert("0000000");
		var ci_name=$('#city option:selected').val();
		$('#county').html('<option value="">请选择区县</option>');
		$.ajax({
			url:"/findcounty1?ci_name="+ci_name,
			type:"get",
			dataType:"json",
		success:function(data){
		
			if(data!=null){
				$(data).each(function(index){
					$('#county').append('<option value="'+data[index].co_name + '">'+data[index].co_name+'</option>');
				});
			}
		}
		});
	});
	$(".login-btn").on("click",function(){
		var Phone = $(".Phone").val();
		var Password = $(".password").val();
		var imgcode = $(".code").val();
		var area = $("#province option:selected").val() + $("#city option:selected").val() + $("#county option:selected").val();
		var xdboughtuser={"Phone":Phone,"Password":Password,"imgcode" : imgcode,"area":area}
		alert(Phone + Password + imgcode + area);
		if(Phone =='' || Phone == null ){
			//window.alert("手机号不能为空");
			$("#msg").css("display", "block");
	        $("#msg").text("手机号不能为空!!!");
		}else if(Password=="" || Password == null){
			//window.alert("密码不能为空");
			$("#msg").css("display", "block");
	        $("#msg").text("密码不能为空!!!");
		}else if(imgcode =="" || imgcode==null ){
			//window.alert("验证
			$("#msg").css("display", "block");
	        $("#msg").text("验证码不能为空!!!");
	        }else{
		
		$.ajax({
			url:"/register",
			type:"post",
			data:xdboughtuser,
			/*data:{
				"servicePhone":servicePhone,
				"servicePassword":servicePassword,
				"imgcode":imgcode,
				"area":area
			},*/

		success:function(data){
			//alert("0000000");
			console.log("成功后返回数据", data);
			if(data.code == 1){
				location.href="e-commerce_login.html"
			}else if(data.code == 2){
				alert("手机号格式错误")
				location.href="/findprovince1"
			}
			else if(data.code == -1){
				alert("已拥有该用户")
				location.href="/findprovince1"
			}
			else {
				alert("验证码错误");
				location.href = "/findprovince1"
			}

		},
		error:function(data){
			console.log("失败后返回数据", data);
		}
		})
	        }	
		//location.href="/register"
	})
	
});
