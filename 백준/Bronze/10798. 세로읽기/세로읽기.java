import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strArr = new String[5];
        int maxLength = 0;
        for(int i = 0; i<5; i++){
            String nowStr = br.readLine();
            strArr[i] = nowStr;
            maxLength = Math.max(maxLength,nowStr.length());
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i< maxLength; i++){
            for(int j = 0; j< 5; j++){
                if(strArr[j].length() >i){
                    sb.append(strArr[j].charAt(i));
                }
            }
        }
        System.out.println(sb.toString());
        
        
    }
}
