package 计算机程序算法分类.二叉树问题;

import 牛客网练习题.Solution;

/**
 * @Classname Trie前缀树208
 * @Description TODO
 * @Date 2021/4/16 9:22
 * @Created by xjl
 */
public class Trie {
    private Trie[] children;
    private boolean isEnd;

    //构造函数
    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }

    //插入函数
    public void insert(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Trie();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    //查询函数
    public boolean search(String word) {
        Trie node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    //匹配函数
    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    private Trie searchPrefix(String prefix) {
        Trie node = this;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                return null;
            }
            node = node.children[index];
        }
        return node;
    }
}
