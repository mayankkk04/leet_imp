/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxPathSum(TreeNode root) {
        int[] maxValue = new int[1];
        maxValue[0] = Integer.MIN_VALUE;
        maxPath(root , maxValue);
        return maxValue[0];
    }
    private int maxPath( TreeNode node , int[] maxValue){
        if( node == null ) return 0;
        int leftSum = Math.max(0,maxPath(node.left, maxValue));
        int rightSum = Math.max(0,maxPath(node.right, maxValue));
        maxValue[0] = Math.max(maxValue[0] , leftSum + rightSum + node.val);
        return node.val + Math.max(leftSum , rightSum);
    }
}
