var InItShop = function () {
    $.ajax({
        url:"/provide/getshop",
        type : "get",
        dataType : "JSON",
        success:function (data) {
            var providerInfo = document.getElementById("providerInfo");
            providerInfo.value=data.introduction;

            var qq = document.getElementById("qq");
            qq.value=data.qq;
            var cellphone =document.getElementById("cellphone");
            cellphone.value=data.servicePhone;

            var count=$("#workTime").find("option").length;

            for(var i=0;i<count;i++)
            {
                if($("#workTime").get(0).options[i].text == data.worktime) {
                $("#workTime").get(0).options[i].selected = true;
                break;
            }
            }
        }
    })
};