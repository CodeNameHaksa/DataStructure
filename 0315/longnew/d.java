import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class kakao {

    public static int[][] rotate(int[][] arr){
        int[][] temp = new int[arr.length][arr.length];

        for (int x = 0; x < arr.length; x++)
            for (int y = 0; y < arr.length; y++)
                temp[y][arr.length - 1 - x] = arr[x][y];

        return temp;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] key = new int[n][n];
        int[][] lock = new int[m][m];
        int[][] graph = new int[m + 2 * (n - 1)][m + 2 * (n - 1)];

        for (int i = 0; i < n; i++) {
            int idx = 0;
            st = new StringTokenizer(br.readLine(), " ");

            while (st.hasMoreTokens()) {
                key[i][idx] = Integer.parseInt(st.nextToken());
                idx += 1;
            }
        }

        for (int i = 0; i < m; i++) {
            int idx = 0;
            st = new StringTokenizer(br.readLine(), " ");

            while (st.hasMoreTokens()) {
                lock[i][idx] = Integer.parseInt(st.nextToken());
                graph[n - 1 + i][n - 1 + idx] = lock[i][idx];
                idx += 1;
            }
        }
        int flag = 0;

        for (int i = 0; i < 4; i++) {

            for (int x = 0; x < graph.length - (n - 1); x++) {
                for (int y = 0; y < graph.length - (n - 1); y++) {
                    flag = 1;
                    // key를 그래프에 입력.

                    for (int gap_x = 0; gap_x < n; gap_x++)
                        for (int gap_y = 0; gap_y < n; gap_y++)
                            graph[x + gap_x][y + gap_y] += key[gap_x][gap_y];

                    // 그래프에서 lock이 존재하는 구간내에 있는 모든 숫자들이 같은지 확인하기.
                    int temp = -1;
                    for (int gap_x = 0; gap_x < m; gap_x++) {
                        int lock_x = n - 1 + gap_x;

                        for (int gap_y = 0; gap_y < m; gap_y++) {
                            int lock_y = n - 1 + gap_y;

                            if (temp == -1)
                                temp = graph[lock_x][lock_y];
                            else if (temp != graph[lock_x][lock_y])
                                flag = 0;
                        }
                    }

                    for (int a = 0; a < graph.length; a++) {
                        for (int b = 0; b < graph.length; b++) {
                            System.out.print(graph[a][b]);
                        }
                        System.out.println();
                    }
                    System.out.println(flag);


                    // 계산이 끝난 이후엔 값들을 다시 빼줘서 정상적으로 작동이 하도록 하자.
                    for (int gap_x = 0; gap_x < n; gap_x++)
                        for (int gap_y = 0; gap_y < n; gap_y++)
                            graph[x + gap_x][y + gap_y] -= key[gap_x][gap_y];

                    if (flag == 1)
                        break;
                }
                if (flag == 1)
                    break;
            }
            if (flag == 1)
                break;
            key = rotate(key);

        }

        if (flag == 1)
            System.out.println("Success");
        else
            System.out.println("Fail");
    }

}
