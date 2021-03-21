import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class a {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Stack<Character> data = new Stack<>();
        int flag = 0, cnt = 0;
        String s = "";
        while ((s = br.readLine()) != null) {
            for (int i = 0; i < s.length(); i++) {
                char d = s.charAt(i);

                if (d == '\"'){
                    if (flag == 0)
                        flag = 1;
                    else
                        flag = 0;
                    continue;
                }

                if (d == '\''){
                    if (cnt == 0)
                        cnt = 1;
                    else
                        cnt = 0;
                    continue;
                }

                if (flag == 1 || cnt == 1)
                    continue;
                
                if (d == '(' || d == '{' || d == '[')
                    data.push(d);
                else if (d == ')' || d == '}' || d == ']') {

                    if (data.size() == 0){
                        System.out.println("Compile Error");
                        System.exit(0);
                    }

                    if (d == ')' && data.peek() != '(') {
                        System.out.println("Compile Error");
                        System.exit(0);
                    } else if (d == '}' && data.peek() != '{') {
                        System.out.println("Compile Error");
                        System.exit(0);
                    } else if (d == ']' && data.peek() != '[') {
                        System.out.println("Compile Error");
                        System.exit(0);
                    } else
                        data.pop();
                }
            }
        }
        if (data.size() != 0)
            System.out.println("Compile Error");
        else
            System.out.println("No Error");
    }
}
