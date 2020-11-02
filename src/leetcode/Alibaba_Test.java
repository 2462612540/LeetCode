/**
 * Copyright (C), 2018-2020
 * FileName: Alibaba_Test
 * Author:   xjl
 * Date:     2020/8/15 9:56
 * Description: 阿里测试
 */
package leetcode;

import java.util.*;

/**
 * 输入多行字母 选择最大程度的序列
 */
public class Alibaba_Test {
    //定义一个对象
    public static class Node {
        char start;
        char end;
        int length;
        String content;

        public Node(char start, char end, int length, String content) {
            this.start = start;
            this.end = end;
            this.length = length;
            this.content = content;
        }

        public char getStart() {
            return start;
        }

        public char getEnd() {
            return end;
        }

        public int getLength() {
            return length;
        }

        public String getContent() {
            return content;
        }
    }

    public static void main(String[] args) {

        //数据的输入
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] array = new String[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextLine();
        }

        //函数的调用
        String result = test0001(array);

        //打印结果

        System.out.println(result);
    }

    public static String test0001(String[] array) {
        String result = "";
        List<Node> list = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            String str = array[i];
            Node node = new Node(str.charAt(0), str.charAt(str.length() - 1), array.length, array[i]);
            list.add(node);
        }
        //list排序
        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Integer.valueOf(o1.start) - Integer.valueOf(o2.start);
            }
        });
        //开始连接
        result = list.get(0).getContent();
        //判断是否加入第二个节点
        for (int i = 2; i < list.size(); i++) {
            //第一个节点
            Node frist = list.get(i - 1);
            //第二节点
            Node second = list.get(i);
            //如果是第二节点的头部大于尾部
            if (second.start > frist.end) {
                //直接加入第一个
                result += frist.getContent();
            }
            //

        }
        //需要判断最后的一个的情况
        return result;
    }
}
