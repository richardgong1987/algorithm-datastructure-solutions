package codesignal.codearcade.core;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ConstructSquare {
    public static void main(String[] args) {
        ConstructSquare s = new ConstructSquare();
        System.out.println(s.solution("ab"));
        System.out.println(s.solution2("ab"));

    }

    int solution(String s) {
        int a = (int) Math.ceil(Math.sqrt(Math.pow(10, s.length() - 1)));
        int b = (int) Math.floor(Math.sqrt(Math.pow(10, s.length()) - 1));
        int[] chars = new int[26];

        for (char ch : s.toCharArray())
            chars[ch - 'a'] += 1;
        Arrays.sort(chars);

        for (int i = b; i >= a; i--) {
            int n = i * i;
            if (isSquare(n, chars)) return n;
        }

        return -1;
    }

    private static boolean isSquare(int n, int[] chars) {
        int[] digits = new int[26];
        while (n > 0) {
            digits[n % 10] += 1;
            n /= 10;
        }
        Arrays.sort(digits);

        return Arrays.equals(chars, digits);
    }

    int solution2(String s) {
        int L = s.length();
        int A = (int) Math.sqrt(Math.pow(10, (L - 1)));    // min square
        int B = (int) Math.sqrt(Math.pow(10, L));        // max square

        int[] targetFormat = extractSignature(s);

        for (int i = B; i >= A; i--) {
            int v = (int) Math.pow(i, 2);
            if (conformsToFormat(targetFormat, v)) return v;
        }

        return -1;  // not possible
    }

    boolean conformsToFormat(int[] targetFormat, int n) {
        String ns = Integer.toString(n);
        return Arrays.equals(targetFormat, extractSignature(ns));
    }

    // 'zzz' -> [3]
// 'aaa' -> [3]
// 'aab' -> [2,1]
    int[] extractSignature(String s) {
        Map<Character, Integer> m = new HashMap<>();
        for (char c : s.toCharArray()) m.put(c, m.getOrDefault(c, 0) + 1);
        int[] arr = m.values().stream().mapToInt(j -> j).toArray();
        Arrays.sort(arr);
        return arr;
    }
}
