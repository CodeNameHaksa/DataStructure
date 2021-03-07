package sort;

import java.util.*;

class Player implements Comparable<Player>{
    String name;
    int score;

    Player(String name, int score){
        this.name = name;
        this.score = score;
    }

    @Override
    public int compareTo(Player o) {
        return o.score - this.score;
    }
}
public class compare {
    public static void main(String[] args) {

        List<Player> players = new ArrayList<>();
        players.add(new Player("Alice", 899));
        players.add(new Player("Bob", 982));
        players.add(new Player("Chloe", 1090));
        players.add(new Player("Dale", 982));
        players.add(new Player("Eric", 1018));

        int[] scores = {899, 982, 1090, 982, 1018};
        Arrays.sort(scores);
        System.out.println(Arrays.toString(scores));

        // 클래스에 comparable을 implement 하여서 정렬 순서를 만든다.
        // 그러나, 한 클래스에 하나의 규칙만을 만들기 때문에
        // 여러 규칙을 만들기 힘들다.
        Collections.sort(players);
        for (int i = 0; i < players.size(); i++){
            System.out.println(players.get(i).name);
        }

        // 익명 클래스로 comparator 를 만든 후에
        // compare 메소드에 내가 원하는 정렬 방식을 입력한다.
        Comparator<Player> comparator = new Comparator<Player>() {
            @Override
            public int compare(Player o1, Player o2) {
                return o1.score - o2.score;
            }
        };

        Collections.sort(players, comparator);
        for (int i = 0; i < players.size(); i++){
            System.out.println(players.get(i).name);
        }

        // 눈에 가장 잘 보이는 람다 함수로
        // 비교할 두 값을 파라미터로 집어넣은 후에
        // 비교할 값을 나타내면 된다.
        Collections.sort(players, (a, b) -> b.score - a.score);
        for (int i = 0; i < players.size(); i++){
            System.out.println(players.get(i).name);
        }
    }

}
