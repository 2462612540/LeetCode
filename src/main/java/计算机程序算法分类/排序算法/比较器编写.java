/**
 * Copyright (C), 2018-2020
 * FileName: 比较器编写
 * Author:   xjl
 * Date:     2020/9/6 10:00
 * Description:
 */
package 计算机程序算法分类.排序算法;

public class 比较器编写 {

    private String username;
    private int age;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "username='" + username + '\'' +
                ", age=" + age +
                '}';
    }
}
