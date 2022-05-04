package codesignal.codearcade.core;

public class CreateAnagram {
    public static void main(String[] args) {
        CreateAnagram s = new CreateAnagram();
        System.out.println(s.solution2("AABAA", "BBAAA"));
    }
    int solution(String s, String t) {
        for (int i = 0; i < s.length(); i++) {
            t = t.replaceFirst("" + s.charAt(i), "");
        }
        return t.length();
    }

    int solution2(String s, String t) {
        int[] zahl1 = new int[26];
        int[] zahl2 = new int[26];
        for (int i = 0; i < s.length(); i++) {
            zahl1[s.charAt(i) - 'A']++;
            zahl2[t.charAt(i) - 'A']++;
        }

        int ans = 0;
        for (int i = 0; i < 26; i++) {
            ans += Math.abs(zahl1[i] - zahl2[i]);
        }
        return ans / 2;
    }
}
