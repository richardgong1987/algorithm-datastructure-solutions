package codesignal.interviewpractice.treebasic;

public class FindProfession {
    public static void main(String[] args) {
        FindProfession s = new FindProfession();
        System.out.println(s.solution(3, 3));
    }

    /**
     * https://www.geeksforgeeks.org/find-profession-in-a-hypothetical-special-situation/
     */
    String solution(int level, int pos) {

        // Base case
        if (level == 1) {
            return "Engineer";
        }


        // Recursively find parent"s
        // profession. If parent
        // is a Doctor, this node
        // will be a Doctor if it
        // is at odd position and an
        // engineer if at even position
        if (solution(level - 1, (pos + 1) / 2).equals("Doctor")) {
            return (pos % 2 == 0) ? "Engineer" : "Doctor";
        }


        // If parent is an engineer,
        // then current node will be
        // an engineer if at add
        // position and doctor if even
        // position.
        return (pos % 2 == 0) ? "Doctor" : "Engineer";
    }
}
