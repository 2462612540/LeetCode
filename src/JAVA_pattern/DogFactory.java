/**
 * Copyright (C), 2018-2020
 * FileName: DogFactory
 * Author:   xjl
 * Date:     2020/2/25 20:52
 * Description: 狗工厂
 */
package JAVA_pattern;

public class DogFactory implements Factory {

    public Animal createAnimal() {
        return new Dog();
    }
}
