package org.example.Q2;


class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class Q2 {
    Node root;

    // Perform right rotation on a node
    private Node rightRotate(Node node) {
        Node temp = node.left;
        node.left = temp.right;
        temp.right = node;
        return temp;
    }

    // Convert BST into skewed tree
    private Node convertToSkewed(Node node) {
        // Base case
        if (node == null) {
            return null;
        }
        // Perform right rotation on each node until it has only a right child
        while (node.left != null) {
            node = rightRotate(node);
        }
        // Recursively convert right subtree into skewed tree
        node.right = convertToSkewed(node.right);
        return node;
    }

    // Display node values in ascending order
    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    public static void main(String[] args) {
        Q2 tree = new Q2();
        tree.root = new Node(50);
        tree.root.left = new Node(30);
        tree.root.right = new Node(60);
        tree.root.left.left = new Node(10);
        tree.root.right.left = new Node(55);

        // Convert BST into skewed tree
        tree.root = tree.convertToSkewed(tree.root);

        // Display node values in ascending order
        tree.inOrder(tree.root);
    }


}

