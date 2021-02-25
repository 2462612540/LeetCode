/**
 * Copyright (C), 2018-2020
 * FileName: hasGroupsSizeX
 * Author:   xjl
 * Date:     2020/3/27 15:15
 * Description: 给定一副牌，每张牌上都写着一个整数。  此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：      每组都有 X 张牌。     组内所有的牌上都写着相同的整数。  仅当你可选的 X >= 2 时返回 true。  来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/x-of-a-kind-in-a-deck-of-cards 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package leetcode练习题;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 遍历这数组，将其放入 Arraylist中就可，如果包含的货那就删除一直到查看是否有空既可以
 * stack
 */
public class hasGroupsSizeX {
    public boolean hasGroupsSizeX(int[] deck) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < deck.length; i++) {
            if (!set.contains(deck[i])) {
                set.add(deck[i]);
            } else {
                set.remove(deck[i]);
            }
        }
        return set.size() == 0;
    }

    public boolean hasGroupsSizeX2(int[] deck) {
        int[] count = new int[10000];
        for (int c : deck) {
            count[c]++;
        }
        int g = -1;
        for (int i = 0; i < 10000; ++i)
            if (count[i] > 0) {
                if (g == -1)
                    g = count[i];
                else
                    g = gcd(g, count[i]);
            }
        return g >= 2;
    }

    public int gcd(int x, int y) {
        return x == 0 ? y : gcd(y % x, x);
    }

    /**
     * 求解最大公约数的赞转相除的算法
     */
    public int GCD(int a, int b) {
//       if(b==0){
//           return a;
//       }else {
//           return Maxyue(b,a%b);
//       }
        int c = a % b;
        while (c != 0) {
            a = b;
            b = c;
            c = a % b;
        }
        return b;
    }

    public boolean hasGroupsSizeX3(int[] deck) {
        if (deck.length == 1) {
            return false;
        }
        int count = 1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < deck.length; i++) {
            if (!map.containsKey(deck[i])) {
                map.put(deck[i], count);
            } else {
                map.put(deck[i], map.get(deck[i]) + 1);
            }
        }
        int[] arr = new int[map.size()];
        int j = 0;
        for (Integer key : map.keySet()) {
            arr[j++] = map.get(key);
        }
        int result = 0;
        for (int i = 0; i < arr.length; ++i){
            if (i == 0) {
                result = arr[0];
            } else {
                result = GCD(result, arr[i]);
            }
        }
        return result>=2;
    }

    @Test
    public void test() {
        int[] numbers = {1, 2, 3, 4, 4, 3, 2, 1, 1, 1};
        System.out.println(hasGroupsSizeX3(numbers));
    }

    @Test
    public void test3() {
        int[] arr = {325, 130, 270, 150};
        int result = 0;
        for (int i = 0; i < arr.length; ++i){
            if (i == 0) {
                result = arr[0];
            } else {
                result = GCD(result, arr[i]);
            }
        }

        System.out.println(result);
    }

    @Test
    public void test2() {
        System.out.println(GCD(325, 130));
    }

}
