package codesignal.interviewpractice;

import java.util.LinkedHashMap;

public class AreFollowingPatterns {
    public static void main(String[] args) {
        AreFollowingPatterns s = new AreFollowingPatterns();
        System.out.println(s.solution(new String[]{"cat", "dog", "dog"}, new String[]{"a", "b", "c"}));
    }


    boolean solution(String[] strings, String[] patterns) {
        LinkedHashMap<String, String> map1 = new LinkedHashMap<>();
        LinkedHashMap<String, String> map2 = new LinkedHashMap<>();
        for (int i = 0; i < strings.length; i++) {
            String string = strings[i];
            String pattern = patterns[i];
            if (map1.containsKey(string) && !map1.get(string).equals(pattern)) {
                return false;
            }

            if (map2.containsKey(pattern) && !map2.get(pattern).equals(string)) {
                return false;
            }
            map1.put(string, pattern);
            map2.put(pattern, string);

        }
        return true;
    }

}
