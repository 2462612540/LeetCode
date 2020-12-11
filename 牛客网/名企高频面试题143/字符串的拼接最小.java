package 名企高频面试题143;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @Classname 字符串的拼接最小
 * @Description TODO
 * @Date 2020/12/11 18:09
 * @Created by xjl
 */
public class 字符串的拼接最小 {
    /**
     * @description TODO 字符串在有序就可以是的整个都是有序的
     * @param: strs
     * @date: 2020/12/11 18:59
     * @return: java.lang.String
     * @author: xjl
     */
    public String minString2(String[] strs) {
        int len = strs.length;
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1 + o2).compareTo(o2 + o1);
            }
        });
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < len; i++) {
            sb.append(strs[i]);
        }
        return sb.toString();
    }

    @Test
    public void test() {
        String string = minString(new String[]{"abc", "de"});
        System.out.println("*************");
        System.out.println(string);
    }

    public String minString(String[] strs) {
        if (strs.length == 0) {
            return null;
        }
        ArrayList<ArrayList<String>> lists = new ArrayList<>();
        ArrayList<String> list = new ArrayList<>();
        boolean[] vis = new boolean[strs.length];
        dfs(strs, list, lists, vis);

        ArrayList<String> ans = new ArrayList<>();
        for (ArrayList<String> list1 : lists) {
            String res = "";
            for (String s : list1) {
                res += s;
            }
            ans.add(res);
        }
        Collections.sort(ans);
        return ans.get(0);
    }

    private void dfs(String[] strs, ArrayList<String> list, ArrayList<ArrayList<String>> lists, boolean[] vis) {
        if (list.size() == strs.length) {
            lists.add((ArrayList<String>) list.clone());
        }
        for (int i = 0; i < strs.length; i++) {
            if (!vis[i]) {
                list.add(strs[i]);
                vis[i] = true;
                dfs(strs, list, lists, vis);
                list.remove(list.size() - 1);
                vis[i] = false;
            }
        }
    }
}
