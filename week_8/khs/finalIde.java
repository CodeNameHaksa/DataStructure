import java.io.*;
import java.util.*;

class cell {
    HashMap<String, Integer> map;
    int value = 0;
    int max = 0;
    int bracket = 1;

    public cell(HashMap<String, Integer> map, int max, int bracket, int value) {
        this.map = map;
        this.value = value;
        this.max = max;
        this.bracket = bracket;
    }

    public cell(HashMap<String, Integer> map, int max, int bracket) {
        this.map = map;
        this.max = max;
        this.bracket = bracket;
    }

    public cell(int bracket){
        this.bracket = bracket;
    }


}

public class ide {
    public static String[] right = new String[]{")", "}", "]"};
    public static String[] left = new String[]{"(", "{", "["};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().toLowerCase();
        str = str.replaceAll("\\t", " ");
        String[] sarr = str.trim().split(" ");
        Stack<cell> st = new Stack<>();
        boolean flag = false;
        HashMap<String, Integer> data = new HashMap<>();
        st.push(new cell(data, 0, 0, 0)); // 초기값 설정

        if (inArray(left, sarr[0]) == -1) {
            flag = true;
        }


        for (int i = 0; i < sarr.length; i++) {
            String s = sarr[i].trim();
            HashMap<String, Integer> map = new HashMap<>();

            if (flag) { //만약 괄호가 아닌 문자로 시작하는 경우
                map.put(s, 1);
                st.pop();
                st.push(new cell(map, findMax(map), 1));
                flag = !flag;
            } else {
                map = new HashMap<>();
                if (inArray(left, s) != -1) { //새로운 괄호가 등장한 경우
                    int b = inArray(left, s) + 2;
                    st.push(new cell(map, 0, b, 0)); // 빈 스택을 추가
                    continue;
                } else if (inArray(right, s) != -1) { // 닫는 괄호라면?
                    int b = inArray(right, s) + 2;
                    cell c = st.pop(); // 스택에서 하나 꺼낸다.
                    if(b!=c.bracket){ //꺼낸 cell과 현재 입력받은 괄호 비교해서 같은지 확인
                        System.out.println("-1");
                        System.exit(0);
                    }
                    st.peek().value += (c.max + c.value) * c.bracket;
                    continue;
                } else if (inArray(left, s) == -1 && inArray(right, s) == -1) { //문자열이라면
                    map = st.peek().map;
                    if (map.containsKey(s)) {
                        map.put(s, map.get(s) + 1);
                    } else {
                        map.put(s, 1);
                    }
                    st.peek().max = findMax(map);
                    continue;
                }
            }
        }
        cell ans = st.pop();
        if(st.size()==0){
            System.out.println(ans.value + ans.max);
        }else{
            System.out.println("-1");
        }

    }

    public static int inArray(String[] arr, String s) {
        for (int i = 0; i < arr.length; i++) {
            if (s.equals(arr[i])) {
                return i;
            }
        }
        return -1;
    }

    public static int findMax(HashMap<String, Integer> map) {
        int max = 0;
        HashMap<String, Integer> data = map;

        for (String key : data.keySet()) {
            if (data.get(key) > max) {
                max = data.get(key);
            }
        }

        return max;
    }
}
