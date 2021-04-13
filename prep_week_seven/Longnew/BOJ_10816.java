import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10816 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        String[] temp = br.readLine().split(" ");
        int[] card1 = new int[n];
        for (int i = 0; i < n; i++)
            card1[i] = Integer.parseInt(temp[i]);

        Arrays.sort(card1);

        int m = Integer.parseInt(br.readLine());
        temp = br.readLine().split(" ");
        for (int i = 0; i < m; i++){
            int right = all_right(card1, Integer.parseInt(temp[i]));
            int left = all_left(card1, Integer.parseInt(temp[i]));

            sb.append((right - left + 1) + " ");
        }
        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }

    static int all_right(int[] array, int target){
        int left = 0, right = array.length - 1;

        while (left <= right){
            int mid = (left + right) / 2;

            if (array[mid] <= target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return right;
    }

    static int all_left(int[] array, int target){
        int left = 0, right = array.length - 1;

        while (left <= right){
            int mid = (left + right) / 2;

            if (array[mid] >= target)
                right = mid - 1;
            else
                left = mid + 1;
        }

        return left;
    }
}
