/**
 * Copyright (C), 2018-2020
 * FileName: Student
 * Author:   xjl
 * Date:     2020/2/25 21:46
 * Description: 学生类
 */
package JAVA_pattern;

/**
 * 保证泪在单例模式中只有一个对象
 */
public class Student {
    //构造私有方法
    private  Student(){}
    //自己构建一个对象
    //不能让外界直接进行访问
    private static Student s=new Student();
    //提供公共访问的方法
    public static Student getStudent(){
        return s;
    }
}
