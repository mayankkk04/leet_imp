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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if( root == null ) return result;
        Queue<TreeNode> nodesQueue = new LinkedList<>();
        nodesQueue.add(root);
        boolean l2r = true;
        while(!nodesQueue.isEmpty()){
            int size = nodesQueue.size();
            Integer[] row = new Integer[size];
            for(int i = 0 ; i < size ; i++){
                TreeNode node = nodesQueue.poll();

                int index = (l2r) ? i : (size -1 -i);
                row[index] = node.val;
                if(node.left != null){
                    nodesQueue.add(node.left);
                }
                if(node.right != null){
                    nodesQueue.add(node.right);
                }
            }
            l2r = !l2r;
            result.add(Arrays.asList(row));
        }
        return result;
    }
}
