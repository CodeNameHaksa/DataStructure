import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++){

            int n = Integer.parseInt(br.readLine());

            int[] note_1 = new int[n];
            String[] temp = br.readLine().split(" ");
            for (int k = 0; k < n; k++)
                note_1[k] = Integer.parseInt(temp[k]);

            Arrays.sort(note_1);

            int m = Integer.parseInt(br.readLine());
            int[] note_2 = new int[m];
            temp = br.readLine().split(" ");

            for (int k = 0; k < m; k++)
                note_2[k] = Integer.parseInt(temp[k]);

            for (int target = 0; target < m; target++){
                int left = 0, right = n - 1;
                boolean flag = false;
                
                while (left <= right){
                    int mid = (left + right) / 2;

                    if (note_1[mid] < note_2[target])
                        left = mid + 1;
                    else if (note_1[mid] > note_2[target])
                        right = mid - 1;
                    else{
                        flag = true;
                        break;
                    }
                        
                }
                if (flag){
                    bw.write("1\n");
                }else{
                    bw.write("0\n");
                }
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
