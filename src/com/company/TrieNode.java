package com.company;

import java.util.HashMap;

class TrieNode {
    private HashMap<Character, TrieNode> _children = new HashMap<>();

    public int Size;

    public boolean IsEnd;

    public void PutChildIdempotent(char c) {
        _children.putIfAbsent(c, new TrieNode());
    }

    public TrieNode GetChild(char c) {
        return _children.get(c);
    }
}