/**
 * Copyright (C), 2018-2020
 * FileName: SimpleFactoryTest
 * Author:   xjl
 * Date:     2020/2/25 18:20
 * Description: 简单工厂模式
 */
package JAVA_pattern;

public class SimpleFactoryTest {
    public static void main(String[] args) {
        //具体类的调用
        Dog d = new Dog();
        d.eat();

        Cat c = new Cat();
        c.eat();
        System.out.println("-------------");
        //通过工厂来进行调用
//        Dog DD=AnimalFactory.creatDog();
//        Cat CC=AnimalFactory.creatCat();
//
//        DD.eat();
//        CC.eat();
        //通过改进的工厂
        Animal dog = AnimalFactory.createAnimal("dog");
        dog.eat();
        Animal cat = AnimalFactory.createAnimal("cat");
        cat.eat();

        //nullpointException
        Animal b = AnimalFactory.createAnimal("pjg");
        if (b != null) {
            b.eat();
        }else {
            System.out.println("sorrry cant offer  Animal");
        }

    }
}
