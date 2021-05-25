//import java.util.*;
//
//class Node{
//    int num, x, y;
//    Node left, right;
//
//    public Node(int x, int y, int num){
//        this.x = x;
//        this.y = y;
//        this.num = num;
//    }
//}
//
//class Tree{
//    Node root;
//    List<Integer> order = new ArrayList<>();
//
//    public Tree(Node root){
//        this.root = root;
//    }
//
//    public void connect(Node parent, Node child){
//        // x의 기준으로 parent보다 작다는 것은 왼쪽에 위치
//        if (parent.x > child.x){
//            if (parent.left == null)
//                parent.left = child;
//            else
//                connect(parent.left, child);
//        }else {
//            if (parent.right == null)
//                parent.right = child;
//            else
//                connect(parent.right, child);
//        }
//    }
//
//    public void preorder(Node node){
//        if (node == null)
//            return;
//
//        order.add(node.num);
//        preorder(node.left);
//        preorder(node.right);
//    }
//
//    public void postorder(Node node){
//        if (node == null)
//            return;
//
//        postorder(node.left);
//        postorder(node.right);
//        order.add(node.num);
//    }
//}
//
//class Solution {
//    public static void main(String[] args) {
//        int[][] data = {{5,3}, {11,5}, {13,3}, {3,5}, {6,1}, {1,3}, {8,6}, {7,2}, {2,2}};
//        solution(data);
//    }
//    public static int[][] solution(int[][] nodeinfo) {
//        int[][] answer = new int[2][nodeinfo.length];
//        Node[] data = new Node[nodeinfo.length];
//
//        for(int i = 0; i < nodeinfo.length; i++)
//            data[i] = new Node(nodeinfo[i][0], nodeinfo[i][1], i + 1);
//
//        Arrays.sort(data, new Comparator<Node>(){
//            public int compare(Node n1, Node n2){
//                if (n1.y == n2.y)
//                    return n1.x - n2.x;
//                return n2.y - n1.y;
//            }
//        });
//
//        Tree tree = new Tree(data[0]);
//
//        for (int i = 1; i < data.length; i++)
//            tree.connect(tree.root, data[i]);
//
//        tree.preorder(tree.root);
//
//        List<Integer> first = tree.order;
//        int cnt = 0;
//        for (int temp : first) {
//            answer[0][cnt] = temp;
//            cnt++;
//        }
//
//        tree.order.clear();
//
//        tree.postorder(tree.root);
//        List<Integer> two = tree.order;
//        cnt = 0;
//        for (int temp : two) {
//            answer[1][cnt] = temp;
//            cnt++;
//        }
//
//        return answer;
//    }
//}