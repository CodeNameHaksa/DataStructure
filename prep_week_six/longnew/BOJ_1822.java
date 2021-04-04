import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1822 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static TreeSet<Integer> A = new TreeSet<>();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[] A_str = br.readLine().split(" ");
        for (int i = 0; i < A_str.length; i++)
            A.add(Integer.parseInt(A_str[i]));

        String[] B_str = br.readLine().split(" ");
        for (int i = 0; i < B_str.length; i++)
            if (A.contains(Integer.parseInt(B_str[i])))
                A.remove(Integer.parseInt(B_str[i]));

        System.out.println(A.size());
        for (Integer item : A)
            System.out.print(item + " ");
    }
}
