package codesignal.interviewpractice.treebasic;

import java.util.HashMap;
import java.util.Map;

public class FindSubstrings {
    String[] solution(String[] words, String[] parts) {
        Map<String, Boolean> hash = new HashMap<>();
        for (String string : parts) {
            hash.put(string, true);
        }
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int len = word.length();
            for (int j = 5; j > 0; j--) {
                for (int k = 0; k <= len - j; k++) {
                    String sub = word.substring(k, k + j);
                    if (hash.containsKey(sub)) {
                        words[i] = word.replaceFirst(sub, "[" + sub + "]");
                        j = -1;// Break loop out
                        break;
                    }
                }
            }
        }
        return words;
    }

}
