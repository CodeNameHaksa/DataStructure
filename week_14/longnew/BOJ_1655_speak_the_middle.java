import java.io.*;
import java.util.*;

public class BOJ_1655_speak_the_middle {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();

        for (int i = 0; i < n; i++){
            int temp = Integer.parseInt(br.readLine());

            if (minHeap.size() == maxHeap.size())
                minHeap.add(-temp);
            else
                maxHeap.add(temp);

            if (minHeap.size() > 0 && maxHeap.size() > 0)
                if (-minHeap.peek() > maxHeap.peek()){
                    int from_min = -minHeap.poll();
                    int from_max = maxHeap.poll();

                    minHeap.add(-from_max);
                    maxHeap.add(from_min);
                }

            sb.append(-minHeap.peek() + "\n");
        }
        System.out.println(sb);
    }
}
