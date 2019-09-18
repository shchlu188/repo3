package cn.scl.tree;

/**
 * 二叉树
 */
public class BinaryTree {
    TreeNode root;

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
}
