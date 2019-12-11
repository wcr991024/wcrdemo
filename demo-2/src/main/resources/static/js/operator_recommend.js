$(".user-arrow-down").on("click", function () {
    if ($(".dropdown").is(":hidden")) {
        $(".dropdown").show();
    } else {
        $(".dropdown").hide();
    }
})
$(".sort li").eq(0).on("click", function () {
    $(".sort li").removeClass("font-red");
    $(this).addClass("font-red");
})
$(".sort li").eq(1).on("click", function () {
    $(".sort li").removeClass("font-red");
    $(this).addClass("font-red");
})
$(".sort li").eq(2).on("click", function () {
    $(".sort li").removeClass("font-red");
    $(this).addClass("font-red");
})
$(function(){
	
	var url=window.location.href;                    //获取当前页面的url
	if(url.indexOf("?")!=-1){                                 //判断是否存在参数
		url = url.replace(/(\?|#)[^'"]*/, '');            //去除参数
		window.history.pushState({},0,url);
	}
	
		var pcount=$('#pageCount').val();
		var psize=$('#pageSize').val();
		var pstart=$('#pageStart').val();
		var product_name=$('#product_name').val();
		var nihao=$('#nihao').val();
		var nowpage=pstart/psize+1;
		//alert(pstart);
		var cpage=Math.ceil(pcount/psize);
		var strhtml="";
		
		if(cpage<=10){
			for(var i=1;i<=cpage;i++){
				if(i==nowpage){
					strhtml+='<a href=/'+ nihao+'?pageStart='+psize*(i-1)+'&product_name='+product_name+' style="background-color:#aaaaaa">'+i+'</a>';
				}else{
					strhtml+='<span> <a href=/'+ nihao+'?pageStart='+psize*(i-1)+'&product_name='+product_name+'>'+i+'</a></span>';
				}
			}
		}else if(cpage>10 && 1<=nowpage && nowpage<=6){		//pagestart=20 nowpage=11 cpage=15
			//alert("111111===" + nowpage);
			for(var i=1;i<=10;i++){
				if(i==nowpage){
					strhtml+='<a href=/'+ nihao+'?pageStart='+psize*(i-1)+'&product_name='+product_name+' style="background-color:#aaaaaa;font-weight:700">'+i+'</a>';
					//strhtml+='<a href=/userAll?pageStart='+psize*(i-1)+' style="background-color:#aaaaaa"><div class="nowpage">'+i+'</div></a>';
				}else{
					strhtml+='<span> <a href=/'+ nihao+'?pageStart='+psize*(i-1)+'&product_name='+product_name+'>'+i+'</a></span>';
				}
			}
		}else if(cpage>10 && nowpage<=cpage-4){
			//alert("222222===" + nowpage);
			for(var i=nowpage-5;i<=nowpage+4;i++){//6--15
				if(i==nowpage){
					strhtml+='<a href=/'+ nihao+'?pageStart='+psize*(i-1)+'&product_name'+product_name+' style="background-color:#aaaaaa;font-weight:700">'+i+'</a>';
				}else{
					strhtml+='<span><a href=/'+ nihao+'?pageStart='+psize*(i-1)+'&product_name'+product_name+'>'+i+'</a></span>';
				}
			}
		}else if(cpage>10 && cpage-4<nowpage && nowpage<=cpage){
			//alert("333333===" + nowpage);
			for(var i=cpage-9;i<=cpage;i++){
				if(i==nowpage){
					strhtml+='<a href=/'+ nihao+'?pageStart='+psize*(i-1)+'&product_name='+product_name+' style="background-color:#aaaaaa;font-weight:700">'+i+'</a>';
				}else{
					strhtml+='<span> <a href=/'+ nihao+'?pageStart='+psize*(i-1)+'&product_name='+product_name+'>'+i+'</a></span>';
				}
			}
		}else{
			console.error(00000000);
		}
		$("#mydiv").html(strhtml);
		
	});

$(".paijia-btn").on("click", function(){
    location.href="/paijia"
})
$(".paixiao-btn").on("click", function(){
    location.href="/paixiao"
})
$(".tuijian-btn").on("click", function(){
    location.href="/tuijian"
})

