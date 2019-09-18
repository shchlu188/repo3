package cn.scl.tree1;

/**
 * 二叉树
 */
public class BinaryTree {
    TreeNode root ;
    TreeNode pre = null;

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {

        this.root = root;
    }

    public void frontShow() {
        root.frontShow();
    }

    public void midShow() {
        root.midShow();
    }

    public void afterShow() {
        root.afterShow();
    }

    public TreeNode frontSerch(int value) {
        return root.frontSerch(value);
    }

    public TreeNode midSerch(int value) {
        return root.midSerch(value);
    }

    public TreeNode afterSerch(int value) {
        return root.afterSerch(value);
    }

    public void delete(int value) {
        if (root.value == value) {
            root = null;
            return;
        }
        root.delete(value);
    }

    /**
     * 中序线索化二叉树
     */
    public void threadNodes() {
        threadNodes(root);
    }

    public void threadNodes(TreeNode node) {
        if (node == null) {
            return;
        }
        //左
        threadNodes(node.left);
        //自己
        if (node.left == null) {

            node.left = pre;
            node.leftType = 1;
        }
        if (pre != null && pre.right == null) {
            pre.right = node;
            pre.rightType = 1;
        }
        //保存当前节点
        pre = node;
        //右
        threadNodes(node.right);

    }

    /**
     * 遍历
     */
    public void thradIterator() {
        //存放当前节点
        TreeNode node = root;
        while (node != null) {
            while (node.leftType == 0) {
                node = node.left;
            }
            System.out.println(node.value);
            while (node.rightType == 1) {
                node = node.right;
                System.out.println(node.value);
            }
            node = node.right;
        }
    }
}
