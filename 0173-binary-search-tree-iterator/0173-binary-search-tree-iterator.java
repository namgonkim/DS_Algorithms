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
 // inorder: 왼쪽 - 출력 - 오른쪽 
class BSTIterator {
    public List<Integer> iters = new ArrayList<>();
    public int idx = 0;
    // 생성 시 트리의 모든 요소보다 더 작은 값으로 포인터를 적용 
    public BSTIterator(TreeNode root) {
        iters.add(-1);
        visitor(root);
    }

    private void visitor(TreeNode cur) {
        if(cur == null) {
            return;
        }
        visitor(cur.left);
        iters.add(cur.val);
        visitor(cur.right);
    }
    
    public int next() {
        idx++;
        return iters.get(idx);
    }
    
    public boolean hasNext() {
        if(idx < iters.size() - 1) {
            return true;
        }
        return false;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */