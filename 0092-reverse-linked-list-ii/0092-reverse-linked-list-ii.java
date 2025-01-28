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
    // prev, cur, temp를 활용해 left부터 right까지 차례대로 노드 연결을 재작업 
    // 1 2 3 4 5 
    // p c t  
    // 1 3 2 4 5 => 
    // p c   t
    // 1 4 3 2 5
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || left == right) {
            return head;
        }
        // 현 링크드리스트 앞쪽에 덤프 노드 하나 생성 
        ListNode dump = new ListNode(0);
        dump.next = head;
        // prev를 left까지 이동 
        ListNode prev = dump;
        for(int i=0; i<left-1; i++) {
            prev = prev.next;
        }

        // cur 노드 지정 후 temp를 right까지 차례로 옮기며 노드 위치 변경 
        ListNode cur = prev.next;
        for(int i=0; i<right-left; i++) {
            ListNode temp = cur.next;
            cur.next = temp.next;
            temp.next = prev.next;
            prev.next = temp;
        }
        // [3,5] 1<->2
        // [0,3,5]
        // (d)p/(h)c/t
        // 첫 노드부터 바꾸게 되면 기존 헤더가 뒤로 밀리기 때문에 dump.next를 지정 
         
        return dump.next;
    }
}