import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class textIndex {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> data = new HashMap<>();
        ArrayList<Map<String, Integer>> arrList = new ArrayList<>();
        String[] sarr = null;
        int cnt = 0;
        int max = 0;
        String maxkey = null;
        String s = null;

        while((s = br.readLine())!=null){
//        int n = 3;
//        while(n-->0){
//            s = br.readLine();
            sarr = s.split(" ");

            Map<String, Integer> tmpMap = new HashMap<>();

            for(int i = 0; i < sarr.length; i++) {
                String tmp = sarr[i].toLowerCase();
                if (data.containsKey(tmp)) {
                    data.put(tmp, data.get(tmp) + 1);
                    tmpMap.put(tmp, data.get(tmp) + 1);
                } else {
                    data.put(tmp, 1);
                    tmpMap.put(tmp, 1);
                }
            }
            arrList.add(tmpMap);
            cnt++;
        }

        Set<String> set = data.keySet();

        for(String item: set){
            if(data.get(item) > max){
                max = data.get(item);
                maxkey = item;
            }
        }

        System.out.println(maxkey+" ");

        for(int i=0; i<cnt; i++){
            Map<String, Integer> mapList = arrList.get(i);
            Set<String> tmpSet = mapList.keySet();

            if(tmpSet.contains(maxkey)){
                System.out.print(i+1+" ");
            }
        }




    }
}
