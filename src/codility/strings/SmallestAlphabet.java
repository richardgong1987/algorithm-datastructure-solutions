package codility.strings;
/*
https://www.geeksforgeeks.org/lexicographically-smallest-string-formed-by-removing-at-most-one-character/
 */
public class SmallestAlphabet {
    public String solution(String S) {
        int strLen = S.length();
        String result = "";

        for (int i = 0; i < strLen - 1; i++) {

            if (S.charAt(i) > S.charAt(i + 1)) {

                for (int j = 0; j < strLen; j++) {
                    if (i != j) {
                        result += S.charAt(j);
                    }
                }
                return result;
            }

        }

        return S.substring(0, strLen - 1);
    }

    public static void main(String[] args) {
        SmallestAlphabet smallestAlphabet = new SmallestAlphabet();
        String hot = smallestAlphabet.solution("hot");// hot->ho  aaaa -> aaa
        System.out.println(hot);
    }
}
