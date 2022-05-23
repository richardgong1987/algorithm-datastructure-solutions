package paypay;

import java.util.*;

public class WordLadder {
    public static int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Set<String> reached = new HashSet<>();
        reached.add(beginWord);
        int distance = 1;
        while (!reached.contains(endWord)) {
            Set<String> toAdd = new HashSet<>();
            for (String each : reached) {
                for (int i = 0; i < each.length(); i++) {
                    char[] chars = each.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        chars[i] = ch;
                        String word = new String(chars);
                        if (wordList.contains(word)) {
                            toAdd.add(word);
                            wordList.remove(word);
                        }
                    }
                }
            }

            distance++;
            if (toAdd.isEmpty()) return 0;
            reached = toAdd;
        }
        return distance;
    }

    public static int ladderLength2(String beginWord, String endWord, Set<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) {
            return 0;
        }

        Queue<String> q = new LinkedList<>();
        q.add(beginWord);

        Set<String> visited = new HashSet<>();
        q.add(beginWord);

        int changes = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String word = q.poll();
                if (word.equals(endWord)) {
                    return changes;
                }
                for (int j = 0; j < word.length(); j++) {
                    for (int k = 'a'; k <= 'z'; k++) {
                        char[] arr = word.toCharArray();
                        arr[j] = (char) k;
                        String str = new String(arr);
                        if (set.contains(str) && !visited.contains(str)) {
                            q.add(str);
                            visited.add(str);
                        }
                    }
                }
            }
            ++changes;
        }
        return 0;
    }

    public static void main(String[] args) {
        {
            var wordList = new HashSet<>(List.of("ce", "mo", "ko", "me", "co"));
            int i = ladderLength2("be", "ko", wordList);
            System.out.println(i);
        }

        {
            var beginWord = "hit";
            var endWord = "cog";
            var wordList = new HashSet<>(List.of("hot", "dot", "dog", "lot", "log"));
            int i = ladderLength(beginWord, endWord, wordList);
            System.out.println(i);
        }

    }
}
