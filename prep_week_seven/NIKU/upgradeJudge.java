import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.LoggingPermission;

public class upgradeJudge {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] sarr = null;
        sarr = br.readLine().split(" ");
        long[] judge = new long[sarr.length];
        long max = 0;
        long start = 0;
        for(int i = 0; i < sarr.length;i++){
            judge[i] = Long.parseLong(sarr[i]);
            if(max < judge[i]){
                max = judge[i] * N;
            }
        }

        while(start <= max){
            long mid = (max+start)/2;

            long tmp = howLong(judge, mid);

            if(tmp >= N){
                max = mid-1;
            }else{
                start = mid+1;
            }
        }

        System.out.println(start);

    }

    public static long howLong(long[] judge, long time){

        long sum = 0;

        for(long j : judge){
            sum += time/j;
            if(sum >= 10){
                sum -= sum/10;
            }
        }

        return sum;

    }
}
