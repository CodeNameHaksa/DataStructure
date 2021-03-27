import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Diff_Tomato {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Queue<Pos> q;
    static int[][] graph;
    static int w, h;

    static class Pos{
        int x, y, day;

        Pos(int x, int y, int day){
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }

    public static void bfs(){
        int ans = -1;
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        while (!q.isEmpty()){
            Pos now = q.poll();

            for (int i = 0; i < 4; i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 0 || nx >= h || ny < 0 || ny >= w)
                    continue;

                if (graph[nx][ny] > 0){
                    q.add(new Pos(nx, ny, now.day + graph[nx][ny]));
                    graph[nx][ny] = 0;
                }
            }

            ans = Math.max(ans, now.day);
        }
        if (check())
            System.out.println(ans);
        else
            System.out.println(-1);
    }

    public static boolean check(){
        for (int i = 0; i < h; i++)
            for (int j = 0; j < w; j++)
                if (graph[i][j] != 0)
                    return false;

        return true;
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        q = new LinkedList<>();
        graph = new int[h][w];

        for (int i = 0; i < h; i++){
            st = new StringTokenizer((br.readLine()));

            for (int j = 0; j < w; j++) {
                int temp = Integer.parseInt(st.nextToken());
                graph[i][j] = temp;

                // 다 익은 토마토를 미리 큐에 저장해 두자.
                if (temp == 0)
                    q.add(new Pos(i, j, 0));
            }
        }

        bfs();
    }
}
