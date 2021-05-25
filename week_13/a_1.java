import java.io.*;

public class a_1 {
    public static String[] data;
    public static int K;
    public static int M;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sData = br.readLine().split(" ");
        K  = Integer.parseInt(sData[0]);
        M  = Integer.parseInt(sData[1]);
        data = new String[K];

        for(int i = 0; i < M; i++){
            sData = br.readLine().split(" ");
            hash(sData[0], sData[1]);
        }

        for(int i = 0; i < K; i++){
            if(data[i] != null){
                System.out.print(data[i]+" ");
            }
        }

    }

    public static void hash(String key, String value){
        int cnt = 0;
        for(int i = 0; i < K; i++){
            if(data[i] == null){
                cnt++;
            }
        }

        if(cnt == 0){
            return;
        }

        if(data[Integer.parseInt(key)%K] == null){
            data[Integer.parseInt(key)%K] = value;
        }else{
            int keyIndex = Integer.parseInt(key);
            while(data[keyIndex%K]!=null){
                keyIndex++;
            }
            data[keyIndex] = value;
        }
    }

}
