package algorithm.jzoffer;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: deceiver
 * Date: 2019-06-04
 * Time: 11:54
 */
public class ReverseList {

    class ListNode {
        int val;
        ListNode next = null;

        public ListNode() {}

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode reverseList(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }

        ListNode newHead = null;
        ListNode midNode = pHead;
        ListNode nextNode = null;
        ListNode preNode = null;

        while (midNode != null) {
            nextNode = midNode.next;
            if (nextNode == null) {
                newHead = midNode;
            }

            midNode.next = preNode;
            preNode = midNode;
            midNode = nextNode;
        }
        return newHead;
    }

    public ListNode printReverseList(ListNode node) {
        ListNode head = new ListNode(-1);  // 作为辅助节点
        while (node != null) {
            ListNode next = node.next;
            node.next = head.next;  //node.next指向前一个节点
            head.next = node;  // head.next 用于存储前一个节点
            node = next;
        }
        return head;
    }

    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode next = head.next;
        head.next = null;
        ListNode newHead = reverseList1(next);
        next.next = head;
        return newHead;
    }
}
