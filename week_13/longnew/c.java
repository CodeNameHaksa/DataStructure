import java.io.*;
import java.util.*;

public class c {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static HashMap<String, String[]> map = new HashMap<>();
    static Queue<String> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        String root = "";

        for (int i = 0; i < n; i++) {
            String[] temp = br.readLine().split(" ");
            if (i == 0)
                root = temp[0];

            String[] child = {temp[1], temp[2]};

            map.put(temp[0], child);
        }

        List<String> left = new ArrayList<>();
        List<String> right = new ArrayList<>();

        queue.add(root);
        while (!queue.isEmpty()){
            String now = queue.poll();
            left.add(now);

            String[] temp = map.get(now);
            if (!temp[0].equals("."))
                queue.add(temp[0]);
        }

        queue.add(root);
        while (!queue.isEmpty()){
            String now = queue.poll();
            right.add(now);

            String[] temp = map.get(now);
            if (!temp[1].equals("."))
                queue.add(temp[1]);
        }

        for (int i = left.size() - 1; i > 0; i--)
            System.out.print(left.get(i) + " ");

        for (int i = 0; i < right.size(); i++)
            System.out.print(right.get(i) + " ");
    }
}
