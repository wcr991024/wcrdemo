var InItaccount = function () {
    $.ajax({
        url:"/member/getlogin",
        dataType:"JSON",
        type:"get",
        success:function (data) {

            sessionStorage.setItem("gender", "");
            //姓名
            if (data.name!=null&&data.name!="null"&&data.name!=""){
                var name = document.getElementById("name");
                name.value=data.name;
            }
            //性别
            if (data.gender!=null&&data.gender!="null"&&data.gender!=""){
                if (data.gender=="1"){
                    $("#male").attr(checked, true);
                }
                else {
                    $("#girl").attr(checked, true);
                }
            }
            //头像
            if (data.headImg!=null&&data.headImg!="null"&&data.headImg!=""){
                var headimg = document.getElementById("logimg");
                headimg.setAttribute("src",data.headImg);
            }

            //邮箱
            if (data.email!=null&&data.email!="null"&&data.email!=""){
                var email = document.getElementById("email");
                email.value=data.email;
            }


        }
    })
};

function setgendermale() {
    sessionStorage.setItem("gender", "1");
}

function setgendergirl() {
    sessionStorage.setItem("gender","2")
}