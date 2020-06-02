$(function () {
    $.ajax({
        url: "api/v1/node/list",
        success : function(result) {
            console.log(result);
        },
        //请求失败，包含具体的错误信息
        error : function(e){
            console.log(e.status);
        }
    })

    $.ajax({
        type : "GET",
        url: "api/v1/node/docker-desktop",
        success : function(result) {
            console.log(result);
        },
        //请求失败，包含具体的错误信息
        error : function(e){
            console.log(e.status);
        }
    })
})