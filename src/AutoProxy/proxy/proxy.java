/**
 * Copyright (C), 2018-2020
 * FileName: LogUserProxy
 * Author:   xjl
 * Date:     2020/3/10 13:18
 * Description: 静态代理对象
 */
package AutoProxy.proxy;

import AutoProxy.java.UserDaoImpl;

//这里是继承了targetobject的父类对象，并进行了重写的一种操作。
public class proxy extends UserDaoImpl {
    public void query(String name) {
        System.out.println("long LogUserProxy……");
        System.out.println("query name= " + name);
    }
}
