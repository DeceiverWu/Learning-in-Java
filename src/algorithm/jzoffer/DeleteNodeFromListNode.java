package algorithm.jzoffer;

/**
 *
 */
public class DeleteNodeFromListNode {

    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode delteNode(ListNode head, ListNode target) {
        if (head == null || target == null)
            return null;
        if (target.next != null) {
            ListNode next = target.next;
            target.val = next.val;
            target.next = next.next;
        } else {
            if (head == target)
                head = null;
            else {
                ListNode node = head;
                while (node.next != target)
                    node = node.next;
                node.next = null;
            }
        }
        return head;
    }
}
