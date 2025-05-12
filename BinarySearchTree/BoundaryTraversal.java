/************************************************************

 Following is the Binary Tree node structure:

 class TreeNode {
     int data;
     TreeNode left;
     TreeNode right;

     TreeNode(int data) {
         this.data = data;
         this.left = null;
         this.right = null;
     }
 }

 ************************************************************/


import java.util.*;
public class Solution {
    public static List<Integer> traverseBoundary(TreeNode root){
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        ans.add(root.data);
        addLeftBoundary(root, ans);
        addLeaves(root, ans);
        addRightBoundary(root, ans);
        return ans;
    }
    static boolean isleaf(TreeNode node) {
        return node != null && node.left == null && node.right == null;
    }
    static void addLeftBoundary( TreeNode root , ArrayList<Integer> ans){
        TreeNode curr = root.left;
        while( curr != null){
            if(isleaf(curr) == false) ans.add(curr.data);
            if(curr.left != null) curr = curr.left;
            else curr = curr.right;
        }
    }
    static void addLeaves( TreeNode root , ArrayList<Integer> ans){
        if(isleaf(root)) {
            ans.add(root.data);
            return;
        }
        if(root.left != null) addLeaves(root.left, ans);
        if(root.right != null) addLeaves(root.right, ans);

    }
    static void addRightBoundary( TreeNode root , ArrayList<Integer> ans){
        TreeNode curr = root.right;
        ArrayList<Integer> temp = new ArrayList<>();
        while(curr!= null){
            if(isleaf(curr) == false) temp.add(curr.data);
            if(curr.right != null) curr = curr.right;
            else curr = curr.left;
        }
        int i;
        for(i = temp.size() -1 ; i >= 0 ; i--){
            ans.add(temp.get(i));
        }
    }
}
