import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] map = new int[101][101];
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            for(int j = x; j< x+10; j++){
                if(j>100) continue;
                for(int k = y; k < y+10; k++){
                    if(k>100) continue;
                    map[j][k] = 1;
                }
            }
        }
        int cnt = 0;
        for(int i = 1; i<101; i++){
            for(int j =1; j<101; j++){
                if(map[i][j] ==1) cnt++;
            }
        }
        System.out.println(cnt);
    }
}
