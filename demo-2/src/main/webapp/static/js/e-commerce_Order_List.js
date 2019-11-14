function orderonclick(page) {
    $.ajax({
        url:"/order/memberlist",
        type:"post",
        dataType:"json",
        data:{"page":page,
              "word":sessionStorage.getItem("word"),
              "startDate":sessionStorage.getItem("startdate"),
              "endDate":sessionStorage.getItem("enddate")},
        success:function (data) {

            var strhtml='';
            for (var i=0;i< data.size;i++){
                //转换时间
                var date=new Date(data.list[i].createTime);
                Y = date.getFullYear() + '-';
                M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
                D = date.getDate() + ' ';
                h = date.getHours() + ':';
                m = date.getMinutes() + ':';
                s = date.getSeconds();


                strhtml+='<div class="orders">\n' +
                    '                <div class="order-num">订单号：'+data.list[i].id+' 下单时间：'+Y+M+D+h+m+s+'</div>\n' +
                    '                <ul class="order-details">\n' +
                    '                    <li>\n' +
                    '                        <img src="./images/user-lg.png" alt="图片">\n' +
                    '                        <ul>\n' +
                    '                            <li>'+data.list[i].unit+'</li>\n' +
                    '                            <li>'+data.list[i].serviceName+'</li>\n' +
                    '                        </ul>\n' +
                    '                        <p style="width: 70px;text-align:right;">¥'+data.list[i].unitPrice+'</p>\n' +
                    '                        <p style="width: 20px;text-align:right;">'+data.list[i].buyNum+'</p>\n' +
                    '                    </li>\n' +
                    '                    <li class="font-aqua">¥'+data.list[i].totalPrice+'</li>\n' +
                    '                    <li class="font-aqua">已付款</li>\n' +
                    '                    <li>交易完成</li>\n' +
                    '                </ul>\n' +
                    '            </div>';
            }
            $("#orderlist").empty();

            $("#orderlist").append(strhtml);

            var optionString2 = "";
            for (var i=1;i<data.pages+1;i++){
                if (i==data.pageNum){
                    optionString2+='<li value="'+i+'"><a class="active" href="#">'+i+'</a></li>';
                    continue;
                }
                if(i<data.pageNum+2&&i>data.pageNum-2){
                    optionString2+='<li value="'+i+'"><a onclick="orderonclick('+i+')">'+i+'</a></li>';
                }
            }
            $("#orderpage").empty();
            $("#orderpage").append(optionString2);
        }
    })
}

function setTime() {
    var starttime = document.getElementById("startdate");
    var endtime = document.getElementById("enddate");

    sessionStorage.setItem("startdate", starttime.value);
    sessionStorage.setItem("enddate", endtime.value);
    sessionStorage.setItem("word", "");

}

function selecttime() {
    orderonclick(1);
}

function selectname() {
    var word = document.getElementById("word");
    var starttime = document.getElementById("startdate");
    var endtime = document.getElementById("enddate");
    starttime.value="";
    endtime.value="";
    sessionStorage.setItem("startdate", "");
    sessionStorage.setItem("enddate", "");
    sessionStorage.setItem("word", word.value);
    orderonclick(1);
}
