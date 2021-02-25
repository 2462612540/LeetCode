package leetcode练习题;

/**
 * Copyright (C), 2018-2020
 * FileName: leetcode.Pagehandler
 * Author:   xjl
 * Date:     2020/2/24 9:15
 * Description: 常用语分页的算法
 */

public class Pagehandler {
    public static void main(String[] args) {
        /**
         * 1 通过查询的制定的商品的总的数据totalsize
         * 2 获取每页需要展示的数据pagesize
         *      返回总的页数 totalPage
         * 3 当前段发送的页码数字page 后端并返回数据：
         *      3.1 $sql = "SELECT * FROM `message` limit $start,$size";
         *           start=page*20 size=20
         *          该sql语句表示从表message中的第10行开始取后面的三条记录,也就是第10、11、12行的数据，共三条。
         *          将返回的数据做好封装并返回前段AngularJS解析数据
         */
        int totalRows = 129;//总条数据（根据函数去查SQL中的商品的总的数据）
        int pageSize = 20;//每页条数(自定义的显示页数、可以是获取到指定的数)
        int totalPage;//总页数
        if ((totalRows % pageSize) == 0) {
            totalPage = totalRows / pageSize;
        } else {
            totalPage = totalRows / pageSize + 1;
        }
        System.out.println("总页数：" + totalPage);
    }

}
