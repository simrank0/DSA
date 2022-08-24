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
    ListNode t = new ListNode();
    public ListNode reverseList(ListNode head) {
        reverseList2(head);
        return t;
    }
    void reverseList2(ListNode head) {
        if(head == null || head.next == null) {
            t = head;
            return;
        }
        reverseList2(head.next);
        head.next.next = head;
        head.next = null;
    }
}