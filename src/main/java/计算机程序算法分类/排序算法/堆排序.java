package 计算机程序算法分类.排序算法;

import org.junit.Test;

/**
 * @Classname 堆排序
 * @Description TODO
 * @Date 2021/3/23 10:51
 * @Created by xjl
 */
public class 堆排序 {
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * @description TODO  构建一个最大的堆
     * @param: tree
     * @param: n
     * @date: 2021/3/23 11:00
     * @return: void
     * @author: xjl
     */
    public static void buildheap(int[] tree, int n) {
        int last_node = n - 1;
        int parent = (last_node - 1) / 2;
        int i;
        for (i = parent; i >= 0; i--) {
            adjustheap(tree, n, i);
        }
    }

    public static void adjustheap(int[] tree, int n, int i) {
        //递归的出口实现
        if (n <= i) {
            return;
        }
        int c1 = 2 * i + 1;
        int c2 = 2 * i + 2;
        int max = i;
        if (c1 < n && tree[c1] > tree[max]) {
            max = c1;
        }
        if (c2 < n && tree[c2] > tree[max]) {
            max = c2;
        }
        if (max != i) {
            swap(tree, max, i);
            //递归进行的子树的进行的改正
            adjustheap(tree, n, max);
        }
    }

    //声明全局变量，用于记录数组array的长度；
    static int len;

    /**
     * 堆排序算法
     *
     * @param array
     * @return
     */
    public static int[] HeapSort(int[] array) {
        len = array.length;
        if (len < 1) return array;
        //1.构建一个最大堆
        buildMaxHeap(array);
        //2.循环将堆首位（最大值）与末位交换，然后在重新调整最大堆
        while (len > 0) {
            swap(array, 0, len - 1);
            len--;
            adjustHeap(array, 0);
        }
        return array;
    }

    /**
     * 建立最大堆
     *
     * @param array
     */
    public static void buildMaxHeap(int[] array) {
        //从最后一个非叶子节点开始向上构造最大堆
        //for循环这样写会更好一点：i的左子树和右子树分别2i+1和2(i+1)
        for (int i = (len / 2 - 1); i >= 0; i--) {
            adjustHeap(array, i);
        }
    }

    /**
     * 调整使之成为最大堆
     *
     * @param array
     * @param i
     */
    public static void adjustHeap(int[] array, int i) {
        int maxIndex = i;
        //如果有左子树，且左子树大于父节点，则将最大指针指向左子树
        if (i * 2 < len && array[i * 2] > array[maxIndex])
            maxIndex = i * 2 + 1;
        //如果有右子树，且右子树大于父节点，则将最大指针指向右子树
        if (i * 2 + 1 < len && array[i * 2 + 1] > array[maxIndex])
            maxIndex = i * 2 + 2;
        //如果父节点不是最大值，则将父节点与最大值交换，并且递归调整与父节点交换的位置。
        if (maxIndex != i) {
            swap(array, maxIndex, i);
            adjustHeap(array, maxIndex);
        }
    }
}
