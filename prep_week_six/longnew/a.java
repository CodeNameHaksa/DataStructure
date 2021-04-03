import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class a {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static HashMap<String, HashSet<String>> data;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        data = new HashMap<>(n);

        for (int i = 0; i < n; i++)
            data.put(String.valueOf(i), new HashSet<String>());

        for (int i = 0; i < m; i++){
            String[] temp = br.readLine().split(" ");
            HashSet<String> tempSet = data.get(temp[0]);
            tempSet.add(temp[1]);
            data.put(temp[0], tempSet);
        }

        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++){
            String[] temp = br.readLine().split(" ");
            // get을 통해서 가지고 온것을 그냥 a 에다가 넣어서 사용하게 되면
            // 주소가 남아 있어 data 안의 set값 자체를 바꿔버린다.
            // 새로운 변수 하나를 만들어 놓고 돌려야 한다.
            HashSet<String> a = new HashSet<>(data.get(temp[1]));

            // https://edu.goorm.io/learn/lecture/41/%EB%B0%94%EB%A1%9C%EC%8B%A4%EC%8A%B5-%EC%83%9D%ED%99%9C%EC%BD%94%EB%94%A9-%EC%9E%90%EB%B0%94-java/lesson/792/set
            if (temp[0].equals("U")){
                a.addAll(data.get(temp[2]));
                a.addAll(data.get(temp[3]));
                System.out.println(a.size());

            } else if (temp[0].equals("I")){
                a.retainAll(data.get(temp[2]));
                a.retainAll(data.get(temp[3]));
                System.out.println(a.size());

            } else {
                a.removeAll(data.get(temp[2]));
                a.removeAll(data.get(temp[3]));
                System.out.println(a.size());
            }
        }
    }
}
