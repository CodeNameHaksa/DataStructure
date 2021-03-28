import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class changeHexString {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args)throws IOException {
        int N = Integer.parseInt(br.readLine());

//        for(int i=0;i<N;i++){
//            System.out.println(change2Hex(i+1));
//        }
        System.out.println(change2Hex(N));



    }
    public static String change2Hex(int num){
        String str = "";
        Queue<String> q = new LinkedList<>();
        int tmp = num;

        while(num>0){
            tmp = num%16;
            num = num/16;
            if(tmp>9){
                if(tmp==10){
                    q.add("A");
                }else if(tmp==11){
                    q.add("B");
                }else if(tmp==12){
                    q.add("C");
                }else if(tmp==13){
                    q.add("D");
                }else if(tmp==14){
                    q.add("E");
                }else if(tmp==15){
                    q.add("F");
                }
            }else{
                q.add(Integer.toString(tmp));
            }
        }
        if(num>0){
            q.add(Integer.toString(num));
        }


        while(!q.isEmpty()){
            String tmpS = q.poll();
            str = tmpS+str;
        }

        return str;
    }
}
