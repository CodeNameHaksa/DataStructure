import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());
        List<Integer> data = new ArrayList<Integer>();

        for (int i = 0; i < k; i++){
            int temp = Integer.parseInt(br.readLine());
            if (temp == 0)
                data.remove(data.size() - 1);
            else
                data.add(temp);
        }

        int ans = 0;
        for (int item : data)
            ans += item;
        System.out.println(ans);
    }
}
