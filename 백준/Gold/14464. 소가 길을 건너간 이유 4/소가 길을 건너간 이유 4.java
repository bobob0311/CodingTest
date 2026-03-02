import java.io.*;
import java.util.*;

/*
닭은 C마리(20000) i번째 닭은 Ti초에만 소를 도와줄 수있다.
소는 N마리(20000)

j번째 소는 Aj초부터 Bj초까지 길을 건널 수 있다.

Ti를 정렬해서 사용?

Ti를 작은 순으로 뺀다

Bj를 작은 순으로 정렬해서 사용?

1 5 7 8
    |       |
1 2
2 3
1 7
6 9
*/

public class Main {

    static int C,N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        int[] chickens = new int[C];

        for(int i = 0; i<C; i++){
            chickens[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(chickens);

        int[][] cowArr = new int[N][2];

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            cowArr[i][0] = Integer.parseInt(st.nextToken());
            cowArr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cowArr,(a,b) -> {
            if(a[0] == b[0]){
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        int answer = 0;
        int cowIdx = 0;

        for(int i = 0; i< C; i++){
            int nowChicken = chickens[i];
            for(int j = cowIdx; j<N; j++){
                if(cowIdx >=N) break;
                if(cowArr[j][0] <= nowChicken){
                    pq.add(cowArr[j][1]);
                    cowIdx++;
                }else{
                    break;
                }
            }
            while(!pq.isEmpty()){
                int nowCowEnd = pq.poll();
                if(nowChicken <=nowCowEnd){
                    answer++;
                    break;
                }
            }
        }

        System.out.println(answer);
    }
}