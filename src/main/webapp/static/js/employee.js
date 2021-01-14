$(function () {
    /*员工列表展示*/
    $('#dg').datagrid({
        url: "employeeList",
        columns: [[
            {field: 'username', title: '姓名', width: 100, align: 'center'},
            {field: 'inputtime', title: '入职时间', width: 100, align: 'center'},
            {field: 'tel', title: '电话', width: 100, align: 'center'},
            {field: 'email', title: '邮箱', width: 100, align: 'center'},
            {
                field: 'department', title: '部门', width: 100, align: 'center', formatter: function (value, row, index) {
                    if (value) {
                        return value.name;
                    }
                }
            },
            /*row是查询出来的一行的数据，value是该参数的数据*/
            {
                field: 'state', title: '状态', width: 100, align: 'center', formatter: function (value, row, index) {
                    if (row.state) {
                        return "在职";
                    } else {
                        return "<font style='color: red'>离职</font>";
                    }
                }
            },
            {
                field: 'admin', title: '管理员', width: 100, align: 'center', formatter: function (value, row, index) {
                    if (row.admin) {
                        return "管理员";
                    } else {
                        return "非管理员";
                    }
                }
            },
        ]],
        fit: true,
        fitColumns: true,//真正的自动展开/收缩列的大小，以适应网格的宽度，防止水平滚动。
        rownumbers: true,//显示一个行号列
        pagination: true,/*该分页控件允许用户导航页面的数据。它支持页面导航和页面长度选择的选项设置。用户可以在分页控件上添加自定义按钮，以增强其功能。*/
        singleSelect: true,
        striped: true,
        toolbar: "#tb", //添加工具栏
        onClickRow:function (rowIndex,rowData) {
            /*判断当前行是否是离职状态*/
            if(!rowData.state){
                /*离职,把离职按钮禁用*/
                $("#delete").linkbutton("disable");
            }else {
                /*离职,把离职按钮启用*/
                $("#delete").linkbutton("enable");
            }
        }
    });


    /*对话框*/
    $("#dialog").dialog({
        title: '员工添加',
        width: 330,
        height: 370,
        closed: true,
        buttons: [{
            text: '保存',
            handler: function () {
                /*通过是否存在id，判断是新增还是修改操作*/
                var url;
                /*把name = id 的值取出来*/
                var id = $("[name='id']").val();
                if (id) {
                    url = "updateEmployee";
                } else {
                    url = "saveEmployee";
                }

                /*提交表单*/
                // $('#employeeForm').attr("method", 'post');
                $("#employeeForm").form("submit", {
                    url: url,
                    method: 'post',
                    success: function (data) {
                        data = $.parseJSON(data);
                        if (data.success) {
                            /*新增成功*/
                            $.messager.alert("温馨提示", data.msg);
                            /*关闭对话框*/
                            $("#dialog").dialog("close");
                            /*重新加载表格数据*/
                            $("#dg").datagrid("reload");
                        } else {
                            /*新增失败*/
                            $.messager.alert("温馨提示", data.msg);
                        }
                    }

                });
            }
        }, {
            text: '关闭',
            handler: function () {
                /*关闭表单*/
                $("#dialog").dialog("close");

            }
        }]
    });


    /*监听添加按钮点击*/
    $("#add").click(function () {

        /*将密码字段改为必填字段*/
        $("[name='password']").validatebox({required: true});

        $("#password").show();
        /*清空表单*/
        $('#employeeForm').form('clear');
        /*打开表单*/
        $("#dialog").dialog("open");

    });

    /*监听编辑按钮*/
    $("#edit").click(function () {
        var rowData = $("#dg").datagrid("getSelected");
        /*如果没有选中数据*/
        if (!rowData) {
            $.messager.alert("提示", "请选择一行数据进行编辑");
            return;
        }

        /*将密码字段的必填框去掉*/
        $("[name='password']").validatebox({required: false});
        /*弹出对话框*/
        $("#password").hide();
        $("#dialog").dialog("setTitle", "编辑员工");
        /*回显部门*/
        rowData["department.id"] = rowData["department"].id;
        /*回显管理员*/
        rowData["admin"] = rowData["admin"] + "";

        $("#dialog").dialog("open");
        $("#employeeForm").form("load", rowData);

    });

    /*设置员工离职状态*/
    $("#delete").click(function () {
        /*选中当前行*/
        var rowData = $("#dg").datagrid("getSelected");
        if (!rowData) {
            $.messager.alert("提示", "请选择一行进行编辑");
            return;
        }
        $.messager.confirm("确认", "是否做离职操作", function (res) {
            if (res) {
                /*做离职操作*/
                $.get("updateState?id=" + rowData.id, function (data) {
                    if (data.success) {
                        $.messager.alert("温馨提示", data.msg);
                        /*重新加载数据表格*/
                        $("#dg").datagrid("reload");
                    } else {
                        $.messager.alert("温馨提示", data.msg);
                    }

                });
            }
        });

    });

    /*监听搜索按钮点击*/
    $("#searchbtn").click(function () {
        /*获取搜索的内容*/
        var keyword =  $("[name='keyword']").val();
        /*重新加载列表  把参数keyword传过去*/
        $("#dg").datagrid("load",{keyword:keyword});
    });
    /*监听刷新点击*/
    $("#reload").click(function () {
        /*清空搜索内容*/
        $("[name='keyword']").val('');
        /*重新加载数据*/
        $("#dg").datagrid("load",{});
    });


    /*部门选择，下拉列表*/
    $("#department").combobox({
        width: 150,
        panelHeight: 'auto',
        editable: false, //不允许编辑
        valueField: 'id', //哪个字段发送给服务器
        textField: 'name', //哪个字段展示给客户端
        url: 'departList',  //从数据库中查询department的数据并
        onLoadSuccess: function () { /*数据加载完毕之后回调*/
            $("#department").each(function (i) {
                var span = $(this).siblings("span")[i];
                var targetInput = $(span).find("input:first");
                if (targetInput) {
                    $(targetInput).attr("placeholder", $(this).attr("placeholder"));
                }
            });
        }
    });

    /*是否为管理员，下拉列表*/
    $("#state").combobox({
        width: 150,
        panelHeight: 'auto',
        editable: false, //不允许编辑
        valueField: 'value', //哪个字段发送给服务器
        textField: 'label', //哪个字段展示给客户端
        data: [{
            label: '是',
            value: 'true'
        }, {
            label: '否',
            value: 'false'
        }],
        onLoadSuccess: function () { /*数据加载完毕之后回调*/
            $("#state").each(function (i) {
                var span = $(this).siblings("span")[i];
                var targetInput = $(span).find("input:first");
                if (targetInput) {
                    $(targetInput).attr("placeholder", $(this).attr("placeholder"));
                }
            });
        }

    });

});