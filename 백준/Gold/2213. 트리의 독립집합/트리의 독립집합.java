import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;
    static ArrayList<LinkedList<Integer>> tree = new ArrayList<>();
    static int[] wt;
    static int[][] memo;
    static boolean[] visitied;
    static ArrayList<Integer> res = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 트리의 정점수
        int K = Integer.parseInt(br.readLine());


        st = new StringTokenizer(br.readLine());
        wt = new int[K+1];
        visitied = new boolean[K+1];
        memo = new int[K+1][2];

        for(int i = 0; i<K ;i++){
            wt[i+1] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i<K+1 ;i++){
            tree.add(new LinkedList<>());
        }

        for(int i = 0; i<K-1; i++){
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            tree.get(start).add(end);
            tree.get(end).add(start);
        }
        dfs(1);

        Arrays.fill(visitied,false);
        if(memo[1][0] > memo[1][1]){
            System.out.println(memo[1][0]);
            trace(1, false);
        } else{
            System.out.println(memo[1][1]);
            trace(1, true);
        }

        Collections.sort(res);
        StringBuilder sb = new StringBuilder();
        for(Integer now : res){
            sb.append(now+" ");
        }
        System.out.println(sb.toString());
    }

    static void dfs(int cur){
        int child_size = tree.get(cur).size();

        // 선택안하는경우
        memo[cur][0] = 0;
        // 선택하는 경우
        memo[cur][1] = wt[cur];
        visitied[cur] = true;

        for(int i = 0; i<child_size; i++){
            int next = tree.get(cur).get(i);
            if(!visitied[next]){
            dfs(next);

            memo[cur][0] += Math.max(memo[next][1], memo[next][0]);
            memo[cur][1] += memo[next][0];
            }
        }
    }

    static void trace(int cur, boolean isInclude){
        visitied[cur] = true;



        if(isInclude){
            res.add(cur);
            for(Integer next : tree.get(cur)){
                if(!visitied[next]) trace(next, false);
            }
        }else{
            for(Integer next : tree.get(cur)){
                if(!visitied[next]){
                    if(memo[next][1] > memo[next][0]){
                        trace(next,true);
                    }else trace(next,false);
                }
            }
        }
    }
}