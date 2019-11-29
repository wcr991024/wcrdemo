$(document).ready(function(){
	var url=window.location.href;                    //获取当前页面的url
	if(url.indexOf("?")!=-1){                        //判断是否存在参数
		url = url.replace(/(\?|#)[^'"]*/, '');           //去除参数
		window.history.pushState({},0,url);
	}
})
/********** 支付 ************/
$(".payment li").eq(1).on("click", function(){
    //location.href="e-commerce_shoping-car.html";
	var orderId = $("#orderId").text();
	//alert($("#orderId").text());
	$.ajax({
		url:"/payment",
		type:"get",
		data:{"orderId":orderId},
		dataType:"json",
		success:function(data){
			if(data.code==1){
				alert("支付成功");
				location.href="/selectByProviderName";
			}else if(data.code==0){
				alert("支付失败");
				location.href="#";
			}else{
				alert("未找到订单");
				location.href="#";
			}
		},
		error:function(){
			alert("支付失败2");
			location.href="#";
		}
	})
})
