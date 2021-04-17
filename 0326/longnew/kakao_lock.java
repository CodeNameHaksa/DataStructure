import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] graph;
    static int[][] key;
    static int n;
    static boolean flag;

    public static void main(String[] args) throws IOException{
        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        graph = new int[m + 2 * (n - 1)][m + 2 * (n - 1)];
        key = new int[n][n];

        for (int i = 0; i < n; i++){
            String[] temp = br.readLine().split(" ");

            for (int j = 0; j < n; j++){
                key[i][j] = Integer.parseInt(temp[j]);
            }
        }

        for (int i = 0; i < n; i++){
            String[] temp = br.readLine().split(" ");

            for (int j = 0; j < n; j++){
                graph[i + n - 1][j + n - 1] = Integer.parseInt(temp[j]);
            }
        }
        for (int i = 0; i < 4; i++){
            for (int x = 0; x < m + n - 1; x++){
                for (int y = 0; y < m + n - 1; y++){

                    // make graph copy with key numbers
                    for (int gap_x = 0; gap_x < n; gap_x++){
                        for (int gap_y = 0; gap_y < n; gap_y++){
                            graph[x + gap_x][y + gap_y] += key[gap_x][gap_y];
                        }
                    }

                    // now check if the lock is opened;
                    if (check()){
                        System.out.println("Success");
                        System.exit(0);
                    }

                    for (int gap_x = 0; gap_x < n; gap_x++){
                        for (int gap_y = 0; gap_y < n; gap_y++){
                            graph[x + gap_x][y + gap_y] -= key[gap_x][gap_y];
                        }
                    }
                }
            }
            rotate();
        }

        System.out.println("Fail");
    }

    public static void rotate(){
        int[][] temp = new int[n][n];

        for (int x = 0; x < n; x++)
            for (int y = 0; y < n; y++)
                temp[x][y] = key[x][y];

        // rotating key to 90 degree
        for (int x = 0; x < n; x++)
            for (int y = 0; y < n; y++)
                key[x][y] = temp[n - 1 - x][y];
    }

    public static boolean check(){
        int x = n - 1;
        int y = n - 1;
        int data = graph[x][y];
        flag = true;

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (data != graph[x + i][y + j])
                    return false;

        return true;
        // at main class
        // check everytime if it can open or not.
    }
}
