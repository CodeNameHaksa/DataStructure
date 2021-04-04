import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class BOJ_4358 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static HashMap<String, Integer> data = new HashMap<>();

    public static void main(String[] args) throws IOException {
        String s = "";
        int total = 0;

        while ((s = br.readLine()) != null){

            if (data.containsKey(s)){
                int cnt = data.get(s);
                data.put(s, cnt + 1);
            }else
                data.put(s, 1);

            total++;
        }

        Object[] keys = data.keySet().toArray();
        Arrays.sort(keys);

        for (Object item : keys){
            int temp = data.get(item);
            double ans = (double)temp / total * 100;
            System.out.println((String) item + " " + String.format("%.4f", ans));
        }
    }
}
