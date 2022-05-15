package codesignal.interviewpractice.treebasic;

public class FindProfession {
    public static void main(String[] args) {
        FindProfession s = new FindProfession();
        System.out.println(s.solution(3, 3));
    }

    /**
     * Level 1: E
     * Level 2: ED
     * Level 3: EDDE
     * Level 4: EDDEDEED
     * Level 5: EDDEDEEDDEEDEDDE
     * https://www.geeksforgeeks.org/find-profession-in-a-hypothetical-special-situation/
     */
    String solution(int level, int pos) {
        // Count set bits in 'pos-1'
        int c = countSetBits(pos - 1);

        // If set bit count is odd, then doctor, else engineer
        if (c % 2 != 0) {
            return "Doctor";
        }
        return "Engineer";
    }


    int countSetBits(int n) {
        int count = 0;
        while (n != 0) {
            n &= (n - 1);
            count++;
        }
        return count;
    }
}
