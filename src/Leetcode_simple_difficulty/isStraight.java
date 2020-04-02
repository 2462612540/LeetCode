/**
 * Copyright (C), 2018-2020
 * FileName: isStraight
 * Author:   xjl
 * Date:     2020/4/2 14:40
 * Description: 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。  来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package Leetcode_simple_difficulty;

public class isStraight {
    public boolean isStraight(int[] nums) {
        for (int i=1;i<nums.length;i++){
            if (nums[i]!=nums[i-1]+1){
                return false;
            }
            continue;
        }
        return true;
    }
}
