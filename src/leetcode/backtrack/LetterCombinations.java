package leetcode.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LetterCombinations {
    public static void main(String[] args) {
        List<String> stringList = letterCombinations("23");
        System.out.println("----------------------------------------------");
        System.out.println(stringList);
    }

    static String[] phoneButtons = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static List<String> letterCombinations(String digits) {
        List<String> ret = new ArrayList<>();
        if (digits.length() == 0) {
            return ret;
        }

        backtrack(digits, 0, new StringBuilder("#".repeat(digits.length())), ret);
        return ret;
    }

    static void backtrack(String digits, int i, StringBuilder sb, List<String> ret) {
        if (i == digits.length()) {
            ret.add(sb.toString());
            return;
        }
        int index = digits.charAt(i) - '0';
        for (char c : phoneButtons[index].toCharArray()) {
            sb.setCharAt(i, c);
            System.out.println("sb=" + sb + ",c=" + c + ",i=" + i + ",index=" + index + ",keyPad[index]=" + Arrays.toString(phoneButtons[index].toCharArray()));
            backtrack(digits, i + 1, sb, ret);
        }
    }
}
