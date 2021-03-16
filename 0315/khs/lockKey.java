import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class lockKey {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer st= null;
        int N = Integer.parseInt(input);
        input = br.readLine();
        int M = Integer.parseInt(input);
        int key[][] = new int[N][N];
        int lock[][] = new int[M+2*N-2][M+2*N-2];

        for(int i=0;i<N;i++){
            input = br.readLine();
            st = new StringTokenizer(input);
            for(int j=0;j<N;j++){
                key[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=N-1;i<N+M-1;i++){
            input = br.readLine();
            st = new StringTokenizer(input);
            for(int j=N-1;j<N+M-1;j++){
                lock[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] lockarr = new int[7][7];
        //lockarr = new int[][]{{0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0}, {0, 0, 2, 2, 2, 0, 0}, {0, 0, 2, 2, 2, 0, 0}, {0, 0, 2, 2, 2, 0, 0}, {0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0}};
        //System.out.println(checkArr(lockarr, N, M));
        boolean flag =false;
        for(int i=0;i<4;i++){
            if(attachArr(key, lock)){
                flag = true;
                break;
            }else{
                key = rotate(key);
            }
        }

        if(flag){
            System.out.println("Success");
        }else{
            System.out.println("Fail");
        }

    }

    public static int[][] rotate(int[][] arr){
        int N = arr.length;
        int[][] rotateArr = new int[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                rotateArr[i][j] = arr[j][N-1-i];
            }
        }
        return rotateArr;
    }

    public static boolean checkArr(int[][] arr, int N, int M){
        int k = arr[N-1][N-1];
        int x = N-1;
        int y = N-1;

        for(int i = 0 ;i < M; i++){
            for(int j = 0; j < M; j++){
                if(arr[x+i][y+j]!=k){
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean attachArr(int[][] key, int[][]lock){
        int N = key.length;
        int M = lock.length-2*N+2;
        int[][] tmp = lock;


        for(int x=0;x<M+N-1;x++){
            for(int y=0;y<N+M-1;y++) {

                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < N; k++) {
//                        System.out.println("j, k"+j+" "+k);
                        tmp[x + j][y + k] += key[j][k];
                    }
                }

//                System.out.println("초기화");
                if (checkArr(tmp, N, M)) {
                    return true;
                }

                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < N; k++) {
                        tmp[x + j][y + k] -= key[j][k];
                    }
                }
            }
        }

        return false;
    }

    public static void printArr(int[][] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

}
