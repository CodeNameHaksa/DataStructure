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
        boolean flag = false, cnt = false;
        String s = "";
        while ((s = br.readLine()) != null) {
            for (int i = 0; i < s.length(); i++) {
                char d = s.charAt(i);

                if (d == '\"' && !cnt)
                    flag = !flag;
                if (d == '\'' && !flag)
                    cnt = !cnt;

                if (flag || cnt)
                    continue;

                if (d == '(' || d == '{' || d == '[')
                    data.push(d);
                else if (d == ')' || d == '}' || d == ']') {

                    if (data.isEmpty()){
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
        if (data.isEmpty())
            System.out.println("No Error");
        else
            System.out.println("Compile Error");
    }
}
