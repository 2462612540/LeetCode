/**
 * Copyright (C), 2018-2020
 * FileName: Student
 * Author:   xjl
 * Date:     2020/5/31 21:10
 * Description: 学生测试类
 */
package Sort;

//对Comparable的接口的方法进行重写 对年龄大小进行排序
public class Student implements Comparable<Student> {
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

    @Override
    public int compareTo(Student o) {
        return this.getAge() - o.getAge();
    }
}
