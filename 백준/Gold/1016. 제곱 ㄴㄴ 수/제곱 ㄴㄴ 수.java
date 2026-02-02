import java.io.*;
import java.util.*;

// 정수의 제곱으로 나눠지지 않는 구간안에 수를 찾아라

public class Main {
    static StringTokenizer st;

    static long min,max;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());

        min = Long.parseLong(st.nextToken());
        max = Long.parseLong(st.nextToken());

        boolean[] chk = new boolean[(int)(max-min) +1];

        long nowX = 2;

        while(nowX <= 1000000){
            // 현재 확인하려고하는 제곱 수
            long nowXX = nowX * nowX;
            // 나눠서 최소 찾기
            long nowIdx =  ((min -1) / nowXX);
            long value = nowIdx * nowXX + nowXX;

            while(max >= value){
                chk[(int)(value - min)] = true;
                value+= nowXX;
            }

            nowX++;
        }

        int cnt = 0;

        for(int i = 0; i< chk.length; i++){
            if(!chk[i]) cnt++;
        }

        System.out.println(cnt);
    }


}