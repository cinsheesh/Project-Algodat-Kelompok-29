class TreeNode {
    String division;
    LinkedList staffList; 
    TreeNode left, middle, right;

    public TreeNode(String division) {
        this.division = division;
        this.staffList = new LinkedList();
        this.left = this.middle = this.right = null;
    }
}

