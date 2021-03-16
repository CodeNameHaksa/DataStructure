import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        String temp = br.readLine();
        char[] data = temp.toCharArray();

        int[] alpha = new int[26];
        int ans = 0, len = 1, start = 0, end = 1, cnt = 1;
        alpha[(int)(data[0]) - 97] += 1;

        while (end < temp.length()){
            int idx = (int)data[end] - 97;

            if (alpha[idx] == 0)
                cnt += 1;

            alpha[idx] += 1;
            len += 1;

            if (cnt <= n)
                ans = Math.max(ans, len);
            else {
                while (start < end && cnt > n){
                    idx = (int)data[start] - 97;
                    alpha[idx] -= 1;
                    start += 1;
                    len -= 1;
                    if (alpha[idx] == 0){
                        cnt -= 1;
                    }
                }
            }
            end++;
        }

        System.out.println(ans);

    }
}
