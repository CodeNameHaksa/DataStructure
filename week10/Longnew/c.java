import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

class Human implements Comparable<Human>{
    int where, speed, times;

    public Human(int where, int speed, int times){
        this.where = where;
        this.speed = speed;
        this.times = times;
    }
    @Override
    public int compareTo(Human o){
        return o.where - this.where;
    }
}

public class c {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<Human> data = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        String[] temp = br.readLine().split(" ");
        int participant = Integer.parseInt(temp[0]);
        int end = Integer.parseInt(temp[1]);

        for (int i = 0; i < participant; i++){
            temp = br.readLine().split(" ");
            int where = Integer.parseInt(temp[0]);
            int speed = Integer.parseInt(temp[1]);
            data.add(new Human(where, speed, (end - where) / speed));
        }
        Collections.sort(data);
        int ans = 0;
        int now = 0;

        for (Human item : data){
            if (now < item.times){
                now = item.times;
                ans++;
            }
        }

        System.out.println(ans);
    }
}
