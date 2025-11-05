import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i< N; i++){
            int num = Integer.parseInt(br.readLine());
            int one = calc(num,sb,25);
            int two = calc(one,sb,10);
            int three = calc(two,sb,5);
            int four = calc(three,sb,1);
            sb.append('\n');
        }
        System.out.println(sb.toString());
    }
    static public int calc(int target,StringBuilder sb,int num){
        sb.append(target/num+" ");
        return target % num;
    }
}
