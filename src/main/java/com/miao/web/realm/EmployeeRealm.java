package com.miao.web.realm;

import com.miao.domain.Employee;
import com.miao.service.EmployeeService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @author miaoyin
 * @date 2021/1/19 - 12:22
 * @commet:
 */
public class EmployeeRealm extends AuthorizingRealm {

    @Autowired
    private EmployeeService employeeService;

    /*先认证*/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("来到了认证");
        /*拿到数据信息*/
        String username = (String) token.getPrincipal();
        System.out.println(username);

        /*到数据库查询认证*/
        Employee employee = employeeService.getEmployeeByUsername(username);
        if (employee.getUsername() == null) {
            return null;
        }
        /*认证*/
        /*参数：主体，正确的密码，盐，当前realm名称*/
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(
                employee,
                employee.getPassword(),
                ByteSource.Util.bytes(employee.getUsername()),
                this.getName());
        return info;
    }

    /*后授权*/
     /*授权
     web  doGetAuthorizationInfo 什么时候调用
     1.发现访问路径对应的方法上面 有授权注解  就会调用doGetAuthorizationInfo
     2.页面当中有授权标签  也会调用doGetAuthorizationInfo
    * */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("-------------------------------授权调用了");
        /*获取用户身份信息*/
        Employee employee = (Employee) principalCollection.getPrimaryPrincipal();
        /*根据当前用,查询角色和权限*/
        List<String> roles = new ArrayList<>();
        List<String> permissions = new ArrayList<>();

        /*判断当前用户是不是管理员 如果是管理员 拥有所有的权限*/
        if(employee.getAdmin()){
            /*拥有所有的权限*/
            permissions.add("*:*");
        }else {
            /*查询角色*/
            roles = employeeService.getRolesById(employee.getId());
            /*查询权限*/
            permissions = employeeService.getPermissionById(employee.getId());
        }

        /*给授权信息*/
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addRoles(roles);
        info.addStringPermissions(permissions);
        return info;
    }
}
