import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class cell{
    int x;
    int y;
    int z;
    int day;
    public cell(int x, int y, int z, int day){
        this.x = x;
        this.y = y;
        this.z = z;
        this.day = day;
    }
}
public class boj_7569 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String[] sArr = null;
    static int[] dx = {1,-1,0,0,0,0};
    static int[] dy = {0,0,1,-1,0,0};
    static int[] dz = {0,0,0,0,1,-1};
    static Queue<cell> q = new LinkedList<>();
    static int M, N, H;
    static int[][][] tmt;


    public static void main(String[] args)throws IOException {
        sArr = br.readLine().split(" ");
        M = Integer.parseInt(sArr[0]);
        N = Integer.parseInt(sArr[1]);
        H = Integer.parseInt(sArr[2]);

        tmt = new int[H][N][M];
        for(int i=0;i<H;i++){
            for(int j=0;j<N;j++){
                sArr = br.readLine().split(" ");
                for(int k=0;k<M;k++){
                    if(Integer.parseInt(sArr[k])==1){
                        q.add(new cell(j,k,i,0));
                    }
                    tmt[i][j][k] = Integer.parseInt(sArr[k]);
                }
            }
        }

        bfs();


    }

    public static void bfs(){
        int day = 0;
        while(!q.isEmpty()){
            cell tmpCell = q.poll();
            day = tmpCell.day;

            for(int i=0;i<6;i++){
                int nx = tmpCell.x+dx[i];
                int ny = tmpCell.y+dy[i];
                int nz = tmpCell.z+dz[i];

                if(nx>=0 && nz>=0 && ny>=0 && nx<N && ny<M && nz<H){
                    if(tmt[nz][nx][ny]==0){
                        tmt[nz][nx][ny]=1;
                        q.add(new cell(nx,ny,nz, day+1));
                    }
                }
            }
        }
        if(checktmt()){
            System.out.println(day);
        }else{
            System.out.println(-1);
        }

    }

    public static boolean checktmt(){
        for(int i=0;i<H;i++){
            for(int j=0;j<N;j++){
                for(int k=0;k<M;k++){
                    if(tmt[i][j][k]==0){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
