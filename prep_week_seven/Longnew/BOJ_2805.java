import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[] input_temp = br.readLine().split(" ");

        long limit = 0;
        long[] data = new long[n];
        for (int i = 0; i < n; i++) {
            data[i] = Long.parseLong(input_temp[i]);
            if (limit < data[i])
                limit = data[i];
        }

        long left = 1, right = limit;
        while (left <= right){
            long mid = (left + right) / 2;
            long total = 0;

            for (int i = 0; i < n; i++) {
                if (data[i] > mid)
                    total += data[i] - mid;
            }

            if (total >= m)
                left = mid + 1;
            else
                right = mid - 1;
        }

        System.out.println(right);
    }
}
