import java.io.*;
import java.util.HashSet;

public class c {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static HashSet<Integer> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        int target = Integer.parseInt(br.readLine());
        String[] temp = br.readLine().split(" ");

        int[] data = new int[temp.length];
        for (int i = 0; i < temp.length; i++)
            data[i] = Integer.parseInt(temp[i]);

        for (int i = 0; i < data.length; i++)
            for (int j = 0; j < data.length; j++)
                set.add(data[i] + data[j]);

        for (Integer item : set)
            for (Integer next_item : set)
                if (item + next_item == target){
                    System.out.println("true");
                    System.exit(0);
                }

        System.out.println("false");
    }
}
