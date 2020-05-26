/**
 * Copyright (C), 2018-2020
 * FileName: test1
 * Author:   xjl
 * Date:     2020/4/22 10:45
 * Description: 测试Io的交集
 */
package CodingTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * java总的各种的输入的模板
 */
public class Main {
    private static class node {
        int id;
        String name;

        public node(int id, String name) {
            this.id = id;
            this.name = name;
        }

    }

    public static void main(String[] args) {
        //输入
        Scanner sc = new Scanner(System.in);
        String splittle = sc.nextLine();
        List<node> list = new ArrayList<>();
        do {
            String[] str = sc.nextLine().split(",");
            int id = Integer.valueOf(str[0]);
            String name = str[1];
            list.add(new node(id, name));
            if (sc.next().equals(" ")) {
                break;
            }
        }while (true);
    }

}


