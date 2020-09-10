/**
 * Copyright (C), 2018-2020
 * FileName: 有效的IP93
 * Author:   xjl
 * Date:     2020/9/10 14:05
 * Description:
 */
package 深度优先广度优先问题;

import java.util.ArrayList;
import java.util.List;

public class 有效的IP93 {

    List<String> res = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        //分割的段数
        List<String> segment = new ArrayList<>();
        //开始搜索
        dfs(s, 0, segment);
        return res;
    }

    private void dfs(String s, int start, List<String> segment) {
        if (start == s.length()) {
            if (segment.size() == 4) {
                //如果分割的结果是是4段 就将结果保留在res
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < segment.size(); i++) {
                    sb.append(segment.get(i));
                    //注意在最后的一个是不用的加 .的
                    if (i != segment.size() - 1) sb.append('.');
                }
                //将结果都加入其中
                res.add(sb.toString());
            }
            return;
        } else {
            //如果是段大于4段的直接返回空
            if (segment.size() >= 4) return;
            //取三个字符的这个效果
            for (int i = start; i < s.length() && i < start + 3; i++) {
                String str = s.substring(start, i + 1);
                //如果str的第一个是0 直接break
                if (str.charAt(0) == '0' && str.length() > 1) break;
                //计算这个数据是不是在0 255 之间  那就添加到结果中
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
