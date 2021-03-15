import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_11441 {
    static int[] arr;
    static int[] dp;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int N = Integer.parseInt(input);
        arr = new int[N+1];
        dp = new int[N+1];
        dp[0] = 0;
        input = br.readLine();
        StringTokenizer st= new StringTokenizer(input);
        for(int i=1;i<N+1;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1;i<N+1;i++){
            dp[i] = dp[i-1]+arr[i];
        }
        input = br.readLine();
        int M = Integer.parseInt(input);
        for(int i=0;i<M;i++){
            input = br.readLine();
            st = new StringTokenizer(input);
            System.out.println(getRangeSum(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

    }

    public static int getRangeSum(int start, int end){
        return dp[end]-dp[start-1];
    }

}
