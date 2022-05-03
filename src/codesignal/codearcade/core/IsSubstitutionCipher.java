package codesignal.codearcade.core;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IsSubstitutionCipher {
    public static void main(String[] args) {
        IsSubstitutionCipher s = new IsSubstitutionCipher();
        System.out.println(s.solution("aab", "bbc"));
    }

    boolean solution(String str1, String str2) {
        // once a letter is assigned, must be used for same
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < str1.length(); i++) {
            String str1val = str1.substring(i, i + 1);
            String str2val = str2.substring(i, i + 1);
            if (!map.containsKey(str1val)) {
                // already mapped to a different str1val
                if (map.containsValue(str2val)) {
                    return false;
                }
                map.put(str1val, str2val);
            }
            if (!map.get(str1val).equals(str2val)) {
                return false;
            }

        }
        return true;
    }

    boolean solution2(String string1, String string2) {
        char[] x = new char[26];
        Arrays.fill(x, ' ');

        for (int i = 0; i < string1.length(); i++) {
            int ascii = string1.charAt(i) - 97;
            if (x[ascii] != ' ' && x[ascii] != string2.charAt(i)) {
                return false;
            }

            x[ascii] = string2.charAt(i);
        }

        for (int i = 0; i < x.length; i++) {
            if (x[i] == ' ') {
                continue;
            }

            for (int j = 0; j < x.length; j++) {
                if (i != j && x[i] == x[j]) {
                    return false;
                }
            }
        }

        return true;
    }
}
