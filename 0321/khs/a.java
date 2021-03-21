import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class a {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        Stack<Character> sStack = new Stack<>();
        char[] leftChar = {'{', '[', '('};
        char[] rightChar = {'}', ']', ')'};
        boolean flag = false;
        boolean flag2 = false;
        boolean ignore = false;
        while ((input = br.readLine()) != null) {
//        for(int j=0;j<1;j++){
//
//            input = br.readLine();
            for (int i = 0; i < input.length(); i++) {
                char tmp = input.charAt(i); // 새로 체크하는 문자

                if ((tmp == '\"' || tmp == '\'')&& !ignore)
                    ignore = true;
                else if ((tmp == '\"' || tmp == '\'') && ignore)
                    ignore = false;

                if(ignore){
                    continue;
                }



//
//
//                if(tmp=='\"' && !flag2){
//                    flag = !flag;
//                }if(tmp =='\'' && !flag){
//                    flag2 = !flag2;
//                }
//                if(flag||flag2){
//                    continue;
//                }


                if (inArr(leftChar, tmp) != -1 || inArr(rightChar, tmp) != -1) {
                    if (sStack.size() != 0) {
                        char peekTmp = sStack.peek();
                        if (inArr(leftChar, peekTmp) != -1) { //스택 맨 위가 여는 괄호라면?
                            int checkIndex = inArr(leftChar, peekTmp);
                            if (inArr(rightChar, tmp) == checkIndex) { //들어오는 문자가 닫는 괄호다?
                                sStack.pop();
                            }else{
                                sStack.push(tmp);
                            }
                        }

                    } else { //스택이 아예 비어있다면?
                        if (inArr(leftChar, tmp) != -1) { //스택이 아예 비어있고, 여는 괄호라면? push 한
                            sStack.push(tmp);
                        } else { //여는 괄호가 아니면 에러 출력
                            System.out.println("Compile Error");
                            System.exit(0);
                        }
                    }

                }
            }
        }


        if (sStack.size() == 0) {
            System.out.println("No Error");
        } else {
            System.out.println("Compile Error");
        }


    }


    public static int inArr(char[] arr, char tmp) {
        for (int i = 0; i < arr.length; i++) {
            if (tmp == arr[i]) {
                return i;
            }
        }
        return -1;
    }

    public static void printArr(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "");
        }
    }
}
