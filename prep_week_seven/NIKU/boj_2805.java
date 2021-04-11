import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class cutLog {
    public static long[] tree;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sarr = br.readLine().split(" ");
        int N = Integer.parseInt(sarr[0]);
        int M = Integer.parseInt(sarr[1]);
        sarr = br.readLine().split(" ");
        long start = 0;
        long max = 0;

        tree = new long[sarr.length];

        for(int i = 0; i < N; i++){
            tree[i] = Integer.parseInt(sarr[i]);
            if(max < tree[i]){
                max = tree[i];
            }
        }


        long  mid = 0;

        while(start <= max){
            mid = (start+max)/2;
            long tmp = treeSize(mid);

            if(tmp >= M){
                start = mid + 1;
            }else{
                max = mid -1;
            }

        }
        System.out.println(max);

    }

    public static long treeSize(long cutter){
        long sum = 0;
        for(long l : tree){
            if(l < cutter){
                continue;
            }else{
                sum += l-cutter;
            }

        }
        return sum;
    }

}
