import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class c {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        long t = Long.parseLong(br.readLine());
        String[] input_temp = br.readLine().split(" ");

        // 다른 이분 탐색과 동일 하게 가는데 여기에서 가장 최악의 경우는 무엇일까?
        // 모든 목재에 대해 높이를 지정한 절단기를 이용해서 우리는 목재를 자를 것이다.
        // 그렇다면 이 절단기의 높이가 어디까지 올라갈 수 있는 지를 알아야 한다.
        // 그렇기에, 입력 받은 나무의 높이들 중 가장 높은 것을 찾는다.
        long limit = 0;
        long[] data = new long[input_temp.length];
        for (int i = 0; i < input_temp.length; i++) {
            data[i] = Long.parseLong(input_temp[i]);

            if (limit < data[i])
                limit = data[i];
        }

        // 나무의 높이 중 가장 낮은 것은 1이니까 left는 1에서 시작하자.
        long left = 1, right = limit;

        while (left <= right){
            // 중간 부분을 찾아서 절단기의 높이로 지정하자.
            long height = (left + right) / 2;
            long total = 0;

            for (int i = 0; i < data.length; i++)
                // 절단기의 높이 보다 작은 나무의 경우 베어버릴 수가 없다.
                // 베어버리면 음수의 값을 집어 넣는데 이건 에러를 유발함.
                if (data[i] > height)
                    total += data[i] - height;

            // 계산한 total의 값이 target 값보다 같거나 크면, 일단 조건을 충족한 것이다.
            // 우린 t 이상의 목재를 얻는 것이 목표인데 그 중 가장 최소를 찾는 것이다.
            // 그러니까 절단기의 높이를 높여 더 적은 나무를 베어내게 하고 싶은 것.
            // 그래서 left를 올려줌으로써 절단기의 높이를 올린다.
            if (total >= t)
                left = height + 1;
            else
                right = height - 1;
        }

        System.out.println(right);
        limit = 0;
        // 1번째 절단을 통해 나무가 줄어들어야 하니까 값을 업데이트 해주자.
        // 이때에도 절단기 보다 낮은 놈들을 주의 해줘야 한다.
        for (int i = 0; i < data.length; i++) {
            if (data[i] > right)
                data[i] = data[i] - (data[i] - right);

            if (limit < data[i])
                limit = data[i];
        }

        left = 1;
        right = limit;

        while (left <= right){
            long height = (left + right) / 2;
            long total = 0;

            for (int i = 0; i < data.length; i++)
                if (data[i] > height)
                    total += data[i] - height;

            if (total >= t)
                left = height + 1;
            else
                right = height - 1;
        }
        System.out.println(right);
    }
}
