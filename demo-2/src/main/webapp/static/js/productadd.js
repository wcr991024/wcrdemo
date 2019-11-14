function send(url,titilemess,testmess) {
    // 省
    var cmbProvince=document.getElementById('cmbProvince').value;
    // 市
    var cmbCity = document.getElementById('cmbCity').value;
    // 区
    var cmbArea = document.getElementById('cmbArea').value;
    // 服务类型
    var sortStyle = document.getElementById('sortStyle').value;
    // 服务分类
    var sortType = document.getElementById('sortType').value;
    // alert(cmbProvince+cmbCity+cmbArea+sortType+sortStyle);//测试
    var formdata = new FormData($('#productform')[0]);

    formdata.append("region",cmbProvince+"-"+cmbCity+"-"+cmbArea);
    formdata.append("styleId",sortStyle);
    formdata.append("typeId",sortType);
    swal({
        title: titilemess,
        text: testmess,
        type: "warning",
        showCancelButton: true,
        closeOnConfirm: false,
        confirmButtonText: "确定",
        confirmButtonColor: "#ec6c62"
    }, function() {
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
        }).error(function(data) {
            swal("OMG", "失败!", "error");
        });
    });
}