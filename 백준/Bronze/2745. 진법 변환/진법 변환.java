import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;
        String target = st.nextToken();
        int num = Integer.parseInt(st.nextToken());
        for(int i = 0; i < target.length(); i++){
            char nowChar = target.charAt(i);
            int targetNum = (int) nowChar;
            if(targetNum >= 65){
                targetNum-= 55;
            }else{
                targetNum -= 48;
            }
            answer += Math.pow(num,target.length() - i -1) * targetNum;
        }
        System.out.println(answer);
    }
}
