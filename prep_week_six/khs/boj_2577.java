import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_2577 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Integer> map = new HashMap<>();
        int tmp = 1;
        int N = 3;
        while(N-->0){
            tmp *= Integer.parseInt(br.readLine());
        }

        while(tmp>0){
            int num = tmp%10;
            tmp /= 10;
            if(map.containsKey(num)){
                map.put(num, map.get(num)+1);
            }else{
                map.put(num, 1);
            }
        }

        for(int i = 0 ; i < 10 ; i++){
            if(map.containsKey(i)){
                System.out.println(map.get(i));
            }else{
                System.out.println(0);
            }

        }
    }
}
