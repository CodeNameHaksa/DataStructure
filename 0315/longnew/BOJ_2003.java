import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int ans = 0;
        int[] data = new int[n];
        st = new StringTokenizer(br.readLine(), " ");

        int idx = 0;
        while (st.hasMoreTokens()){
            data[idx] = Integer.parseInt(st.nextToken());
            idx += 1;
        }
        int temp = data[0], start = 0, end = 1;
        while (start <= end){
            if (end == n && temp < m)
                break;
            
            
            if (temp == m){
                ans++;
                temp -= data[start];
                start++;
            }else if(temp < m){
                temp += data[end];
                end++;
            }else {
                temp -= data[start];
                start++;
            }
        }

        System.out.println(ans);
    }
}
