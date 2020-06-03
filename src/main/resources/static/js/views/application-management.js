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
            ,url:'/api/v1/deployment/all/list'
            ,cols: [[
                {field:'name',  title: '名称'}
                ,{field:'imagesName',  title: '镜像名称'}
                ,{field:'namespace',  title: '命名空间'}
                ,{field:'groupStatus', title: '容器组状态', sort: true}
                ,{field:'creationTimestamp', title: '创建时间'}
            ]],
            parseData: function(res){ //res 即为原始返回的数据
                console.log(res.data.records)
                return {
                    "code": res.status, //解析接口状态
                    "msg": res.message, //解析提示文本
                    "count": res.data.total, //解析数据长度
                    "data": res.data.records
                };
            }
            ,request: {
                pageName: 'current' //页码的参数名称，默认：page
                ,limitName: 'size' //每页数据量的参数名，默认：limit
            }
            ,page: true,response: {
                statusCode: 200 //重新规定成功的状态码为 200，table 组件默认为 0
            }
        });
    });

})