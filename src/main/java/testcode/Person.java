package testcode;

import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Classname 深浅拷贝
 * @Description TODO
 * @Date 2021/3/16 14:24
 * @Created by xjl
 */
public class Person {
    // 姓名
    private String name;
    // 年龄
    private int age;
    // 邮件
    private String email;
    // 描述
    private String desc;

    public Person(String name, int age, String email, String desc) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * @description TODO  直接赋值的方式没有生产新的对象，只是生新增了一个对象引用  这相当于是的浅拷贝的原理 深拷贝是将产生一个新的引用地址的
     * @param: args
     * @date: 2021/3/16 14:28
     * @return: void
     * @author: xjl
     */
    public static void main(String[] args) {
        // 初始化一个对象
        Person person = new Person("张三", 20, "123456@qq.com", "我是张三");
        // 复制对象
        Person person1 = person;
        // 改变 person1 的属性值
        person1.setName("我不是张三了");
        System.out.println("person 对象：" + person);
        System.out.println("person1对象：" + person1);

        ConcurrentHashMap map = new ConcurrentHashMap();

        String[] aa = {"a", "b", "c", "d", "e"};
        StringBuilder reverse = new StringBuilder(Arrays.toString(aa)).reverse();
        System.out.println(reverse);

    }
}
