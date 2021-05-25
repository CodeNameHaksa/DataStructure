import java.io.*;
import java.util.HashMap;

public class a_2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, String> pass = new HashMap<>();
        HashMap<String, String> tries = new HashMap<>();
        String[] sData = null;
        int M = Integer.parseInt(br.readLine());
        for(int i = 0; i < M; i++){
            sData = br.readLine().split(" ");
            pass.put(sData[0], sData[1]);
        }
        int K = Integer.parseInt(br.readLine());

        for(int i = 0; i < K; i++){
            sData = br.readLine().split(" ");
            if(!pass.containsKey(sData[0])){
                System.out.println(false);
                continue;
            }
            if(returnCode(pass.get(sData[0])) == Integer.parseInt(sData[1])){
                System.out.println(true);
            }else{
                System.out.println(false);
            }
        }



    }
    public static int returnCode(String s){
        StringBuilder sb = new StringBuilder(s);
        String reverseS = sb.reverse().toString();
        int ans = 0;
        String lower = reverseS.toLowerCase();
        String upper = reverseS.toUpperCase();

        ans += lower.hashCode();
        ans += upper.hashCode();

        return ans;
    }

}
