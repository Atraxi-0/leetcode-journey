class LRUCache {
    int capacity = 0;
    Map<Integer, Node> cache = new HashMap<>();
    Node head, tail;
    
    public LRUCache(int capacity) {
        this.capacity = capacity; 
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
    }

    class Node {
        int key, value; 
        Node prev, next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private void addNode(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addNode(node);
    }

    private Node popTail() {
        Node res = tail.prev;
        removeNode(res);
        return res;
    }
    
    public int get(int key) {
        Node node = cache.get(key);
        if (node == null ) {
            return -1;
        } else {
            moveToHead(node);
            return node.value;
        }
    }
    
    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node != null) {
            node.value = value;
            moveToHead(cache.get(key));           
        } else {
            node = new Node(key, value);
            addNode(node);
            cache.put(key,node);
            if (cache.size() > capacity) {
                Node lruNode = popTail();
                cache.remove(lruNode.key);
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */