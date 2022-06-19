package leetcode.graph;

public class FindCenter {
    public static void main(String[] args) {
        FindCenter f = new FindCenter();

//        [
//            [1,2],
//            [2,3],
//            [4,2]
//        ]

        System.out.println(f.findCenter(new int[][]{{1, 2}, {2, 3}, {4, 2}}));
    }

    public int findCenter(int[][] edges) {

        int a1 = edges[0][0];
        int a2 = edges[0][1];

        int b1 = edges[1][0];
        int b2 = edges[1][1];

        if (a1 == b1 || a1 == b2) return a1;
        return a2;
    }
}
