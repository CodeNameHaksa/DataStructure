import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BOJ_7576_Tomato {
    static int[][] data;
    static Queue<Cell> q;

    static class Cell{
        int x, y, day;

        public Cell(int x, int y, int day){
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }

    public static void bfs(int limit_y, int limit_x){
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int ret = 0;

        while (!q.isEmpty()){
            Cell now = q.poll();

            for (int i = 0; i < 4; i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 0 || nx >= limit_x || ny < 0 || ny >= limit_y)
                    continue;
                if (data[nx][ny] == 0){
                    q.add(new Cell(nx, ny, now.day + 1));
                    data[nx][ny] = 1;
                }
            }
            ret = Math.max(ret, now.day);
        }
        if (check(limit_y, limit_x))
            System.out.println(ret);
        else
            System.out.println(-1);
    }

    public static boolean check(int limit_y, int limit_x){
        for (int i = 0; i < limit_x; i++)
            for (int j = 0; j < limit_y; j++)
                if (data[i][j] == 0)
                    return false;

        return true;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        data = new int[n][m];
        q = new LinkedList<>();

        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++){
                data[i][j] = Integer.parseInt(st.nextToken());
                if (data[i][j] == 1)
                    q.add(new Cell(i, j, 0));
            }
        }
        
        bfs(m, n);
    }
}
