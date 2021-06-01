import java.io.*;
import java.util.*;

class Heap{
    ArrayList<Integer> data = new ArrayList<>();

    public Heap(){
        data.add(-1);
    }

    void insert(int n){
        data.add(n);
        int idx = data.size() - 1;

        // 힙에 원소를 집어 넣었으면 이게 위에 놈이랑 비교 해서
        // heapify 처럼 반복을 해야함.
        while (idx > 0){
            // idx 1부터 시작하도록 했음
            int parent = idx / 2;

            if (parent < 1 || data.get(parent) < data.get(idx))
                break;
            // parent의 값이 data안에 있을 때 &&
            // parent 원소 값과 idx 원소 값을 비교 해서
            // parent가 작으면 계속 idx에 있던 원소가 커져야 함.
            swap(idx, parent);

            idx = parent;

        }

    }

    int delete(){
        int idx = data.size() - 1;

        if (idx == 0)
            return 0;

        int ret = data.get(1);
        swap(1, idx);
        data.remove(data.size() - 1);
        minHeapify(1);

        return ret;
    }

    void minHeapify(int idx){
        int left = idx * 2;
        int right = idx * 2 + 1;
        int i = idx;

        if (left < data.size() && data.get(left) < data.get(i))
            i = left;

        if (right < data.size() && data.get(right) < data.get(i))
            i = right;

        if (idx != i){
            swap(idx, i);
            minHeapify(i);
        }
    }

    void swap(int target, int idx){
        int temp = data.get(idx);
        data.set(idx, data.get(target));
        data.set(target, temp);
    }
}

public class BOJ_1927_Min_Heap {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());

        Heap heap = new Heap();
        for (int i = 0; i < n; i++){
            int temp = Integer.parseInt(br.readLine());

            if (temp == 0) {
                System.out.println(heap.delete());
                continue;
            }

            heap.insert(temp);
        }
    }
}
