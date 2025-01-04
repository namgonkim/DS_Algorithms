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
 // 이진 트리가 주어졌을 때 같은 깊이에 있는 노드를 연결 리스트로 연결해주는 코드를 작성 
 // 즉, 트리의 깊이가 D라면 D개의 연결 리스트를 생성 
 // 3 / 9 20 / 15 7
import java.util.*;

class Solution {
    public Map<Integer, List<Integer>> map = new HashMap<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        visitor(root, 1);

        List<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);

        List<List<Integer>> list = new ArrayList<>();
        for(int level : keys) {
            List<Integer> siblings = map.get(level);
            list.add(siblings);
        }
        return list;
    }

    public void visitor(TreeNode now, int level) {
        if(now == null) {
            return;
        }

        List<Integer> sibling;
        if(map.containsKey(level)) {
            sibling = map.get(level);
        } else {
            sibling = new ArrayList<>();
        }
        sibling.add(now.val);
        map.put(level, sibling);

        visitor(now.left, level+1);
        visitor(now.right, level+1);
    }
}