import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class c {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static HashSet<String> intersection = new HashSet<>();
    static HashSet<String> temp;

    public static void main(String[] args) throws IOException {
        int m = Integer.parseInt(br.readLine());
        List<HashMap<String, Integer>> data = new ArrayList<>(m);
        int cnt = 0;

        for (int i = 0; i < m * 2 - 1; i++){
            String input = br.readLine();
            if (input.equals(""))
                continue;

            String[] word = input.split(" ");
            data.add(new HashMap<>());
            temp = new HashSet<>();

            for (int j = 0; j < word.length; j++){
                String temp_word = word[j];
                String temp_stack = "";

                for (int k = 0; k < temp_word.length(); k++){
                    Character now = temp_word.charAt(k);

                    if ('a' <= now && now <= 'z')
                        temp_stack += now;
                    else if('A' <= now && now <= 'Z')
                        temp_stack += (char)(now + 32);
                }

                if (data.get(cnt).containsKey(temp_stack)){
                    int value = data.get(cnt).get(temp_stack);
                    data.get(cnt).put(temp_stack, value + 1);
                }else {
                    data.get(cnt).put(temp_stack, 1);
                    }

                temp.add(temp_stack);
                }

            if (intersection.size() > 0)
                intersection.retainAll(temp);
            else
                intersection = temp;

            cnt++;
        }

        for (int i = 0; i < m; i++){
            int total = 0;
            int max_val = 0;
            String max_str = "";

            for (String temp : data.get(i).keySet()) {
                int temp_val = data.get(i).get(temp);

                if (!intersection.contains(temp)){
                    total += temp_val;
                    if (max_val < temp_val){
                        max_str = temp;
                        max_val = temp_val;
                    }
                }
            }
            System.out.println(max_str + " " + Math.round((double)max_val / total * 100) / 100.0);
        }
    }
}
