package codesignal.codearcade.core;

import java.util.Arrays;
import java.util.stream.IntStream;

public class IsSubstitutionCipher {
    public static void main(String[] args) {
        IsSubstitutionCipher s = new IsSubstitutionCipher();
        System.out.println(s.solution("aab", "bbc"));
    }

    boolean solution(String str1, String str2) {
        return IntStream.range(0, str1.length()).allMatch(i -> str1.indexOf(str1.substring(i, i + 1)) == str2.indexOf(str2.substring(i, i + 1)));
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
