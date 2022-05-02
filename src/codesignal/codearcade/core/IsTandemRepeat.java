package codesignal.codearcade.core;

public class IsTandemRepeat {
    public static void main(String[] args) {
        IsTandemRepeat s = new IsTandemRepeat();
        System.out.println(s.solution("tandemtandem"));
    }

    boolean solution(String inputString) {
        return inputString.matches("(\\w+)\\1");
    }

    boolean solution2(String inputString) {
        int length = inputString.length();
        if (length % 2 != 0) {
            return false;
        }
        return inputString.substring(0, length / 2).equals(inputString.substring(length / 2));
    }
}
