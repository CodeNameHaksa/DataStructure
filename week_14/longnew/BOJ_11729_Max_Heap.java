import java.io.*;
import java.util.*;

class Heap{
    ArrayList<Integer> data = new ArrayList<>();

    public Heap(){
        data.add(-1);
    }

    void swap(int target, int idx){
        int temp = data.get(target);
        data.set(target, data.get(idx));
        data.set(idx, temp);
    }

    void maxHeapify(int idx){
        int left = idx * 2;
        int right = idx * 2 + 1;
        int i = idx;

        if (left < data.size() && data.get(left) > data.get(i))
            i = left;

        if (right < data.size() && data.get(right) > data.get(i))
            i = right;

        if (idx != i){
            swap(i, idx);
            maxHeapify(i);
        }
    }

    void insert(int n){
        data.add(n);
        int idx = data.size() - 1;

        // 새로 들어온 원소에 대한 정렬을 수행.
        while (idx > 0){
            int parent = idx / 2;

            if (parent < 1 || data.get(parent) > data.get(idx))
                break;

            swap(parent, idx);
            idx = parent;
        }
    }

    int delete(){
        int idx = data.size() - 1;

        // -1추가 해둔 0번 인덱스를 가리키면 없는 노드 니까
        // 0을 리턴.
        if (idx == 0)
            return 0;

        int ret = data.get(1);
        swap(1, idx);
        data.remove(idx);
        maxHeapify(1);
        return ret;
    }
}

public class BOJ_11729_Max_Heap {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        Heap heap = new Heap();

        for (int i = 0; i < n; i++){
            int temp = Integer.parseInt(br.readLine());

            if (temp == 0){
                System.out.println(heap.delete());
                continue;
            }
            heap.insert(temp);
        }
    }
}
