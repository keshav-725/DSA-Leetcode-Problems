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
    public int pairSum(ListNode head) {
        ListNode slow=head,fast=head;
        while(fast.next!=null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode right = reverse(slow.next);
        ListNode left = head;
        
        int max = Integer.MIN_VALUE;
        
        while(right != null){
            int val = left.val + right.val;
            max = Math.max(val,max);
            left = left.next;
            right = right.next;
        }
        return max;
    }
    public ListNode reverse(ListNode node){
        ListNode prev=null,curr=node;
        
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}