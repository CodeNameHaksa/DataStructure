import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class boj_2669 {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);

        int[][] arr = new int[100][100]; // int[row][col]  -> int[y][x];
        int x1, x2, y1, y2;
        int cnt = 0;
        for (int i = 0; i < 4; i++) {
            x1 = sc.nextInt();
            y1 = sc.nextInt();
            x2 = sc.nextInt();
            y2 = sc.nextInt();

            for(int y = y1; y < y2; y++){
                for(int x = x1; x < x2; x++){

                    if(arr[y][x] == 1){
                        continue;
                    }else{
                        arr[y][x] = 1;
                        cnt++;
                    }
                }
            }

        }

        System.out.println(cnt);


    }
}
