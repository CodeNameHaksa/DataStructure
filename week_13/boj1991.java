import java.io.*;
import java.util.*;

public class boj1991 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] data = null;
        data = br.readLine().split(" ");
        Node root = new Node(data[0], data[1], data[2]);
        for(int i = 1; i < N; i++){
            data = br.readLine().split(" ");
            add(root, data[0], data[1], data[2]);
        }

        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        postOrder(root);


    }

    public static void add(Node root, String label, String left, String right){
        if(root == null){
            if(!label.equals(".")){
                root = new Node(label);
            }
//            if(!left.equals(".")){
                root.left = new Node(left);
//            }
//            if(!left.equals(".")){
                root.right = new Node(right);
//            }
        }
        else{
            search(root, label, left, right);
        }
    }

    public static void search(Node root, String label, String left, String right){
        if(root == null){
            return;
        }
        else if(root.label.equals(label)){
//            if(!left.equals(".")){
                root.left = new Node(left);
//            }
//            if(!right.equals(".")){
                root.right = new Node(right);
//            }
        }
        else{
            search(root.left, label, left, right);
            search(root.right, label,left, right);
        }
    }

    public static void preOrder(Node t){
        System.out.print(t);
        if(!t.left.label.equals(".")){
            preOrder(t.left);
        }
        if(!t.right.label.equals(".")){
            preOrder(t.right);
        }
    }

    public static void inOrder(Node t){
        if(!t.left.label.equals(".")){
            inOrder(t.left);
        }
        System.out.print(t);
        if(!t.right.label.equals(".")){
            inOrder(t.right);
        }
    }

    public static void postOrder(Node t){
        if(!t.left.label.equals(".")){
            postOrder(t.left);
        }
        if(!t.right.label.equals(".")){
            postOrder(t.right);
        }
        System.out.print(t);
    }
}



class Node{
    Node left, right;
    String label;

    public Node(String label){
        this.label = label;
    }

    public Node(String label, String left, String right){
        this.left = new Node(left);
        this.right = new Node(right);
        this.label = label;
    }

    public String toString(){
        return label;
    }
}
