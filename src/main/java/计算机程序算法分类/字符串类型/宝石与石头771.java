package 计算机程序算法分类.字符串类型;

import org.junit.Test;

import java.util.HashMap;

/**
 * @Classname 宝石与石头771
 * @Description TODO
 * @Date 2021/7/3 20:55
 * @Created by xjl
 */
public class 宝石与石头771 {
    /**
     * @description TODO 采用的的hashmap的思想
     * @param: jewels
     * @param: stones
     * @date: 2021/7/3 21:14
     * @return: int
     * @author: xjl
     */
    public int numJewelsInStones(String jewels, String stones) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < stones.length(); i++) {
            if (map.containsKey(stones.charAt(i))) {
                map.put(stones.charAt(i), map.get(stones.charAt(i)) + 1);
            } else {
                map.put(stones.charAt(i), 1);
            }
        }

        int count = 0;

        for (int i = 0; i < jewels.length(); i++) {
            if (map.containsKey(jewels.charAt(i))) {
                count += map.get(jewels.charAt(i));
            }
        }
        return count;
    }

    public int numJewelsInStones2(String J, String S) {
        return S.replaceAll("[^" + J + "]", "").length();
    }



    @Test
    public void test() {
        int i = numJewelsInStones("z", "ZZ");
        System.out.println(i);
    }
}
