import java.io.*;
import java.util.*;

/*
각 장을 다른 파일에 저장
한개의 파일로 만들어야하는데
- 두 개의 파일을 합쳐서 하나의 임시 파일로 마나듬
- 비용은 두 파일 크기의 합이라고 가정


*/

public class Main {

    static int T;
    static int N;



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PriorityQueue<Long> chapters = new PriorityQueue<>();
        // 색상환에 포함된 수
        T = Integer.parseInt(br.readLine());
        for(int t = 0; t<T; t++){
            N = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());

            for(int i = 0; i< N; i++){
                chapters.add(Long.parseLong(st.nextToken()));
            }
            long answer = 0;
            while(chapters.size()!=1){
                long first = chapters.poll();
                long second = chapters.poll();
                long cost = first + second;
                answer += cost;
                chapters.add(cost);
            }

            chapters.clear();
            System.out.println(answer);
        }
    }

}