import java.io.*;
import java.util.*;

class heap{
    ArrayList<Integer> data = new ArrayList<>();

    void insert(int n){
        data.add(n);
        int last_idx = data.size() - 1;

        while (last_idx >= 0){
            int parent_idx = (last_idx - 1) / 2;

            if (parent_idx >= 0 && data.get(parent_idx) < data.get(last_idx)){
                swap(parent_idx, last_idx);

                last_idx = parent_idx;
            }else
                break;

        }
    }

    int delete(){
        int last_idx = data.size() - 1;

        if (last_idx < 0)
            return -1;

        int ret = data.get(0);
        swap(0, last_idx);
        data.remove(data.size() - 1);
        maxHeapify(0);

        return ret;
    }

    void maxHeapify(int i){
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        int idx = i;

        if (left < data.size() && data.get(left) > data.get(idx))
            idx = left;

        if (right < data.size() && data.get(right) > data.get(idx))
            idx = right;

        if (i != idx){
            swap(i, idx);
            // 자식에 대해 히피파이 해주기.
            maxHeapify(idx);
        }
    }

    void swap(int target_idx, int idx){
        int temp = data.get(target_idx);
        data.set(target_idx, data.get(idx));
        data.set(idx, temp);
    }
}

public class a {

    public static void main(String[] args) throws IOException{


        System.out.println(" 정렬 전 original 배열 : ");
        for (int val : data) {
            System.out.println(val + " ");
        }


    }
}
