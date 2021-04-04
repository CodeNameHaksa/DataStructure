import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

public class b {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = null;
        String[] sarr = null;
        String maxkey = null;
        int max = 0;
        double cnt = 0;
        HashMap<String, Integer> hashMap= new HashMap<>();

        while((s = br.readLine())!=null){
            sarr = s.split("[\\W_]+");

            for(int i = 0; i < sarr.length; i++){
                String lowerstr = sarr[i].toLowerCase();
                if(!hashMap.containsKey(lowerstr)){
                    hashMap.put(lowerstr,1);
                }else{
                    hashMap.put(lowerstr, hashMap.get(lowerstr)+1);
                    if(max<hashMap.get(lowerstr)){
                        max = hashMap.get(lowerstr);
                        maxkey = lowerstr;
                    }
                }
                cnt++;

            }
        }

        System.out.println(maxkey);
        System.out.println(Math.round(hashMap.get(maxkey)/cnt*100)/100.0);
        System.out.println(cnt);


    }
}
