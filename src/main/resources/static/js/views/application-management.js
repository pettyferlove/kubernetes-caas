$(function () {


    /*$.ajax({
        url: "api/v1/deployment/list",
        success : function(result) {
            console.log(result);
        },
        //请求失败，包含具体的错误信息
        error : function(e){
            console.log(e.status);
        }
    })*/


    layui.use('table', function(){
        var table = layui.table;
        table.render({
            elem: '#development'
            ,url:'/api/v1/deployment/list'
            ,cols: [[
                {field:'name',  title: '名称'}
                ,{field:'namespace',  title: '命名空间'}
                ,{field:'sex', title: '容器组', sort: true}
                ,{field:'city', title: '已运行时间'}
                ,{field:'sign', title: '创建时间'}
            ]],
            parseData: function(res){ //res 即为原始返回的数据
                console.log(res)
                return {
                    "code": res.status, //解析接口状态
                    "msg": res.message, //解析提示文本
                    "count": res.total, //解析数据长度
                    "data": res.items
                };
            }
            ,request: {
                pageName: 'curr' //页码的参数名称，默认：page
                ,limitName: 'limit' //每页数据量的参数名，默认：limit
            }
            ,page: true
        });
    });

})