/**
 * Copyright (C), 2018-2020
 * FileName: SequenceListTest
 * Author:   xjl
 * Date:     2020/3/6 13:55
 * Description: 顺序表
 */
package JAVA_sort_arithmetic.src.linear;

import java.util.Iterator;

public class SequenceList<T> implements Iterable<T> {
    //成员变量
    private T[] eles;//表示的是存储元素的数组
    private int N;//表示线性表的长度

    //构造函数
    public SequenceList(int capacity) {
        //初始化数组
        this.eles = (T[]) new Object[capacity];
        //初始化数组的长度
        this.N = 0;
    }

    //成员函数

    /**
     * 空质线性表
     */
    public void clear() {
        this.N = 0;
    }

    ;

    /**
     * 判断线性表是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return N == 0;
    }

    ;

    /**
     * h获取线性表的长度
     *
     * @return
     */
    public int length() {
        return N;
    }

    ;

    /**
     * 获取线性表中的制定的元素
     *
     * @param i
     * @return
     */
    public T get(int i) {
        return eles[i];
    }

    ;

    /**
     * 在线性表中的第i个元素插入一个值为t的一个数据
     *
     * @param i
     * @param t
     */
    public void insert(int i, T t) {
        if (N > eles.length * 0.75) {
            resize(2 * eles.length);
        }
        //将把i的及其以后的元素向后移动一位
        for (int index = N; index > i; index--) {
            eles[index] = eles[index - 1];
        }
        //再把t的元素的索引放入i既可以
        eles[i] = t;
        //元素个数
        N++;
    }

    /**
     * 向线性表中的插入一个数据
     *
     * @param t
     */
    public void insert(T t) {
        if (N > eles.length * 0.75) {
            resize(2 * eles.length);
        }
        eles[N++] = t;
    }

    /**
     * 删除线性表的中的数据
     *
     * @param i
     * @return
     */
    public T remove(int i) {
        if (N < eles.length * 0.25) {
            resize(eles.length / 2);
        }
        //将位置向前移动
        for (int index = i; i < N; i++) {
            eles[index] = eles[index + 1];
        }
        //元素个数-1
        N--;
        //记录索引i处的位置
        return eles[i];
    }

    /**
     * 返回线性表中的收储出现的制定的元素 如果不存在的话则返回-1
     *
     * @param t
     * @return
     */
    public int indexof(T t) {
        for (int i = 0; i < N; i++) {
            if (eles[i].equals(t)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * y属于内部类的写法
     */
    private class SIterator implements Iterator {
        private int cusor;

        public SIterator() {
            this.cusor = 0;
        }

        @Override
        public boolean hasNext() {
            return cusor < N;
        }

        @Override
        public Object next() {
            return eles[cusor++];
        }
    }

    @Override
    public Iterator iterator() {
        return new SIterator();
    }

    /**
     * 扩容
     *
     * @param newsize
     */
    public void resize(int newsize) {
        //顶一个临时数组 指引原来的数组
        T[] temp = eles;
        //创建一个新的数组
        eles = (T[]) new Object[newsize];
        //把原来的数据拷贝到数组既可以
        for (int i = 0; i < N; i++) {
            eles[i] = temp[i];
        }
    }
}
