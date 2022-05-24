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
    ListNode h2;
    public boolean isPalindrome(ListNode head) {
        h2 = head;
        return isPalindromeHelper(head.next);
    }
    boolean str = true;
    boolean isPalindromeHelper(ListNode endHead) {
        if(endHead == null) return true;
        str = isPalindromeHelper(endHead.next);
        // if(endHead == h2 || endHead.next == h2) {
        //     return str;
        // }
        if(endHead.val != h2.val) return str = false;
        h2 = h2.next;
        return str;
    }
}