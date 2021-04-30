package testcode;

/**
 * @Classname test2
 * @Description TODO
 * @Date 2021/4/21 15:31
 * @Created by xjl
 */
public class test2 {
    public static void main(String[] args) {
        int[] array={7,6,5,4,3,2,1};
        int[] result=test_01(array);
        for (int i:result){
            System.out.print(i+" ");
        }
    }

    private static int[] test_01(int[] array) {
        if (array.length==0)return null;
        int[] result=new int[array.length];
        int left=0;
        int right=array.length-1;
        int index=0;
        while (left<=right){
            if (left==right){
                result[index++]=array[right--];
            }else {
                result[index++]=array[right--];
                result[index++]=array[left++];
            }
        }
        return result;
    }
}
