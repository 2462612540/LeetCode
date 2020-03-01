/**
 * Copyright (C), 2018-2020
 * FileName: AnimalFactory
 * Author:   xjl
 * Date:     2020/2/25 18:31
 * Description: 工厂类
 */
package JAVA_pattern;

public class AnimalFactory {

    private AnimalFactory() {
    }
    public static Animal createAnimal(String type){
        if("dog".equals(type)){
            return new Dog();
        }else if ("cat".equals(type)) {
            return new Cat();
        }else {
            return null;
        }
    }
//    public static Dog creatDog() {
//        return new Dog();
//    }
//
//    public static Cat creatCat() {
//        return new Cat();
//    }

}
