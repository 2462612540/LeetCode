/**
 * Copyright (C), 2018-2020
 * FileName: SequenceListTest
 * Author:   xjl
 * Date:     2020/3/6 14:39
 * Description: 测试代码
 */
package JAVA_sort_arithmetic.test;

import JAVA_sort_arithmetic.src.linear.SequenceList;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SequenceListTest {

    @Test
    public void test1() {
        //创建顺序表的对象
        SequenceList<String> sequenceList = new SequenceList<>(6);
        //测试插入
        sequenceList.insert("姚1");
        sequenceList.insert("姚2");
        sequenceList.insert("姚3");
        sequenceList.insert("姚4");
        sequenceList.insert(1, "庄小焱");
        sequenceList.insert(2, "庄2焱");
        for (String s : sequenceList) {
            System.out.println(s);
        }
        System.out.println("------------------------------------------------");
        //测试获取
        System.out.println(sequenceList.indexof("庄小焱"));
        // 测试删除
        String name = sequenceList.remove(3);
        System.out.println("清空的数据是：" + name);
        // 测试清空
        sequenceList.clear();
        System.out.println("清空的长度是" + sequenceList.length());
    }

    /**
     * 测试顺序表的扩容问题
     * 在两个时候可能存在扩容问题：添加元素的时候
     * 一个就会就是在删除元素的时候
     */
    @Test
    public void test2() {
        //创建顺序表的对象
        SequenceList<String> sequenceList = new SequenceList<>(3);
        sequenceList.insert("庄1");
        sequenceList.insert("庄2");
        sequenceList.insert("庄3");
        sequenceList.insert("庄4");
        sequenceList.insert("庄5");
        List list=new ArrayList();
    }
}
