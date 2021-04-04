import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class c {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String sarr[] = null;
        ArrayList<HashMap<String, Integer>> hsList = new ArrayList<>();
        HashSet<String> tmp = new HashSet<>();



        for (int i = 0; i < N + N - 1; i++) {
            HashSet<String> hsTmp = new HashSet<>();
            HashMap<String, Integer> hsMap = new HashMap<>();
            String s = br.readLine();

            if (s.length() > 0) {
                sarr = s.split("[\\W_]+");
                for (int j = 0; j < sarr.length; j++) {
                    hsTmp.add(sarr[j].toLowerCase());

                    if (hsMap.containsKey(sarr[j].toLowerCase())) {
                        hsMap.put(sarr[j].toLowerCase(), hsMap.get(sarr[j].toLowerCase()) + 1);
                    } else {
                        hsMap.put(sarr[j].toLowerCase(), 1);
                    }
                }
                hsList.add(hsMap);
            } else {
                continue;
            }

            if(tmp.size()==0){
                tmp.addAll(hsTmp);
            }else{
                tmp.retainAll(hsTmp);
            }

        }

        System.out.println(tmp.toString());




        for(int i=0;i<N;i++){
            HashMap<String, Integer> tmpMap = hsList.get(i);
            int cnt =0;
            int max = 0;
            String maxKey = "";

            for(String key : tmpMap.keySet()){
                if(!tmp.contains(key)) {
                    if(max<tmpMap.get(key)){
                        max = tmpMap.get(key);
                        maxKey = key;
                    }
                    cnt+=tmpMap.get(key);
                }
            }

//            System.out.println(maxKey);
//            System.out.println(max);
//            System.out.println(cnt);
            System.out.println(maxKey+" "+Math.round((double)max/cnt*100)/100.0);


        }




    }
}
