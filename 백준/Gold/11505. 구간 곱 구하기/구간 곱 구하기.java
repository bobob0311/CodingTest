import java.io.*;
import java.util.*;

/*
- 구간의 곱을 구하려는 문제
*/

public class Main {
    static int N,M,K;
    static long[] list;
    static long[] tree;
    static int MOD = 1_000_000_007;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 수의 개수 => 1,000,000
        N = Integer.parseInt(st.nextToken());
        // 수의 변경 횟수 => 10,000
        M = Integer.parseInt(st.nextToken());
        // 구간 곱을 구하는 횟수 => 10,000
        K = Integer.parseInt(st.nextToken());

        list = new long[N+1];
        tree = new long[4*N];
        StringBuilder sb = new StringBuilder();

        for(int i = 1; i<=N; i++){
            list[i] = Long.parseLong(br.readLine());
        }

        makeSegmentTree(1,N,1);

        for(int i = 1; i<= M+K; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if(a == 1) {
                change(1, N, 1, b, c);
                list[b] =c;
            } else if(a == 2) sb.append(calcMuti(1,N,1,b,(int)c)).append('\n');

        }

        System.out.println(sb.toString());
    }

    public static long makeSegmentTree(int start, int end, int node){
        if(start == end) return tree[node] = list[start];
        int mid = (start + end) / 2;

        return tree[node] = (makeSegmentTree(start,mid,node *2) * makeSegmentTree(mid+1,end,node*2 +1)) % MOD;
    }

    static void change(int start, int end, int node, int index, long val){
        if(index < start || index > end)
            return;

        if(start == end){
            tree[node] = val;
            return;
        }

        int mid = (start + end) / 2;

        change(start, mid, node*2, index, val);
        change(mid+1, end, node*2+1, index, val);

        tree[node] = (tree[node *2] * tree[node*2 +1]) %MOD;
    }

    static long calcMuti(int start, int end, int node, int left, int right){
        if(right < start || end < left) return 1;
        if(left <= start && end <=right) return tree[node];

        int mid = (start+end)/2;
        return (calcMuti(start,mid, node*2, left,right) * calcMuti(mid+1,end,node *2 +1, left,right)) %MOD;
    }
}