import java.io.*;
import java.util.*;

/*
- 구간의 곱을 구하려는 문제
*/

public class Main {
    static int N,M;
    static int[] list;
    static int[] maxTree,minTree;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new int[N+1];
        maxTree = new int[4*N+1];
        minTree = new int[4*N+1];

        Arrays.fill(minTree,1000000001);

        for(int i = 1; i<= N; i++){
            list[i] = Integer.parseInt(br.readLine());
        }

        makeSegmentMax(1,N,1);
        makeSegmentMin(1,N,1);

        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            sb.append(findMin(1,N,1,start,end)).append(" ").append(findMax(1,N,1,start,end)).append('\n');
        }

        System.out.println(sb.toString());
    }

    static int findMin(int left, int right, int node, int start, int end){
        if(right < start || left > end) return Integer.MAX_VALUE;

        if(start<=left && end >= right){
            return minTree[node];
        }

        int mid = (left + right)/2;

        return Math.min(findMin(left,mid,node *2,start,end),findMin(mid+1,right,node *2+1,start,end));
    }

    static int findMax(int left, int right, int node, int start, int end){
        if(right < start || left > end) return 0;

        if(start<=left && end >= right){
            return maxTree[node];
        }

        int mid = (left + right)/2;

        return Math.max(findMax(left,mid,node *2,start,end),findMax(mid+1,right,node *2+1,start,end));
    }

    static int makeSegmentMax(int left, int right, int node){
        if(left >= right) return maxTree[node] = list[left];

        int mid = (left + right)/2;

        return maxTree[node] = Math.max(makeSegmentMax(left,mid,node *2),makeSegmentMax(mid+1,right,node*2+1));
    }
    static int makeSegmentMin(int left, int right, int node){
        if(left >= right) return minTree[node] = list[left];

        int mid = (left + right)/2;

        return minTree[node] = Math.min(makeSegmentMin(left,mid,node *2),makeSegmentMin(mid+1,right,node*2+1));
    }

}