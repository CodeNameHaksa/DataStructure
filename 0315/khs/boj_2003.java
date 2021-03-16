import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2003 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N+1];
        int[] sum = new int[N+1];
        input = br.readLine();
        st = new StringTokenizer(input);


        for(int i=1;i<N+1;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        sum[0] = 0;
        for(int i=1;i<N+1;i++){
            sum[i]=sum[i-1]+arr[i];
        }

        int ans = 0;
        int tmp = 0;


        for(int i=1;i<N+1;i++){
            for(int j=0;j<i;j++){
                tmp = sum[i]-sum[j];
                if(tmp == M){
                    ans++;
                }
            }
        }

        System.out.println(ans);

    }
}
