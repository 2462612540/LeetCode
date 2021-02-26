package 牛客网名企面试笔试问题2021;

/**
 * @Classname 最长的递增子序列的字符
 * @Description TODO
 * @Date 2021/2/26 10:30
 * @Created by xjl
 */
public class 最长的递增子序列的字符 {

        /**
         * retrun the longest increasing subsequence
         * @param arr int整型一维数组 the array
         * @return int整型一维数组
         */
        /**
         本质是求最长上升子序列，采用动态规划：
         dp存储每个元素往前的最长子数列大小
         dp[i]=max(dp[i],dp[j]+1)
         j为0-i-1中比arr[i]小的子数列数据
         为了避免重复比较，用end数组村塾最长上升子序列
         当arr[i]>end[len]时，arr[i]添加到end后面
         负责从end 0->len范围内查找到第一个比arr[i]大的元素进行替换，此处采用二分法查找
         **/
        public int[] LIS (int[] arr) {
            // write code here
            int n = arr.length;
            //列表的最大子序列，下标从1开始
            int[] end = new int[n+1];
            //存储每个元素的最大子序列个数
            int[] dp = new int[n];
            int len = 1;
            //子序列的第一个元素默认为数组第一个元素
            end[1] = arr[0];
            //第一个元素的最大子序列个数肯定是1
            dp[0] = 1;
            for(int i=0;i<n;i++){
                if(end[len]<arr[i]){
                    //当arr[i]>end[len]时，arr[i]添加到end后面
                    end[++len] = arr[i];
                    dp[i] = len;
                }else{
                    //当元素小于end中的最后一个元素，利用二分法查找第一个大于arr[i]的元素
                    //end[l]替换为当前元素dp[]
                          int l = 0;
                    int r = len;
                             while (l <= r) {
                        int mid = (l + r) >> 1;
                        if (end[mid] >= arr[i]) {
                            r = mid - 1;
                        } else {
                            l = mid + 1;
                        }
                    }
                    end[l] = arr[i];
                    dp[i] = l;
                }
            }
                 int[] res = new int[len];
            for(int j=n-1;j>=0;j--){
                if(dp[j]==len){
                    res[--len] = arr[j];
                }
            }
            return res;
        }
}
