/**
 * Copyright (C), 2018-2020
 * FileName: Student
 * Author:   xjl
 * Date:     2020/3/6 7:43
 * Description: 学生类
 */
package JAVA_sort_arithmetic.src.base_sort;

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
        return this.age - o.age;
    }
}
