import java.util.*;
import java.io.*;

class Thing{
    int value = 0;
    int max = 0;
    String bracket;
    HashMap<String, Integer> map = new HashMap<>();

    public Thing(String bracket){
        this.bracket = bracket;
    }
}

public class ide {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Stack<Thing> stack = new Stack<>();
    // cnt의 존재로 현재 보고있는 괄호 안의 문자열이 어디에 위치하는지 알 수 있다.
    public static void main(String[] args) throws IOException{
        String s = "";
        stack.push(new Thing("z"));
        int ans = 0;

        while((s = br.readLine()) != null){
            String[] words = s.split(" ");

            for (int i = 0; i < words.length; i++){
                String target = "";
                Thing thing = stack.peek();
                for (int j = 0; j < words[i].length(); j++){
                    Character ch = words[i].charAt(j);
                    if ('A' <= ch && ch <= 'Z') {
                        target += (char) (ch + 32);
                        continue;
                    }
                    target += ch;
                }

                if (target.equals(""))
                    continue;

                if (target.equals("(") || target.equals("{") || target.equals("[")){
                    stack.push(new Thing(target));
                    continue;

                }else if(target.equals(")") || target.equals("}") || target.equals("]")){
                    if (thing.bracket.equals("z")){
                        System.out.println(-1);
                        System.exit(0);
                    }

                    if (target.equals(")") && !thing.bracket.equals("(")){
                        System.out.println(-1);
                        System.exit(0);

                    }else if (target.equals("}") && !thing.bracket.equals("{")){
                        System.out.println(-1);
                        System.exit(0);

                    }else if (target.equals("]") && !thing.bracket.equals("[")){
                        System.out.println(-1);
                        System.exit(0);

                    }else {
                        Thing good = stack.pop();
                        good.max += good.value;
                        Thing prev = stack.peek();

                        if (good.bracket.equals("(")){
                            prev.value += good.max * 2;
                        }else if(good.bracket.equals("[")){
                            prev.value += good.max * 4;
                        }else{
                            prev.value += good.max * 3;
                        }
                    }
                    continue;
                }

                // 괄호가 아닌 나머지 값.
                // Thing thing으로 선언해둠.
                if(thing.map.containsKey(target)){
                    int val = thing.map.get(target);
                    thing.map.put(target, val + 1);

                    if (thing.max < val + 1)
                        thing.max = val + 1;
                }else{
                    thing.map.put(target, 1);

                    if(thing.max < 1)
                        thing.max = 1;
                }
            }
        }

        Thing answer = stack.pop();
        if (answer.bracket.equals("z")){
            System.out.println(answer.max + answer.value);
        }else{
            System.out.println(-1);
        }
    }
}
