import java.util.ArrayList;

/**
 * An Integer Binary Search Tree
 * @author: Your Name Here
 * @version: Date
 */

public class BST {
    private BSTNode root;
    private ArrayList<BSTNode> inorder = new ArrayList<>();
    private ArrayList<BSTNode> preorder = new ArrayList<>();
    private  ArrayList<BSTNode> postorder = new ArrayList<>();

    public BSTNode getRoot() {
        return this.root;
    }

    public void setRoot(BSTNode root) {
        this.root = root;
    }

    /**
     * Sets up a binary search tree
     * with some default values
     */
    public void setupTestData() {
        this.root = new BSTNode(10);
        this.root.setLeft(new BSTNode(5));
        this.root.setRight(new BSTNode((15)));
        this.root.getLeft().setLeft(new BSTNode(3));
        this.root.getLeft().setRight(new BSTNode(9));
    }

    /**
     * Prints the provided ArrayList of nodes
     * in the form node1-node2-node3
     * @param nodes ArrayList of BSTNodes
     */
    public static void printNodes(ArrayList<BSTNode> nodes) {
        for(int i=0; i<nodes.size()-1; i++) {
            System.out.print(nodes.get(i) + "-");
        }
        System.out.println(nodes.get(nodes.size()-1));
    }

    /**
     * A function that searches for a value in the tree
     * @param val integer value to search for
     * @return true if val is in the tree, false otherwise
     */
    public boolean search(int val, BSTNode n) {
        if (n == null) {
            return false;
        }
        if (val == n.getVal()) {
            return true;
        }
        if (val > n.getVal()) {
            return search(val, n.getRight());
        }
        return search(val, n.getLeft());
    }

    public boolean search(int val) {
        return search(val, getRoot());
    }


    /**
     * @return ArrayList of BSTNodes in inorder
     */
    public ArrayList<BSTNode> getInorder() {
        return getInorder(getRoot());
    }

    public ArrayList<BSTNode> getInorder(BSTNode n) {
        if (n == null) {
            return inorder;
        }
        getInorder(n.getLeft());
        inorder.add(n);
        getInorder(n.getRight());
        return inorder;
    }

    /**
     * @return ArrayList of BSTNodes in preorder
     */
    public ArrayList<BSTNode> getPreorder() {
        return getPreorder(getRoot());
    }

    public ArrayList<BSTNode> getPreorder(BSTNode n) {
        if (n == null) {
            return preorder;
        }
        preorder.add(n);
        getPreorder(n.getLeft());
        getPreorder(n.getRight());
        return preorder;
    }

    /**
     * @return ArrayList of BSTNodes in postorder
     */
    public ArrayList<BSTNode> getPostorder() {
        return getPostorder(getRoot());
    }

    public ArrayList<BSTNode> getPostorder(BSTNode n) {
        if (n == null) {
            return postorder;
        }
        getPostorder(n.getLeft());
        getPostorder(n.getRight());
        postorder.add(n);
        return postorder;
    }

    /**
     * Inserts the given integer value to the tree
     * if it does not already exist. Modifies the
     * root instance variable to be the root of the new modified tree.
     * @param val The value ot insert
     */
    public void insert(int val) {
        if (!search(val)) {
            for (BSTNode n : inorder) {
                if (n.getVal() > val) {
                    BSTNode newv = new BSTNode(val);
                    setRoot(newv);
                    inorder.set(inorder.indexOf(n), newv);
                    break;
                }
            }
        }
    }

    /**
     * Determines if the current BST is
     * a valid BST.
     * @return true if valid false otherwise
     */
    public boolean isValidBST() {
        // TODO: Optional Challenge!
        return false;
    }

    public static void main(String[] args) {
        // Tree to help you test your code
        BST tree = new BST();
        tree.setupTestData();

        System.out.println("\nSearching for 15 in the tree");
        System.out.println(tree.search(15));

        System.out.println("\nSearching for 22 in the tree");
        System.out.println(tree.search(22));

        System.out.println("\nPreorder traversal of binary tree is");
        ArrayList<BSTNode> sol = tree.getPreorder();
        printNodes(sol);

        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);

        System.out.println("\nPostorder traversal of binary tree is");
        sol = tree.getPostorder();
        printNodes(sol);

        tree.insert(8);
        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);
    }
}
