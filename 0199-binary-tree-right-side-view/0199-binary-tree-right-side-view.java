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
import java.util.*;
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null) return list;
        q.offer(root);
        while(!q.isEmpty()) {
            // 현재 depth 에서 마지막 하나가 남을때까지 pop
            int size = q.size();
            while(size-- > 0) {
                TreeNode curNode = q.poll();

                if(size == 0) {
                    list.add(curNode.val);
                }
                if(curNode.left != null) {
                    q.offer(curNode.left);
                }
                if(curNode.right != null) {
                    q.offer(curNode.right);
                }
            }
        }
        return list;
    }
}