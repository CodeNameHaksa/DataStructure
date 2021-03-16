import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class printer {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);
        int pilLeng = Integer.parseInt(st.nextToken())+1;
        long[] pillar = new long[pilLeng];
        int N = Integer.parseInt(st.nextToken());
        int start = 0;
        int end = 0;
        int tmp = 0;
        for(int i=0;i<N;i++){
            input = br.readLine();
            st = new StringTokenizer(input);
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            tmp = Integer.parseInt(st.nextToken());
            pillar[start-1]+=tmp;
            pillar[end]-=tmp;
        }



        for(int i=1;i<pilLeng;i++){
            pillar[i]+=pillar[i-1];
        }

        long max = pillar[0];
        for(int i=1;i<pilLeng;i++){
            if(max<pillar[i]){
                max = pillar[i];
            }
        }

        System.out.println(max);

    }
}
