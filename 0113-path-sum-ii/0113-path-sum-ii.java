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
    // 루트부터 리프까지 가는 path의 합이 targetSum과 같으면 path를 List에 저장해라 
    public List<List<Integer>> paths = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        visitor(root, "", 0, targetSum);
        return paths;
    }

    public void visitor(TreeNode cur, String path, int value, int targetSum) {
        if(cur == null) return;

        if(targetSum == value + cur.val && (cur.left == null && cur.right == null)) {
            path = path + " " + cur.val;
            path = path.trim();
            String[] tokens = path.split(" ");
            List<Integer> pathList = new ArrayList<>();
            for(int i=0; i<tokens.length; i++) {
                pathList.add(Integer.parseInt(tokens[i]));
                // System.out.println(tokens[i]);
            }
            paths.add(pathList);
            path = "";
        }

        visitor(cur.left, path + " " + cur.val, value + cur.val, targetSum);
        visitor(cur.right, path + " " + cur.val, value + cur.val, targetSum);
    }
}