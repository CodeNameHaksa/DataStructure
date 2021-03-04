import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


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
        
        return 0;
    }
}
