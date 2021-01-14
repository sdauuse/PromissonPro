$(function () {
    /*角色列表展示*/
    $('#role_dg').datagrid({
        url: "roleList",
        columns: [[
            {field: 'rnum', title: '角色编号', width: 100, align: 'center'},
            {field: 'rname', title: '角色名称', width: 100, align: 'center'},
        ]],
        fit: true,
        fitColumns: true,//真正的自动展开/收缩列的大小，以适应网格的宽度，防止水平滚动。
        rownumbers: true,//显示一个行号列
        pagination: true,/*该分页控件允许用户导航页面的数据。它支持页面导航和页面长度选择的选项设置。用户可以在分页控件上添加自定义按钮，以增强其功能。*/
        singleSelect: true,
        striped: true,
        toolbar: "#toolbar", //添加工具栏
    });
    /*监听添加按钮点击*/
    $("#add").click(function () {

        /*清空已选权限*/
        $("#role_data2").datagrid("loadData", {rows: []});
        /*清空表单*/
        $('#myform').form('clear');
        /*打开表单*/
        $("#dialog").dialog("open");

    });

    /*新增按钮*/
    $("#add").click(function () {
        $("#dialog").dialog("setTitle", "新增角色");
        $("#myform").form("clear");
        $("#dialog").dialog("open");
    });

    /*对话框*/
    $("#dialog").dialog({
        title: '添加角色',
        width: 700,
        height: 530,
        closed: true,
        buttons: [{
            text: '保存',
            handler: function () {
                /*判断当前是保存操作还是编辑操作*/
                var rid = $("[name='rid']").val();
                var url;
                if (rid) {
                    /*编辑*/
                    url = "updateRole"
                } else {
                    /*保存*/
                    url = "saveRole";
                }

                /*提交表单*/
                $("#myform").form("submit", {
                    url: url,
                    method: 'post',
                    onSubmit: function (param) {  /*传递额外参数  已选择的权限*/

                        /*获取已经选择的权限*/
                        var allRows = $("#role_data2").datagrid("getRows");
                        /*遍历出每一个权限*/
                        for (var i = 0; i < allRows.length; i++) {
                            /*取出每一个权限 */
                            var row = allRows[i];
                            /*给它封装到集合中*/
                            param["permissions[" + i + "].pid"] = row.pid;
                        }

                    },
                    success: function (data) {
                        data = $.parseJSON(data);
                        if (data.success) {
                            /*新增成功*/
                            $.messager.alert("温馨提示", data.msg);
                            /*关闭对话框*/
                            $("#dialog").dialog("close");
                            /*重新加载表格数据*/
                            $("#role_dg").datagrid("reload");
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

    /*权限列表*/
    $("#role_data1").datagrid({
        title: "所有权限",
        width: 250,
        height: 310,
        fitColumns: true,
        singleSelect: true,
        url: 'permissionList',
        columns: [[
            {field: 'pname', title: '权限名称', width: 100, align: 'center'},
        ]],
        onClickRow: function (rowIndex, rowData) {/*点击一行时，回调*/
            /*判断是否已经存在该权限*/
            var allRows = $("#role_data2").datagrid("getRows");
            /*通过遍历判断是否存在该权限*/
            for (var i = 0; i < allRows.length; i++) {
                var row = allRows[i];
                if (rowData.pid == row.pid) {/*已经存在该权限*/
                    /*让已经存在权限成为选中的状态*/
                    /*获取已经成为选中状态当前角标*/
                    var index = $("#role_data2").datagrid("getRowIndex", row);
                    /*让该行成为选中状态*/
                    $("#role_data2").datagrid("selectRow", index);
                    return;
                }

            }

            /*把当前选中的权限，添加到已选权限中*/
            $("#role_data2").datagrid("appendRow", rowData);
        }
    });

    $("#role_data2").datagrid({
        title: "已选权限",
        width: 250,
        height: 310,
        singleSelect: true,
        fitColumns: true,
        columns: [[
            {field: 'pname', title: '权限名称', width: 100, align: 'center'},
        ]],
        onClickRow: function (rowIndex, rowData) {
            /*删除当中选中的一行*/
            $("#role_data2").datagrid("deleteRow", rowIndex);
        }
    });

    /*编辑按钮*/
    $("#edit").click(function () {
        /*获取当前选中的行*/
        var rowData = $("#role_dg").datagrid("getSelected");
        console.log(rowData);
        if (!rowData) {
            $.messager.alert("提示", "选择一行数据进行编辑");
            return;
        }
        /*加载当前角色下的权限*/
        var options = $("#role_data2").datagrid("options");
        options.url = "findPermissionByRid?rid=" + rowData.rid;
        /*重新加载数据*/
        $("#role_data2").datagrid("load");


        /*回显表单*/
        $("#myform").form("load", rowData);
        $("#dialog").dialog("setTitle", "编辑角色");
        /*打开对话框*/
        $("#dialog").dialog("open");
    });

    /*删除按钮*/
    $("#remove").click(function () {
        /*获取当前选中的行*/
        var rowData = $("#role_dg").datagrid("getSelected");
        console.log(rowData);
        if (!rowData) {
            $.messager.alert("提示", "选择一行数据进行删除");
            return;
        }

        $.messager.confirm("确认", "是否做删除操作", function (res) {
            if (res) {
                /*做离职操作*/
                $.get("deleteRole?rid=" + rowData.rid, function (data) {
                    if (data.success) {
                        $.messager.alert("温馨提示", data.msg);
                        /*重新加载数据表格*/
                        $("#role_dg").datagrid("reload");
                    } else {
                        $.messager.alert("温馨提示", data.msg);
                    }

                });
            }
        });

    });
});