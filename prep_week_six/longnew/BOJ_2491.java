import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2491 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String[] crotatia = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

    public static void main(String[] args) throws IOException {
        String data = br.readLine();

        for (int i = 0; i < 8; i++){
            String comp = crotatia[i];
            data = data.replace(comp, "a");
        }

        System.out.println(data.length());
    }
}
