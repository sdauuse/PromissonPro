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
        // toolbar: "#tb", //添加工具栏
    });

});