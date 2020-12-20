package 复现代码;

import java.util.*;

/**
 * @Classname Main
 * @Description TODO
 * @Date 2020/12/20 13:31
 * @Created by xjl
 */
public class 目标值和dfs {
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int target = sc.nextInt();
        int[] num = new int[m];
        for (int i = 0; i < m; i++) {
            num[i] = sc.nextInt();
        }
        ArrayList<ArrayList<Integer>> res = test(num, target);
        for (ArrayList<Integer> li : res) {
            for (int i : li) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        System.out.println(res.size());
    }

    public static ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        ArrayList<Integer> ls = new ArrayList<>();
        if (num == null || num.length == 0) {
            return list;
        }
        Arrays.sort(num);
        dfs(num, 0, target, ls);
        return list;
    }

    private static void dfs(int[] arr, int index, int sum, ArrayList<Integer> ls) {
        if (sum < 0) {
            return;
        }
        if (sum == 0 && !list.contains(ls)) {
            list.add(new ArrayList<>(ls));
            return;
        }
        for (int i = index; i < arr.length; i++) {
            ls.add(arr[i]);
            dfs(arr, i + 1, sum - arr[i], ls);
            ls.remove(ls.size() - 1);
        }
    }

    public static ArrayList<ArrayList<Integer>> test(int[] num, int target) {
        ArrayList<Integer> ls = new ArrayList<>();
        if (num == null || num.length == 0) {
            return list;
        }
        Arrays.sort(num);
        dfs1(num, 0, 0, target, ls);
        return list;
    }

    private static void dfs1(int[] num, int index, int curr, int target, ArrayList<Integer> ls) {
        if (curr == target) {
            Collections.sort(ls);
            if (!list.contains(ls) && new HashSet(ls).size() == ls.size()) {
                list.add(new ArrayList<>(ls));
            }
        }
        if (curr > target) {
            return;
        }
        for (int i = index; i < num.length; i++) {
            ls.add(num[i]);
            curr += num[i];
            dfs1(num, index + 1, curr, target, ls);
            curr -= num[i];
            ls.remove(ls.size() - 1);
        }
    }
}
