import java.io.*;
import java.util.*;

public class b_3 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<String, String[]> tree = new HashMap<>();
        String[] data = null;
        String root ="";
        for(int i = 0; i < N; i++){
            data = br.readLine().split(" ");
            if(i == 0){
                root = data[0];
            }
            String[] arr = new String[2];
            arr[0] = data[1];
            arr[1] = data[2];
            tree.put(data[0], arr);
        }

        Queue<String> q = new LinkedList<>();
        String end = ".";
        String answer = "";
        String tmp = root;
        while(!tmp.equals(end)){
            tmp = tree.get(tmp)[0];
            if(tmp.equals(end)){
                continue;
            }
            answer = tmp +" "+answer;
        }
        tmp = root;
        answer += root+" ";
        while(!tmp.equals(end)){
            tmp = tree.get(tmp)[1];
            if(tmp.equals(end)){
                continue;
            }
            answer = answer + tmp + " ";
        }


        System.out.println(answer);
    }
}
