import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int maxValue = 0;
        int xIdx =1;
        int yIdx =1;
        
        
        for(int i =1; i<=9; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=9; j++){
                int nowNum = Integer.parseInt(st.nextToken());
                if(nowNum > maxValue){
                    maxValue = nowNum;
                    xIdx = i;
                    yIdx = j;
                }
            }
        }
        System.out.println(maxValue);
        System.out.println(xIdx+" "+yIdx);
    
    }
}
