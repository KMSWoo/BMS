package com.kmswoo.bms.config;

import com.fasterxml.jackson.databind.SerializerProvider;
import com.kmswoo.bms.mapper.UserMapper;
import com.kmswoo.bms.pojo.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;


public class UserRealm extends AuthorizingRealm {

    @Autowired
    UserMapper userMapper;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
//        System.out.println("Authorization");
        return null;
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
        return new SimpleAuthenticationInfo(user.getName(),user.getPassword(),"");
    }
}
