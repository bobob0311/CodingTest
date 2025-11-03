import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String nowStr = br.readLine();
        int startIdx = 0;
        int endIdx = nowStr.length() -1;
        
        while(startIdx <endIdx){
            if(nowStr.charAt(startIdx) != nowStr.charAt(endIdx)){
                System.out.println(0);
                return;
            }
            startIdx++;
            endIdx--;
        }
        System.out.println(1);
    }
}
