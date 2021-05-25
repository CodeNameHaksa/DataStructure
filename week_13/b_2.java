import java.io.*;

public class b_2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] sData = br.readLine().split(" ");
        int[] data = new int[sData.length];
        for(int i = 0; i <sData.length; i++){
            data[i] = Integer.parseInt(sData[i]);
        }

        node root = new node(data[0]);
        node p = root;
        for(int i = 1; i < data.length; i++){
            insert(root, data[i]);
        }

        preorder(root);
        System.out.println();
        postorder(root);

        System.out.println();
        inorder(root);



    }

    public static void insert(node root, int key){
        if(key < root.label){
            if(root.left != null){
                insert(root.left, key);
            }else{
                root.left = new node(key);
            }
        }else{
            if(root.right != null){
                insert(root.right, key);
            }else{
                root.right = new node(key);
            }
        }
    }

    public static void preorder(node root){
        System.out.print(root+" ");
        if(root.left!=null){
            preorder(root.left);
        }
        if(root.right!=null){
            preorder(root.right);
        }
    }

    public static void postorder(node root){
        if(root.left!=null){
            postorder(root.left);
        }
        if(root.right!=null){
            postorder(root.right);
        }
        System.out.print(root+" ");
    }

    public static void inorder(node root){
        if(root.left!=null){
            inorder(root.left);
        }
        System.out.print(root+" ");
        if(root.right!=null){
            inorder(root.right);
        }
    }


}
class node{
    node left;
    node right;
    int label;

    public node(int label){
        this.label = label;
    }
    public String toString(){
        return Integer.toString(label);
    }

}
