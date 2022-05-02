package codesignal.codearcade.core;

public class StringsConstruction {
    public static void main(String[] args) {
        StringsConstruction s = new StringsConstruction();
        System.out.println(s.solution("abc", "abcabcabc"));
    }

    int solution(String a, String b) {
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        /**
         * 97 is the numeric value of the character 'a',
         * so if you subtract 97 from a character between 'a' and 'z',
         * you are mapping that character to an index of your array between 0 and 25.
         */
        for (int i = 0; i < a.length(); i++) {
            int ascii = a.charAt(i) - 97;
            arr1[ascii]++;
        }
        for (int i = 0; i < b.length(); i++) {
            arr2[b.charAt(i) - 97]++;
        }

        int min = b.length();
        for (int i = 0; i < 26; i++) {
            if (arr1[i] != 0) {
                arr1[i] = arr2[i] / arr1[i];
                if (arr1[i] < min) {
                    min = arr1[i];
                }
            }
        }
        return min;
    }
}
