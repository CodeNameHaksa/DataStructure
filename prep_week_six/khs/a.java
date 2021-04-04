import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

public class a {
    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sarr = br.readLine().split(" ");
        int N = Integer.parseInt(sarr[0]);
        int M = Integer.parseInt(sarr[1]);
        ArrayList<HashSet<String>> setList = new ArrayList<>();
        for(int i=0;i<N;i++){
            setList.add(new HashSet<>());
        }

        for(int i=0;i<M;i++){
            sarr = br.readLine().split(" ");
            int tmp = Integer.parseInt(sarr[0]);
            String tmpS = sarr[1];
            setList.get(tmp).add(tmpS);
        }

        int K = Integer.parseInt(br.readLine());


        for(int i=0;i<K;i++){

            sarr = br.readLine().split(" ");
            String choice = sarr[0];
            int[] iarr = new int[3];

            HashSet<String> tmp = new HashSet<>();

            if(choice.equals("U")){
                tmp.addAll(setList.get(Integer.parseInt(sarr[1])));
                tmp.addAll(setList.get(Integer.parseInt(sarr[2])));
                tmp.addAll(setList.get(Integer.parseInt(sarr[3])));
                System.out.println(tmp.size());

            }else if(choice.equals("I")){
                tmp.addAll(setList.get(Integer.parseInt(sarr[1])));
                tmp.retainAll(setList.get(Integer.parseInt(sarr[2])));
                tmp.retainAll(setList.get(Integer.parseInt(sarr[3])));
                System.out.println(tmp.size());

            }else if(choice.equals("D")){
                tmp.addAll(setList.get(Integer.parseInt(sarr[1])));
                tmp.removeAll(setList.get(Integer.parseInt(sarr[2])));
                tmp.removeAll(setList.get(Integer.parseInt(sarr[3])));
                System.out.println(tmp.size());
            }
        }

    }

}
