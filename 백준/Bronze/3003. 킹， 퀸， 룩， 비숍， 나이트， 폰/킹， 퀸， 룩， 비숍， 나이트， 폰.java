import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] targetArr = new int[] {1,1,2,2,2,8};
        int[] arr = new int[6];
        for(int i = 0; i<6; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i<6; i++){
            int gap = targetArr[i] - arr[i];
            sb.append(gap+" ");
        }
        System.out.println(sb.toString());
    }
}
