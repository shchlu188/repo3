package cn.scl.demo03;

public class BinarySortTree {
    private Node root;

    public void add(Node node) {
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }

    public void midShow() {
        if (root == null) {
            return;
        }
        root.midShow(root);
    }

    public Node search(int value) {
        if (root == null) {
            return null;
        }
        return root.search(value);
    }

    public void delete(int value) {
        if (root == null) {
            return;
        }
        Node target = search(value);
        if (target == null) {
            return;
        } else {
            Node node = searchParent(value);
            //删除的是叶子节点
            if (target.getLeft() == null && target.getRight() == null) {
                if (node.getValue() == target.getValue()) {
                    Node left = node.getLeft();
                    left = null;
                } else {
                    Node right = node.getRight();
                    right = null;
                }
                //删除的节点有两个子节点
            } else if (target.getLeft() != null && target.getRight() != null) {
                int min = deleteMin(target.getRight());
                target.setValue(min);

                //有一个子节点
            } else {
                if (target.getLeft()!=null){
                    if (node.getLeft().getValue()==value){
                        node.setLeft(target.getLeft());
                    }else {
                        node.setRight(target.getLeft());
                    }
                }else {
                    if (node.getRight().getValue()==value){
                        node.setRight(target.getRight());
                    }else {
                        node.setLeft(target.getRight());
                    }
                }
            }

        }
    }
    //删除最小节点
    private int deleteMin(Node node) {
        Node target = node;
        while(node.getLeft()!=null){
            target = target.getLeft();
        }
        delete(target.getValue());
        return target.getValue();
    }

    public Node searchParent(int value) {
        if (root == null) {
            return null;
        } else {
            return root.searchParent(value);
        }
    }

}
