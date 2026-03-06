import java.io.*;
import java.util.*;

/*
왼쪽 / 오른쪽 주머니에는 M개씩의 정수가 들어있다.

- 수열은 N개의 정수로 이루어져있다.

1. 왼쪽 주머니에서 하나의 정수를 꺼냄 L
2. 오른쪽 주머니에서 하나의 정수를 꺼냄 R

case 1: L <= R 이면
    수열에서 L과 R 구간내에서 최댓값을 찾고 기록
else 종이에 10^9 기록
=> 반복


=> 이 과정에서 최댓값을 최소화하는 방법이 궁금하다.

=> 수열 두 원소의 위치를 바꿔야한다?
*/

public class Main {

    static int N,M,Q;
    static int[] nums, left, right;
    static TreeMap<Integer,Integer> map = new TreeMap<>();
    static boolean[] chk;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        // 200,000
        N = Integer.parseInt(st.nextToken());

        // 200.000
        M = Integer.parseInt(st.nextToken());

        // 200,000
        Q = Integer.parseInt(st.nextToken());

        nums = new int[N+1];
        left = new int[M];
        right = new int[M];

        int[] chkNum = new int[N+2];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i<= N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        StringTokenizer stLeft = new StringTokenizer(br.readLine());
        StringTokenizer stRight = new StringTokenizer(br.readLine());
        for(int i = 0; i<M; i++){
            left[i] = Integer.parseInt(stLeft.nextToken());
            right[i] = Integer.parseInt(stRight.nextToken());
        }

        Arrays.sort(left);
        Arrays.sort(right);

        chk = new boolean[N+1];

        for(int i = 0; i<M; i++){
            int leftIdx = left[i];
            int rightIdx = right[i];
            if(leftIdx > rightIdx) {
                for(int q = 0; q< Q; q++){
                    sb.append(1000000000).append('\n');
                }
                System.out.println(sb.toString());
                return;
            }else{
                chkNum[leftIdx] +=1;
                chkNum[rightIdx+1] -=1;
            }
        }

        int sum = 0;
        for(int i =1; i<=N; i++){
            sum += chkNum[i];
            if(sum>0) chk[i] = true;
        }

        for(int i = 1 ; i<=N; i++){
            if(!chk[i]) continue;
            int nowValue = nums[i];
            if(map.get(nowValue) != null){
                map.put(nowValue,map.get(nowValue) +1);
            }else{
                map.put(nowValue,1);
            }
        }



        for(int i = 0; i<Q; i++){
            st = new StringTokenizer(br.readLine());
            int idx1 = Integer.parseInt(st.nextToken());
            int idx2 = Integer.parseInt(st.nextToken());

            swap(idx1,idx2);

            sb.append(map.lastKey()).append('\n');
        }

        System.out.println(sb.toString());
    }


    static void swap(int a, int b){
        int valueA = nums[a];
        int valueB = nums[b];

        if(chk[a] && !chk[b]){
            // a 삭제부터
            if(map.get(valueA) == 1){
                map.remove(valueA);
            }else{
                map.put(valueA,map.get(valueA)-1);
            }
            // b추가
            if(map.get(valueB) != null){
                map.put(valueB,map.get(valueB) +1);
            }else{
                map.put(valueB,1);
            }
        }else if(!chk[a] && chk[b]){
            if(map.get(valueB) == 1){
                map.remove(valueB);
            }else{
                map.put(valueB,map.get(valueB)-1);
            }
            if(map.get(valueA) != null){
                map.put(valueA,map.get(valueA) +1);
            }else{
                map.put(valueA,1);
            }
        }

        nums[a] = valueB;
        nums[b] = valueA;
    }
}