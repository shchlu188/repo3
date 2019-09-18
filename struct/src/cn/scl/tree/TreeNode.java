package cn.scl.tree;

/**
 * 树节点
 */
public class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode(int value) {
        this.value = value;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }


    public void frontShow() {
        System.out.println(value);
        if (left != null) {
            left.frontShow();
        }
        if (right != null) {
            right.frontShow();
        }
    }

    public void midShow() {
        if (left != null) {
            left.midShow();
        }
        System.out.println(value);
        if (right != null) {
            right.midShow();
        }

    }

    public void afterShow() {
        if (left != null) {
            left.afterShow();
        }
        if (right != null) {
            right.afterShow();
        }
        System.out.println(value);
    }

    public TreeNode frontSerch(int value) {
        TreeNode target = null;
        if (this.value == value) {
            return this;
        } else {
            if (left != null) {
                target = left.frontSerch(value);
            }
            if (target != null) {
                return target;
            }
            if (right != null) {
                target = right.frontSerch(value);
            }
        }
        return target;
    }


    public TreeNode midSerch(int value) {
        TreeNode target = null;
        if (left != null) {
            target = left.midSerch(value);
            if (target != null) {
                return target;
            }
        }
        if (this.value == value) {
            return this;
        }
        if (right != null) {
            target = right.midSerch(value);
        }
        return target;
    }

    public TreeNode afterSerch(int value) {
        TreeNode target = null;
        if (left != null) {
            target = left.afterSerch(value);
            if (target != null) {
                return target;
            }
        }
        if (right != null) {
            target = right.afterSerch(value);
            if (target != null) {
                return target;
            }
        }
        if (this.value == value) {
            target = this;
        }
        return target;
    }

    public void delete(int value) {
        TreeNode parent = this;
        if (parent.left.value == value){
            parent.left = null;
            return;
        }
        if (parent.right.value == value){
            parent.right = null;
            return;
        }
        parent = left;
        if(parent != null){
            parent.delete(value);
        }
        parent = right;
        if(parent != null){
            parent.delete(value);
        }
    }
}
