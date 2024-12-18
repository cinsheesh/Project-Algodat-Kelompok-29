class Node {
    String name;
    int id;
    String position;
    boolean isCompleted; 
    Node next;

    public Node(String name, int id, String position) {
        this.name = name;
        this.id = id;
        this.position = position;
        this.isCompleted = false; 
        this.next = null;
    }
}