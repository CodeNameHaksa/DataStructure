import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class a {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        // ans의 경우 idx 몇 번째에서 뒤집을 건지 알기 위해 존재.
        // 근데 idx와 다르게 세아릴 때는 1부터 세니까 1에서 시작.
        int cnt = 1;
        int idx = 0;
        // 오름차순으로 이미 정렬되어 있는 경우를 예외 처리 하기 위함.
        int now = Integer.parseInt(st.nextToken());

        while (st.hasMoreTokens()){
            int temp = Integer.parseInt(st.nextToken());
            if (now > temp)
                idx = cnt;

            now = temp;
            cnt++;
        }

        int back = cnt - idx;
        if (idx > back)
            System.out.println(back);
        else
            System.out.println(idx);
    }
}

/*
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        String[] temp = br.readLine().split(" ");

        int[] data = new int[temp.length];
        for(int i = 0; i < temp.length; i++)
            data[i] = Integer.parseInt(temp[i]);

        int idx = 0;
        for(int i = 0; i < temp.length - 1; i++){
            if (data[i] > data[i + 1])
                idx = i + 1;
        }
        int idx_co = temp.length - idx;

        if (idx_co < idx)
            System.out.println(String.valueOf(idx_co));
        else
            System.out.println(String.valueOf(idx));
    }
}
*/
