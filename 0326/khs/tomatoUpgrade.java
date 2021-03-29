import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class box{
    int x;
    int y;
    int day;
    public box(int x, int y, int day){
        this.x = x;
        this.y = y;
        this.day = day;
    }
}
public class tomatoUpgrade {
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String[] strArr = null;
    static int[][] tomato;
    static int W, H;

    public static void main(String[] args)throws IOException {
        strArr = br.readLine().split(" ");
        W = Integer.parseInt(strArr[0]);
        H = Integer.parseInt(strArr[1]);
        tomato = new int[H][W];
        for(int i=0;i<H;i++){
            strArr = br.readLine().split(" ");
            for(int j=0;j<W;j++){
                tomato[i][j] = Integer.parseInt(strArr[j]);
            }
        }
        bfs();

    }

    public static void bfs(){
        Queue<box> q = new LinkedList<>();
        int day = 0;
        for(int i=0;i<H;i++){
            for(int j=0;j<W;j++){
                if(tomato[i][j] == 0){
                    q.offer(new box(i,j,0));
                }
            }
        }

        while(!q.isEmpty()){
            box box = q.poll();
            day = box.day;

            for(int i=0;i<4;i++){
                int nx = box.x+dx[i];
                int ny = box.y+dy[i];
                if(nx>=0&&nx<H&&ny>=0&&ny<W){
                    if(tomato[nx][ny]!=-1&&tomato[nx][ny]!=0){
                        q.offer(new box(nx, ny, day+tomato[nx][ny]));
                        tomato[nx][ny] =0;
                    }
                }
            }
        }

        if(checkTomato()){
            System.out.println(day);
        }else{
            System.out.println("-1");
        }



    }

    public static boolean checkTomato(){
        for(int i=0;i<H;i++){
            for(int j=0;j<W;j++){
                if(tomato[i][j]>0){
                    return false;
                }
            }
        }
        return true;
    }
}
