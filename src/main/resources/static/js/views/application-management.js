$(function () {
    layui.use('table', function(){
        var table = layui.table;
        table.render({
            elem: '#development'
            ,url:'/demo/table/user/'
            ,cols: [[
                ,{field:'name',  title: '名称'}
                ,{field:'name',  title: '命名空间'}
                ,{field:'sex', title: '容器组', sort: true}
                ,{field:'city', title: '已运行时间'}
                ,{field:'sign', title: '创建时间'}
            ]]
            ,page: true
        });
    });

})