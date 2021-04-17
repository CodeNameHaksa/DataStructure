import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.io.IOException;

public class Hex {
    public static String check(int input){
        if (input == 10)
            return "A";
        if (input == 11)
            return "B";
        if (input == 12)
            return "C";
        if (input == 13)
            return "D";
        if (input == 14)
            return "E";
        if (input == 15)
            return "F";
        return Integer.toString(input);
    }

    public static void convert(int m){

        Stack<String> temp = new Stack<>();

        while (m > 0) {
            temp.add(check(m % 16));
            m /= 16;
        }

        String ans = "";
        while (!temp.isEmpty())
            ans += temp.pop();

        System.out.print(ans + " ");
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++)
            convert(i);
    }
}


/*
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static String check(int input){
        if (input == 10)
            return "A";
        else if (input == 11)
            return "B";
        else if (input == 12)
            return "C";
        else if (input == 13)
            return "D";
        else if (input == 14)
            return "E";
        else if (input == 15)
            return "F";

        return String.valueOf(input);

    }

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < n; i++){
            StringBuilder a = new StringBuilder();
            int temp = i;

            while(temp > 0){
            // 16 진수이니까 여기가 중요.
                a.append(check(temp % 16));
                temp = temp / 16;
            }

            sb.append(a.reverse() + " ");
        }
        System.out.println(sb.toString());
    }
}
*/
