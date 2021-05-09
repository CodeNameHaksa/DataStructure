import java.io.*;
import java.util.*;

public class c {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] sarr = input.split(" ");
        int pNum = Integer.parseInt(sarr[0]);
        int end = Integer.parseInt(sarr[1]);
        ArrayList<people> pList = new ArrayList<>();

        for (int i = 0; i < pNum; i++) {
            sarr = br.readLine().split(" ");
            pList.add(new people(Integer.parseInt(sarr[0]), Integer.parseInt(sarr[1]), (end - Integer.parseInt(sarr[0])) / Integer.parseInt(sarr[1])));
        }

        Collections.sort(pList);
        int now = 0;
        int cnt = 0;
        for(people p : pList){
            if(now < p.max){
                now = p.max;
                cnt++;
            }
        }

        System.out.println(cnt);


    }

    public static class people implements Comparable<people> {
        int start;
        int v;
        int max;

        public people(int start, int v, int max) {
            this.start = start;
            this.v = v;
            this.max = max;
        }

        @Override
        public int compareTo(people o) {
            return o.start - this.start;
        }

        public String toString(){
            return String.valueOf(this.start);
        }


    }

}

