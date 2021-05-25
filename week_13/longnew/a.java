import java.io.*;
import java.util.*;

public class a {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static HashMap<String, String[]> map = new HashMap<>();
    static Queue<String> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++){
            String[] temp = br.readLine().split(" ");
            String[] child= {temp[1], temp[2]};

            if (i == 0)
                queue.add(temp[0]);

            map.put(temp[0], child);
        }

        while (!queue.isEmpty()){
            order(queue.size());
        }
    }

    public static void order(int length){
        for (int i = 0; i < length; i++) {
            String now = queue.poll();
            System.out.print(now + " ");

            if (map.containsKey(now))
                for (String item : map.get(now))
                    if (!item.equals("."))
                        queue.add(item);
        }
        System.out.println();
    }
}
