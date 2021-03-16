import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2003_a {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        input = br.readLine();
        st = new StringTokenizer(input);
        int[] list = new int[N];
        for(int i=0;i<N;i++){
            list[i] = Integer.parseInt(st.nextToken());
        }
        int start = 0;
        int end = 1;
        int tmp = list[0];
        int ans = 0;

        while(start < N){
            if(end == N){
                if(tmp == M){
                    tmp -= list[start];
                    start++;
                    ans++;
                }else{
                    tmp -=list[start];
                    start++;
                }
            }
            else{
                if(tmp>M){
                    tmp-=list[start];
                    start++;
                }else if(tmp==M){
                    tmp-=list[start];
                    start++;
                    ans+=1;
                }else{
                    tmp+=list[end];
                    end++;
                }
            }

        }

        System.out.println(ans);
    }
}
