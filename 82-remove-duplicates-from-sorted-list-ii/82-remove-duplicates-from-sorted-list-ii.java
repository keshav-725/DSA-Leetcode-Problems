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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode node = new ListNode(0);
        ListNode curr = head;
        ListNode pre = node;
        node.next = head;
        while(curr!=null){
            if(curr.next!=null && curr.val == curr.next.val){
                curr = curr.next;
            }
            else if(pre.next == curr){
                pre = curr;
                curr=curr.next;
            }
            else{
                pre.next = curr.next;
                curr = curr.next;
            }
        }
        return node.next;
    }
}