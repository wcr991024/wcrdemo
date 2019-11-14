function update(formid) {

    var workTime = document.getElementById("workTime").value;
    var formdata = new FormData($(formid)[0]);
    formdata.append("workTime",workTime);
    swal({
        title: "更新数据？",
        text: "您确定要提交信息？",
        type: "warning",
        showCancelButton: true,
        closeOnConfirm: false,
        confirmButtonText: "提交",
        confirmButtonColor: "#ec6c62"
    }, function() {
        $.ajax({
            url: "/provide/upshop",
            data: formdata,
            type: "POST", //类型，POST或者GET
            cache: false,
            processData: false,
            contentType: false,
            dataType: 'json', //数据返回类型，可以是xml、json等
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
            }else {
                swal({
                    title: "操作失败",
                    text: data.flag,
                    icon: "error",
                    dangerMode: true,
                },function () {
                    location.reload();
                })
            }

        }).error(function(data) {
            swal("OMG", "操作失败了!", "error");
        });
    });
}