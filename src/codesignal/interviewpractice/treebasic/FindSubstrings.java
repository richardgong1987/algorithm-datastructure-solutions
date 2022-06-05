package codesignal.interviewpractice.treebasic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindSubstrings {
    public static void main(String[] args) {
        FindSubstrings f = new FindSubstrings();
        System.out.println(Arrays.toString(f.solution(
            new String[]{"Apple", "Melon", "Orange", "Watermelon"},
            new String[]{"a", "mel", "lon", "el", "An"})));
    }

    String[] solution(String[] words, String[] parts) {
        Trie t = new Trie(parts);
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int longest = -1;
            int startIdx = 0;
            for (int j = 0; j < word.length(); j++) {
                int index = t.search(word.substring(j));
                if (index != -1 && index > longest) {
                    longest = index;
                    startIdx = j;
                }
                if (longest > word.length() - j) break;
            }
            if (longest > -1)
                words[i] = new StringBuilder(word).insert(startIdx, '[').insert(startIdx + longest + 1, ']').toString();
        }
        return words;
    }
    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isWord = false;
        TrieNode() {}
    }

    class Trie {
        TrieNode root;
        Trie(String[] array) {
            root = new TrieNode();
            for (String s : array) {
                insert(s);
            }
        }
        public void insert(String s) {
            TrieNode cur = root;
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                cur.children.computeIfAbsent(ch, k -> new TrieNode());
                cur = cur.children.get(ch);
            }
            cur.isWord = true;
        }
        public int search(String s) {
            TrieNode cur = root;
            int result = -1;
            for (int i = 0; cur != null && i < s.length(); i++) {
                cur = cur.children.get(s.charAt(i));
                if (cur != null && cur.isWord) {
                    result = i + 1;
                }
            }
            return result;
        }
    }
}
