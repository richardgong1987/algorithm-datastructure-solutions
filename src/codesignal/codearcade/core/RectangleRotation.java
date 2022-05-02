package codesignal.codearcade.core;

public class RectangleRotation {
    public static void main(String[] args) {
        RectangleRotation s = new RectangleRotation();
        System.out.println(s.solution(6,4));
    }
    int solution(int a, int b) {
        int x = (int)Math.floor(a/Math.sqrt(2));
        int y = (int)Math.floor(b/Math.sqrt(2));
        int tmp = 0;
        if ((x+y)%2 == 1) tmp = 1;

        return (x*y) + (x+1)*(y+1) - tmp;
    }

}
