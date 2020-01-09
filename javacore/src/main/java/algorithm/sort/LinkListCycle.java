package algorithm.sort;


import java.util.*;

/**
 * @author qidi
 * @date 2019-12-05 16:52
 */
public class LinkListCycle {


    /**
     * 链表结构
     */
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    //申请的连续链表

    /**
     * 找到链表的尾巴
     *
     * @param head
     * @return
     */
    public ListNode getPos(ListNode head) {
        Map<ListNode, Boolean> map = new HashMap<>();
        if (null == head) {
            return null;
        }

        if (null == head.next) {
            return null;
        }

        ListNode currentNode = head;
        map.put(head, true);
        while (null != currentNode.next) {
            ListNode nextNode = currentNode.next;

            if (map.containsKey(nextNode)) {
                return nextNode;
            }
            map.put(nextNode, true);
            currentNode = currentNode.next;
        }
        return null;
    }


}
