import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] bucket = new int[26];
        int max = 0;
        for(int i = 0; i<str.length();i++){
            int nowCode = (int) str.charAt(i);
            if(nowCode >= 97) nowCode-=97;
            if(nowCode >= 65) nowCode-=65;
            bucket[nowCode] +=1;
            if(bucket[nowCode] > max) max = bucket[nowCode];
        }
        char answer = '?';
        for(int i = 0; i<26;i++){
            if(bucket[i] == max){
                if(answer == '?') {
                    answer = (char) (65+ i);
                }else{
                    answer = '?';
                    break;
                }
                
            }
        }
        System.out.println(answer);
        
        }
}
