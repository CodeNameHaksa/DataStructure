import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Objects;
import java.io.InputStreamReader;

public class Baseball {

    public static void main(String[] args) throws IOException{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            int[] trial = new int[n];
            int[] strikes = new int[n];
            int[] balls = new int[n];

            for (int i = 0; i < n; i++){
                String[] temp = br.readLine().split(" ");
                trial[i] = Integer.parseInt(temp[0]);
                strikes[i] = Integer.parseInt(temp[1]);
                balls[i] = Integer.parseInt(temp[2]);
            }

            br.close();

            // 문제의 조건에 서로 다른 3개의 숫자라는 명시가 존재.
            HashSet<Integer> ans = new HashSet<>();

            for (int i = 123; i < 987; i++){
                int[] digit = new int[3];

                // 반대로 쓰시는 듯 2 == 뒤에서 2쨰자리
                // 1 == 뒤에서 첫 째 자리
                // 0 == 뒤에서 0 째 자리

                digit[2] = i / 100;
                digit[1] = (i % 100) / 10;
                digit[0] = i % 10;

                if (digit[0] == 0 || digit[1] == digit[0] || digit[2] == digit[0] || digit[1] == digit[2])
                    continue;

                boolean isCandidate = true;
                for (int j = 0; j < n; j++){
                    isCandidate &= compareDigit(digit, trial[j], strikes[j], balls[j]);
                }

                if (isCandidate)
                    ans.add(i);

            }

            for (Integer item : ans) {
                System.out.println(item);
            }

            System.out.println(ans.size());
    }

    private static boolean compareDigit(int[] candidate, int trial, int tr_strikes, int tr_balls){
        int[] trial_digit = new int[3];

        trial_digit[2] = trial / 100;
        trial_digit[1] = (trial % 100) / 10;
        trial_digit[0] = trial % 10;

        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 3; i++)
            if (candidate[i] == trial_digit[i])
                strike++;
        
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (i != j && candidate[i] == trial_digit[j])
                    ball++;

        return tr_strikes == strike && tr_balls == ball;
    }
}
