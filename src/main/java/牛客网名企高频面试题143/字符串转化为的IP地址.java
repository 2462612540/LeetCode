package 牛客网名企高频面试题143;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname 字符串转化为的IP地址
 * @Description TODO
 * @Date 2020/12/18 13:27
 * @Created by xjl
 */
public class 字符串转化为的IP地址 {
    ArrayList<String> res = new ArrayList<>();

    public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> segment = new ArrayList<>();
        //开始搜索
        dfs(s, 0, segment);
        return res;
    }

    private void dfs(String s, int start, List<String> segment) {
        if (start == s.length()) {
            if (segment.size() == 4) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < segment.size(); i++) {
                    sb.append(segment.get(i));
                    if (i != segment.size() - 1) sb.append('.');
                }
                res.add(sb.toString());
            } else {
                return;
            }
        } else {
            if (segment.size() >= 4) {
                return;
            }
            for (int i = start; i < s.length() && i < start + 3; i++) {
                String str = s.substring(start, i + 1);
                if (str.charAt(0) == '0' && str.length() > 1) break;
                int num = Integer.parseInt(str);
                if (num >= 0 && num <= 255) {
                    segment.add(str);
                    dfs(s, i + 1, segment);
                    segment.remove(segment.size() - 1);
                } else {
                    break;
                }
            }
        }
    }
}
