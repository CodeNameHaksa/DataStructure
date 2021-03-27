import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Calculator {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static Queue<String> q = new LinkedList<>();
    static Stack<String> temp = new Stack<>();
    static String[] data;

    public static int priority(String now){
        if (now.equals("+") || now.equals("-"))
            return 1;
        if (now.equals("*") || now.equals("/") || now.equals("%"))
            return 2;
        if (now.equals("^"))
            return 3;
        // "("의 경우에는 0을 주자.
        return 0;
    }

    public static void in2Post(){
        // 문자열로 받아야 2자리 이상의 수를 기록 할 수 있다.
       for (int i = 0; i < data.length; i++){
           String now = data[i];
           if (now.equals(" "))
               continue;

           if (now.equals("*") || now.equals("/") || now.equals("%") || now.equals("+") || now.equals("-") || now.equals("^")) {
               int prior = priority(now);
               while (!temp.isEmpty() && priority(temp.peek()) >= prior) {
                   q.add(temp.pop());
               }
               temp.add(now);
               continue;
           }

           if (now.equals("(")){
               temp.add(now);
               continue;
           }

           if (now.equals(")")){
               while (!temp.peek().equals("(")){
                   q.add(temp.pop());
               }
               temp.pop();
               continue;
           }


           q.add(now);
       }

       while (!temp.isEmpty())
           q.add(temp.pop());

       int len = q.size();
       for (int i = 0; i < len; i++){
           String ret = q.poll();

           if (i == len - 1)
               System.out.print(ret + "\n");
           else
               System.out.print(ret + " ");

           q.add(ret);
       }

       // 나눗셈을 생각해서 double형을 이용. double의 경우 64비트 까지 충당가능.
       sum();
    }

    public static void sum(){
        // 값을 계산할 때는 후위 표기로 만드는 것과 반대(?)로 진행된다고 보면 됨
        // 연산자를 만날 경우 가장 위에 존재하는 2개의 숫자를 꺼내서 계산 후
        // 다시 스택에 넣자.
        Stack<String> ret = new Stack<>();

        while (!q.isEmpty()){
            String now = q.poll();

            if (now.equals("*") || now.equals("/") || now.equals("%") || now.equals("+") || now.equals("-")){
                // 연산자를 만난 경우를 구현.
                double temp_cal;
                String one = ret.pop();
                String two = ret.pop();
                // 순서에 대한 주의가 필요.
                temp_cal = calculate(two, now, one);
                ret.add(String.valueOf(temp_cal));
                continue;
            }
            if (now.equals("^")){
                double temp_cal;
                temp_cal = rounding(ret.pop());
                ret.add(String.valueOf(temp_cal));
                continue;
            }

            ret.add(now);
        }

        System.out.println(ret.pop());
    }

    public static double calculate(String one, String mid, String two){
        double dou_one = Double.parseDouble(one);
        double dou_two = Double.parseDouble(two);

        if (mid.equals("+"))
            return dou_one + dou_two;
        else if (mid.equals("-"))
            return dou_one - dou_two;
        else if (mid.equals("*"))
            return dou_one * dou_two;
        else if (mid.equals("/"))
            return dou_one / dou_two;
        else
            return dou_one % dou_two;
    }

    public static double rounding(String one){
        double dou_one = Double.parseDouble(one);
        return Math.round(dou_one);
    }

    public static void main(String[] args) throws IOException{
        data = br.readLine().split("");
        in2Post();
    }
}
