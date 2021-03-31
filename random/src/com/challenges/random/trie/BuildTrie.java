package com.challenges.random.trie;

public class BuildTrie {

    TrieNode root;

    public BuildTrie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        char[] wArr = word.toCharArray();
        TrieNode current = root;

        for (char w : wArr) {
            TrieNode temp = current.children.get(w);
            if (temp == null) {
                temp = new TrieNode();
                current.children.put(w, temp);
            }
            current = temp;
        }

        current.isEnd = true;
    }
}
