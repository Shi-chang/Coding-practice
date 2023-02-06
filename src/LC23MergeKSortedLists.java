import java.util.PriorityQueue;
import java.util.Queue;

/**
 * LC23. Merge k Sorted Lists
 */
public class LC23MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        if (lists.length == 1) {
            return lists[0];
        }

        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;

        Queue<ListNode> queue = new PriorityQueue<>((a, b) -> a.val - b.val);

        // O(length of lists)
        for (ListNode node : lists) {
            if (node != null) {
                queue.offer(node);
            }
        }

        // O(n * log n)
        while (!queue.isEmpty()) {
            // O(log n)
            ListNode node = queue.poll();

            cur.next = node;
            cur = cur.next;
            // O(log n)
            if (node.next != null) {
                queue.offer(node.next);
            }
        }

        return dummy.next;
    }

    //Definition for singly-linked list.
    class ListNode {

        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}