import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class rotate {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = 0;
        int cnt = 0;
        int cnt2 = 0;
        boolean flag = false;
        while(st.hasMoreTokens()){
            int tmp = Integer.parseInt(st.nextToken());
            if(!flag){
                if(max < tmp){
                    max = tmp;
                    cnt++;
                }
                if(max > tmp){
                    flag = !flag;
                    cnt2++;
                }
            }else{
                cnt2++;
            }

        }
        System.out.println(cnt+" "+cnt2);

        System.out.println(Math.min(cnt, cnt2));

    }
}
