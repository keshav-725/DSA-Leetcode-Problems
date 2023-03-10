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

    ArrayList<Integer> arr;

    public Solution(ListNode head) {
        arr = new ArrayList<>();
        while(head != null){
            arr.add(head.val);
            head = head.next;
        }   
    }
    
    public int getRandom() {
        int num = (int) (Math.random() * this.arr.size()); 
        return this.arr.get(num);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */