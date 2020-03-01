/**
 * Copyright (C), 2018-2020
 * FileName: FactoryTest
 * Author:   xjl
 * Date:     2020/2/25 20:51
 * Description: 测试类
 */
package JAVA_pattern;

public class FactoryTest {
    public static void main(String[] args) {
        //买一只狗
        Factory f=new DogFactory();
        Animal dog=f.createAnimal();
        dog.eat();

        f=new CatFactory();
        Animal cat=f.createAnimal();
        cat.eat();
    }
}
