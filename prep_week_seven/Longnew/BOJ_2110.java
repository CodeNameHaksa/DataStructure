import java.io.*;
import java.util.Arrays;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] temp = br.readLine().split(" ");
        int n = Integer.parseInt(temp[0]);
        int c = Integer.parseInt(temp[1]);

        int[] data = new int[n];
        for (int i = 0; i < n; i++)
            data[i] = Integer.parseInt(br.readLine());
        Arrays.sort(data);

        int left = 1, right = data[data.length - 1] - data[0];
        while (left <= right){
            int mid = (left + right) / 2;

            int total = 1;
            int sum = data[0] + mid;
            for (int i = 1; i < n; i++){
                if (sum <= data[i]){
                    sum = data[i] + mid;
                    total++;
                }
            }

            if (total < c)
                right = mid - 1;
            else
                left = mid + 1;
        }

        System.out.println(right);
    }
}
