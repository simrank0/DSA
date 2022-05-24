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
    ListNode ans = new ListNode(), ANS = ans;
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return head;
        removeElementsHelper(head, val);
        return ANS.next;
    }
    public void removeElementsHelper(ListNode node, int val) {
        if(node == null) return;
        if(node.val != val) {
            ans.next = new ListNode(node.val);
            ans = ans.next;
        }
        removeElementsHelper(node.next, val);
    }
}