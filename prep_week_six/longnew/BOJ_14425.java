import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_14425 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static HashSet<String> data = new HashSet<>();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++)
            data.add(br.readLine());

        int ans = 0;
        for (int i = 0; i < m; i++)
            if (data.contains(br.readLine()))
                ans++;
        System.out.println(ans);
    }
}
