package algorithm.jzoffer;

/**
 *
 */
public class EntryNodeOfLoop {

    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode entryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null)
            return pHead;
        ListNode fast = pHead, slow = pHead;
        while (fast != slow) {
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = pHead;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
