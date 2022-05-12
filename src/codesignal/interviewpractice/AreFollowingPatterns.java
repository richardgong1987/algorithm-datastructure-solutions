package codesignal.interviewpractice;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class AreFollowingPatterns {
    public static void main(String[] args) {
        AreFollowingPatterns s = new AreFollowingPatterns();
        System.out.println(s.solution(new String[]{"cat", "dog", "doggy"}, new String[]{"a", "b", "b"}));
    }

    boolean solution(String[] strings, String[] patterns) {
        if (strings.length != patterns.length) {
            return false;
        }

        LinkedHashMap<String, String> stringsCounts = new LinkedHashMap<>();
        for (int i = 0; i < strings.length; i++) {
            String string = strings[i];
            String pattern = patterns[i];
            stringsCounts.computeIfAbsent(pattern, k -> string);

            if (!stringsCounts.get(pattern).equals(string)) {
                return false;
            }
        }


        return true;
    }

}
