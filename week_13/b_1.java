import java.io.*;
import java.util.*;

public class b_1 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<String, String[]> tree = new HashMap<>();
        String[] sData = null;

        String root = null;
        for(int i = 0; i < N; i++){
            sData = br.readLine().split(" ");
            String[] arr = new String[2];
            arr[0] = sData[1];
            arr[1] = sData[2];

            for(int j = 0; j < 2; j++){
                if(arr[j].equals(".")){
                    arr[j] = null;
                }
            }
            if(i == 0){
                root = sData[0];
                tree.put(root, arr);
                continue;
            }
            tree.put(sData[0], arr);
        }

        Queue<String> q = new LinkedList<>();
        q.add(root);
        int length = q.size();

        while(!q.isEmpty()){
            for(int i = 0; i < length; i++){
                String tmp = q.poll();
                System.out.print(tmp+" ");
                for(int j = 0; j < 2; j++){
                    if(tree.containsKey(tmp)){
                        if(tree.get(tmp)[j]!=null){
                            q.add(tree.get(tmp)[j]);
                        }
                    }
                }
            }
            System.out.println();
            length = q.size();

        }
    }
}
