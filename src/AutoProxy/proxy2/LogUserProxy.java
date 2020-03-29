/**
 * Copyright (C), 2018-2020
 * FileName: LogUserProxy
 * Author:   xjl
 * Date:     2020/3/10 13:18
 * Description: 静态代理对象
 */
package AutoProxy.proxy2;

import AutoProxy.java.UserDao;

//这里是继承了targetobject的父类对象，并进行了重写的一种操作。
public class LogUserProxy implements UserDao {
    private UserDao userDao;

    public LogUserProxy(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void query(String name) {
        System.out.println("log proxy");
        userDao.query("query2……"+name);
    }
}
