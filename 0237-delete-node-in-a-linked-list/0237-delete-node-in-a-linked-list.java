/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        // 링크드리스트에서 중간 노드를 삭제하는 법
        // 1. 삭제할 노드의 next 노드 값을 복사 
        node.val = node.next.val;
        // 2. next 노드의 next 노드를 현재 노드의 next로 변경 
        node.next = node.next.next;

    }
}