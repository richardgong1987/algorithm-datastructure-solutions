package codesignal.interviewpractice.treebasic;

import codesignal.interviewpractice.Tree;

public class RestoreBinaryTree {

    public static void main(String[] args) {
        RestoreBinaryTree restoreBinaryTree = new RestoreBinaryTree();
        restoreBinaryTree.solution(new int[]{4, 2, 1, 5, 3, 6}, new int[]{1, 2, 4, 3, 5, 6});
    }

    Tree<Integer> solution(int[] inorder, int[] preorder) {
        if (inorder.length == 0) {
            return null;
        }

        var rootValue = preorder[0];
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootValue) {
                var root = new Tree<>(rootValue);
                root.left = solution(getArr(0, i - 1, inorder), getArr(1, i, preorder));
                root.right = solution(getArr(i + 1, inorder.length - 1, inorder), getArr(i + 1, preorder.length - 1, preorder));
                return root;
            }
        }

        return null;
    }

    int[] getArr(int start, int end, int[] arr) {
        var len = end - start + 1;
        var result = new int[len];

        int index = 0;
        for (int i = start; i <= end; i++) {
            result[index] = arr[i];
            index++;
        }
        return result;
    }

}
