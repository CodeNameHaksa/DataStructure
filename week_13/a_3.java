import java.io.*;
import java.util.*;

public class a_3 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(br.readLine());
        String[] sData = br.readLine().split(" ");
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < sData.length; i++){
            for(int j = 0; j < sData.length; j++){
                set.add(Integer.parseInt(sData[i]) + Integer.parseInt(sData[j]));
            }
        }

        for(int i : set){
            for(int j : set){
                if(i+j == target) {
                    System.out.println(true);
                    System.exit(0);
                }
            }
        }

        System.out.println(false);

    }
}
