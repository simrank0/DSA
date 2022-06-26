package Recursion;

import java.util.Scanner;

public class PalindromeLinkedList {
    static class Solution {
        ListNode h2;
        public boolean isPalindrome(ListNode head) {
            h2 = head;
            return isPalindromeHelper(head.next);
        }
        boolean str = true;
        boolean isPalindromeHelper(ListNode endHead) {
            if(endHead == null) return true;
            str = isPalindromeHelper(endHead.next);
//            if(endHead == h2 || endHead.next == h2) {
//                h2 = endHead;
//                return str;
//            }
            if(endHead.val != h2.val) return str = false;
            h2 = h2.next;
            return str;
        }
    }
    //[8,9,8]

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode l = new ListNode(0);
        Scanner in = new Scanner(System.in);
        ListNode ans = l;
        int[] a = {8,0,7,1,7,7,9,7,5,2,9,1,7,3,7,0,6,5,1,7,7,9,3,8,1,5,7,7,8,4,0,9,3,7,3,4,5,7,4,8,8,5,8,9,8,5,8,8,4,7,5,4,3,7,3,9,0,4,8,7,7,5,1,8,3,9,7,7,1,5,6,0,7,3,7,1,9,2,5,7,9,7,7,1,7,0,8};
        for(int i : a) {
            l.next = new ListNode(i);
            l = l.next;
        }
//        l.next = new ListNode(1);
//        l.next.next = new ListNode(1);
//        l.next.next.next = new ListNode(2);
////        l.next.next.next.next = new ListNode(1);
        System.out.println(s.isPalindrome(ans.next));
    }
}

