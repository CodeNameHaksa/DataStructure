import java.io.*;

public class a {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        String[] temp = br.readLine().split(" ");
        int k = Integer.parseInt(temp[0]);
        int m = Integer.parseInt(temp[1]);

        String[] data = new String[k];

        for (int i = 0; i < m; i++) {
            if (i >= k)
                break;

            temp = br.readLine().split(" ");
            int idx = Integer.parseInt(temp[0]);

            while (data[idx % k] != null)
                idx++;

            data[idx % k] = temp[1];
        }

        for (String item : data)
            if (item != null)
                System.out.print(item + " ");
    }
}
