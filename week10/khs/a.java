import java.io.*;
import java.util.*;

public class a {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {

        a aa = new a();
        a.sol();

    }

    public static void sol()throws IOException{
        String s = null;
        String[] sarr = null;
        HashMap<String, Integer> dic = new HashMap<>();

        while(!((s=br.readLine()) == null)){
            sarr = s.split(" ");
            if(dic.containsKey(sarr[2])){
                dic.put(sarr[2], dic.get(sarr[2])+Integer.parseInt(sarr[1]));
            }else{
                dic.put(sarr[0], Integer.parseInt(sarr[1]));
            }
        }

        ArrayList<people> pList = new ArrayList<>();

        for(String key : dic.keySet()){
            pList.add(new people(key, dic.get(key)));
        }

        Collections.sort(pList);

        for(people p : pList){
            System.out.println(p);
        }


    }

    static class people implements Comparable<people>{

        String name;
        int salary;

        public people(String name, int salary){
            this.name = name;
            this.salary = salary;
        }

        @Override
        public int compareTo(people o) {
            return this.salary - o.salary;
        }

        public String toString(){
            return this.name;
        }
    }


}
