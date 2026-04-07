import java.io.*;
import java.util.*;

/*
소문자로 이루어진 문자열 W
양의 정수 K

어떤 문자를  K 포함하는 가장 짧은 연속 문자열의 길이
어떤 문자를 포함하고 첫번째와 마지막 글자가 해당 문자로 같은 가장 긴 연속 문자열 길이
*/



public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int T;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());



        for(int i = 0; i< T; i++){
            String nowStr = br.readLine();
            int K = Integer.parseInt(br.readLine());

            int[][] prevIdx = new int[26][10001];
            int[] charIdx = new int[26];

            int max = -1;
            int min = Integer.MAX_VALUE;

            for(int j = 0; j< 26; j++){
                Arrays.fill(prevIdx[j],-1);
            }
            Arrays.fill(charIdx,0);

            for(int j = 0; j< nowStr.length(); j++){
                int nowCharNum = (int) nowStr.charAt(j) -97;
                prevIdx[nowCharNum][charIdx[nowCharNum]] = j;
                charIdx[nowCharNum]++;
            }



            for(int j = 0; j< 26; j++){
                int maxCnt = charIdx[j];
                if(maxCnt >=K){
                    for(int z = 0; z<maxCnt -K +1; z++){
                        max = Math.max(max,prevIdx[j][z+K-1] - prevIdx[j][z] +1);
                        min = Math.min(min,prevIdx[j][z+K-1] - prevIdx[j][z] +1);
                    }
                }
            }
            if(max == -1){
                sb.append(-1).append('\n');
            }else{
                sb.append(min).append(" ").append(max).append('\n');
            }

        }


        System.out.println(sb.toString());

    }

}