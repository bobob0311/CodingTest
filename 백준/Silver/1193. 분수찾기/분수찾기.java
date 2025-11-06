import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int targetNum = Integer.parseInt(br.readLine());
        int line = 1;
        int value = 1;
        while(true){
            if(value >= targetNum){
                break;
            }
            line++;
            value+=line;
        }
        int rest = (targetNum - (value - line)) % (line + 1);
        if(line % 2 == 0) System.out.println(rest+"/"+(line-rest +1));
        if(line % 2 != 0) System.out.println((line-rest + 1)+"/"+rest);
       
    }
}
