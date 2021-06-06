import java.io.*;
import java.util.*;

class Solution{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] graph;
    static int[][] key;
    static int n, m;

    public static void main(String[] args) throws IOException{
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        key = new int[n][n];
        for (int i = 0; i < n; i++){
            String[] temp = br.readLine().split(" ");

            for (int j = 0; j < n; j++){
                key[i][j] = Integer.parseInt(temp[j]);
            }
        }

        graph = new int[2 * (n - 1) + m][2 * (n - 1) + m];
        int x = n - 1;
        int y = n - 1;
        for (int i = 0; i < m; i++){
            String[] temp = br.readLine().split(" ");

            for (int j = 0; j < m; j++){
                graph[x + i][y + j] = Integer.parseInt(temp[j]);
            }
        }

        for (int i = 0; i < 4; i++){

            for (x = 0; x < n + m - 1; x++){
                for (y = 0; y < n + m - 1; y++){

                    for (int dx = 0; dx < n; dx++){
                        for (int dy = 0; dy < n; dy++){
                            graph[x + dx][y + dy] += key[dx][dy];
                        }
                    }

                    if (check()){
                        System.out.println("Success");
                        System.exit(0);
                    }

                    for (int dx = 0; dx < n; dx++){
                        for (int dy = 0; dy < n; dy++){
                            graph[x + dx][y + dy] -= key[dx][dy];
                        }
                    }
                }

                rotate();
            }

        }

        System.out.println("Fail");
    }

    public static void rotate(){
        int w = key.length;
        int[][] temp = new int[w][w];

        for (int i = 0; i < w; i++)
            for (int j = 0; j < w; j++)
                temp[i][j] = key[w - 1 - j][i];

        for (int i = 0; i < w; i++)
            for (int j = 0; j < w; j++)
                key[i][j] = temp[i][j];
    }

    public static boolean check(){
        int x = n - 1;
        int y = n - 1;

        int target = graph[x][y];

        for (int i = 0; i < m; i++)
            for (int j = 0; j < m; j++)
                if(target != graph[x + i][y + j])
                    return false;

        return true;
    }
}

// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.util.Arrays;
// import java.util.StringTokenizer;

// public class kakao {

//     public static int[][] rotate(int[][] arr){
//         int[][] temp = new int[arr.length][arr.length];

//         for (int x = 0; x < arr.length; x++)
//             for (int y = 0; y < arr.length; y++)
//                 temp[y][arr.length - 1 - x] = arr[x][y];

//         return temp;
//     }
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st;

//         int n = Integer.parseInt(br.readLine());
//         int m = Integer.parseInt(br.readLine());

//         int[][] key = new int[n][n];
//         int[][] lock = new int[m][m];
//         int[][] graph = new int[m + 2 * (n - 1)][m + 2 * (n - 1)];

//         for (int i = 0; i < n; i++) {
//             int idx = 0;
//             st = new StringTokenizer(br.readLine(), " ");

//             while (st.hasMoreTokens()) {
//                 key[i][idx] = Integer.parseInt(st.nextToken());
//                 idx += 1;
//             }
//         }

//         for (int i = 0; i < m; i++) {
//             int idx = 0;
//             st = new StringTokenizer(br.readLine(), " ");

//             while (st.hasMoreTokens()) {
//                 lock[i][idx] = Integer.parseInt(st.nextToken());
//                 graph[n - 1 + i][n - 1 + idx] = lock[i][idx];
//                 idx += 1;
//             }
//         }
//         int flag = 0;

//         for (int i = 0; i < 4; i++) {

//             for (int x = 0; x < graph.length - (n - 1); x++) {
//                 for (int y = 0; y < graph.length - (n - 1); y++) {
//                     flag = 1;
//                     // key를 그래프에 입력.

//                     for (int gap_x = 0; gap_x < n; gap_x++)
//                         for (int gap_y = 0; gap_y < n; gap_y++)
//                             graph[x + gap_x][y + gap_y] += key[gap_x][gap_y];

//                     // 그래프에서 lock이 존재하는 구간내에 있는 모든 숫자들이 같은지 확인하기.
//                     int temp = -1;
//                     for (int gap_x = 0; gap_x < m; gap_x++) {
//                         int lock_x = n - 1 + gap_x;

//                         for (int gap_y = 0; gap_y < m; gap_y++) {
//                             int lock_y = n - 1 + gap_y;

//                             if (temp == -1)
//                                 temp = graph[lock_x][lock_y];
//                             else if (temp != graph[lock_x][lock_y])
//                                 flag = 0;
//                         }
//                     }

//                     for (int a = 0; a < graph.length; a++) {
//                         for (int b = 0; b < graph.length; b++) {
//                             System.out.print(graph[a][b]);
//                         }
//                         System.out.println();
//                     }
//                     System.out.println(flag);


//                     // 계산이 끝난 이후엔 값들을 다시 빼줘서 정상적으로 작동이 하도록 하자.
//                     for (int gap_x = 0; gap_x < n; gap_x++)
//                         for (int gap_y = 0; gap_y < n; gap_y++)
//                             graph[x + gap_x][y + gap_y] -= key[gap_x][gap_y];

//                     if (flag == 1)
//                         break;
//                 }
//                 if (flag == 1)
//                     break;
//             }
//             if (flag == 1)
//                 break;
//             key = rotate(key);

//         }

//         if (flag == 1)
//             System.out.println("Success");
//         else
//             System.out.println("Fail");
//     }

// }
