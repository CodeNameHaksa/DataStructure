import java.io.*;
import java.util.*;

public class b {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static HashMap<String, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++){
            String[] temp = br.readLine().split(" ");
            String word = "";
            int val = 0;

            for (int j = temp[1].length() - 1; j >= 0; j--)
                word += temp[1].charAt(j);

            val += word.toUpperCase().hashCode();
            val += word.toLowerCase().hashCode();

            map.put(temp[0], val);
        }

        int k = Integer.parseInt(br.readLine());

        for (int i = 0; i < k; i++){
            String[] temp = br.readLine().split(" ");
            if (map.containsKey(temp[0])){
                if (map.get(temp[0]) == Integer.parseInt(temp[1])) {
                    System.out.println("true");
                    continue;
                }
            }
            System.out.println("false");
        }
    }
}
