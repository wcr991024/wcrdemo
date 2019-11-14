function edit(providerId) {
    if (providerId){
        document.cookie="productId="+providerId+"; max-age =;"+1*60*60;
        location.reload("./service_edit.html");
    }
}