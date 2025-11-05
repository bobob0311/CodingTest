import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int targetNum = Integer.parseInt(st.nextToken());
        int powNum = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        
        while(targetNum >=powNum){
            int front = targetNum % powNum;
            targetNum/= powNum;
            sb.append(transform(front));
        }
        sb.append(transform(targetNum));
        System.out.println(sb.reverse().toString());
    }
    static public char transform(int num){
        if(num < 10) return (char) (num + 48);
        return (char) (num + 55);
    }
}