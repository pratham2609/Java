package com.binarytree;
import java.util.ArrayList;

public class Bst {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    public static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }
        if (root.data > val) {
            root.left = insert(root.left, val);
        }
        if(root.data < val) {
            root.right = insert(root.right, val);
        }
        return root;
    }

    public static void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
        return;
    }

    public static boolean search(Node root,int key) {
        if(root == null) {
            return false;
        }
        if(root.data == key) {
            return true;
        }
        if(root.data > key) {
            return search(root.left, key);
        }
        else {
            return search(root.right, key);
        }
    }

    public static Node delete(Node root, int val) {
        if(root.data < val) {
            root.right = delete(root.right, val);
        }
        else if(root.data > val) {
            root.left = delete(root.left, val);
        }
        else {
            if(root.left == null && root.right == null) {
                return null;
            }
            if (root.left == null) {
                return root.right;
            }
            else if (root.right == null) {
                return root.left;
            }
        }
        return root;
    }


    public static void printInRange(Node root, int k1, int k2) {
        if (root == null) {
            return;
        }
        if(root.data >= k1 && root.data <= k2) {
            printInRange(root.left, k1, k2);
            System.out.print(root.data + " ");
            printInRange(root.right, k1, k2);
        } else if (root.data < k1) {
            printInRange(root.left, k1, k2);
        } else {
            printInRange(root.right, k1, k2);
        }
    }


    public static void printPath(ArrayList<Integer> path) {
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i) + "->");
        }
        System.out.println("NULL");
    }

    public static void printRootToLeaf(Node root, ArrayList<Integer> path) {
        if(root == null) {
            return;
        }
        path.add(root.data);
        if(root.left == null && root.right == null) {
            printPath(path);
        }
        printRootToLeaf(root.left, path);
        printRootToLeaf(root.right, path);
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        int[] values = { 8, 5, 3, 6, 10, 11, 14 };
        Node root = null;
        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }
        inOrder(root);
        if (search(root, 50)) {
            System.out.println("Found!");
        }
        else {
            System.out.println("Not found");
        }
        printInRange(root, 5, 12);
        printRootToLeaf(root, new ArrayList<>());
    }
}
