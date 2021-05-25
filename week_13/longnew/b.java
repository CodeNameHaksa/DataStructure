import java.util.*;
import java.io.*;

class Node{
    int data;
    Node left, right;

    public Node(String data){
        this.data = Integer.parseInt(data);
    }
}

class Tree{
    Node root;

    public Tree(String data){
        root = new Node(data);
    }

    public void insert(Node parent, Node child){
        if (parent.data > child.data){
            if (parent.left == null)
                parent.left = child;
            else
                insert(parent.left, child);
        }else{
            if (parent.right == null)
                parent.right = child;
            else
                insert(parent.right, child);
        }
    }

    public void preorder(Node node){
        System.out.print(node.data + " ");
        if (node.left != null)
            preorder(node.left);
        if (node.right != null)
            preorder(node.right);
    }

    public void inorder(Node node){
        if (node.left != null)
            inorder(node.left);

        System.out.print(node.data + " ");

        if (node.right != null)
            inorder(node.right);
    }

    public void postorder(Node node){
        if (node.left != null)
            postorder(node.left);
        if (node.right != null)
            postorder(node.right);

        System.out.print(node.data + " ");
    }
}

public class b {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());

        String[] temp = br.readLine().split(" ");

        Tree tree = new Tree(temp[0]);

        for (int i = 1; i < n; i++)
            tree.insert(tree.root, new Node(temp[i]));

        tree.preorder(tree.root);
        System.out.println();
        tree.postorder(tree.root);
        System.out.println();
        tree.inorder(tree.root);
        System.out.println();
    }
}
