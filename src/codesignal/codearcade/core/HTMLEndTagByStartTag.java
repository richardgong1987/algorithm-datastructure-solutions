package codesignal.codearcade.core;

public class HTMLEndTagByStartTag {
    public static void main(String[] args) {
        HTMLEndTagByStartTag s = new HTMLEndTagByStartTag();
        System.out.println(s.solution("<button type='button' disabled>"));
    }

    String solution(String startTag) {
        return "</" + startTag.split("[< >]")[1] + ">";
    }

}
