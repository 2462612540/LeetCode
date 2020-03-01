/**
 * Copyright (C), 2018-2020
 * FileName: SingleTest
 * Author:   xjl
 * Date:     2020/2/25 21:47
 * Description: 单例模式的测试类
 */
package JAVA_pattern;

/**
 * 单例模式：保证类在内存中只有一个对象
 * 如何保证：
 * 1 构造方法进行私有
 * 2在成员位置中创建一个对象
 * 3通过一个公共的方法提供访问
 */
public class SingleTest {
    public static void main(String[] args) {
        //通过单例设计的模式
        Student s=Student.getStudent();
        Student s1=Student.getStudent();
        System.out.println(s==s1);
    }
}
