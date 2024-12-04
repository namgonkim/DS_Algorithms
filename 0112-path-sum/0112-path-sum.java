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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return visitor(root, 0, targetSum);
    }

    public boolean visitor(TreeNode cur, int value, int targetSum) {
        if(cur == null) return false;
        // System.out.println(value+cur.val);
        // 현재 노드까지 왔을 때 리프노드 이면서 타겟섬과 같으면 true
        if(value+cur.val == targetSum && (cur.left == null && cur.right == null)) {
            return true;
        }
        
        return visitor(cur.left, value+cur.val, targetSum) || visitor(cur.right, value+cur.val, targetSum);

        // if(root == null) return false;
        // if(root.left == null && root.right == null) return targetSum - root.val == 0 ; // leaf node
        // return hasPathSum(root.left,targetSum-root.val) || hasPathSum(root.right,targetSum-root.val);
    }
}