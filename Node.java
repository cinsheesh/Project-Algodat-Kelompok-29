class Node {
    String name;
    int id;
    String position;
    Node next;

    public Node(String name, int id, String position) {
        this.name = name;
        this.id = id;
        this.position = position;
        this.next = null;
    }
}