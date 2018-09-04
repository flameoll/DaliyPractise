package sort;

import java.util.ArrayDeque;
import java.util.Queue;

public class BinarySearchTree {
    private Node node;
    private int count;

    class Node {
        int key;
        int value;
        Node left;
        Node right;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public BinarySearchTree() {
        this.node = null;
        this.count = 0;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void insert(int key, int value) {
        node = __insert(node, key, value);
    }

    private Node __insert(Node node, int key, int value) {
        if (node == null) {
            node = new Node(key, value);
            count++;
            return node;
        }
        if (node.key == key) {
            node.value = value;
            return node;
        } else if (node.key > key) {
            node.left = __insert(node.left, key, value);
        } else {
            node.right = __insert(node.right, key, value);
        }
        return node;
    }

    public boolean contain(int key) {
        return __contain(node, key);
    }

    private boolean __contain(Node node, int key) {
        if (node == null) return false;
        if (node.key > key) return __contain(node.left, key);
        if (node.key < key) return __contain(node.right, key);
        return true;
    }

    public int search(int key) {
        return __search(node, key);
    }

    private int __search(Node node, int key) {
        if (node == null) return -1;
        if (node.key > key) return __search(node.left, key);
        if (node.key < key) return __search(node.right, key);
        return node.value;
    }

    public void preOrder() {
        __perOrder(node);
        System.out.println();
    }

    private void __perOrder(Node node) {
        if (node == null) return;
        System.out.print(node.key + " ");
        __perOrder(node.left);
        __perOrder(node.right);
    }

    public void inOrder() {
        __inOrder(node);
        System.out.println();

    }

    private void __inOrder(Node node) {
        if (node == null) return;
        __inOrder(node.left);
        System.out.print(node.key + " ");
        __inOrder(node.right);
    }

    public void postOrder() {
        __postOrder(node);
        System.out.println();
    }

    private void __postOrder(Node node) {
        if (node == null) return;
        __postOrder(node.left);
        __postOrder(node.right);
        System.out.print(node.key + " ");
    }

    public void levelOrder() {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.print(node.key + " ");
            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
        }
        System.out.println();
    }

    public Node min() {
        if (count == 0) return null;
        return __min(node);
    }

    private Node __min(Node node) {
        if (node.left == null) {
            return node;
        }
        return __min(node.left);
    }

    public Node max() {
        if (count == 0) return null;
        return __max(node);
    }

    private Node __max(Node node) {
        if (node.right == null) {
            return node;
        }
        return __max(node.right);
    }

    public Node removeMin() {

        node = __removeMin(node);
        return node;
    }

    private Node __removeMin(Node node) {
        if (node.left == null) {
            node = node.right;
            count--;
            return node;
        }
        node.left = __removeMin(node.left);
        return node;
    }

    public void remove(int key) {
        __remove(node, key);
    }

    private Node __remove(Node node, int key) {
        if (node == null) return node;
        if (node.key > key) node.left = __remove(node.left, key);
        if (node.key < key) node.right = __remove(node.right, key);
        if (node.key == key) {
            if (node.left == null) {
                node = node.right;
                count--;
                return node;
            }
            if (node.right == null) {
                node = node.left;
                count--;
                return node;
            }
            Node successor = __min(node.right);
            node.right = __removeMin(node.right);
            node.key = successor.key;
            node.value = successor.value;
            return node;
        }

        return null;
    }

    public int floor(int key) {
        Node x = floor(node, key);
        if (x == null) return 0;
        return x.key;
    }

    private Node floor(Node x, int key) {
        if (x == null) return null;
        if (key == x.key) return x;
        else if (key < x.key) return floor(x.left, key);
        else {
            Node t = floor(x.right, key);
            if (t == null) return x;
            else return t;
        }
    }
    public int ceil(int key){
        Node x=ceil(node,key);;
        return x.key;
    }
    private Node ceil(Node node,int key){
        if(node==null) return null;
        if(node.key==key) return node;
        else if(key>node.key) return ceil(node.right,key);
        else {
            Node t =ceil(node.left,key);
            if(t==null) return node;
            else return t;
        }

    }
}

