package codesignal.codearcade.core;

public class IsMAC48Address {
    public static void main(String[] args) {
        IsMAC48Address isMAC48Address = new IsMAC48Address();
        System.out.println(isMAC48Address.solution("02-03-04-05-06-07-"));
    }

    boolean solution(String inputString) {
        return inputString.matches("([\\dA-F]{2}-){5}[\\dA-F]{2}");
    }

}
