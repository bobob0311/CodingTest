import java.util.*;
import java.io.*;

// 안넣는 경우까지 생각을 하는듯? => 가능한 부분 집합을 모두 구하여라!!
// C를 안넘는 모든 부분 집합의 부분 집합을 구하면 될거같아요. => 근데 안겹쳐요?
// 당연히 겹치죠..? 아니면 10억번의 연산을 해요?
// 당연히 안되지않을까요...?

public class Main{
    static int C;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 물건의 개수
        int N = Integer.parseInt(st.nextToken());
        int[] items = new int[N];
        
        // 가방의 최대
        C = Integer.parseInt(st.nextToken());
       
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            items[i] = Integer.parseInt(st.nextToken());
        }
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();
        
        dfs(0,N/2,0,items,left);
        dfs(N/2,N,0,items,right);
        
        Collections.sort(left);
        Collections.sort(right);
        
        int answer = 0;
        
        for(int i = 0; i<left.size(); i++){
            int searchValue = C - left.get(i);
            answer += binarySearch(right, searchValue) +1;
        }
        
        System.out.println(answer);
    }
    
    public static void dfs(int start, int end, int sum, int[]arr , ArrayList<Integer> list){
        if(sum > C) return;
        if(start == end){
            list.add(sum);
            return;
        }
        dfs(start + 1,end,sum + arr[start],arr, list);
        
        dfs(start + 1,end,sum,arr, list);
    }
    
    public static int binarySearch(ArrayList<Integer> sum, int target){
        int left = 0;
        int right = sum.size()-1;
        int answer = -1;
        while(left <= right){
            int mid = (left + right)/2;
            if(sum.get(mid) <= target){
                answer = mid;
                left = mid +1;
            }else{
                right = mid -1;
            }
        }
        return answer;
    }
}