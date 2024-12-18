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
    public void addStaffToDivision(TreeNode node, String name, int id, String position) {
        if (node != null) {
            node.staffList.insertLast(new Node(name, id, position));
        }
    }

    public void traverse() {
        traverse(root, 0);
    }

    private void traverse(TreeNode node, int level) {
        if (node == null) {
            return;
        }
        System.out.println("  ".repeat(level) + "- " + node.division);
        System.out.println("  ".repeat(level) + "  Staff:");
        node.staffList.display();
        traverse(node.left, level + 1);
        traverse(node.middle, level + 1);
        traverse(node.right, level + 1);
    }
}
   
