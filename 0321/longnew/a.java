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
        String s = "";
        
        while ((s = br.readLine()) != null) {
            
            for (int i = 0; i < s.length(); i++){
                char d = s.charAt(i);

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
                        
                    } else if (d == '}' && data.peek() != '{'){
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
        System.out.println("No Error");
    }
}
