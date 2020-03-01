/**
 * Copyright (C), 2018-2020
 * FileName: runtimeTest
 * Author:   xjl
 * Date:     2020/2/25 22:43
 * Description: 应用实例
 */
package JAVA_pattern;

public class runtimeTest {
    public static void main(String[] args) {

    }
}

class RunTime {
    //饿汉式的设计
    private RunTime(){}
    private  static  RunTime currentRuntime=new RunTime();
    public static RunTime getCurrentRuntime(){
        return currentRuntime;
    }
}
