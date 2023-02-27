import java.util.HashMap;
import java.util.Map;

public class LC146LRUCache {
    int size;
    int capacity;
    Map<Integer, DLinkedNode> cache;
    DLinkedNode dHead;
    DLinkedNode dTail;

    public LC146LRUCache(int capacity) {
        size = 0;
        this.capacity = capacity;

        cache = new HashMap<>();
        dHead = new DLinkedNode();
        dTail = new DLinkedNode();
        dHead.next = dTail;
        dHead.prev = null;
        dTail.prev = dHead;
        dTail.next = null;
    }

    // Gets the value if the key exists, or -1 otherwise
    public int get(int key) {
        DLinkedNode cur = cache.get(key);

        if (cur == null) {
            return -1;
        }

        dHead.removeNode(cur);
        dHead.addNode(cur);
        return cur.value;
    }

    // If the key exists, updates the value and moves the node right after the dHead.
    // If the key does not exist, puts the key-value pair into the cache map and DLinkedNode.
    //     - If the size exceeds the capacity, remove the node right before the tail.
    public void put(int key, int value) {
        DLinkedNode cur = cache.get(key);

        if (cur != null) {
            cur.value = value;
            dHead.removeNode(cur);
            dHead.addNode(cur);
            return;
        }

        DLinkedNode newNode = new DLinkedNode(key, value);
        cache.put(key, newNode);
        dHead.addNode(newNode);
        size++;

        if (size > capacity) {
            cache.remove(dTail.prev.key);
            dHead.removeNode(dTail.prev);
            size--;
        }
    }

    private class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;

        public DLinkedNode() {

        }

        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }

        // Adds the other node right after the dummy head of the list.
        public void addNode(DLinkedNode other) {
            other.prev = dHead;
            other.next = dHead.next;

            dHead.next.prev = other;
            dHead.next = other;
        }

        // Removes the other node from the list.
        public void removeNode(DLinkedNode other) {
            DLinkedNode tempPrev = other.prev;
            DLinkedNode tempNext = other.next;

            tempPrev.next = tempNext;
            tempNext.prev = tempPrev;

            other.prev = null;
            other.next = null;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
