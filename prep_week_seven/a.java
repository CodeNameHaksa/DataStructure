import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class a {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        // ans의 경우 idx 몇 번째에서 뒤집을 건지 알기 위해 존재.
        // 근데 idx와 다르게 세아릴 때는 1부터 세니까 1에서 시작.
        int ans = 1;
        // 오름차순으로 이미 정렬되어 있는 경우를 예외 처리 하기 위함.
        boolean flag = false;

        int now = Integer.parseInt(st.nextToken());

        while (st.hasMoreTokens()){
            if (now > Integer.parseInt(st.nextToken())) {
                flag = true;
                break;
            }
            ans++;
        }

        if (flag)
            System.out.println(ans);
        else
            System.out.println(0);
    }
}
