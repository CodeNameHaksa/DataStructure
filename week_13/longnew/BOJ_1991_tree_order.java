
import java.io.*;
import java.util.*;

public class BOJ_1991_tree_order {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static HashMap<String, String[]> data = new HashMap<>();

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] temp = br.readLine().split(" ");
            String[] data_temp = {temp[1], temp[2]};

            data.put(temp[0], data_temp);
        }

        preOrder("A");
        System.out.println();

        inOrder("A");
        System.out.println();

        postOrder("A");
    }

    public static void preOrder(String temp){
        System.out.print(temp);
        String[] child = data.get(temp);

        if (!child[0].equals("."))
            preOrder(child[0]);

        if (!child[1].equals("."))
            preOrder(child[1]);
    }

    public static void postOrder(String temp){
        String[] child = data.get(temp);

        if (!child[0].equals("."))
            postOrder(child[0]);

        if (!child[1].equals("."))
            postOrder(child[1]);

        System.out.print(temp);
    }

    public static void inOrder(String temp){
        String[] child = data.get(temp);

        if (!child[0].equals("."))
            inOrder(child[0]);

        System.out.print(temp);

        if (!child[1].equals("."))
            inOrder(child[1]);
    }
}
