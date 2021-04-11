import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class b {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        String[] input_temp = br.readLine().split(" ");

        long limit = 0;
        int[] data = new int[input_temp.length];
        for (int i = 0; i < input_temp.length; i++) {
            data[i] = Integer.parseInt(input_temp[i]);

            if (limit < data[i])
                limit = data[i];
        }

        long left = 1, right = limit * n;
        while (left <= right){
            long mid = (left + right) / 2;
            long total = 0;

            for (int i = 0; i < data.length; i++) {
                total += mid / data[i];
                // 쉬는 시간이 존재하기 때문에 10번째에 심사를 통과한 사람들은
                // 없다. 그래서 몫을 빼서 값을 줄여주자.
                total -= (mid / data[i]) / 10;
            }
            if (total >= n)
                right = mid - 1;
            else
                left = mid + 1;
        }

        System.out.println(left);
    }
}
