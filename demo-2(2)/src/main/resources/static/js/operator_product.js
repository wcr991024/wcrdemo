$(".user-arrow-down").on("click",function(){
    if($(".dropdown").is(":hidden")){
        $(".dropdown").show();
 }else{
       $(".dropdown").hide();
 }
}) 
$(".edit-btn").on("click", function(event){
	goto($(this).siblings(".product_id").val());
    $(".masking").show();
})
$(".save-btn").on("click", function(){
	//var product = {
			var productId=$(".productId").val();
			var productName=$(".productName").text();
			var productInfo=$(".productInfo").text();
			var price=$(".price").text();
			var product = { "productId":productId,"productName":productName,"productInfo":productInfo,"price":price}
	//alert(JSON.stringify(product))
	$.ajax({
		url:"/update",
		type:"post",
		data:product,
		success:function(data){
			if(data.code==1){
				alert("修改成功");
				location.href="/product";
			}else{
				alert("修改失败");
				location.href="#";
			}
		},
		error:function(){
			alert("error");
		}
	})
    
})
$(".cancel").on("click", function(event){
    $(".masking").hide();
    console.log("取消");
})

$(".handle-btn").on("click", function(){
	var productId=$(this).siblings(".product_id").val();
	var status = $(this).text();
	var operate = $(this).children(".operate");
	var status1 = $(this).parent().parent().children(".status");
	//alert(productId + "----" + status)
	$.ajax({
		url:"/changeStatus",
		type:"post",
		data:{
			"productId":productId,
			"status":status
		},
	success:function(data){
		if(data.code==1){
			if(data.product.status == '上线'){
				operate.text('下线');
				status1.children().text('在线');
				status1.children().css("background-color","#67C23A");
			}else if(data.product.status == '下线'){
				operate.text('上线');
				status1.children().text('下线');
				status1.children().css("background-color","#909399");
			}else{
				
			}
			
		}else{
			alert("失败");
		}
		console.log("123");
			
		},
		error:function(){
			alert("删除成功");
		}
	})
    
})
$(".up-line").on("click", function(){
	var status = $(this).text()
	console.log(status);
	$.ajax({
		url:"/changeAllStatus",
		type:"post",
		data:{
			"status":status
		},
		success:function(data){
			if(data.code != 0){
				$(".operate").text('下线');
				$(".status").children().text('在线');
				$(".status").children().css("background-color","#67C23A");
			}else{
				alert("失败");
			}
		},
		error:function(){
			alert("error");
		}
	})
    
})
$(".down-line").on("click", function(){
	var status = $(this).text();
	console.log(status);
	$.ajax({
		url:"/changeAllStatus",
		type:"post",
		data:{
			"status":status
		},
		success:function(data){
			if(data.code != 0){
				$(".operate").text('上线');
				$(".status").children().text('下线');
				$(".status").children().css("background-color","#909399");
			}else{
				alert("失败");
			}
		},
		error:function(){
			alert("error");
		}
	})
    
})

$(function(){
	
	var url=window.location.href;                    //获取当前页面的url
	if(url.indexOf("?")!=-1){                        //判断是否存在参数
		url = url.replace(/(\?|#)[^'"]*/, '');           //去除参数
		window.history.pushState({},0,url);
	}
		
	
		var pcount=$('#pageCount').val();
		var psize=$('#pageSize').val();
		var pstart=$('#pageStart').val();
		var product_name=$('#product_name').val();
		var nowpage=pstart/psize+1;
		//alert(pstart);
		var cpage=Math.ceil(pcount/psize);
		var strhtml="";
		if(cpage<=10){
			for(var i=1;i<=cpage;i++){
				if(i==nowpage){
					strhtml+='<a href=/product?pageStart='+psize*(i-1)+'&product_name='+product_name+' style="background-color:#aaaaaa">'+i+'</a>';
				}else{
					strhtml+='<span> <a href=/product?pageStart='+psize*(i-1)+'&product_name='+product_name+'>'+i+'</a></span>';
				}
			}
		}else if(cpage>10 && 1<=nowpage && nowpage<=6){		//pagestart=20 nowpage=11 cpage=15
			//alert("111111===" + nowpage);
			for(var i=1;i<=10;i++){
				if(i==nowpage){
					strhtml+='<a href=/product?pageStart='+psize*(i-1)+'&product_name='+product_name+' style="background-color:#aaaaaa;font-weight:700">'+i+'</a>';
					//strhtml+='<a href=/userAll?pageStart='+psize*(i-1)+' style="background-color:#aaaaaa"><div class="nowpage">'+i+'</div></a>';
				}else{
					strhtml+='<span> <a href=/product?pageStart='+psize*(i-1)+'&product_name='+product_name+'>'+i+'</a></span>';
				}
			}
		}else if(cpage>10 && nowpage<=cpage-4){
			//alert("222222===" + nowpage);
			for(var i=nowpage-5;i<=nowpage+4;i++){//6--15
				if(i==nowpage){
					strhtml+='<a href=/product?pageStart='+psize*(i-1)+'&product_name'+product_name+' style="background-color:#aaaaaa;font-weight:700">'+i+'</a>';
				}else{
					strhtml+='<span><a href=/product?pageStart='+psize*(i-1)+'&product_name'+product_name+'>'+i+'</a></span>';
				}
			}
		}else if(cpage>10 && cpage-4<nowpage && nowpage<=cpage){
			//alert("333333===" + nowpage);
			for(var i=cpage-9;i<=cpage;i++){
				if(i==nowpage){
					strhtml+='<a href=/product?pageStart='+psize*(i-1)+'&product_name='+product_name+' style="background-color:#aaaaaa;font-weight:700">'+i+'</a>';
				}else{
					strhtml+='<span> <a href=/product?pageStart='+psize*(i-1)+'&product_name='+product_name+'>'+i+'</a></span>';
				}
			}
		}else{
		}
		$("#mydiv").html(strhtml);
		
	});
function goto(id){
	$.ajax({
		url:"/updateQ",
		type:"post",
		data:{"product_id":id},
		success:function(data){
			console.log(data);
			$(".productId").val(data.product.productId);
			$(".productName").text(data.product.productName);
			$(".productInfo").text(data.product.productInfo);
			$(".price").text(data.product.price);
		},
		error:function(){
			alert("error");
		}
	})
	$(".masking").show();
}