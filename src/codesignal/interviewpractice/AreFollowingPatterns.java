package codesignal.interviewpractice;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class AreFollowingPatterns {
    boolean solution(String[] strings, String[] patterns) {
        if (strings.length != patterns.length) {
            return false;
        }

        LinkedHashMap<String, Integer> stringsCounts = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> patternsCounts = new LinkedHashMap<>();
        for (int i = 0; i < strings.length; i++) {
            String string = strings[i];
            String pattern = patterns[i];
            stringsCounts.put(string, stringsCounts.getOrDefault(string, 0) + 1);
            patternsCounts.put(pattern, patternsCounts.getOrDefault(pattern, 0) + 1);
            if (!patternsCounts.get(pattern).equals(stringsCounts.get(string))) {
                return false;
            }
        }


        return true;
    }

}
