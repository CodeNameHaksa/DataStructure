import java.io.*;
import java.util.Arrays;
import java.util.HashMap;

public class boj10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String sarr[] = null;

        int N = Integer.parseInt(br.readLine());
        int arr1[] = new int[N];
        sarr = br.readLine().split(" ");
        for(int i = 0; i < sarr.length; i++){
            arr1[i] = Integer.parseInt(sarr[i]);
        }

        Arrays.sort(arr1);

        int M = Integer.parseInt(br.readLine());
        int arr2[] = new int[M];
        sarr = br.readLine().split(" ");
        for(int i = 0; i < sarr.length; i++){
            arr2[i] = Integer.parseInt(sarr[i]);
        }

        for(int i = 0; i <arr2.length; i++){
            sb.append(binaryRight(arr1, arr2[i])-binaryLeft(arr1, arr2[i])+1);
            sb.append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static int binaryRight(int[] arr, int target){
        int left = 0, right = arr.length - 1;

        while(left <= right){
            int mid = (left+right)/2;

            if(arr[mid] <= target){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }

        return right;
    }

    public static int binaryLeft(int[] arr, int target){
        int left = 0;
        int right = arr.length-1;

        while(left <= right){
            int mid = (left+right)/2;

            if(arr[mid] >= target){
                right = mid -1;
            }else{ //arr[mid]랑 target이 값이 같더라도 계속해서 더 큰 mid 중에 target이랑 같은 값이 있는지 찾는것임.
                left = mid + 1;
            }
        }
        return left;
    }
}
