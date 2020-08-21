class LinkedList<T> {

    Node<T> head;
    Node<T> tail;
    int size;

    
    void append(Node<T> n) {
        if (head == null) {
            head = n;
        } else {
            tail.next = n;
        }
        tail = n;
        size++;
    }

    
    void prepend(Node<T> n) {
        n.next = head;
        head = n;

        if (tail == null) {
            tail = n;
        }
        size++;
    }

   
    void insertAfter(Node<T> newNode, Node<T> node) {
        if (node.equals(tail)) {
            tail = newNode;
        }
        newNode.next = node.next;
        node.next = newNode;
        size++;
    }

    
    void insertBefore(Node<T> newNode, Node<T> node) {
        if (head.equals(node)) {
            newNode.next = head;
            head = newNode;
        } else {
            Node<T> n = head;

            while (n.next != null) {
                if (node.equals(n.next)) {
                    newNode.next = n.next;
                    n.next = newNode;
                    break;
                }
                n = n.next;
            }
        }
        size++;
    }

    
    void removeAfter(Node<T> n) {
        if (n.next != null) {
            if (n.next.equals(tail)) {
                tail = n;
            }
            n.next = n.next.next;
            size--;
        }
    }

   
    void removeBefore(Node<T> n) {}

    
    void removeHead() {
        if (head != null) {
            head = head.next;
            size--;

            if (head == null) {
                tail = null;
            }
        }
    }

   
    void removeTail() {}

    
    void remove(Node<T> n) {}

    
    Node<T> get(int index) {
        if (index > size - 1) {
            return null;
        }
        Node<T> n = head;

        while (n.next != null && index > 0) {
            n = n.next;
            index--;
        }
        return n;
    }
}