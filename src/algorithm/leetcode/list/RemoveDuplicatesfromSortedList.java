package algorithm.leetcode.list;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 *
 * Example 1:
 *
 * Input: 1->1->2
 * Output: 1->2
 * Example 2:
 *
 * Input: 1->1->2->3->3
 * Output: 1->2->3
 *
 */
public class RemoveDuplicatesfromSortedList {

    public class ListNode {
        int val;
        ListNode next;
        public ListNode() { }
        public ListNode(int val) {
            this.val = val;
        }
        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode dummy = head;
        ListNode slow = head, fast = slow.next;

        while (slow.next != null) {
            while (fast != null && fast.val == slow.val)
                fast = fast.next;
            if (slow.next == fast) {
                slow = slow.next;
                fast = fast.next;
            } else {
                slow.next = fast;
            }
        }
        return dummy;
    }
}
