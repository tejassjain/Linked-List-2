/**
Time Complexity: O(N)
Space Complexity: constant space
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
        if(head == null || head.next == null)
            return;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next !=null && fast.next.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        fast = reverse(slow.next);
        slow.next = null;
        slow = head;
        ListNode curr;
        while(fast !=null)
        {
            curr = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = curr;
            slow = curr;
        }
    }
    private ListNode reverse(ListNode root)
    {
        ListNode prev = null;
        ListNode curr = root;
        while(curr!=null)
        {
            ListNode newnode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = newnode;
        }
        return prev;
    }
}