import java.io.*;
import java.util.*;

/*
가장 많은 고층 빌딩이 보이는 고층 빌딩을 찾으려고한다.
N개 빌딩있음

지붕을 잇는 선분이 A와 B를 제외한 다른 빌딩을 지나거나 접하지 않아야한다.
*/



public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N;
    static long[] heights;
    static int[] count;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        heights = new long[N];
        count = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            heights[i] = Long.parseLong(st.nextToken());
        }
        for(int i = 0; i<N; i++){
            for(int j = i+1; j<N; j++){
                if(isCan(i,j)) {
                    count[i]++;
                    count[j]++;
                };
            }
        }

        int max = 0;
        for(int i = 0; i<N; i++){
            max = Math.max(max,count[i]);
        }
        System.out.println(max);

    }
    static boolean isCan(int nowIdx, int targetIdx){
        long diff = heights[targetIdx] - heights[nowIdx];
        double f = (double) diff / (targetIdx - nowIdx);

        long nowHeight = heights[nowIdx];
        for(int i = nowIdx +1; i<targetIdx; i++){
            if(heights[i] >= nowHeight + (i-nowIdx)*f) return false;
        }
        return true;
    }
}