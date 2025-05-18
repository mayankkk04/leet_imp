/*******************************************************
 Following is the TreeNode class structure

 class TreeNode<T> {
     T data;
     TreeNode<T> left;
     TreeNode<T> right;

     public TreeNode(T x) {
         this.data = x;
         this.left = null;
         this.right = null;
     }
 };
 *******************************************************/
import java.util.*;

public class Solution {

    public static TreeNode<Integer> getTreeFromPostorderAndInorder(int[] postOrder, int[] inOrder) {
        if (inOrder == null || postOrder == null || inOrder.length != postOrder.length) return null;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inOrder.length; i++) {
            map.put(inOrder[i], i);
        }

        return buildTree(inOrder, 0, inOrder.length - 1,
                         postOrder, 0, postOrder.length - 1, map);
    }

    public static TreeNode<Integer> buildTree(int[] inOrder, int inStart, int inEnd,
                                              int[] postOrder, int postStart, int postEnd,
                                              HashMap<Integer, Integer> map) {
        if (postStart > postEnd || inStart > inEnd) return null;

        TreeNode<Integer> root = new TreeNode<>(postOrder[postEnd]);
        int inRoot = map.get(root.data);
        int numsLeft = inRoot - inStart;

        root.left = buildTree(inOrder, inStart, inRoot - 1,
                              postOrder, postStart, postStart + numsLeft - 1, map);

        root.right = buildTree(inOrder, inRoot + 1, inEnd,
                               postOrder, postStart + numsLeft, postEnd - 1, map);

        return root;
    }

}
