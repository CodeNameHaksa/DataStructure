import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class upgradelog {
    public static long[] tree;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        String[] sarr = null;
        sarr = br.readLine().split(" ");
        int N = sarr.length;
        tree = new long[sarr.length];


        long start = 0;
        long max = 0;
        long  mid = 0;

        for(int i = 0; i < N; i++){
            tree[i] = Integer.parseInt(sarr[i]);
            if(max < tree[i]){
                max = tree[i];
            }
        }

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

        for(int i = 0; i < tree.length; i++){
            if(tree[i] > max ){
                tree[i] = max;
            }
        }
        
        start = 0;
        max = 0;
        mid = 0;

        for(int i = 0; i < N; i++){
            if(max < tree[i]){
                max = tree[i];
            }
        }

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
