import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Introduce {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int ans = 0;

        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            while (st.hasMoreTokens())
                ans += st.nextToken().length();
        }
        System.out.println(ans);
    }
}
