package tree;

import java.util.Random;

public class BinarySearchTree {
    Node root;
    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        public Node() {
            this(-1);
        }
    }

    private void insert(int item) {
        System.out.println(String.format("Inserting %s", item));
        if(root == null)
            root = new Node(item);
        else
            insert(root, item);
    }

    private void insert(Node node, int item) {
        if(node.data > item) {
            if (node.right == null)
                node.right = new Node(item);
            else
                insert(node.right, item);
        }else {
            if(node.left == null)
                node.left = new Node(item);
            else
                insert(node.left, item);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        Random random = new Random(5);

        // insert data
        random.ints(0,20).distinct().limit(20).forEach(bst::insert);

        // delete data
        random.ints(0, 20).distinct().limit(5).forEach(bst::delete);
    }

    private void delete(int item) {
        System.out.println(String.format("Deleting %s", item));
        if(root == null)
            throw new NullPointerException("Empty Tree");

    }
}
