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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode tmp = head;
        int count = 0;
        while(tmp!=null){
            tmp = tmp.next;
            count++;
        }
        int tcount = k;
        ListNode ltmp = head;
        ListNode rtmp = head;
        while(tcount-1>0){
            ltmp = ltmp.next;
            tcount--;
        }
        int remcount = count-k;
        while(remcount>0){
            rtmp = rtmp.next;
            remcount--;
        }
        int tval = ltmp.val;
        ltmp.val = rtmp.val;
        rtmp.val = tval;
        return head;
    }
}