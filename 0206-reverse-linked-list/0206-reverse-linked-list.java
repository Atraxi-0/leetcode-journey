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
    public ListNode reverseList(ListNode head) {
        ArrayList<Integer> arr = new ArrayList<>();
        ListNode ptr = head;
        while(ptr != null) {
            arr.add(ptr.val);
            ptr = ptr.next;
        }
        ptr = head;
        for (int i=arr.size()-1; i>=0; i--) {
            ptr.val = arr.get(i); 
            ptr = ptr.next;
        }
        return head;
    }
}