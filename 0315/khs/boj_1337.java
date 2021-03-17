import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj_1337 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String input = null;
        int[] numList = new int[N];

        for(int i=0;i<N;i++){
            input = br.readLine();
            numList[i]=Integer.parseInt(input);
        }
        int ans=0;
        Arrays.sort(numList);
        for(int i=0;i<N;i++){
            int addCnt = 0;
            int cnt = 1;
            for(int j=i+1;j<N;j++){
                int delta = numList[j]-numList[j-1];
                addCnt+=delta;
                if(addCnt>=5){
                    break;
                }
                cnt++;
            }
            if(ans<cnt){
                ans = cnt;
            }
        }

        System.out.println(5-ans);



    }
    public static void printArr(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
