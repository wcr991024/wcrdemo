$(".user-arrow-down").on("click",function(){
    if($(".dropdown").is(":hidden")){
        $(".dropdown").show();
 }else{
       $(".dropdown").hide();
 }
})
$(".business-order").on("click", function(){
    $(".main-content").show();
    $("table").show();
    $(".main-pagination").show();
    $(".main-sercive").hide();
    $(".business-order").addClass("border-red");
    $(".service-order").removeClass("border-red");
    $(".main-top li").eq(3).text("注册用户");
})
$(".service-order").on("click", function(){
    $(".main-content").hide();
    $("table").hide();
    $(".main-pagination").hide();
    $(".main-sercive").show();
    $(".service-order").addClass("border-red");
    $(".business-order").removeClass("border-red");
    $(".main-top li").eq(3).text("服务商用户");
})

$(function() {
	
	var url=window.location.href;                    //获取当前页面的url
	if(url.indexOf("?")!=-1){                          //判断是否存在参数
		url = url.replace(/(\?|#)[^'"]*/, '');           //去除参数
		window.history.pushState({},0,url);
	}
	
				var pcount = $('#pageCount').val();
				var psize = $('#pageSize').val();
				var pstart = $('#pageStart').val();
				var name = $('#name').val();
				var nowpage = pstart / psize + 1;
				//alert(pstart);
				var cpage = Math.ceil(pcount / psize);
				var strhtml = "";

				if (cpage <= 10) {
					for (var i = 1; i <= cpage; i++) {
						if (i == nowpage) {
							strhtml += '<a href=/yonghu?pageStart=' + psize
									* (i - 1) + '&name=' + name
									+ ' style="background-color:#aaaaaa">' + i
									+ '</a>';
						} else {
							strhtml += '<span> <a href=/yonghu?pageStart='
									+ psize * (i - 1) + '&name=' + name + '>'
									+ i + '</a></span>';
						}
					}
				} else if (cpage > 10 && 1 <= nowpage && nowpage <= 6) { //pagestart=20 nowpage=11 cpage=15
					//alert("111111===" + nowpage);
					for (var i = 1; i <= 10; i++) {
						if (i == nowpage) {
							strhtml += '<a href=/yonghu?pageStart='
									+ psize
									* (i - 1)
									+ '&name='
									+ name
									+ ' style="background-color:#aaaaaa;font-weight:700">'
									+ i + '</a>';
							//strhtml+='<a href=/userAll?pageStart='+psize*(i-1)+' style="background-color:#aaaaaa"><div class="nowpage">'+i+'</div></a>';
						} else {
							strhtml += '<span> <a href=/yonghu?pageStart='
									+ psize * (i - 1) + '&name=' + name + '>'
									+ i + '</a></span>';
						}
					}
				} else if (cpage > 10 && nowpage <= cpage - 4) {
					//alert("222222===" + nowpage);
					for (var i = nowpage - 5; i <= nowpage + 4; i++) {//6--15
						if (i == nowpage) {
							strhtml += '<a href=/yonghu?pageStart='
									+ psize
									* (i - 1)
									+ '&name'
									+ name
									+ ' style="background-color:#aaaaaa;font-weight:700">'
									+ i + '</a>';
						} else {
							strhtml += '<span><a href=/yonghu?pageStart='
									+ psize * (i - 1) + '&name' + name + '>'
									+ i + '</a></span>';
						}
					}
				} else if (cpage > 10 && cpage - 4 < nowpage
						&& nowpage <= cpage) {
					//alert("333333===" + nowpage);
					for (var i = cpage - 9; i <= cpage; i++) {
						if (i == nowpage) {
							strhtml += '<a href=/yonghu?pageStart='
									+ psize
									* (i - 1)
									+ '&name='
									+ name
									+ ' style="background-color:#aaaaaa;font-weight:700">'
									+ i + '</a>';
						} else {
							strhtml += '<span> <a href=/yonghu?pageStart='
									+ psize * (i - 1) + '&name=' + name + '>'
									+ i + '</a></span>';
						}
					}
				} else {
					console.error(00000000);
				}
				$("#mydiv").html(strhtml);

			});
$(".handle-btn").on("click", function(event){
	goto($(this).siblings(".id").val());
    $(".masking").show();
})
function goto(id){
	$.ajax({
		url:"/selectconsumer",
		type:"post",
		data:{"id":id},
		success:function(data){
			console.log(data);
			$(".id").val(data.consumer.id);
			$(".code").text(data.consumer.code);
			$(".name").text(data.consumer.name);
			$(".cellphone").text(data.consumer.cellphone);
			$(".region").text(data.consumer.region);
			$(".registerTime").text(data.consumer.registerTime);
			$(".buyNum").text(data.consumer.buyNum);
			$(".price").text(data.consumer.price);
		},
		error:function(){
			alert("error");
		}
	})
	$(".masking").show();
}
$(".save-btn").on("click", function(){
    location.href="/yonghu"
})
