import java.io.*;
import java.math.BigInteger;
import java.util.*;

/*
서로 다른 정수로 이루어진 집합이 있는데 순열로 큰 정수 가능
합친 수가 정수 K로 나누어 떨어지는 순열을 구하는  프로그램

답을 맞출 확률을 분수로 출력해라

나머지를 활용해야할거같은데
*/

public class Main {

    static int N,K;
    static String[] numStrs;
    static int[][] mods;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        numStrs = new String[N];

        for(int i = 0; i<N; i++){
            numStrs[i] = br.readLine();
        }

        K = Integer.parseInt(br.readLine());
        mods = new int[N][K]; // N번째에 나머지 K가 앞에 붙었을때 나머지

        for(int i = 0; i< numStrs.length; i++){
            String nowStr = numStrs[i];
            for(int mod =0; mod < K; mod++){
                mods[i][mod] = calcMod(mod,nowStr);
            }
        }

        long[][] dp = new long[1<<N][K]; // mask 사용했고 나머지가 K일때 경우의 수

        dp[0][0] = 1;

        for(int visit = 0; visit < (1<<N); visit++){
            // 현재 나머지가 i일 경우
            for(int i = 0; i<K; i++){
                if(dp[visit][i] ==0) continue;

                for(int next = 0; next < N; next++){
                    if((visit & (1<<next)) !=0) continue;

                    int nextvisit = visit | (1<< next);
                    int newR = mods[next][i];

                    dp[nextvisit][newR] += dp[visit][i];
                }
            }
        }

        long top = dp[(1<<N)-1][0];
        long bottom =1;
        for(int i = 2; i<=N; i++){
            bottom *=i;
        }

        long g = gcd(bottom,top);
        System.out.println((top/g) + "/" + (bottom/g));


    }

    static int calcMod(int frontRemainder, String str) {
        int remainder = frontRemainder;

        for (int i = 0; i < str.length(); i++) {
            remainder = (remainder * 10 + (str.charAt(i) - '0')) % K;
        }

        return remainder;
    }

    static long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}