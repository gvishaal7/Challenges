package com.challenges.random.trie;

public class SearchTrie {

    public boolean search(TrieNode node, String word) {
        char[] wArray = word.toCharArray();
        for (char w : wArray) {
            TrieNode temp = node.children.get(w);
            if (temp == null) {
                return false;
            }
            node = temp;
        }
        return node.isEnd;
    }
}
