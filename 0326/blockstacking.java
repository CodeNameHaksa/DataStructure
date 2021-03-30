import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class blockStacking {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[3];
        String[] sArr = br.readLine().split(" ");
        for(int i=0;i<3;i++){
            arr[i] = Integer.parseInt(sArr[i]);
        }
        int[] arr0 = new int[arr[0]];
        int[] arr1 = new int[arr[1]];
        int[] arr2 = new int[arr[2]];
        Stack<Integer> st0 = new Stack<>();
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();


        sArr = br.readLine().split(" ");
        for(int j=0;j< sArr.length;j++){
            arr0[j] = Integer.parseInt(sArr[j]);
        }
        sArr = br.readLine().split(" ");
        for(int j=0;j< sArr.length;j++){
            arr1[j] = Integer.parseInt(sArr[j]);
        }
        sArr = br.readLine().split(" ");
        for(int j=0;j< sArr.length;j++){
            arr2[j] = Integer.parseInt(sArr[j]);
        }

        for(int i=0;i<arr0.length;i++){
            if(i==0){
                st0.push(arr0[arr0.length-1-i]);
            }else{
                st0.push(st0.peek()+arr0[arr0.length-1-i]);
            }
        }

        for(int i=0;i<arr1.length;i++){
            if(i==0){
                st1.push(arr1[arr1.length-1-i]);
            }else{
                st1.push(st1.peek()+arr1[arr1.length-1-i]);
            }
        }

        for(int i=0;i<arr2.length;i++){
            if(i==0){
                st2.push(arr2[arr2.length-1-i]);
            }else{
                st2.push(st2.peek()+arr2[arr2.length-1-i]);
            }
        }

        while(!st0.isEmpty()&&!st1.isEmpty()&&!st2.isEmpty()){
            int tmp0 = st0.peek();
            int tmp1 = st1.peek();
            int tmp2 = st2.peek();

            if(tmp0==tmp1&&tmp0==tmp2){
                System.out.println(tmp0);
                System.exit(0);
            }else{


                if(tmp0>tmp1&&tmp0>tmp2){
                    st0.pop();
                    continue;
                }if(tmp1>tmp0&&tmp1>tmp2){
                    st1.pop();
                    continue;
                }if(tmp2>tmp0&&tmp2>tmp1){
                    st2.pop();
                    continue;
                }
                if(tmp0==tmp1){
                    st0.pop();
                    st1.pop();
                    continue;
                }
                if(tmp0==tmp2){
                    st0.pop();
                    st2.pop();
                    continue;
                }if(tmp2==tmp1){
                    st2.pop();
                    st1.pop();
                    continue;
                }

            }
        }

//         System.out.println("-1");





    }
}
