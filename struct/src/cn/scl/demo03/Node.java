package cn.scl.demo03;

public class Node {
    private int value;
    private Node left;
    private Node right;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node(int value) {
        this.value = value;
    }

    /**
     * 添加节点
     *
     * @param node
     */
    public void add(Node node) {
        if (node == null) {
            return;
        }
        if (this.value >= node.value) {
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.add(node);
            }
        }
        if (this.value < node.value) {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        }
    }

    public void midShow(Node node) {
        if (node == null) {
            return;
        }
        if (this.left != null) {
            midShow(node.left);
        }
        System.out.println(node.value);
        if (this.right != null) {
            midShow(node.right);
        }
    }

    public Node search(int value) {
        if (value == this.value) {
            return this;
        }
        if (value < this.value) {
            if (this.left != null) {
                return left.search(value);
            }
        } else if (value > this.value) {
            if (this.right != null) {
                return right.search(value);
            }
        }
        return null;
    }

    /**
     * 删除节点
     *
     * @param target
     */
    public void delete(Node target) {

    }

    /**
     * 查找父节点
     *
     * @param value
     * @return
     */
    public Node searchParent(int value) {
        if ((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)) {
            return this;
        } else {
            if (this.value > value) {
                return this.left.searchParent(value);
            } else if (this.value < value) {
                return this.right.searchParent(value);
            }
            return null;
        }
    }
}
