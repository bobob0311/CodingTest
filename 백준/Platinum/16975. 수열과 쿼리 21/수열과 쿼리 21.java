import java.io.*;
import java.util.*;

/*

*/

public class Main {
    static int N,M;
    static int[] list;
    static StringTokenizer st;
    static long[] tree;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        tree = new long[4*N];
        list = new int[N+1];

        st= new StringTokenizer(br.readLine());
        for(int i = 1; i<=N; i++){
            list[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());

        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
           int type = Integer.parseInt(st.nextToken());
           if(type == 1){
                addK();
           }else{
                sb.append(peekK()).append('\n');
           }
        }

        System.out.println(sb.toString());

    }

    static void addK(){
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int value = Integer.parseInt(st.nextToken());
        updateTree(1,N,1,start,end,value);
    }

    static void updateTree(int left, int right, int node, int start,int end,int value){
        if(end < left || right <start) return;

        if(start <= left && right <=end) {
            tree[node] += (long)value;
            return;
        }

        int mid = (left + right) /2;
        updateTree(left,mid,node * 2,start,end,value);
        updateTree(mid+1,right,node *2 +1,start,end,value);
    }

    static long peekK(){
        int idx = Integer.parseInt(st.nextToken());
        return list[idx] + findCalcResult(1,N,idx,1);
    }

    static long findCalcResult(int left,int right,int idx, int node){
        if(left == right) return tree[node];
        long sum = 0;
        
        int mid = (left + right)/2;
        if(idx <= mid) sum += findCalcResult(left,mid,idx,2*node);
        else  sum+= findCalcResult(mid +1,right,idx, 2*node +1);
        return sum + tree[node];
    }
}