package cn.scl.demo01;


import java.util.*;

public class BinaryTree {
    public static void main(String[] args) {
//        int[] arr = {3,5,7,8,11,14,23,29};
//        Node huffmanTree = createHuffmanTree(arr);
//        System.out.println(huffmanTree);
//        System.out.println(huffmanTree.getLeft());
//        System.out.println(huffmanTree.getRight().getRight());
        String str = "aaabbccsdafrger";
        byte[] bytes = huffmanZip(str.getBytes());

        //解码
        byte[] newBytes = decode(bytes, huffCodes);
        System.out.println(Arrays.toString(newBytes));
        System.out.println(new String(newBytes
        ));
    }

    private static byte[] decode(byte[] bytes, Map<Byte, String> huffCodes) {
        StringBuilder sb = new StringBuilder();
        List<Byte> byteList = new ArrayList<>();
        //byte数组转为二进制
        for (int i = 0; i < bytes.length; i++) {
            byte b = bytes[i];
            boolean flag = (i == bytes.length - 1);
            sb.append(byteToStr(!flag, b));
        }
        Map<String, Byte> map = new HashMap<>();
        for (Map.Entry<Byte, String> entry : huffCodes.entrySet()) {
            map.put(entry.getValue(), entry.getKey());
        }
        for (int i = 0; i < sb.length(); ) {
            int count = 1;
            boolean flag = true;
            while (flag) {
                String key = sb.substring(i, i + count);
                Byte b = map.get(key);
                if (b == null) {
                    count++;
                } else {
                    byteList.add(b);
                    flag = false;
                }
            }
            i += count;
        }
        byte[] bytes1 = new byte[byteList.size()];
        int index = 0;
        for (Byte aByte : byteList) {
            bytes1[index++]=aByte;
        }
        return bytes1;
    }

    private static String byteToStr(boolean flag, byte a) {
        int temp = a;
        if (flag) {
            temp |= 256;
        }
        String str = Integer.toBinaryString(temp);
        if (flag) {

            return str.substring(str.length() - 8);
        } else {
            return str;
        }

    }
    /**
     * 压缩
     *
     * @param bytes
     * @return
     */
    public static byte[] huffmanZip(byte[] bytes) {
        //统计次数
        List<Node> nodes = getNodes(bytes);
        //创建赫夫曼树
        Node tree = createHuffmanTree(nodes);
        //创建赫夫曼编码表
        Map<Byte, String> codes = getCodes(tree);
        //编码
        byte[] b = zip(bytes, codes);
        return b;
    }

    /**
     * 进行编码
     *
     * @param bytes
     * @param codes
     * @return
     */
    private static byte[] zip(byte[] bytes, Map<Byte, String> codes) {
        StringBuilder st = new StringBuilder();
        for (byte b : bytes) {
            st.append(codes.get(b));
        }
        System.out.println(st.toString());
        int len = st.length() % 8 == 0 ? st.length() / 8 : st.length() / 8 + 1;
        byte[] by = new byte[len];
        //记录下标
        int index = 0;
        for (int i = 0; i < st.length(); i += 8) {
            String str;
            if ((i + 8) > st.length()) {
                str = st.substring(i);
            } else {
                str = st.substring(i, i + 8);
            }
            //转换为字节
            byte byt = (byte) Integer.parseInt(str, 2);
            by[index++] = byt;
        }
        System.out.println("-----------qw------------");
        System.out.println("-----------qw------------");
        return by;
    }

    private static StringBuilder sb = new StringBuilder();
    private static Map<Byte, String> huffCodes = new HashMap<>();

    private static Map<Byte, String> getCodes(Node tree) {
        if (null == tree) {
            return null;
        }
        getCodes(tree.getLeft(), "0", sb);
        getCodes(tree.getRight(), "1", sb);
        return huffCodes;
    }

    private static void getCodes(Node node, String code, StringBuilder sb) {
        StringBuilder sb2 = new StringBuilder(sb);
        sb2.append(code);
        if (node.getLeft() != null) {
            getCodes(node.getLeft(), "0", sb2);
            getCodes(node.getRight(), "1", sb2);
        } else {
            String str = sb2.toString();
            huffCodes.put(node.getData(), str);
        }
    }


    /**
     * 创建赫夫曼树
     *
     * @param list
     * @return
     */
    private static Node createHuffmanTree(List<Node> list) {
        //循环执行，直到只剩下一个node为止
        while (list.size() > 1) {
            //排序
            Collections.sort(list);
            //获取集合中两个出现次数少的的node
            Node left = list.get(0);
            Node right = list.get(1);
            //把两个node的次数赋值给新的node
            Node newNode = new Node(null, left.getWeight() + right.getWeight());
            //设置新node的左右节点
            newNode.setLeft(left);
            newNode.setRight(right);
            //把新的节点添加进集合
            list.add(newNode);
            //移除两个小的节点
            list.remove(right);
            list.remove(left);
        }
        //System.out.println(list);
        return list.get(0);
    }

    private static List<Node> getNodes(byte[] bytes) {
        List<Node> nodes = new ArrayList<>();
        Map<Byte, Integer> counts = new HashMap<>();
        //把字符和字符出现次数存入map集合中
        for (byte b : bytes) {
            Integer count = counts.get(b);
            if (count == null) {
                counts.put(b, 1);
            } else {
                counts.put(b, count + 1);
            }
        }
        for (Map.Entry<Byte, Integer> entry : counts.entrySet()) {
            nodes.add(new Node(entry.getKey(), entry.getValue()));
        }
        //   System.out.println(nodes);
        return nodes;
    }

    /**
     * 赫夫曼树
     */
    public static Node createHuffmanTree(int[] arr) {
        List<Node> list = new ArrayList<>();
        for (int value : arr) {
            list.add(new Node(value));
        }
        while (list.size() > 1) {
            Collections.sort(list);
            Node left = list.get(0);
            Node right = list.get(1);
            Node newNode = new Node(left.getWeight() + right.getWeight());
            newNode.setLeft(left);
            newNode.setRight(right);
            list.add(newNode);
            list.remove(left);
            list.remove(right);
        }
        return list.get(0);
    }

    /**
     * 1、获得字符的次数
     */
}
