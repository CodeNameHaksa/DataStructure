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

            if(end==input.length()){ //end가 끝까지 간 경우
                if(ans<len&&tmp<N){ //정답의 업데이트가 필요한 경우. 문자의 종류의 갯수가 조건보다 적으면 답을 업데이트.  
                    ans = len;
                }
                break;
            }

            if(tmp>N){ //알파벳 종류의 수가 주어진 수보다 클 때
                indexTmp = input.charAt(start)-97;
                alpha[indexTmp]--; //알파벳 지우기
                start++; //start 한 칸 넘겨
                len--; //길이도 줄인다.
                if(alpha[indexTmp]==0){ //문자가 사라졌다면, 종류의 갯수를 줄인다.
                    tmp--;
                }
            }else {
                indexTmp = input.charAt(end) - 97;
                if (alpha[indexTmp] == 0) { //처음 등장한 알파벳이라면?
                    tmp++; //문자의 종류 갯수 증가
                }
                alpha[indexTmp]++; //알파벳 등장 기록 증가
                len++; //문자 길이 증가
                end++; //현재 알파벳 종류의 수가 주어진 수보다 적거나 같다는 것이므로, end를 한칸 증가시킴.

                if (tmp <= N) { //문제에서 주어진 조건에 부합하면 답을 업데이트.
                    if (len > ans) {
                        ans = len;
                    }

                }


            }
        }
        System.out.println(ans);
    }
}
