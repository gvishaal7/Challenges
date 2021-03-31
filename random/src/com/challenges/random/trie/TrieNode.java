package com.challenges.random.trie;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {

    boolean isEnd;
    Map<Character, TrieNode> children;

    TrieNode() {
        isEnd = false;
        children = new HashMap<>();
    }
}
