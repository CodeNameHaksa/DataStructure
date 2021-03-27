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

