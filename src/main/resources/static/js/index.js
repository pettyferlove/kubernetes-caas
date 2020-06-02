$(function () {
    layui.use('element', function(){
        let element = layui.element; //导航的hover效果、二级菜单等功能，需要依赖element模块
        //监听导航点击
        element.on('nav(menu)', function(elem){
            $("#main-content").attr("src", elem.attr("url")||"dashboard")
        });
    });
})