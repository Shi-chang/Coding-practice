// example
// 9 9 9 9
// i

// 9 9 9
// j

//d 8 9 9 0 1
//c

// carryOn = 1

/**
 * 2. Add Two Numbers
 */
public class LC2AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;

        ListNode p1 = l1;
        ListNode p2 = l2;

        int carryOn = 0;

        while (p1 != null || p2 != null) {
            int value1 = p1 == null ? 0 : p1.val;
            int value2 = p2 == null ? 0 : p2.val;

            int sum = value1 + value2 + carryOn;
            int retainedVal = sum % 10;
            carryOn = sum / 10;

            cur.next = new ListNode(retainedVal);

            if (p1 != null) {
                p1 = p1.next;
            }
            if (p2 != null) {
                p2 = p2.next;
            }

            cur = cur.next;
        }

        if (carryOn == 1) {
            cur.next = new ListNode(1);
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
