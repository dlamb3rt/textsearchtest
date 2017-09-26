package com.company;

public class Trie {
    private TrieNode _root = new TrieNode();

    public void Add(String word) {
        TrieNode current = _root;

        for (int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            current.PutChildIdempotent(c);
            current = current.GetChild(c);
            current.Size++; //prefix count for prefix search
        }

        current.IsEnd = true; //for exact word search
    }

    public boolean ContainsWord(String search) {
        TrieNode found = FindPrefix(search);
        return found != null ? FindPrefix(search).IsEnd : false;
    }

    private TrieNode FindPrefix(String prefix) {
        TrieNode current = _root;

        for (Character c : prefix.toCharArray()) {
            current = current.GetChild(c);
            if (current == null) {
                return null;
            }
        }

        return current;
    }
}