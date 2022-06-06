/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temp1 = headA, temp2 = headB;
        while(temp1.next != null) temp1 = temp1.next;
        while(temp2.next != null) temp2 = temp2.next;
        if(temp1 != temp2) return null;
        temp1 = headA;
        temp2 = headB;
        while(true) {
            if(temp1 == temp2) return temp2;
            if(temp1== null) temp1 = headA;
            else{
                temp1=temp1.next;
            }
            if(temp2== null) temp2 = headB;
            else { 
                temp2=temp2.next;
            }
        }
    }
}