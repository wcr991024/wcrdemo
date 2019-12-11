function checkcookie() {

    var id = getCookie("providerId");
    if ((id=="")){
        location.href = "service_login.html"
    }
    if ((id==null)){
        location.href = "service_login.html"
    }
    if ((id=="null")){
        location.href = "service_login.html"
    }
}