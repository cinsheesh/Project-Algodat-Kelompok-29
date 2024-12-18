class Stack {
    Node top;

    public void push(Node task) {
        task.next = top;
        top = task;
    }

    public Node pop() {
        if (top == null) return null;
        Node task = top;
        top = top.next;
        task.next = null;
        return task;
    }

    public void display() {
        Node temp = top;
        System.out.println("Riwayat Tugas:");
        while (temp != null) {
            System.out.println("  Tugas: " + temp.name);  
            temp = temp.next;
        }
    }
}

class Queue {
    Node front, rear;

    public Queue() {
        this.front = this.rear = null;
    }

    public void enqueue(Node newNode) {
        if (rear == null) {
            front = rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }

    public Node dequeue() {
        if (front == null) {
            return null;
        }
        Node temp = front;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return temp;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void display() {
        Node temp = front;
        while (temp != null) {
            System.out.println("Task: " + temp.name);
            temp = temp.next;
        }
    }
}