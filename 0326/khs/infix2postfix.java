import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class infix2postfix {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int counter = Integer.parseInt(br.readLine());

        while(counter-->0){
            String input = br.readLine();
            String output = convertPostfix(input);
            System.out.println(output);
        } 
    }
    
    public static String convertPostfix(String s){
        String[] input = s.split(" ");
        int len = input.length;
        Stack<String> stack = new Stack<String>();
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<len;i++){
            String ch = input[i].trim();
            int p = priority(ch);
            if(ch.equals("+") || ch.equals("-") || ch.equals("*") || ch.equals("/")){
                while(!stack.isEmpty() && priority(stack.peek()) >= p){
                    sb.append(stack.pop()+" ");
                }
                stack.push(ch);
            }
            else if(ch.equals("(")){
                stack.push(ch);
            }
            else if(ch.equals(")")){
                while(!stack.isEmpty() && !stack.peek().equals("(")){
                    sb.append(stack.pop()+" ");
                }
                stack.pop();
            }
            else{
                sb.append(ch+" ");
            }
        }

        while(!stack.isEmpty()){
            sb.append(stack.pop() + " ");
        }
        
        String result = sb.toString();
        return result;
    }
    public static int priority(String ch){

        if(ch.equals("*")||ch.equals("/")){
            return 2;
        }else if(ch.equals("+")||ch.equals("-")){
            return 1;
        }else if(ch.equals("(")||ch.equals(")")){
            return 0;
        }else{
            return -1;
        }
    }
    
}
