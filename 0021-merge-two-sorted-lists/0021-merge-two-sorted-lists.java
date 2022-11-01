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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null)
            return list2;
        if(list2==null)
            return list1;
        ListNode l1 = list1;
        ListNode l2 = list2;
        
        ListNode head = new ListNode(-1);
        ListNode ans = head;
        
        while(l1!=null && l2!=null){
            ListNode prev;
            if(l1.val<l2.val){
                ans.next = l1;
                l1 = l1.next;
                
            }else{
                ans.next = l2;
                l2 = l2.next;
            }
            ans = ans.next;
        }
        if(l1 != null){
            ans.next = l1;
        }
        if(l2 != null){
            ans.next = l2;
        }
        return head.next;
    }
}