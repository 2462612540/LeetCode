/**
 * Copyright (C), 2018-2020
 * FileName: TestComparable
 * Author:   xjl
 * Date:     2020/3/6 7:51
 * Description: 测试的接口
 */
package JAVA_sort_arithmetic.test;

import JAVA_sort_arithmetic.src.base_sort.Student;

public class TestComparable {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setAge(20);
        s1.setUsername("张三");
        Student s2 = new Student();
        s2.setUsername("李四");
        s2.setAge(36);

        Comparable max = getMax(s1, s2);
        System.out.println(max);

    }

    public static Comparable getMax(Comparable c1, Comparable c2) {
        int result = c1.compareTo(c2);
        if (result >= 0) {
            return c1;
        } else {
            return c2;
        }
    }
}
