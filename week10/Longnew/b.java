import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Person implements Comparable<Person>{
    String name;
    int num;

    public Person(String name, int num){
        this.name = name;
        this.num = num;
    }

    @Override
    public int compareTo(Person o) {
        // 내림차순으로 정렬이 필요.
        // 가장 큰 1등을 찾으니까.
        return o.num - this.num;
    }
}

public class b {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<Person> data = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        String s = "";

        while ((s = br.readLine()) != null){
            String[] temp = s.split(" ");
            int[] temp_num = new int[temp.length - 1];

            for (int i = 1; i < temp.length; i++)
                temp_num[i - 1] = Integer.parseInt(temp[i]);

            Arrays.sort(temp_num);

            for (int i = 0; i < temp_num.length; i++){
                int cnt = temp_num.length - i;

                if (cnt <= temp_num[i]) {
                    data.add(new Person(temp[0], cnt));
                    break;
                }
            }
        }

        Collections.sort(data);
        System.out.println(data.get(0).name);
    }
}
