import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2263_traversal {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int inOrder[] = new int[100000];
    static int postOrder[] = new int[100000];
    static int position[] = new int[100001];

    static void solve(int is, int ie, int ps, int pe){
        if (is > ie || ps > pe)
            return;

        int root = postOrder[pe];
        System.out.print(root + " ");

        // inOrder에서의 위치를 찾음
        int inRoot = position[root];

        // postOrder에서 왼쪽에 존재하는 자식의 수
        int left = inRoot - is;

        solve(is, inRoot - 1, ps, ps + left - 1);
        solve(inRoot + 1, ie, ps + left, pe - 1);

    }
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        String[] temp = br.readLine().split(" ");
        int cnt = 0;
        for (String data : temp)
            inOrder[cnt++] = Integer.parseInt(data);

        temp = br.readLine().split(" ");
        cnt = 0;
        for (String data : temp)
            postOrder[cnt++] = Integer.parseInt(data);

        // postOrder에서 찾은 루트 노드가 inOrder에서 몇 번째 인덱스에 있는지를 알아야 하기 때문에
        // 이를 저장해 둬야 한다.
        for (int i = 0; i < n; i++)
            position[inOrder[i]] = i;

        solve(0, n - 1, 0, n - 1);
    }
}
