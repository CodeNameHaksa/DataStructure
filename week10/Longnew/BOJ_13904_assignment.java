import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

class Problem implements Comparable<Problem>{
    int day, score;

    public Problem(int day, int score){
        this.day = day;
        this.score = score;
    }

    @Override
    public int compareTo(Problem o){
        return o.score - this.score;
    }
}

public class BOJ_13904_assignment {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] data = new int[1000];
    static ArrayList<Problem> problem = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++){
            String[] temp = br.readLine().split(" ");
            problem.add(new Problem(Integer.parseInt(temp[0]), Integer.parseInt(temp[1])));
        }

        Collections.sort(problem);
        for (Problem item : problem){

            int cnt = item.day - 1;
            while (cnt >= 0 && data[cnt] != 0) {
                cnt--;
            }

            if (cnt < 0)
                continue;

            data[cnt] = item.score;
        }

        int sum = 0;
        for (Integer item : data)
            sum += item;

        System.out.println(sum);
    }
}
