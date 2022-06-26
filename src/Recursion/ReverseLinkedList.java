package Recursion;

public class ReverseLinkedList {
    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println(s.reverseList(head));
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
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
