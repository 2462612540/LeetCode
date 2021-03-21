package leetode每日一题;

/**
 * @Classname test
 * @Description TODO
 * @Date 2021/3/14 11:00
 * @Created by xjl
 */
public class test {

    public static void main(String[] args) {
        String str = "You shall seal the blinding light that plagues their dreams.You Are The Vessel, You Are THe Hollow Knight.!";

        String s = goodString(str);
        System.out.println(s);

    }

    public static String goodString(String paper) {
        int index1 = 0;
        String substr = "";
        String result = "";
        for (int i = index1; i < paper.length(); i++) {
            if (paper.charAt(i) == ',' || paper.charAt(i) == '.' || paper.charAt(i) == '!') {
                //开始对每一段进行分析
                result += goodString2(substr) + paper.charAt(i);
                //新的下一个
                substr = "";
            } else {
                //如果不是的一直连起来
                substr += paper.charAt(i);
            }
        }
        return result;
    }

    private static String goodString2(String str) {
        String res = "";
        String[] arr = str.split(" ");
        if (arr.length == 0) {
            return null;
        }
        if (arr.length == 1) {
            return str;
        }
        String frist = "";
        String oldstr = "";

        String three = "";

        for (int i = 0; i < arr.length; i++) {
            //判断是否为好词
            if (goodString3(arr[i])) {
                //如果到了最后的位置
                if (i + 1 > arr.length - 1) {
                    frist += String.valueOf(arr[i].charAt(0));
                    oldstr += arr[i] + " ";
                    break;
                }//还有下一个位置
                if ((i + 1) <= arr.length - 1) {
                    if (goodString3(arr[i + 1])) {
                        //判断下一个是好词
                        frist += String.valueOf(arr[i].charAt(0)) + String.valueOf(arr[i + 1].charAt(0));
                        oldstr += arr[i] + " " + arr[i + 1] + " ";
                        i++;
                        continue;
                    } else {
                        //判断下一个不是好词
                        frist = "";
                        oldstr += arr[i] + " " + arr[i + 1] + " ";
                        continue;
                    }
                }
            } else {
                if (frist.length() >= 2) {
                    res = frist + " " + "(" + oldstr.trim() + ") "+arr[i]+" ";
                    frist = "";
                    oldstr = "";
                }else {
                    oldstr += arr[i] + " ";
                }
            }
        }
        if (frist.length() != 0) {
            //结束了
            res += frist + " " + "(" + oldstr.trim() + ")";
        } else {
            res = oldstr.trim();
        }
        return res;
    }

    /**
     * @description TODO 是否包含一个大写字母
     * @param: str
     * @date: 2021/3/14 12:08
     * @return: boolean
     * @author: xjl
     */
    private static boolean goodString3(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                count++;
            }
        }
        return count == 1;
    }
}
