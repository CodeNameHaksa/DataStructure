import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class boj_10026 {
}
class Cell{
    int x, y;
    public Cell(int x, int y){
        this.x = x;
        this.y = y;
    }
}
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String[][] rg = null;
    static String[] sArr = null;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int N;
    static Queue<Cell> q = new LinkedList<>();
    public static void main(String[] args)throws IOException {
        N = Integer.parseInt(br.readLine());
        rg = new String[N][N];
        for(int i=0;i<N;i++){
            sArr = br.readLine().split("");
            for(int j=0;j<N;j++){
                rg[i][j] = sArr[j];
            }
        }

        int able = normalBFS();
        int disable = disableBFS();
        System.out.println(able+" "+ disable);


    }
    public static int normalBFS(){
        int[][] visit = new int[N][N];
        int ans = 0;

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){

                if(visit[i][j]==0){
                    q.add(new Cell(i, j));

                    while(!q.isEmpty()){
                        Cell tmp = q.poll();

                        for(int k=0;k<4;k++){
                            int nx = tmp.x+dx[k];
                            int ny = tmp.y+dy[k];
                            if(nx>=0 && ny>=0 && nx<N && ny<N){
                                if(rg[nx][ny].equals(rg[i][j])&&visit[nx][ny]==0){
                                    visit[nx][ny] = 1;
                                    q.add(new Cell(nx, ny));
                                }
                            }
                        }
                    }
                    ans++;
                }
            }
        }
        return ans;
    }


    public static int disableBFS(){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(rg[i][j].equals("G")){
                    rg[i][j]="R";
                }
            }
        }

        return normalBFS();
    }
}
