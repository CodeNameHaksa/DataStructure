import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class boj_16472 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();
        int start = 0;
        int end = 1;
        int tmp = 1;
        int alpha[]  = new int[26];
        int len = end-start; //현재 문자열의 길이
        int indexTmp = 0;
        int ans =0;
        alpha[input.charAt(0) - 97]++;

        while(start<=end){

            if(end==input.length()){
                if(ans<len&&tmp<N){
                    ans = len;
                }
                break;
            }

            if(tmp>N){
                indexTmp = input.charAt(start)-97;
                alpha[indexTmp]--;
                start++;
                len--;
                if(alpha[indexTmp]==0){
                    tmp--;
                }
            }else {
                indexTmp = input.charAt(end) - 97;
                if (alpha[indexTmp] == 0) {
                    tmp++;
                }
                alpha[indexTmp]++;
                len++;
                end++;
                if (tmp <= N) {

                    if (len > ans) {
                        ans = len;
                    }

                }
            }
        }
        System.out.println(ans);
    }
}
