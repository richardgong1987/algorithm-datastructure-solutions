package codesignal.codearcade.core;

public class IsUnstablePair {
    public static void main(String[] args) {
        IsUnstablePair isUnstablePair = new IsUnstablePair();
        System.out.println(isUnstablePair.solution("aa", "AAB"));
    }

    boolean solution(String f1, String f2) {
        return f1.compareTo(f2) * f1.compareToIgnoreCase(f2) < 0;
    }

}
