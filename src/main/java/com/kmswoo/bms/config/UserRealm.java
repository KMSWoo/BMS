package com.kmswoo.bms.config;

import com.kmswoo.bms.mapper.UserMapper;
import com.kmswoo.bms.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;


public class UserRealm extends AuthorizingRealm {

    @Autowired
    UserMapper userMapper;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
//        System.out.println("Authorization");
        //设置角色
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();

        info.addRole(user.getRole());
        return info;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
//        System.out.println("Authentication");
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;

        User user = userMapper.queryUserByName(usernamePasswordToken.getUsername());
        if (user == null){
            return null;
        }

        String name = usernamePasswordToken.getUsername();
        //等同于
//        String name = usernamePasswordToken.getPrincipal().toString();
        String pwd = new String(usernamePasswordToken.getPassword());
        //等同于
//        String pwd = String.valueOf((char[]) usernamePasswordToken.getCredentials());
        String salt = user.getSalt();
        return new SimpleAuthenticationInfo(user,pwd, ByteSource.Util.bytes(salt),getName());
    }
}
