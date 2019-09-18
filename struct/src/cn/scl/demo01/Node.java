package cn.scl.demo01;

public class Node implements Comparable<Node> {
    private Byte data;

    public Byte getData() {
        return data;
    }

    public void setData(Byte data) {
        this.data = data;
    }

    //权值
    private int weight;
    //左节点
    private Node left;
    //右节点
    private Node right;

    public Node(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }

    public Node(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
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

    @Override
    public int compareTo(Node o) {
        return this.getWeight()-o.getWeight();
    }
}
