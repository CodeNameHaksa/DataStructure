import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class printer {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int[] data = new int[n + 1];

        for (int i = 0; i < r; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int temp = Integer.parseInt(st.nextToken());

            data[start - 1] += temp;
            data[end] -= temp;
        }

        long ans = 0;
        long temp = 0;
        for (int item : data){
            temp += item;
            if (ans < temp)
                ans = temp;
        }

        System.out.println(ans);
    }
}
