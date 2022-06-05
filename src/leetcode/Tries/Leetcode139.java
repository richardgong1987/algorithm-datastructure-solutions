package leetcode.Tries;

import java.util.*;

public class Leetcode139 {
    public static void main(String[] args) {
        Leetcode139 s = new Leetcode139();
        System.out.println(s.wordBreak("bb", List.of("a", "b", "bbb", "bbbb")));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Trie trie = new Trie();
        for (String d : wordDict) {
            trie.insert(d);
        }
        List<String> prefix = findPrefix(trie, s);
        Map<String, Boolean> map = new HashMap<>();
        for (String split : prefix) {
            if (canBeSplitted(trie, s.replaceFirst(split, ""), map)) {
                return true;
            }
        }
        return false;
    }

    private boolean canBeSplitted(Trie root, String input, Map<String, Boolean> map) {
        if (map.containsKey(input)) {
            return map.get(input);
        }

        if (root.search(input) || input.length() == 0) {

            return true;
        }
        List<String> prefix = findPrefix(root, input);
        for (String s : prefix) {
            if (canBeSplitted(root, input.replaceFirst(s, ""), map)) {
                return true;
            }
        }
        map.put(input, false);
        return false;
    }

    private List<String> findPrefix(Trie root, String input) {
        List<String> result = new ArrayList<>();

        TrieNode pointer = root.root;
        for (char c : input.toCharArray()) {
            pointer = pointer.next[c - 'a'];
            if (pointer == null) {
                break;
            }

            if (pointer.word != null) {
                result.add(pointer.word);
            }
        }
        return result;
    }


    class TrieNode {

        public String word;
        public TrieNode[] next;

        public TrieNode() {
            word = null;
            next = new TrieNode[26];
        }
    }

    class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode pointer = root;
            for (char c : word.toCharArray()) {
                if (pointer.next[c - 'a'] == null) {
                    pointer.next[c - 'a'] = new TrieNode();
                }
                pointer = pointer.next[c - 'a'];
            }
            pointer.word = word;
        }

        public boolean search(String word) {
            TrieNode pointer = root;
            if (root.word != null && root.word.equals(word)) return true;
            for (int i = 0; i < word.length(); i++) {
                if (pointer.next[word.charAt(i) - 'a'] == null) return false;
                pointer = pointer.next[word.charAt(i) - 'a'];
            }
            if (pointer.word == null) return false;
            return pointer.word.equals(word);
        }

    }
}
