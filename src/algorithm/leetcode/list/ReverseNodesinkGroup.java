package algorithm.leetcode.list;

/**
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 *
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 *
 * Example:
 *
 * Given this linked list: 1->2->3->4->5
 *
 * For k = 2, you should return: 2->1->4->3->5
 *
 * For k = 3, you should return: 3->2->1->4->5
 *
 * Note:
 *
 * Only constant extra memory is allowed.
 * You may not alter the values in the list's nodes, only nodes itself may be changed.
 */
public class ReverseNodesinkGroup {

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

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1)
            return head;

        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode start = newHead;
        int len = 0;
        while (head != null) {
            len++;
            if (len % k == 0) {
                start = reverse(start, head.next);
            }
            head = head.next;
        }
        return newHead.next;
    }

    private ListNode reverse(ListNode start, ListNode end) {
        ListNode pre = start;
        ListNode cur = start.next;
        ListNode next, tail = cur;  // tail用作翻转后的链表链接end
        while (cur != end) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        start.next = pre;   // 前链表链接上翻转后的链表
        tail.next = cur;    // 原子链表的头翻转后在尾部，链接后面的链表
        return tail;
    }
}
