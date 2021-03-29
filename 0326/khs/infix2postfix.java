import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class infix2posfix {

    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());

        while(cnt-->0){
            String tmp = convert(br.readLine());
            System.out.println(tmp);
            System.out.println(calculate(tmp));
        }

    }

    public static String convert(String str){
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        String[] strA = str.split(" ");
        int len = strA.length;
        String ch = "";
        for(int i=0;i<len;i++){
            ch = strA[i];
            int p = priority(ch);
            if(ch.equals("+")||ch.equals("-")||ch.equals("/")||ch.equals("*")||ch.equals("^")||ch.equals("%")){
                while(!stack.isEmpty()&&priority(stack.peek())>=p){
                    sb.append(stack.pop()+" ");
                }
                stack.push(ch);
            }else if(ch.equals("(")){
                stack.push("(");
            }else if(ch.equals(")")){
                while(!stack.isEmpty()&&!stack.peek().equals("(")){
                    sb.append(stack.pop()+" ");
                }
                stack.pop();
            }else{
                sb.append(ch+" ");
            }
        }

        while(!stack.isEmpty()){
            sb.append(stack.pop()+" ");
        }

        String ans = sb.toString();

        return ans;
    }

    public static double calculate(String str){
        String[] sarr = str.split(" ");
        Stack<Double> iStack = new Stack<>();
        Queue<String> q = new LinkedList<>();

        for(int i=0;i<sarr.length;i++){
            q.add(sarr[i]);
        }

        while(!q.isEmpty()){
            String tmp = q.poll();

            if((tmp.equals("/")||tmp.equals("+")||tmp.equals("-")||tmp.equals("*"))){
                double y = iStack.pop();
                double x = iStack.pop();
                iStack.push(operator(x,y,tmp));

            }else if(tmp.equals("^")){
                double x = iStack.pop();
                iStack.push((double) Math.round(x));
            }else{
                iStack.push(Double.parseDouble(tmp));
            }
        }

        return iStack.pop();
    }
    public static double operator(double x, double y, String oper){
        if(oper.equals("/")){
            return Math.round((x/y)*100)/100.0;
        } else if (oper.equals("-")) {
            return x - y;
        } else if (oper.equals("+")) {
            return x + y;
        } else if (oper.equals("*")) {
            return Math.round((x * y) * 100) / 100.0;
        } else {
            return x % y;
        }
    }


    public static int priority(String ch){

        if(ch.equals("^")){
            return 3;
        }else if(ch.equals("*")||ch.equals("/")||ch.equals("%")){
            return 2;
        }else if(ch.equals("+")||ch.equals("-")){
            return 1;
        }else if(ch.equals("(")||ch.equals(")")){
            return 0;
        }else
            return -1;

    }
}
