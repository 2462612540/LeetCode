package 计算机程序算法分类.二叉树问题;

import java.util.HashMap;

/**
 * @Classname TrieNode
 * @Description TODO 这是一种叫做 单词查找树 的结构。它由字符串键中所有的字符构造而成，允许使用被查找键中的字符进行查找。其中包括插入、查找、删除，寻找前缀等操作。
 * @Date 2021/4/16 9:28
 * @Created by xjl
 */
public class TrieII {
    public class TrieNode {
        public int path;//表示当前节点所能链接到其他节点的个数（在删除操作中会用到）
        public int end;//表示以当前节点为结尾的单词的个数
        public HashMap<Character, TrieNode> next;//HashMap<Character, TrieNode>类型，表示当前节点能链接到的所有节点。

        public TrieNode() {
            path = 0;
            end = 0;
            next = new HashMap<>();
        }
    }

    private TrieNode root;

    public TrieII() {
        root = new TrieNode();
    }

    /**
     * @description TODO 插入的数据
     * @param: word
     * @date: 2021/4/16 9:37
     * @return: void
     * @author: xjl
     */
    public void insert(String word) {
        if (word == null || word.equals("")) return ;
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            //如果是不是包含这个节点的话就新建一个节点
            if (!node.next.containsKey(ch)) {
                node.next.put(ch, new TrieNode());
            }
            //如果是包含的话获取他的下一个节点
            node = node.next.get(ch);
            node.path++;
        }
        //表示以当前节点为结尾的单词的个数加1
        node.end++;
    }

    /**
     * @description TODO 查找树
     * @param: word
     * @date: 2021/4/16 9:37
     * @return: boolean
     * @author: xjl
     */
    public boolean search(String word) {
        if (word == null || word.equals("")) return false;
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.next.containsKey(ch)) return false;
            node = node.next.get(ch);
        }
        if (node.end == 0) return false;
        return true;
    }

    /**
     * @description TODO 匹配的
     * @param: word
     * @date: 2021/4/16 9:38
     * @return: boolean
     * @author: xjl
     */
    public boolean startsWith(String word) {
        if (word == null || word.equals("")) return false;
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.next.containsKey(ch)) return false;
            node = node.next.get(ch);
        }
        return true;
    }

    /**
     * @description TODO 删除
     * @param: word
     * @date: 2021/4/16 9:38
     * @return: void
     * @author: xjl
     */
    public void delete(String word) {
        if (word == null || word.equals("") || !search(word)) return;
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (--node.next.get(ch).path == 0) {
                node.next.remove(ch);
                return;
            }
            node = node.next.get(ch);
        }
        node.end--;
    }
}
