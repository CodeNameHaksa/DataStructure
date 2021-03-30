import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.LinkedList;
import java.util.Queue;

public class swea1226 {
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static Queue<maze> q = new LinkedList<>();
    static int[][] graph = new int[16][16];
    static String[] sArr = null;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args)throws IOException {
        String tmp ="";

        for(int i=0;i<10;i++){
            tmp = br.readLine();
            System.out.print("#"+tmp+" ");


            if(bfs()){
                System.out.println("1");

            }else{
                System.out.println("0");
            }

            graph = new int[16][16];
            sArr = null;
        }

//        if(bfs()){
//            System.out.println("1");
//        }else{
//            System.out.println("0");
//        }



    }

    private static boolean bfs() throws IOException {
        q = new LinkedList<>();
        for(int i=0;i<16;i++){
            sArr = br.readLine().split("");
            for(int j=0;j<16;j++){
                graph[i][j] = Integer.parseInt(sArr[j]);
                if(sArr[j].equals("2")){
                    q.add(new maze(i,j));
                }
            }
        }

//        for(int i=0;i<16;i++){
//            for(int j=0;j<16;j++){
//                System.out.print(graph[i][j]+" ");
//            }
//            System.out.println();
//        }


        while(!q.isEmpty()){

            maze tmp = q.poll();

            for(int i=0;i<4;i++){
                int nx = tmp.x+dx[i];
                int ny = tmp.y+dy[i];

                if(nx>=0 && ny >=0 && nx<16 && ny<16){
                    if(graph[nx][ny]==0){
                        graph[nx][ny] = 1;
                        q.add(new maze(nx, ny));
                    }
                    if(graph[nx][ny]==3){
                        return true;
                    }
                }

            }
        }
        return false;
    }
}
class maze{
    int x;
    int y;
    maze(int x, int y){
        this.x = x;
        this.y = y;
    }
}


