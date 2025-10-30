import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            String str = st.nextToken();
            for(int j = 0; j<str.length(); j++){
                char nowChar = str.charAt(j);
                for(int k = 0; k<num; k++) sb.append(nowChar);
            }
            System.out.println(sb.toString());
            sb.setLength(0);
        }
        
        
    }
}
