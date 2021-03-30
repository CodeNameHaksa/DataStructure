import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj_17298 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String[] sArr = null;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        sArr = br.readLine().split(" ");
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(sArr[i]);
        }

        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
                arr[stack.pop()] = arr[i];
            }
            stack.push(i);
        }

        while(!stack.isEmpty()){
            arr[stack.pop()]=-1;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb.toString());

    }


}




















