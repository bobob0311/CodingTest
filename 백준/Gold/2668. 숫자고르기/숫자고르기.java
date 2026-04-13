import javax.swing.text.StyledEditorKit;
import java.io.*;
import java.util.*;

/*
위에 뽑은 집합과 아래 집합이 같아야한다.
그러면서 최대로 많이 뽑는 방법을 찾아야한다.

*/

/*
1 2 3 4 5 6 7

3 1 4 1 5 4 6
*/



public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[] arr;
    static boolean[] visited;

    static HashSet<Integer> set = new HashSet<>();
    static LinkedList<Integer> list = new LinkedList<>();
    static Stack<Integer> stk = new Stack<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N+1];
        for(int i = 1; i<=N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        visited = new boolean[N+1];

        for(int i = 1; i<=N; i++){
            Arrays.fill(visited,false);
            visited[i] = true;
            int startNum = arr[i];
            dfs(arr[i], i);
        }
        for(Integer num :set){
            list.add(num);
        }
        Collections.sort(list);
        sb.append(list.size()).append('\n');
        for(int i = 0; i< list.size(); i++){
            sb.append(list.get(i)).append('\n');
        }
        System.out.println(sb.toString());
    }

    static void dfs(int nextIdx, int startIdx){
        if(arr[nextIdx] == startIdx){
            for(int i = 1; i<N+1; i++){
                if(visited[i]) set.add(arr[i]);
            }
        }
        if(!visited[nextIdx]){
            visited[nextIdx] = true;
            dfs(arr[nextIdx],startIdx);
        }
    }

}