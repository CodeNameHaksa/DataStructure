import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Stack;
import java.io.InputStreamReader;

public class IntoPost {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++){
            String input = br.readLine();
            String output = convertPostfix(input);
            System.out.println(output);
        }
    }

    public static String  convertPostfix(String s){

        String[] input = s.split(" ");
        int len = input.length;

        Stack<String> temp = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < len; i++){
            String ch = input[i];

            int p = priority(ch);
            if (ch.equals("+") || ch.equals("-") || ch.equals("*") || ch.equals("/")){

                while (!temp.isEmpty() && priority(temp.peek()) >= p)
                    sb.append(temp.pop() + " ");

                temp.push(ch);
            } else if (ch.equals("(")){
                temp.push(ch);
            } else if (ch.equals(")")){
                // equals.....
                while (!temp.isEmpty() && !temp.peek().equals("("))
                    sb.append(temp.pop() + " ");
                // 괄호는 결과로 출력 되지 않는다.
                temp.pop();
            } else {
                sb.append(ch + " ");
            }
        }

        while (!temp.isEmpty())
            sb.append(temp.pop() + " ");

        String ret = sb.toString();
        return ret;
    }

    public static int priority(String ch){
        if(ch.equals("*") || ch.equals("/"))
            return 2;

        else if (ch.equals("+") || ch.equals("-"))
            return 1;

        else if (ch.equals("("))
            return 0;

        return - 1;
    }
}
