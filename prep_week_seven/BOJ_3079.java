import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class BOJ_3079 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        // 입력을 받는 시간을 보면 10^9이다. 개 큼..
        long limit = 0;

        int[] data = new int[n];

        for (int i = 0; i < n; i++) {
            data[i] = Integer.parseInt(br.readLine());

            if (limit < data[i])
                limit = data[i];
        }

        // 이분 탐색을 하는데 여기에서 기준이 되는 것이 무엇이냐?
        // 각 시간을 가지고 있을 때, 각각의 심사대에서 몇명을 심사할 수 있느냐
        // 이를 찾는 것이다. 그렇다면 이 것의 최악의 경우는 맨 처음
        // 심사관들의 시간을 입력 받을 떄 가장 큰 놈을 찾아서.
        // 이 심사관이 m명 모두를 심사하는 경우를 뜻한다.

        // 가질 수 있는 최소의 시간은 1분이니까 left를 1로 놓자.
        long left = 1, right = limit * m;
        while (left <= right){
            long mid = (left + right) / 2;
            long cnt = 0;

            // 심사를 한 모든 인원을 cnt변수에 저장.
            for (int i = 0; i < n; i++)
                cnt += mid / data[i];

            // cnt >= m의 경우에는 심사를 통과한 경우이다. 그렇다면 인제 찾아야 할 것은?
            // 시간을 더 줄여도 가능한지를 찾아야 한다.
            // 그렇기에 right의 값을 mid - 1로 만들어 준다.

            // 그러면 정답은 어떻게 찾냐???

            // 마지막까지 가서 while 문을 빠져나가려면 left가 mid + 1을 하면서 나가게 된다.
            // 그러면 왜 얘가 정답이 될수 있는가 ..

            // right의 값이 변하는 것을 보면 mid - 1을 하면서 줄어드는 것을 볼 수 있다.
            // 이걸 생각해 볼때 left == right가 될 수 있는 이유가 mid - 1을 하면서 같아진 거다.
            // 결국 예전에 찾았던 mid값을 left가 다시 가지기 때문에 정답이 된다고 볼 수 있다.
            if (cnt >= m)
                right = mid - 1;
            else
                left = mid + 1;
        }
        System.out.println(left);
    }
}
