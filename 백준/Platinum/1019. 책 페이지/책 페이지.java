import java.io.*;
import java.util.*;

// 1 ~ N 페이지 안에 각 숫자가 전체 페이지 번호에서 모두 몇버 나오는지 구해보자

public class Main {
    static StringTokenizer st;

    static long N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        N = Long.parseLong(br.readLine());
        long[] counts = new long[10];
        long digit = 1;

        while(digit <= N){
            // 위의 자리수
            long high = N / (digit * 10);
            // 현재 자리수
            long current = (N / digit) %10;
            // 아래 자리수
            long low = N % digit;
            for(int i =0; i<=9; i++){
                counts[i] += high * digit;
                if(i < current){
                    counts[i] +=digit;
                }else if(i == current){
                    counts[i] +=low + 1;
                }
            }
            counts[0] -= digit;
            digit *= 10;
        }
        StringBuilder sb = new StringBuilder();
        for(long cnt: counts) sb.append(cnt).append(" ");


        System.out.println(sb.toString());


    }


}