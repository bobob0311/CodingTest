import java.io.*;
import java.util.*;

/*
- 수의 변경이 빈번하게 일어나고 그 중간에 어떤 부분의 합을 구하려한다.
*/

public class Main {
    static int N,M,K;
    static long[] list;
    static long[] tree;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 수의 개수 => 1,000,000
        N = Integer.parseInt(st.nextToken());
        // 수의 변경 횟수 => 10,000
        M = Integer.parseInt(st.nextToken());
        // 구간합 구하는 횟수 => 10,000
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
            } else if(a == 2) sb.append(calcSub(1,N,1,b,(int)c)).append('\n');

        }

        System.out.println(sb.toString());
    }

    public static long makeSegmentTree(int start, int end, int node){
        if(start == end) return tree[node] = list[start];
        int mid = (start + end) / 2;

        return tree[node] = makeSegmentTree(start,mid,node *2) + makeSegmentTree(mid+1,end,node*2 +1);
    }

    static void change(int start, int end, int node, int index, long val){
        if(index < start || index > end)
            return;

        tree[node] += val - list[index];

        int mid = (start + end) / 2;

        if(start == end)
            return;

        change(start, mid, node*2, index, val);
        change(mid+1, end, node*2+1, index, val);
    }

    static long calcSub(int start, int end, int node, int left, int right){
        if(right < start || end < left) return 0;
        if(left <= start && end <=right) return tree[node];

        int mid = (start+end)/2;
        return calcSub(start,mid, node*2, left,right) + calcSub(mid+1,end,node *2 +1, left,right);
    }
}