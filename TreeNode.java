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

class Tree {
    TreeNode root;

    public Tree(String rootDivision) {
        root = new TreeNode(rootDivision);
    }

    public void addLeft(String division) {
        if (root != null) {
            root.left = new TreeNode(division);
        }
    }

    public void addMiddle(String division) {
        if (root != null) {
            root.middle = new TreeNode(division);
        }
    }

    public void addRight(String division) {
        if (root != null) {
            root.right = new TreeNode(division);
        }
    }

   
