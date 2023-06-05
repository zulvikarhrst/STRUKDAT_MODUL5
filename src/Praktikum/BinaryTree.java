package Praktikum;

/**
 *
 * @author Zulvikar Harist
 */
import java.util.Scanner;

class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class BinaryTree {
    Node root;

    public BinaryTree() {
        root = null;
    }

    public void insert(int data) {
        root = insertNode(root, data);
    }

    private Node insertNode(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        } else {
            if (data <= root.data) {
                root.left = insertNode(root.left, data);
            } else {
                root.right = insertNode(root.right, data);
            }
        }
        return root;
    }

    public void preOrderTraversal() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public void inOrderTraversal() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.data + " ");
            inOrder(node.right);
        }
    }

    public void postOrderTraversal() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.data + " ");
        }
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan kombinasi angka yang dipisahkan oleh spasi: ");
        String[] elements = scanner.nextLine().split(" ");
        for (String element : elements) {
            int data = Integer.parseInt(element);
            binaryTree.insert(data);
        }

        System.out.println("\nPre-order traversal:");
        binaryTree.preOrderTraversal();

        System.out.println("\n\nIn-order traversal:");
        binaryTree.inOrderTraversal();

        System.out.println("\n\nPost-order traversal:");
        binaryTree.postOrderTraversal();
    }
}

