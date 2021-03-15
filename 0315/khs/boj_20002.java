import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_20002 {
    public static int[][] arr;
    public static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer st = null;
        int N = Integer.parseInt(input);
        arr = new int[N+1][N+1];
        dp = new int[N+1][N+1];

        for(int i=1;i<N+1;i++){
            input = br.readLine();
            st = new StringTokenizer(input);
            for(int j=1;j<N+1;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[1][1] = arr[1][1];

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                dp[i+1][j+1] = dp[i+1][j]+dp[i][j+1]+arr[i+1][j+1]-dp[i][j];
            }
        }

//        for(int i=0;i<N+1;i++){
//            for(int j=0;j<N+1;j++){
//                System.out.print(arr[i][j]+" ");
//            }
//            System.out.println();
//        }
//
//        System.out.println("dp");
//
//        for(int i=0;i<N+1;i++){
//            for(int j=0;j<N+1;j++){
//                System.out.print(dp[i][j]+" ");
//            }
//            System.out.println();
//        }

        int max = -1000;
        int val = 0;
        for(int i=1;i<N+1;i++){
            for(int x=0;x<N-i+1;x++){
                for(int y=0;y<N-i+1;y++){
                    int nx = x+i;
                    int ny = y+i;
                    val = dp[nx][ny]-dp[nx][y]-dp[x][ny]+dp[x][y];
                    if(max<val){
                        max = val;
                    }
                }
            }
        }

        System.out.println(max);
    }

}
