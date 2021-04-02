import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class App {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static HashMap<String, Integer> data = new HashMap<>();

    public static void main(String[] args) throws IOException {
        String s = "";
        int all = 0;
        int max_val = 0;
        String ans = "";

        while ((s = br.readLine()) != null){
            st = new StringTokenizer(s);

            while (st.hasMoreTokens()){
                String temp_word = st.nextToken();
                String temp_stack = "";

                for (int i = 0; i < temp_word.length(); i++){
                    Character now = temp_word.charAt(i);

                    if ('a' <= now && now <= 'z'){
                        temp_stack += now;
                    } else if('A' <= now && now <= 'Z'){
                        temp_stack += (char)(now + 32);
                    }
                }

                if (data.containsKey(temp_stack)){
                    int value = data.get(temp_stack);
                    data.put(temp_stack, value + 1);

                    if (max_val < value + 1){
                        max_val = value + 1;
                        ans = temp_stack;
                    }
                }else {
                    data.put(temp_stack, 1);
                    if (max_val < 1){
                        max_val = 1;
                        ans = temp_stack;
                    }
                }
                all++;
            }
        }
        double ret = (double)max_val / all;
        System.out.println(ans + " " + String.valueOf(Math.round(ret * 10) / 10.0));
    }
}
