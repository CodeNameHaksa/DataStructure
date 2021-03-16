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
        int start = 0, end = 0, temp = 0;
        int[] data = new int[n];
        st = new StringTokenizer(br.readLine(), " ");

        int idx = 0;
        while (st.hasMoreTokens()){
            data[idx] = Integer.parseInt(st.nextToken());
            idx += 1;
        }

        while (start < n){
            if (end == n){
                if(temp == m) {
                    temp -= data[start];
                    start += 1;
                    ans += 1;
                } else {
                    temp -= data[start];
                    start += 1;
                }
            }
            else {
                if (temp > m) {
                    temp -= data[start];
                    start += 1;
                } else if (temp == m) {
                    temp -= data[start];
                    start += 1;
                    ans += 1;
                } else {
                    temp += data[end];
                    end += 1;
                }
            }
        }

        System.out.println(ans);
    }
}
