package codesignal.interviewpractice.treebasic;

import codesignal.interviewpractice.Tree;

public class DeleteFromBST {
    Tree<Integer> solution(Tree<Integer> t, int[] queries) {
        for (int query : queries) {
            t = deleteFromTree(t, query);
        }
        return t;
    }

    Tree<Integer> deleteFromTree(Tree<Integer> t, int target) {
        if (t == null) return t; //bottom of recursion if we can't find value

        if (target < t.value) {
            t.left = deleteFromTree(t.left, target);
            return t;
        }
        if (target > t.value) {
            t.right = deleteFromTree(t.right, target);
            return t;
        }

        //else found value, so delete from tree

        //only one child so connect parent with right subtree
        if (t.left == null) return t.right;
//    if (t.right == null) return t.left; - this is the usual if we had a normal BST delete operation, but we don't as per description

        Tree<Integer> current = t;
        t = max(current.left);
        t.left = deleteMax(current.left);
        t.right = current.right;

        return t;
    }

    Tree<Integer> max(Tree<Integer> t) {
        if (t.right == null) return t;
        return max(t.right);
    }


    Tree<Integer> deleteMax(Tree<Integer> t) {
        if (t.right == null) return t.left;
        t.right = deleteMax(t.right);
        return t;
    }
}
