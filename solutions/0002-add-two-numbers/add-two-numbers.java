// You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
//
// You may assume the two numbers do not contain any leading zero, except the number 0 itself.
//
// Example:
//
//
// Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
// Output: 7 -> 0 -> 8
// Explanation: 342 + 465 = 807.
//
//


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null && l2 == null) return null;
        ListNode a = l1;
        ListNode b = l2;
        int carry = 0;
        int sum = 0;
        ListNode c_dummy_head = new ListNode(0);
        ListNode c = c_dummy_head;
        while(a!=null || b!= null){
            int a_val = a==null ? 0 : a.val;
            int b_val = b==null ? 0 : b.val;
            sum = a_val + b_val + carry;
            carry = sum/10;
            sum %= 10;
            c.next = new ListNode(sum);
            c = c.next;
            if (a!= null)
                a = a.next;
            if(b!= null)
                b = b.next;
        }
        
        if (carry == 1) c.next = new ListNode(1);
        return c_dummy_head.next;
    }
}
