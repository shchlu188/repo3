package cn.scl.tree1;

public class TestArrayBinaryTree {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        BinaryTree binaryTree = new BinaryTree();
        TreeNode root = new TreeNode(1);
        binaryTree.setRoot(root);
        TreeNode rootL = new TreeNode(2);
        TreeNode rootR = new TreeNode(3);
        root.setLeft(rootL);
        root.setRight(rootR);
        rootL.setLeft(new TreeNode(4));
        rootL.setRight(new TreeNode(5));
        rootR.setLeft(new TreeNode(6));
        rootR.setRight(new TreeNode(7));
        binaryTree.midShow();
        System.out.println("-------------------------");
        binaryTree.threadNodes();
        binaryTree.thradIterator();
    }
}
