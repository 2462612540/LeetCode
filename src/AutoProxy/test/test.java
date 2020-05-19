/**
 * Copyright (C), 2018-2020
 * FileName: test20200430
 * Author:   xjl
 * Date:     2020/3/10 13:20
 * Description: 测试方法
 */
package AutoProxy.test;

import AutoProxy.java.UserDao;
import AutoProxy.java.UserDaoImpl;
import AutoProxy.proxy2.LogUserProxy;
import org.junit.Test;

public class test {
    /**
     * 静态的代理的测试
     */
    @Test
    public void test(){
        UserDao userDao=new UserDaoImpl();
        UserDao proxy=new LogUserProxy(userDao);
        proxy.query("xiaoyan ");
    }
}
