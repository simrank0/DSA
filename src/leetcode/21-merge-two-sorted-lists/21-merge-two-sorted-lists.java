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
    ListNode temp = new ListNode();
    ListNode ans = temp;
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null && l2 != null){
            temp.next = l2;
            return ans.next;
        } else if(l1 != null && l2==null) {
            temp.next = l1;
            return ans.next;
        } else if(l1 == null && l2==null) return ans.next;
        if(l1.val<l2.val) {
            temp.next = l1;
            temp = temp.next;
            mergeTwoLists(l1.next, l2);
        } else {
            temp.next = l2;
            temp = temp.next;
            mergeTwoLists(l1, l2.next);         
        }
        return ans.next;
    }
}