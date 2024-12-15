class LinkedList {
    Node head;

    public void insertLast(Node newNode) {
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public void bubbleSortByName() {
        if (head == null || head.next == null) return;
        boolean swapped;
        do {
            swapped = false;
            Node current = head;
            Node prev = null;
            while (current != null && current.next != null) {
                if (current.name.compareTo(current.next.name) > 0) {
                    Node temp = current.next;
                    current.next = temp.next;
                    temp.next = current;
                    if (prev == null) {
                        head = temp;
                    } else {
                        prev.next = temp;
                    }
                    swapped = true;
                }
                prev = (prev == null) ? head : prev.next;
                current = current.next;
            }
        } while (swapped);
    }