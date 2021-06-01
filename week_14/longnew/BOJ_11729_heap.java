import java.io.*;
import java.util.*;

public class BOJ_11729_heap {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int abs1 = Math.abs(o1);
                int abs2 = Math.abs(o2);

                if (abs1 == abs2){
                    return o1 - o2;
                }
                return abs1 - abs2;
            }
        });

        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(br.readLine());

            if (temp == 0){
                if (q.size() > 0)
                    System.out.println(q.poll());
                else
                    System.out.println(0);

                continue;
            }
            q.add(temp);
        }
    }
}
