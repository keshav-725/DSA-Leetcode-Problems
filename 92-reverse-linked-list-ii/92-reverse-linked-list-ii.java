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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = head, prev = dummy, next = curr, temp = null;
        int i = 1;
        while(i < left){
            i++;
            curr = curr.next;
            prev = prev.next;
        }
        next = curr.next;
        curr.next = null;
        while(left < right){
            left++;
            temp = next.next;
            next.next = curr;
            curr = next;
            next = temp;
        }
        temp = prev.next;
        temp.next = next;
        prev.next = curr;
        return dummy.next;
    }
}