import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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
        // compareTo 의 경우 양수를 리턴 하는 경우 두 값의 위치를 교체하여야 한다.
        // 고로 내림차순을 원한다면, 뒤에 오는 값이 더 크다면 바꿔야 하기 때문에 양수를 리턴하게 한다.
        if (this.score < o.score)
            return 1;
        else if (this.score > o.score)
            return -1;

        else {
            if (this.tries > o.tries)
                return 1;
            else if (this.tries < o.tries)
                return -1;

            else {
                if (this.time < o.time)
                    return 1;
                else if (this.time > o.time)
                    return -1;

                else {
                    // 이름의 경우 오름차순으로 만들려고 한다.
                    // this를 기준으로 비교를 할 경우 오름차순이 만들어 지고
                    // o를 기준으로 비교를 할 경우 내림차순이 생김
                    // 이는 compareTo가 문자열을 어떻게 비교하는지 알아봐야 할 듯
                    return this.name.compareTo(o.name);
                }
            }
        }
    }
}

public class Find_Acha {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        List<Participant> data = new ArrayList();
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            Participant temp = new Participant(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            data.add(temp);
        }
        // 언제나 리스트에 대해서 정렬이 가능하다.
        Collections.sort(data);

        for(Participant temp : data){
            System.out.print(temp.name + " ");
            System.out.print(temp.score + " ");
            System.out.print(temp.tries + " ");
            System.out.print(temp.time + " \n");
        }
        Participant temp = data.get(r - 1);
        System.out.println(temp.name);
    }
}
