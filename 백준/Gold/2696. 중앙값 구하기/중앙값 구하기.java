import java.io.*;
import java.util.*;

/*

홀수번째 입력시 입력받은 값의 중앙값을 출력하는 프로그램
1
*/

public class Main {
    static int T,M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());


        for(int t = 0; t<T; t++){
            M = Integer.parseInt(br.readLine());
            int times = (M - 1) / 10 + 1;
            int[] nums = new int[M];
            int idx = 0;
            for(int i = 0; i<times; i++){
                st = new StringTokenizer(br.readLine());
                while(st.hasMoreTokens()){
                    nums[idx++] = Integer.parseInt(st.nextToken());
                }
            }

            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> -Integer.compare(a,b));

            sb.append(((M+1)/2)+"\n");
            maxHeap.add(nums[0]);
            sb.append(maxHeap.peek()+" ");
            int cnt = 1;
            for(int j = 1; j< M; j++){
                if(maxHeap.size() == minHeap.size()){
                    maxHeap.offer(nums[j]);
                }else {
                    minHeap.offer(nums[j]);
                }

                if((j + 1) % 2 == 1){
                    if(maxHeap.peek() > minHeap.peek()){
                        int maxV = maxHeap.poll();
                        int minV = minHeap.poll();
                        minHeap.offer(maxV);
                        maxHeap.offer(minV);
                    }

                    sb.append(maxHeap.peek()+" ");
                    cnt++;
                    if(cnt == 10){
                        cnt = 0;
                        sb.append("\n");
                    }

                }
            }

            sb.append("\n");

        }

        System.out.println(sb.toString());
    }
}