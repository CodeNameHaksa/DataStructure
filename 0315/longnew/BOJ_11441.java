import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11441 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] data = new int[n + 1];

        st = new StringTokenizer(br.readLine(), " ");
        int idx = 1;
        while (st.hasMoreTokens()){
            int num = Integer.parseInt(st.nextToken());
            data[idx] = data[idx - 1] + num;
            idx += 1;
        }
        int r = Integer.parseInt(br.readLine());
        for (int i = 0; i < r; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int end = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());

            System.out.println(data[start] - data[end - 1]);
        }
    }
}
