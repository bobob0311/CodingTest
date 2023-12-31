package greedy;
/*
1개 회의실에서 N개의회의에 대한 회의실 사용표 제작
시작시간과 끝나는 시간이 있고 각 회의가 겹치지 않게 할 ㅅ 있는 회의 최대개수
끝남과 동시에 다음 회의 시작가능 => 같을 수 있다
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 백준1931 {
    static int N;
    static int[][] time;
    static int count;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        time = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            time[i][0] = Integer.parseInt(st.nextToken());
            time[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(time, new Comparator<int[]>() {

            public int compare(int[] o1, int[] o2) {

                // 종료시간이 같을 경우 시작시간이 빠른순으로 정렬해야한다.
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }

                return o1[1] - o2[1];
            }

        });

        int target = 0;

        for (int i = 0; i < N; i++) {
            if (target <= time[i][0]) {
                target = time[i][1];
                count++;
            }
        }
        System.out.println(count);

    }

}
