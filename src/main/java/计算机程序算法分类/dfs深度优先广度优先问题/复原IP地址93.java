package 计算机程序算法分类.dfs深度优先广度优先问题;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname 复原IP地址93
 * @Description TODO
 * @Date 2021/4/11 15:57
 * @Created by xjl
 */
public class 复原IP地址93 {
    static final int SEG_COUNT = 4;
    int[] segments = new int[SEG_COUNT];

    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<String>();
        dfs(ans, s, 0, 0);
        return ans;
    }

    public void dfs(List<String> ans, String s, int seg_number, int index) {
        // 如果找到了 4 段 IP 地址并且遍历完了字符串，那么就是一种答案
        if (seg_number == SEG_COUNT) {
            //遍历完成了全部的字符串
            if (index == s.length()) {
                StringBuffer ipAddr = new StringBuffer();
                for (int i = 0; i < SEG_COUNT; ++i) {
                    ipAddr.append(segments[i]);
                    if (i != SEG_COUNT - 1) {
                        ipAddr.append('.');
                    }
                }
                //添加到返回的结果中
                ans.add(ipAddr.toString());
            }
            return;
        }
        // 如果还没有找到 4 段 IP 地址就已经遍历完了字符串，那么提前回溯
        if (index == s.length()) {
            return;
        }
        // 由于不能有前导零，如果当前数字为 0，那么这一段 IP 地址只能为 0
        if (s.charAt(index) == '0') {
            segments[seg_number] = 0;
            dfs(ans, s, seg_number + 1, index + 1);
        }

        // 一般情况，枚举每一种可能性并递归
        int addr = 0;
        for (int segEnd = index; segEnd < s.length(); segEnd++) {
            addr = addr * 10 + (s.charAt(segEnd) - '0');
            if (addr > 0 && addr <= 255) {
                segments[seg_number] = addr;
                dfs(ans, s, seg_number + 1, segEnd + 1);
            } else {
                break;
            }
        }
    }
}
