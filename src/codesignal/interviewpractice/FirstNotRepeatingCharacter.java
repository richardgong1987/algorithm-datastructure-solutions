package codesignal.interviewpractice;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNotRepeatingCharacter {
    public static void main(String[] args) {
        FirstNotRepeatingCharacter f = new FirstNotRepeatingCharacter();
        System.out.println(f.solution("abacabad"));
    }
    char solution(String s) {
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> ch : map.entrySet()) {
            if (ch.getValue()==1) {
                return ch.getKey();
            }
        }
        return '_';
    }
}
