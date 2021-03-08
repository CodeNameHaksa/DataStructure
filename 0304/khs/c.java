import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        input = br.readLine();
        StringTokenizer st = new StringTokenizer(input," ");
        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        ArrayList<Participant> p = new ArrayList<Participant>();
        for(int i=0;i<N;i++){
            input = br.readLine();
            st = new StringTokenizer(input, " ");
            Participant tmp = new Participant(st.nextToken(),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            p.add(tmp);
        }
        Collections.sort(p);
        System.out.println(p.get(R-1).name);


    }
}


class Participant implements Comparable<Participant> {
    public String name;
    public int score;
    public int tries;
    public int time;

    public Participant(String name, int score, int tries, int time) {
        this.name = name;
        this.score = score;
        this.tries = tries;
        this.time = time;
    }

    @Override
    public int compareTo(Participant o) {
        //내림차순 정렬 -> (비교대상 -> this)
        //오름차순 정렬 -> (this -> 비교대상)
        //가만히 냅두는게 음
        if(o.score-this.score!=0){
            return o.score-this.score;
        }else {
            if(o.tries-this.tries!=0){
                return this.tries-o.tries;
            }else{
                if(o.time-this.time!=0){
                    return o.time-this.time;
                }else{
                    return this.name.compareTo(o.name);
                }
            }
        }

    }
}
