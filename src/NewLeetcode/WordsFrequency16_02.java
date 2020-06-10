/**
 * Copyright (C), 2018-2020
 * FileName: WordsFrequency16_02
 * Author:   xjl
 * Date:     2020/6/10 15:22
 * Description: 面试题 16.02. 单词频率
 */
package NewLeetcode;

import java.util.HashMap;
import java.util.Map;

public class WordsFrequency16_02 {

    Map<String, Integer> map = new HashMap<>();

    public WordsFrequency16_02(String[] book) {
        for (int i = 0; i < book.length; i++) {
            if (!map.containsKey(book[i])) {
                map.put(book[i], 1);
            } else {
                map.put(book[i], map.get(book[i]) + 1);
            }
        }
    }

    public static void main(String[] args) {
        String[] book = {"i", "have", "an", "apple", "he", "have", "a", "pen"};
        WordsFrequency16_02 obj = new WordsFrequency16_02(book);
        int i = obj.get("i");
        System.out.println(i);
    }

    public int get(String word) {
        if (map.containsKey(word)) {
            return map.get(word);
        }
        return 0;
    }

}
