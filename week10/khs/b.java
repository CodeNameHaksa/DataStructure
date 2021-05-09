import java.io.*;
import java.util.*;

public class b {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{

        b b = new b();
        b.solution();
        
    }
    public static void solution()throws IOException {
        String s = null;
        String[] sarr = null;
        Map<String, Integer> dic = new HashMap<>();
        ArrayList<people> p = new ArrayList<>();

        while((s = br.readLine())!=null){
            sarr = s.split(" ");
            String name = sarr[0];
            int[] list = new int[sarr.length-2];
            for(int i = 0; i < list.length; i++){
                list[i] = Integer.parseInt(sarr[i+1]);
            }
            dic.put(name, hindex(list));
        }


        for(String key : dic.keySet()){
            p.add(new people(key, dic.get(key)));
        }

        Collections.sort(p);
        System.out.println(p.get(0));

    }



    public static int hindex(int[] citations){
        int answer = 0;
        int[] tmp = citations;
        Arrays.sort(tmp);
        for(int i = 0; i < tmp.length; i++){
            if(tmp[tmp.length-1-i] >= i+1){
                answer++;
                continue;
            }else{
                break;
            }
        }

        return answer;
    }


    static class people implements Comparable<people>{

        String name;
        int index;

        public people(String name, int index){
            this.name = name;
            this.index = index;
        }

        @Override
        public int compareTo(people o) {
            return o.index - this.index;
        }

        public String toString(){
            return this.name;
        }
    }
}
