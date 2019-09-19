package cn.scl.demo03;

/**
 * 测试二叉排序树
 */
public class Test {
    public static void main(String[] args) {
        int[] arr = {5,1,3,9,7,10,12};
        BinarySortTree tree = new BinarySortTree();
        for (int i : arr) {
            tree.add(new Node(i));
        }
        tree.midShow();
        System.out.println("---------------------------------");
//        Node nod = tree.search(13);
//        System.out.println(nod.getValue());
//        System.out.println(nod.getLeft().getValue());
//        System.out.println(nod.getRight().getValue());
        System.out.println("---------------------------");
        tree.delete(9);
        tree.midShow();
    }

}
