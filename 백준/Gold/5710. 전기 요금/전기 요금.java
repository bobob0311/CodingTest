
/*
100 2
10000 3
1000000 5
이상 7

요금과 관련된 정보를 나타내는 두숫 자 A B
그 사람이 사는 건물에서 임의로 고른 이웃의 정보와 합친 요금

A: 이웃의 사용량과 사용량ㅇㄹ 합쳤을 때 내야하는 요금
B: 이웃의 전기 요금과의 차이 

항상 상근이가 전기를 ㄷ 작게 쓴다. 
*/
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            Long A = Long.parseLong(st.nextToken());
            Long B = Long.parseLong(st.nextToken());
            if (A == 0 && B == 0) {
                break;
            }

            long total = find(A);

            long start = 0;
            long end = total;

            while (start <= end) {
                long mid = (start + end) / 2;

                long me = calc(mid);
                long ano = calc(total - mid);

                long diff = ano - me;

                if (diff < B) {
                    end = mid - 1;
                } else if (diff > B) {
                    start = mid + 1;
                } else {
                    System.out.println(me);
                    break;
                }
            }

        }
    }

    public static long calc(long A) {

        if (A <= 100) {
            return A * 2;
        } else if (A <= 10000) {
            return 200 + (A - 100) * 3;
        } else if (A <= 1000000) {
            return 200 + 29700 + (A - 10000) * 5;
        } else {
            return 200 + 29700 + 4950000 + (A - 1000000) * 7;
        }
    }

    public static long find(long p) {
        if (p <= 200) {
            return p / 2;
        } else if (p <= 29900) {
            return (p - 200) / 3 + 100;
        } else if (p <= 4979900) {
            return (p - 29900) / 5 + 10000;
        } else {
            return (p - 4979900) / 7 + 1000000;
        }
    }
}