/**
 * Copyright (C), 2018-2020
 * FileName: test20200508
 * Author:   xjl
 * Date:     2020/5/8 8:52
 * Description: 测试
 */
package CodingTest;

public class test20200508 extends Thread {

    public static void main(String[] args) {
        //  System.out.println(test());
        // test2();
        Thread thread = new Thread();
        thread.start();
        thread.run();
    }

    public static void test4() {
        String s1 = new String("woshi");
        String s2 = new String("woshi");
        //表示的是s1和s2的地址是不一样的，string不是基本的数据类型，==比较是的应用的是地址
        System.out.println(s1 == s2);
        StringBuilder stringBuilder = new StringBuilder();
        StringBuffer stringBuffer = new StringBuffer();
    }

    public static int test() {
        try {
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 1;
        } finally {
            System.out.println("你好");
        }
    }

    public static void test2() {
        //string是属于的是应用或者是说是包装数据类型
        String str1 = "hello";                        //str1指向堆内存中静态区
        String str2 = new String("hello");  //str2指向堆上的对象
        String str3 = "hello";                       //指向和str1相同的地址
        String str4 = new String("hello");  //建立了一个新的对象的
        System.out.println("*************************************************");
        System.out.println(str1.equals(str2)); //true 这是的equals方法被重新写了 就是去判断的两个值是否相同的string是不属于基本的数据类型的
        System.out.println(str2.equals(str4)); //true
        System.out.println("*************************************************");
        System.out.println(str1 == str3); //true
        System.out.println(str1 == str2); //false
        System.out.println(str2 == str4); //false
        System.out.println(str2 == "hello"); //false//判断是地址是否相同
        System.out.println("*************************************************");
        str2 = str1;
        System.out.println(str2 == "hello"); //true

    }

}
