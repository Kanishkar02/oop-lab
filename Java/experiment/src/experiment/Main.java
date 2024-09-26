package experiment;
import java.util.*;
class BinaryTreeNode<T> {
    T data;
    BinaryTreeNode<T> left, right;
    BinaryTreeNode(T data) {
        this.data = data;
    }
}
class BinaryTree<T> {
    BinaryTreeNode<T> root;
    void dfs(BinaryTreeNode<T> node) {
        if (node != null) {
            dfs(node.left);
            System.out.print(node.data + " ");
            dfs(node.right);
        }
    }
    void bfs() {
        if (root == null) return;
        Queue<BinaryTreeNode<T>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryTreeNode<T> node = queue.poll();
            System.out.print(node.data + " ");
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
    }
}
public class Main {
    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.root = new BinaryTreeNode<>(1);
        tree.root.left = new BinaryTreeNode<>(2);
        tree.root.right = new BinaryTreeNode<>(3);
        tree.root.left.left = new BinaryTreeNode<>(4);
        tree.root.left.right = new BinaryTreeNode<>(5);
        tree.root.right.left = new BinaryTreeNode<>(6);
        tree.root.right.right = new BinaryTreeNode<>(7);
        System.out.print("DFS: ");
        tree.dfs(tree.root);
        System.out.println();
        System.out.print("BFS: ");
        tree.bfs();
    }
}

