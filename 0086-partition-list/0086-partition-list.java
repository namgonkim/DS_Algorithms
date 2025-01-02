/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    // 1. x보다 작은 노드는 left / x보다 크거나 같은 노드는 right
    // 2. left의 next를 right로 설정 
    public ListNode partition(ListNode head, int x) {
        ListNode left = new ListNode(0);
        ListNode right = new ListNode(0);
        // 끝지점 
        ListNode leftTail = left;
        ListNode rightTail = right;

        ListNode node = head;
        while(node != null) {
            // x보다 작은 노드는 left로 연결 
            if(node.val < x) {
                leftTail.next = node;
                leftTail = leftTail.next;
            }
            // x보다 크거나 같은 노드는 right로 연결 
            else {
                rightTail.next = node; 
                rightTail = rightTail.next;
            }
            node = node.next; 
        }
        // right head에 0이 있음 따라서 0의 next를 leftTail과 이어준다. 
        leftTail.next = right.next;
        // 마지막 right next를 null로 끊어버림 -> 기존의 next가 남아 있을 경우 cycle 발생 
        rightTail.next = null;

        // left head 0 건너띄고 리턴 
        return left.next;
    }
}