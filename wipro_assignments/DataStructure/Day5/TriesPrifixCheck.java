package com.dsa.day7;

import java.util.HashMap;
import java.util.Map;

public class Assignment2D7 {
    private TrieNode root;

    public Assignment2D7() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            current = current.getChildren().computeIfAbsent(ch, k -> new TrieNode());
        }
        current.setEndOfWord(true);
    }

    public boolean isPrefix(String prefix) {
        TrieNode current = root;
        for (char ch : prefix.toCharArray()) {
            current = current.getChildren().get(ch);
            if (current == null) {
                return false;
            }
        }
        return true;
    }

    private class TrieNode {
        private boolean endOfWord;
        private Map<Character, TrieNode> children;

        public TrieNode() {
            endOfWord = false;
            children = new HashMap<>();
        }

        public Map<Character, TrieNode> getChildren() {
            return children;
        }

        public boolean isEndOfWord() {
            return endOfWord;
        }

        public void setEndOfWord(boolean endOfWord) {
            this.endOfWord = endOfWord;
        }
    }

    public static void main(String[] args) {
        Assignment2D7 trie = new Assignment2D7();
        trie.insert("apple");
        trie.insert("banana");
        trie.insert("app");
        trie.insert("application");

        System.out.println("Is 'ap' a prefix? " + trie.isPrefix("ap")); 
        System.out.println("Is 'ban' a prefix? " + trie.isPrefix("ban")); 
        System.out.println("Is 'or' a prefix? " + trie.isPrefix("or")); 
    }
}