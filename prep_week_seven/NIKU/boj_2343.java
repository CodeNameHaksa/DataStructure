import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj_2343 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sarr = br.readLine().split(" ");
        int N = Integer.parseInt(sarr[0]);
        int M = Integer.parseInt(sarr[1]);
        sarr = br.readLine().split(" ");
        long [] data = new long[sarr.length];
        long right = 0;
        long left = 0;
        for(int i = 0; i < data.length; i++){
            data[i] = Long.parseLong(sarr[i]);
            right += data[i];
            if(data[i] > left){
                left = data[i];
            }
        }


        long mid = 0;
        int cnt = 0;

        while(left <= right){
            mid = (left+right)/2;
            int sum = 0;
            cnt = 0;

            for(int i = 0; i < N; i ++){
                if(sum + data[i] > mid){
                    sum = 0;
                    cnt++;
                }
                sum += data[i];
            }

            if(sum!=0){
                cnt++;
            }

            if(cnt > M){ // 디스크 갯수가 M보다 많다는건 용량이 작다는 소리
                left = mid+1;
            }else{ // 디스크 갯수가 M이랑 같더라도, 가장 용량이 작은 블루레이를 찾아야 하므로 계속 이동.
                right = mid-1;
            }

//            if(cnt <= M){
//                right = mid - 1;
//            }else{
//                left = mid+1;
//            }

        }

        System.out.println(left);



    }
}
