var InItSeeting=function () {
  $.ajax({
      url:"/provide/getshop",
      type : "get",
      dataType : "JSON",
      success:function (data) {
          var password =document.getElementById("password");
          password.value=data.servicePassword;
          var name =document.getElementById("name");
          name.value=data.serviceName;
          var cellphone = document.getElementById("cellphone");
          cellphone.value=data.servicePhone;
          var weixin =document.getElementById("weixin");
          weixin.value=data.wechat;
          var qq =document.getElementById("qq");
          qq.value=data.qq;
          var email = document.getElementById("email");
          email.value=data.email;
          if (data.area!=null&&data.area.search("-")!=-1){
              var region=data.area.split("-");
              addressInit('cmbProvince', 'cmbCity', 'cmbArea',region[0],region[1],region[2]);
          }else {
              addressInit('cmbProvince', 'cmbCity', 'cmbArea',"省","市","区")
          }
          var img = document.getElementById("showimg");
          if (data.serviceHead!=null){
              img.setAttribute("src",data.serviceHead);
          }else {
              img.setAttribute("src","./images/default_user.png");
          }

      }
  })
};