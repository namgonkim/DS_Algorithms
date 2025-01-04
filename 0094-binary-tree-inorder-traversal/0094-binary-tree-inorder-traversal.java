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
    public List<Integer> list = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        // 트리에서 중위 순회 : dfs로 내려가면서 왼쪽, 출력, 오른쪽 
        visitor(root);
        return list;
    }

    public void visitor(TreeNode node) {
        if(node == null) {
            return;
        }

        visitor(node.left);
        list.add(node.val);
        visitor(node.right);
    }
}