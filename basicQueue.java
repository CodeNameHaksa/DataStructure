import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class basicQueue {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args)throws IOException {
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        String[] strArr = null;
        for(int i = 0;i < N;i++){
            strArr = br.readLine().split(" ");
            if(strArr[0].equals("1")){
                q.add(Integer.parseInt(strArr[1]));
            }else if(strArr[0].equals("2")){
                q.poll();
            }else if(strArr[0].equals("3")){
                System.out.println(q.peek());
            }
        }

    }
}
