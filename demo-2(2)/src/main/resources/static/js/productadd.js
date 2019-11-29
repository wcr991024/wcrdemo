function send(url,titilemess,testmess) {
    // alert(cmbProvince+cmbCity+cmbArea+sortType+sortStyle);//测试
    var formdata = new FormData($('#productform')[0]);

    swal({
        title: titilemess,
        text: testmess,
        type: "warning",
        showCancelButton: true,
        closeOnConfirm: false,
        confirmButtonText: "确定",
        confirmButtonColor: "#ec6c62"
    }, function() {
        var flag = false;

        for (var value of formdata.values()) {
            if (value==''){
                layer.msg('信息未输入完全', {icon: 5});
                flag=true;
                return 0;
            }
        }
        if (!flag){
            $.ajax({
                url: url,        //后台url
                data: formdata,
                type: "POST", //类型，POST或者GET
                cache: false,
                processData: false,
                contentType: false,
                dataType: 'json' //数据返回类型，可以是xml、json等
            }).done(function(data) {
                if (data.flag=="成功"){
                    swal({
                        title: "操作成功",
                        text: "成功",
                        icon: "success",
                        dangerMode: true,
                    },function () {
                        location.reload();
                    });
                }
                else {
                    swal({
                        title: "操作失败",
                        text: data.flag,
                        icon: "error",
                        dangerMode: true,
                    },function () {
                        location.reload();
                    });
                }
            })
        }

    });
}