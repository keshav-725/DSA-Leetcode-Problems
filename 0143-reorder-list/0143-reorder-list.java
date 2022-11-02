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
    public void reorderList(ListNode head) {
        ListNode slow=head,fast=head;
        
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
    
        ListNode nhead = reverse(slow.next);
        slow.next = null;
        ListNode thead = head;
        while(thead!=null && nhead!=null){
            ListNode temp1 = thead.next;
            ListNode temp2 = nhead.next;
            thead.next = nhead;
            nhead.next = temp1;
            thead = temp1;
            nhead = temp2;
        }
        return;
    }
    public ListNode reverse(ListNode head){
        if(head==null) return null;
        ListNode pre = null,next = head.next;
        
        while(head!=null){
            head.next = pre;
            pre = head;
            head = next;
            if(next != null) next = next.next;
        }
        return pre;
    }
}