package 计算机程序算法分类.贪心算法问题;

import org.junit.Test;

/**
 * @Classname 柠檬水找零
 * @Description TODO
 * @Date 2021/5/17 10:04
 * @Created by xjl
 */
public class 柠檬水找零 {
    public boolean lemonadeChange(int[] biils){
        //停机的店员拥有的5和10的数据量 不用统计的20的 因为不会需要找人家20的元 就是的没有比20大的钱
        int five=0,ten=0;
        for (int bill:biils){
            if (bill==5){
                //如果顾客使用的是5块的不需要找零 数量加1就行
                five++;
            }else if (bill==10){
                //如果是10需要找5块 所以是的5的数量减1 10的数量加1
                five--;
                ten++;
            }else if (ten>0){
                //否则是的我们需要的是减少10 和5块的各一个
                ten--;
                five--;
            }else {
                //否则是的如果两个都没有的话的 那就是的减少三个的5块的
                five-=3;
            }

            if (five<0){
                //直接判断的5元的数量的 如果是5元的数量是小于0 的话 那么就没法给顾客找零了那就是的返回是false
                return false;
            }
        }
        return true;
    }

    @Test
    public void test(){
        String str="123456789";
        System.out.println(str.substring(2));
    }
}
