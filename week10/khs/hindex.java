import java.io.*;
        import java.util.*;

class Solution {

    public int solution(int[] citations) {
        int[] tmp = citations;
        Arrays.sort(tmp);
        int answer = 0;
        for(int i = 0; i < tmp.length; i++){
            if(tmp[tmp.length-1-i] >= i+1){
                answer++;
                continue;
            }else{
                break;
            }
        }
        return answer;
    }

}
