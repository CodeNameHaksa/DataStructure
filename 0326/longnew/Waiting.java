import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Waiting {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static class Person implements Comparable<Person>{
        int l, k;

        Person(int l, int k){
            this.l = l;
            this.k = k;
        }

        @Override
        public int compareTo(Person o) {
            return this.l - o.l;
        }
    }

    public static void open(int n, int m) throws IOException {
        // 직원들이 언제 일을 다하는 지 확인을 위해 우선순위 큐 사용.
        PriorityQueue<Integer> employee = new PriorityQueue<>();
        for (int i = 0; i < n; i++)
            employee.add(0);

        // 손님이 도착하는 시간이 빠른 순서로 먼저 미용을 받음
        PriorityQueue<Person> data = new PriorityQueue<>();
        for (int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            data.add(new Person(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        double ans = 0;

        while (!data.isEmpty()){
            Person temp_cus = data.poll();
            // 일이 가장 빨리 끝나는 직원을 찾음.
            int temp_employee = employee.poll();

            if (temp_employee > temp_cus.l){
                // 대기가 필요한 상황.
                ans += temp_employee - temp_cus.l;
                employee.add(temp_employee + temp_cus.k);
            } else {
                // 대기가 필요없을 때의 경우에는 손님의 미용이 끝나는 시간까지
                // 직원은 일을 해야 한다.
                employee.add(temp_cus.l + temp_cus.k);
            }
        }

        ans = ans / m;
        System.out.println(Math.round(ans * 100)/ 100.0);
    }
    
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        open(n, m);

    }
}
