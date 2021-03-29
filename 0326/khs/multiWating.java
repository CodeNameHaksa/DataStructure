import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class multiWaiting {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String[] strArr = null;
    public static void main(String[] args)throws IOException {
        strArr = br.readLine().split(" ");
        int N = Integer.parseInt(strArr[0]);
        int M = Integer.parseInt(strArr[1]);
        PriorityQueue<Integer> clerk = new PriorityQueue<>();
        PriorityQueue<person> custmr = new PriorityQueue<>();
        double ans =0;

        for(int i=0;i<N;i++){
            clerk.add(0);
        }
        for(int i = 0;i<M;i++){
            strArr = br.readLine().split(" ");
            custmr.add(new person(Integer.parseInt(strArr[0]), Integer.parseInt(strArr[1])));
        }

        while(!custmr.isEmpty()){
            person tmpCustmr = custmr.poll();
            int tmpClerk = clerk.poll();
            if(tmpClerk > tmpCustmr.l){
                ans+=tmpClerk-tmpCustmr.l;
                clerk.add(tmpClerk+tmpCustmr.k);
            }else{
                clerk.add(tmpCustmr.l+tmpCustmr.k);
            }
        }

        ans /= M;
        System.out.println(Math.round(ans*100)/100.0);

    }

}


class person implements Comparable<person>{
    int l, k;

    person(int l, int k){
        this.l = l;
        this.k = k;
    }
    @Override
    public int compareTo(person o) {
        return this.l - o.l;
    }
}


