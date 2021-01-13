<%--
  Created by IntelliJ IDEA.
  User: 75164
  Date: 2021/1/13
  Time: 13:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="/static/common/common.jsp" %>
    <script src="${pageContext.request.contextPath}/static/js/employee.js"></script>
</head>
<body>
<%--<h1>employee主页</h1>--%>
<%--工具栏--%>
<div id="tb">
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" id="add">添加</a>
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true" id="edit">编辑</a>
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" id="delete">删除</a>
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-reload',plain:true" id="reload">刷新</a>

</div>
<%--数据表格--%>
<table id="dg"></table>

<%--对话框--%>
<%--<table id="dialog" align="center" style="border-spacing: 0px 10px">
    <form id="employeeForm">
        <tr>
            <td align="center">用户名:</td>
            <td><input name="username" type="text" class="easyui-validatebox" data-options="required:true"></td>
        </tr>
        <tr>
            <td align="center">密码:</td>
            <td><input name="password" type="text" class="easyui-validatebox" data-options="required:true"></td>
        </tr>
        <tr>
            <td align="center">手机:</td>
            <td><input name="tel" type="text" class="easyui-validatebox"></td>
        </tr>
        <tr>
            <td align="center">邮箱:</td>
            <td><input name="email" type="text" class="easyui-validatebox"
                       data-options="required:true,validType:'email'"></td>
        </tr>
        <tr>
            <td align="center">入职日期:</td>
            <td><input name="inputtime" type="text" class="easyui-datebox" required="required"></td>
        </tr>
        <tr>
            <td align="center">部门:</td>
            <td><input name="department.id" id="department" placeholder="请选择部门"></td>
        </tr>
        <tr>
            <td align="center">是否管理员:</td>
            <td><input name="admin" id="state" placeholder="是否为管理员"></td>
        </tr>
    </form>
</table>--%>
<div id="dialog">
    <form id="employeeForm">
        <%--添加一个隐藏域  编辑--%>
<%--        <input type="hidden" name="id">--%>
        <table align="center" style="border-spacing: 0px 10px">
            <tr>
                <td>用户名:</td>
                <td><input type="text" name="username" class="easyui-validatebox" data-options="required:true"></td>
            </tr>
            <tr id="password">
                <td>密码:</td>
                <td><input type="text" name="password" class="easyui-validatebox"></td>
            </tr>
            <tr>
                <td>手机:</td>
                <td><input type="text" name="tel" class="easyui-validatebox" ></td>
            </tr>
            <tr>
                <td>邮箱:</td>
                <td><input type="text" name="email" class="easyui-validatebox" ></td>
            </tr>
            <tr>
                <td>入职日期:</td>
                <td><input type="text" name="inputtime" class="easyui-datebox"></td>
            </tr>
            <tr>
                <td>部门:</td>
                <td><input id="department" name="department.id" placeholder="请选择部门"/></td>
            </tr>
            <tr>
                <td>是否管理员:</td>
                <td><input id="state" name="admin" placeholder="是否为管理员"/></td>
            </tr>
        </table>
    </form>

</div>

</body>
</html>