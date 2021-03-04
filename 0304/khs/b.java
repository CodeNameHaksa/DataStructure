import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int N = Integer.parseInt(input);
        int cnt = 0;

        for(int i=0;i<N;i++){
            input = br.readLine();
            cnt+=input.length();
            for(int j=0;j<input.length();j++){
                if(input.charAt(j)=='\t') {
                    cnt-=1;
                }else if(input.charAt(j)==' '){
                    cnt-=1;
                }else if(input.charAt(j)=='\n'){
                    cnt-=1;
                }
            }
        }

        System.out.println(cnt);

    }
}
