import java.io.*;
import java.util.*;

/*
M * N 보드를 찾음

K * K 크기의 체스판으로 만들거임
K * K로 자른 다음에 몇개의 정사각 형 다시 칠할 건데 정사격형의 최소 개수를 구해라
*/

public class Main {
    static int N,M,size;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        size = Integer.parseInt(st.nextToken());

        boolean[][] map = new boolean[N][M];

        for(int i = 0; i<N; i++){
            String nowStr = br.readLine();
            for(int j = 0; j<M; j++){
                if(nowStr.charAt(j) == 'B') map[i][j] = true;
            }
        }

        int[][] sum = new int[N+1][M+1];

        for(int i = 0; i<N; i++){
            for(int j = 0; j<M; j++){
                int val = 0;
                if((i+j) % 2 == 0){
                    if(!map[i][j]) val = 1;
                }else{
                    if(map[i][j]) val = 1;
                }
                sum[i+1][j+1] = val + sum[i][j+1] + sum[i+1][j] - sum[i][j];
            }
        }

        int answer = size * size;

        for(int i = 0; i<= N-size; i++){
            for(int j =0; j<=M-size;j++){
                int r1 = i + size;
                int c1 = j + size;

                int cntB = sum[r1][c1] - sum[i][c1] - sum[r1][j] + sum[i][j]; // 왼쪽 위 B 패턴
                int cntW = size * size - cntB; // 반대 패턴

                if (cntB < answer) answer = cntB;
                if (cntW < answer) answer = cntW;
            }
        }
        System.out.println(answer);
    }
}
