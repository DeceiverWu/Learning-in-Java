package algorithm.leetcode.list;

/**
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 * Example 1:
 *
 * Given 1->2->3->4, reorder it to 1->4->2->3.
 * Example 2:
 *
 * Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 */
public class ReorderList {

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

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        ListNode l1 = head;
        ListNode l2 = head;
        // find the mid of list
        while (l2.next != null && l2.next.next != null) {
            l1 = l1.next;
            l2 = l2.next.next;
        }

        // Reverse the half after mid
        ListNode pre = l1;
        ListNode cur = l1.next;
        while (cur.next != null) {
            ListNode next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }

        l1 = head;
        l2 = pre.next;
        while (l1 != pre && l2 != null) {
             ListNode next = l2.next;
             l2.next = l1.next;
             l1.next = l2;
             l1 = l2.next;
             l2 = next;
        }
    }
}
