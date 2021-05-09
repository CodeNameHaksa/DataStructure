import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class Money implements Comparable<Money> {
    int sum;
    String name;

    public Money(String name, int sum){
        this.sum = sum;
        this.name = name;
    }

    @Override
    public int compareTo(Money o) {
        return this.sum - o.sum;
    }
}

public class a {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static HashMap<String, Integer> person = new HashMap<>();
    static ArrayList<Money> ans = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        String s = "";

        while ((s = br.readLine()) != null){
            String[] temp = s.split(" ");
            if (person.containsKey(temp[2])){
                int val = person.get(temp[2]);
                person.put(temp[2], val + Integer.parseInt(temp[1]));
            }else {
                person.put(temp[2], Integer.parseInt(temp[1]));
            }
        }

        for (String item : person.keySet())
            ans.add(new Money(item, person.get(item)));

        Collections.sort(ans);
        for (Money item : ans)
            System.out.println(item.name);
    }
}
