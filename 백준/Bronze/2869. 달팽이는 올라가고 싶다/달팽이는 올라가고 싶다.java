import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int upStep = Integer.parseInt(st.nextToken());
        int downStep = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        
        int prevTarget = target - upStep;
        int cnt = prevTarget / (upStep - downStep);
        if(prevTarget % (upStep - downStep) !=0){
            cnt++;
        }
        System.out.println(cnt +1);
    }
}
