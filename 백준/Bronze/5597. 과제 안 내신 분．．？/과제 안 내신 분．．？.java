import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] chk = new boolean[31];
        for(int i = 0; i< 28; i++){
            int target = Integer.parseInt(br.readLine());
            chk[target] = true;
        }
        StringBuilder sb = new StringBuilder();
        
        for(int i = 1; i< 31; i++){
            if(!chk[i]) System.out.println(i);
        }
    }
}