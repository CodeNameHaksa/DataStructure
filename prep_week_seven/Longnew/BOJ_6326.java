import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_6236 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] data = new int[n];
        for (int i = 0; i < n; i++){
            data[i] = Integer.parseInt(br.readLine());
        }

        long left = 1, right = 100000 * 10000;
        while (left <= right){
            long mid = (left + right) / 2;

            int cnt = 1;
            // 출금을 하고 다시 입금을 한다고 생각하지 않고.
            // 출금을 학 때 남겨 놓는다고 생각을 하자.
            // 그렇기에 32번과 같은 라인이 생긴다.
            long can_use = mid;
            // 출금이 가능 한지 확인 하는 용도.
            boolean flag = false;

            for (int i = 0; i < n; i++){
                // 하루에 사용할 돈 보다 인출 한 돈이 적다는
                // 것은 말이 안된다.
                // 이에 대한 예외 처리 필요.
                if (mid < data[i]){
                    flag = true;
                    break;
                }

                if (can_use < data[i]){
                    // 여기에 들어오는 경우가 이미 mid원 인출 한 것을 다 쓰고 더 인출을 해야 하루를 지낼 수 있는 거다.
                    // 그래서 can_use를 다시 초기화 하며
                    // 인출을 했으니까 cnt를 늘려준다.
                    can_use = mid;
                    cnt++;
                }
                can_use -= data[i];
            }

            if (flag){
                left = mid + 1;
                continue;
            }
            if (cnt <= m)
                right = mid - 1;
            else
                left = mid + 1;
        }
        System.out.println(left);
    }
}
