import java.io.*;
import java.util.*;

/*
양팔 저울과 몇 개의 추가 주어지면 주어진 구슬의 무게를 확인할 수 있는지

추들의 무게와 확인할 구슬들의 무게가 입력되었을때 주어진 추만을 사용하여
구슬의 무게를 확인할 수 있는지를 결정하는 프로그램
*/

public class Main {
    static int N,targetSize;
    static int[] nums, targets;
    static boolean[] chk;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        st = new StringTokenizer(br.readLine());
        chk = new boolean[40001];
        int maxNum = 0;
        Queue<Integer> que = new LinkedList<>();
        for(int i = 0; i< N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int[] reversed = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            reversed[i] = nums[nums.length - 1 - i];
        }

        for(int nowNum : reversed){
            maxNum += nowNum;
            for(int j = 0; j <= maxNum; j++){
                if(chk[j]) {
                    que.add(j + nowNum);
                    que.add(j - nowNum);
                    que.add(nowNum - j);
                }
            }
            while(!que.isEmpty()){
                int now = que.poll();
                if(now >0) chk[now] = true;
            }
            chk[nowNum] = true;
        }

        targetSize = Integer.parseInt(br.readLine());
        targets = new int[targetSize];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<targetSize; i++){
            targets[i] = Integer.parseInt(st.nextToken());
        }

        for(int target : targets){
            if(chk[target]) sb.append("Y ");
            else sb.append("N ");
        }
        System.out.println(sb.toString());


    }
}
