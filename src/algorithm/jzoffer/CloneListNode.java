package algorithm.jzoffer;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: deceiver
 * Date: 2019-06-04
 * Time: 11:26
 */
public class CloneListNode {

    class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    public RandomListNode clone(RandomListNode pHead) {
        cloneNode(pHead);
        connectSiblingNode(pHead);
        return removeOriginNode(pHead);
    }

    /**
     * 将克隆的结点先链接在被克隆结点后面 N - > N'
     *
     * @param pHead
     */
    public void cloneNode(RandomListNode pHead) {
        RandomListNode pNode = pHead;
        while (pNode != null) {
            RandomListNode node = new RandomListNode(pNode.label);
            node.next = pNode.next;
            node.random = null;
            pNode.next = node;
            pNode = node.next;
        }
    }

    /**
     * 链接随机指针
     *
     * @param pHead
     */
    public void connectSiblingNode(RandomListNode pHead) {
        RandomListNode pNode = pHead;
        while (pNode != null) {
            RandomListNode node = pNode.next;
            if (pNode.random != null) {
                node.random = pNode.random.next;
            }
            pNode = node.next;
        }
    }

    /**
     * 将原链表从复制链表分离
     *
     * @param pHead
     * @return
     */
    public RandomListNode removeOriginNode(RandomListNode pHead) {
        RandomListNode pNode = pHead;
        RandomListNode cloneHead = null;
        RandomListNode cloneNode = null;
        //确定复制链表头
        if (pNode != null) {
            cloneHead = cloneNode = pNode.next;
            pNode.next = cloneHead.next;
            pNode = pNode.next;
        }
        //拆卸原链表和复制链表
        while (pNode != null) {
            cloneNode.next = pNode.next;
            cloneNode = cloneNode.next;
            pNode.next = cloneNode.next;
            pNode = pNode.next;
        }

        return cloneHead;
    }


    public RandomListNode clone1(RandomListNode pHead) {
        if (pHead == null)
            return null;
        // 插入新节点
        RandomListNode cur = pHead;
        while (cur != null) {
            RandomListNode clone = new RandomListNode(cur.label);
            clone.next = cur.next;
            cur.next = clone;
            cur = clone.next;
        }
        // 建立 random 链接
        cur = pHead;
        while (cur != null) {
            RandomListNode clone = cur.next;
            if (cur.random != null)
                clone.random = cur.random.next;
            cur = clone.next;
        }
        // 拆分
        cur = pHead;
        RandomListNode pCloneHead = pHead.next;
        while (cur.next != null) {
            RandomListNode next = cur.next;
            cur.next = next.next;
            cur = next;
        }
        return pCloneHead;
    }
}
