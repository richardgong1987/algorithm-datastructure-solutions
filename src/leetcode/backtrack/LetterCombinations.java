package leetcode.backtrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LetterCombinations {
    public static void main(String[] args) {
        letterCombinations("23");
    }

    public static List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }

        HashMap<Integer, String> map = new HashMap<>();
        map.put(0, "");
        map.put(1, "");
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");

        List<String> result = new ArrayList<>();
        DFS(digits, result, new StringBuilder(), 0, map);
        return result;
    }

    public static void DFS(String digits, List<String> result, StringBuilder s, int start, Map<Integer, String> map) {
        if (start == digits.length()) {
            result.add(s.toString());
            return;
        }

        String tmp = map.get(digits.charAt(start) - '0');
        for (int i = 0; i < tmp.length(); i++) {
            s.append(tmp.charAt(i));
            DFS(digits, result, s, start + 1, map);
            s.deleteCharAt(s.length() - 1);
        }
    }

}
