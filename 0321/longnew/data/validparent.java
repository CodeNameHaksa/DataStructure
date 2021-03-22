import java.io.BufferedReader;
import java.io.IOException;
import java.util.Stack;
import java.io.InputStreamReader;

public class bracket {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++){
            Stack<Character> data = new Stack<>();
            boolean flag = true;
            String input = br.readLine();

            for(int j = 0; j < input.length(); j++){
                char temp = input.charAt(j);

                if (temp == '(')
                    data.push('(');
                else{
                    // 시작부터 닫는 괄호인 경우도 처리가 필요
                    if (data.isEmpty()){
                        flag = !flag;
                        break;
                    } else {
                        data.pop();
                    }
                }
            }

            // 계속 여는 괄호만 들어오는 경우를 처리해 줘야 함.
            // 길이가 0인 문자열이 들어올 지는 모르겠지만 혹시나 싶으니 처리해 놓도록 하자.
            if (!flag || !data.isEmpty() || input.length() == 0)
                System.out.println("NO");
            else
                System.out.println("YES");
        }
        
    }
}
