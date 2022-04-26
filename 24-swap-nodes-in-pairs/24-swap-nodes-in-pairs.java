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
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prev = dummy, cur = head;
        while(cur!=null && cur.next!=null){
            ListNode temp = cur.next.next;
            cur.next.next = cur;
            prev.next = cur.next;
            cur.next = temp;
            prev = cur;
            cur = cur.next;
        }
        return dummy.next;
    }
}