import java.io.*;
import java.util.*;

/*
모닝커피(Large) / 백준 12456번 / 플레 5
- N종류의 커피
- i 번째 커피는 ci 만큼 남아있음
- 유통기한은 ti
- i번 종류 커피 1잔이면 si의 만족도
- 유통기한이 지나면 마실 수 없음

=> K일에 얻을 수 있는 만족도 합계의 최대를  구하라
*/

public class Main {

    static int T,N;
    static long K;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        PriorityQueue<long[]> pq = new PriorityQueue<>((a,b)-> PqComparator(a,b));

        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int t = 1; t<= T ; t++){
            pq.clear();
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            K = Long.parseLong(st.nextToken());

            long[][] coffees = new long[N][3];
            for(int i = 0; i<N; i++){
                st = new StringTokenizer(br.readLine());

                long cCnt = Long.parseLong(st.nextToken());
                long cVal = Long.parseLong(st.nextToken());
                int cGood = Integer.parseInt(st.nextToken());

                coffees[i] = new long[] {cCnt,cVal,cGood};
            }
            Arrays.sort(coffees, (a,b) -> -Long.compare(a[1],b[1]));

            int idx = 0;
            boolean last = false;
            Long answer = 0L;
            while(true){
                long diff = 0;

                // pq에 넣는 로직
                while(idx < N){
                    // 만약 다음게 없을 경우
                    if(idx +1 == N){
                        pq.offer(new long[] {coffees[idx][2], coffees[idx][0]});
                        diff = coffees[idx][1];
                        last = true;

                        break;
                    }else{
                        // 다음게 있는 경우
                        diff = coffees[idx][1] - coffees[idx+1][1];
                        pq.offer(new long[] {coffees[idx][2], coffees[idx][0]});
                        idx++;
                        if(idx == N) {
                            diff = coffees[idx-1][1];
                            break;
                        }else if(diff != 0){
                            break;
                        }
                    }
                }


                //다음 가능한게 들어올때까지 마시는 로직
                while(diff > 0 && !pq.isEmpty()){
                    long[] arr = pq.poll();
                    long good = arr[0];
                    long cnt = arr[1];

                    if(diff < cnt){
                        long canCnt = diff;
                        cnt -= diff;
                        answer += good * canCnt;
                        pq.offer(new long[] {good,cnt});

                        diff = 0;
                    }else{
                        long canCnt = cnt;
                        diff -= cnt;
                        answer += good * canCnt;
                    }
                }
                if (last) break;

            }
            sb.append("Case #").append(t).append(": ").append(answer).append('\n');
        }
        System.out.println(sb.toString());
    }
    static int PqComparator(long[] a, long[] b){
        return -Long.compare(a[0],b[0]);
    }
}