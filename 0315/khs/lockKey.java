import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//        for(int i=0;i<N;i++){
//            for(int j=0;j<N;j++){
//                System.out.print(key[i][j]+" ");
//            }
//            System.out.println();
//        }
//        System.out.println();
//
//        for(int i=0;i<M+2*N-2;i++){
//            for(int j=0;j<M+2*N-2;j++){
//                System.out.print(lock[i][j]+" ");
//            }
//            System.out.println();
//        }
//
//        System.out.println();
//        int[][] arr = rotate(key);
//        for(int i=0;i<N;i++){
//            for(int j=0;j<N;j++){
//                System.out.print(arr[i][j]+" ");
//            }
//            System.out.println();
//        }
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

        System.out.println(checkArr(lock, N, M));


        for(int i=0;i<4;i++){
            if(attachArr(key, lock)){
                System.out.println("Success");
                break;
            }else{
                key = rotate(key);
            }
        }

        System.out.println("Fail");

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
        boolean flag = false;
        for(int i=N-1;i<N+M-1;i++){
            for(int j=N-1;j<N+M-1;j++){
                if(arr[i][j]!=k){
                    flag = false;
                    break;
                }else{
                    flag = true;
                }
            }
        }

        return flag;
    }

    public static boolean attachArr(int[][] key, int[][]lock){
        int N = key.length;
        int M = lock.length;
        int[][] tmp = lock;
        boolean flag = false;

        for(int i=0;i<N+M+1;i++){
            for(int j=0;j<N;j++){
                for(int k=0;k<N;k++){
                    tmp[j+i][k+i] += key[j][k];
                }
            }
            if(checkArr(tmp, N, M)){
                flag = true;
                break;
            }
        }

        return flag;
    }

}
