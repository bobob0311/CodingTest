import java.io.*;
import java.util.*;

/*
길이가 N인 수열
수열에서 연속한 1개 이상 수를 뽑을때 같은 수가 여러번 등장하지 않을 경우
범위안에 같은 수가 없어야한다.
*/



public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static HashSet<Integer> set = new HashSet<>();
    static int[] arr;
    static long cnt = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for(int i = 0; i< N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        boolean[] visited = new boolean[100001];

        int right = -1;
        for(int left = 0; left<N; left++){
            while(right + 1 <N && !visited[arr[right+1]]){
                right++;
                visited[arr[right]] = true;
            }

            cnt+= right - left + 1;
            visited[arr[left]] = false;
        }
        System.out.println(cnt);
    }
}