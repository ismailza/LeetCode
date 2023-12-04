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
    int offset = 0;
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if ((l1 != null) && (l2 != null)) {
            int sum = l1.val + l2.val + this.offset;
            if (sum < 10)
                this.offset = 0;
            else {
                sum %= 10;
                this.offset = 1;
            }
            return new ListNode(sum, addTwoNumbers(l1.next, l2.next));
        }
        if (l1 != null) {
            int sum = l1.val + this.offset;
            if (sum < 10)
                this.offset = 0;
            else {
                this.offset = 1;
                sum %= 10;
            }
            return new ListNode(sum, addTwoNumbers(l1.next, null));
        }
        if (l2 != null) {
            int sum = l2.val + this.offset;
            if (sum < 10)
                this.offset = 0;
            else {
                this.offset = 1;
                sum %= 10;
            }
            return new ListNode(sum, addTwoNumbers(l2.next, null));
        }
        if (this.offset == 1)
            return new ListNode(1);
        return null;
    }
}