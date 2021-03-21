package 牛客网名企面试笔试问题2021;

/**
 * @Classname 零钱兑换
 * @Description TODO
 * @Date 2021/3/8 10:53
 * @Created by xjl
 */
public class 零钱兑换 {

    int res = Integer.MAX_VALUE;

    public int coinChange(int[] coins, int amount) {
        if(coins.length == 0){
            return -1;
        }
        dfs(coins,amount,0);
        // 如果没有任何一种硬币组合能组成总金额，返回 -1。
        if(res == Integer.MAX_VALUE){
            return -1;
        }
        return res;
    }

    public void dfs(int[] coins,int amount,int count){
        if(amount < 0){
            return;
        }
        if(amount == 0){
            res = Math.min(res,count);
        }

        for(int i = 0;i < coins.length;i++){
            dfs(coins,amount-coins[i],count+1);
        }
    }
}
