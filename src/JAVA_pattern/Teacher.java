/**
 * Copyright (C), 2018-2020
 * FileName: Teacher
 * Author:   xjl
 * Date:     2020/2/25 22:32
 * Description: 懒汉模式测试
 */
package JAVA_pattern;

public class Teacher {
    private Teacher() {
    }

    private static Teacher t = null;

    //在用的时候在才去创建对象
    public static Teacher getTeacher() {
        if(t==null){
            t=new Teacher();
        }
        return t;
    }
}
