package com.roamer.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

/**
 * @author roamer
 * @version V1.0
 * @date 2018/10/16 23:31
 */
public class Test {
    public static void main(String[] args) {
        // 从配置文件中加载用户、角色、权限信息
        // 生成securityManagerFactory
        Factory<SecurityManager> securityManagerFactory = new IniSecurityManagerFactory("classpath:shiro.ini");
        // 产生securityManager对象
        SecurityManager securityManager = securityManagerFactory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        // 获取Subject(主题可以是用户,也可以是另一个程序)信息
        Subject currSubject = SecurityUtils.getSubject();
        Session session = currSubject.getSession();
        session.setAttribute("ok", true);
        /**
         * 用户包括两部分
         *    principals and credentials
         *     principals（本人）表示用户的标识信息 比如用户名 用户地址等
         *     credentials（凭证）表示用户用于登录的凭证 比如密码 证书等
         */
        if (!currSubject.isAuthenticated()) {

        }

    }
}
