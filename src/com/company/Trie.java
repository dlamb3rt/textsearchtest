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

    public boolean Contains(String search) {
        TrieNode found = Find(search);
        return found != null ? Find(search).IsEnd : false;
    }

    private TrieNode Find(String search) {
        TrieNode current = _root;

        for (Character c : search.toCharArray()) {
            current = current.GetChild(c);
            if (current == null) {
                return null;
            }
        }

        return current;
    }
}