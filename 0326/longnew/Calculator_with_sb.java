import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Calculator {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static String[] data;
    static StringBuilder sb = new StringBuilder();
    static Stack<String> stack = new Stack<>();
    static Stack<Double> num = new Stack<>();

    public static int prior(String oper){
        if (oper.equals("+") || oper.equals("-"))
            return 1;
        if (oper.equals("*") || oper.equals("/") || oper.equals("%"))
            return 2;
        if (oper.equals("^"))
            return 3;
        return 0;
    }
    
    public static double cal(Double one, String oper, Double two){
        
        if (oper.equals("*"))
            return one * two;
        if (oper.equals("/"))
            return one / two;
        if (oper.equals("%"))
            return one % two;
        if (oper.equals("+"))
            return one + two;
        
        return one - two;
    }
    
    public static double cal2(String one){
        double dou_one = Double.parseDouble(one);
        
        return Math.round(dou_one * 100) / 100.0;
    }
    
    public static void sum(){
        data = sb.toString().split("");

        for (int i = 0; i < data.length; i++){
            String temp = data[i];
            
            if (temp.equals("*") || temp.equals("/") || temp.equals("%") || temp.equals("+") || temp.equals("-")){
                Double one = num.pop();
                Double two = num.pop();
                
                num.add(cal(two, temp, one));
                continue;
            }

            if (temp.equals("^")){
                String one = stack.pop();
                double ret = cal2(one);
                continue;
            }

            num.add(Double.parseDouble(temp));
        }
        System.out.println(num.pop());
    }

    public static void In2Post(){
        for (int i = 0; i < data.length; i++){
            String temp = data[i];

            if (temp.equals(" "))
                continue;

            if (temp.equals("(")){
                stack.add("(");
                continue;
            }

            if (temp.equals(")")){
                while (!stack.peek().equals("("))
                    sb.append(stack.pop());
                stack.pop();
                continue;
            }

            if (temp.equals("*") || temp.equals("/") || temp.equals("%") || temp.equals("+") || temp.equals("-") || temp.equals("^")){
                while (!stack.isEmpty() && prior(stack.peek()) >= prior(temp))
                    sb.append(stack.pop());
                stack.add(temp);
                continue;
            }

            sb.append(temp);
        }

        while (!stack.isEmpty())
            sb.append(stack.pop());

        String a = sb.toString();
        System.out.println(a);

        sum();
    }

    public static void main(String[] args) throws IOException {
        data = br.readLine().split("");
        In2Post();
    }
}
