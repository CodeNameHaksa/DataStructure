import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_15903_duplicate {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PriorityQueue<Long> data = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        String[] temp = br.readLine().split(" ");
        int m = Integer.parseInt(temp[1]);
        temp = br.readLine().split(" ");
        for (String item : temp)
            data.add(Long.parseLong(item));

        for (int i = 0; i < m; i++){
            long a = data.poll();
            long b = data.poll();

            data.add(a + b);
            data.add(a + b);
        }

        long ans = 0;
        for (Long n : data)
            ans += n;

        System.out.println(ans);
    }
}
