import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        ArrayList<Integer> lis = new ArrayList<>();
        
        for (int num : arr) {
            // 이분 탐색으로 현재 위치 찾기
            int pos = Collections.binarySearch(lis, num);
            if (pos < 0) {
                pos = -(pos + 1); // 삽입 위치 계산
            }
            // 리스트 갱신
            if (pos == lis.size()) {
                lis.add(num);
            } else {
                lis.set(pos, num);
            }
        }
        
        System.out.println(lis.size());
    }
}
